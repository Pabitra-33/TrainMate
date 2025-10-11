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
		//by invalidating the session we can easily delete the session user.
		session.invalidate();
		model.addAttribute("message", "Logout Successful");
//		model.addAttribute("loginRequest", new LoginCustomer());
		return "login";
	}
}