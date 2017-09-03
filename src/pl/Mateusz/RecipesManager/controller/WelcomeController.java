package pl.Mateusz.RecipesManager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	
	//handling welcome Page
	@RequestMapping("/")
	public String loggingPage() {
		
		
		return "main-menu";
	}
	
}
