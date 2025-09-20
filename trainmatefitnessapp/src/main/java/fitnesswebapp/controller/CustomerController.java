package fitnesswebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import fitnesswebapp.dao.CustomerDao;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao customerDao;
	
	
	
}