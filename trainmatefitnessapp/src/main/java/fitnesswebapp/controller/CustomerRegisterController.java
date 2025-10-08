package fitnesswebapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fitnesswebapp.binding.CustomerBinding;
import fitnesswebapp.binding.LoginCustomer;
import fitnesswebapp.dao.CustomerDao;
import fitnesswebapp.model.Customer;

@Controller
public class RegisterController {

	@Autowired
	private CustomerDao customerDao;
	
	@GetMapping("/showform")
	public String showRegistrationForm(Model model) {
		model.addAttribute("customerbind", new CustomerBinding());
		return "register";
	}
	
	
	@PostMapping("/register")
	public String registerUser(CustomerBinding customerBind, Model model) {
		//customer entity class object
		Customer entity = new Customer();
		BeanUtils.copyProperties(customerBind, entity);
		Customer save = customerDao.save(entity);
		
		if(save != null) {
			model.addAttribute("loginRequest", new LoginCustomer());
			return "login";
		}
		else {
			model.addAttribute("msg", "Registration Unsucessfull");
			return "register";
		}
	}
}