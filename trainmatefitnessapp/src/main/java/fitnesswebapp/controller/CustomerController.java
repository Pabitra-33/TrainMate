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
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	
	@GetMapping("/showform")
	public String showRegistration(Model model) {
		model.addAttribute("customerbind", new CustomerBinding());
		return "register";
	}
	
	
	@PostMapping("/register")
	public String registerCustomer(Model model, CustomerBinding customerBinding) {
		
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerBinding, customer);
		Customer save = customerDao.save(customer);
		if(save != null) {
			model.addAttribute("msg", "Registration Successful");
			model.addAttribute("loginRequest", new LoginCustomer());
			return "login";
		}
		else {
			model.addAttribute("msg", "Registration Unsucessfull");
			return "register";
		}
	}
}