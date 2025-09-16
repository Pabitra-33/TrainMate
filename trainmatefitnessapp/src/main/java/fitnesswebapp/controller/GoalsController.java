package fitnesswebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fitnesswebapp.dao.GoalsDao;

@Controller
public class GoalsController {

	@Autowired
	private GoalsDao goalsDao;
}