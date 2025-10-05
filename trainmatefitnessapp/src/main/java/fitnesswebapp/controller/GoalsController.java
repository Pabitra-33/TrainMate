package fitnesswebapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fitnesswebapp.binding.GoalBinding;
import fitnesswebapp.dao.CustomerDao;
import fitnesswebapp.dao.GoalsDao;
import fitnesswebapp.model.Customer;
import fitnesswebapp.model.Goal;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/goals")
public class GoalsController {

	@Autowired
	private CustomerDao customerDao;//customer dao reference

	@Autowired
	private GoalsDao goalsDao;//goal dao reference

	@GetMapping("/creategoal")
	public String showGoal(Model model) {
		model.addAttribute("goal", new GoalBinding());
		return "addgoal";
	}

	@PostMapping("/savegoal")
	public String addGoal(Model model, HttpSession session, GoalBinding goalBinding) {
		Customer entity = customerDao.findByCustomerName((String) session.getAttribute("username"));
		if (entity == null) {
			model.addAttribute("error", "Please Login !!!!!");
			return "redirect:/login";
		}

		Goal goal = new Goal();
		BeanUtils.copyProperties(goalBinding, goal);

		goal.setCustomer(entity);

		Goal save = goalsDao.save(goal);

		if(save != null) {
			model.addAttribute("message", "Goal Created");
			model.addAttribute("goal", new GoalBinding());
		}
		else {
			model.addAttribute("message", "Goal Not Created");
			model.addAttribute("goal", new GoalBinding());
		}
		
		return "home";
	}
}