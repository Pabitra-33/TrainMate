package fitnesswebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fitnesswebapp.binding.LoginCustomer;
import fitnesswebapp.dao.CustomerDao;
import fitnesswebapp.model.Customer;
import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerLoginController {

	@Autowired
	private CustomerDao customerDao;

	@GetMapping("/login")
	public String ShowLogin(Model model) {
		model.addAttribute("loginRequest", new LoginCustomer());
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, HttpSession session, LoginCustomer username) {

		String user = username.getUsername();
		String pswd = username.getPassword();

		Customer find = customerDao.findByCustomerName(user);// finding the customer data

		if (find != null && find.getPassword().equals(pswd)) {
			session.setAttribute("username", user);
			return "home";
		} else {
			model.addAttribute("error", "Invalid Id or Password");
			model.addAttribute("loginRequest", new LoginCustomer());
			return "login";
		}
	}
}