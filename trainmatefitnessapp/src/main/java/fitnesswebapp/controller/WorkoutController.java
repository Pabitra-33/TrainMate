package fitnesswebapp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fitnesswebapp.binding.WorkoutBinding;
import fitnesswebapp.dao.CustomerDao;
import fitnesswebapp.dao.WorkoutDao;
import fitnesswebapp.model.Customer;
import fitnesswebapp.model.Workout;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private WorkoutDao workoutDao;

	
	@GetMapping("/createWorkout")
	public String showWorkout(Model model) {
		model.addAttribute("workout", new WorkoutBinding());
		return "addworkout";
	}

	
	@PostMapping("/saveWorkout")
	public String saveWorkout(Model model, WorkoutBinding workoutBind,
			HttpSession session) {
		Customer entity = customerDao.findByCustomerName((String)session.getAttribute("username"));
		
		if(entity == null) {
			model.addAttribute("message", "Please Login to create Workout");
			return "redirect:/login";
		}
		
		Workout workEntity = new Workout();
		
		//copying the data from the Binding object to the entity
		BeanUtils.copyProperties(workoutBind, workEntity);
		workEntity.setCustomer(entity);
		
		//save the workout
		Workout save = workoutDao.save(workEntity);
		
		if(save != null) {
			model.addAttribute("message", "Created Workout");
			model.addAttribute("workout", new WorkoutBinding());
		}
		else {
			model.addAttribute("message", "Unable to create Workout");
			model.addAttribute("workout", new WorkoutBinding());
		}
		return "home";
	}
	
	
	@GetMapping("/home") //to directly go to home page
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/viewWorkouts")
	public String viewWorkout(HttpSession session, Model model) {
		Customer customer = customerDao.findByCustomerName((String)session.getAttribute("username"));
		//based on the customer, what workouts has the user added for him
		List<Workout> workouts = workoutDao.findByCustomerEntity(customer);
		model.addAttribute("workouts", workouts);
		return "viewworkouts";
	}
}