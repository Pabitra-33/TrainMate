package fitnesswebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import fitnesswebapp.binding.LoginCustomer;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String doLogout(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "Logout Successful");
//		model.addAttribute("loginRequest", new LoginCustomer());
		return "login";
	}
}