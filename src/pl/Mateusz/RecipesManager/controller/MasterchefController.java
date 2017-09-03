package pl.Mateusz.RecipesManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.Mateusz.RecipesManager.entity.CousineType;
import pl.Mateusz.RecipesManager.entity.Masterchef;
import pl.Mateusz.RecipesManager.entity.MealType;
import pl.Mateusz.RecipesManager.entity.Recipe;
import pl.Mateusz.RecipesManager.service.MasterchefService;

@Controller
@SessionAttributes("masterchef")
@RequestMapping("/masterchef")
public class MasterchefController {

	
	//need to inject MasterchefService
	@Autowired
	private MasterchefService masterchefService;
	
	@ModelAttribute("masterchef")
    public Masterchef getMasterchef() {
        return new Masterchef();

    }
	
	@RequestMapping("/list")
	public String masterchefsList(Model theModel) {
		
		//get Masterchef from MasterchefService(service get it from DAO)
		//add the Masterchef to the model
		
		List<Masterchef> masterchefs = masterchefService.getMasterchefs();
		
		theModel.addAttribute("masterchef", masterchefs);
		
		return "list-masterchefs";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addingMasterChef(Model theModel) {
		
		//create Masterchef object, save this to the databse 
		//create model attribute to bind form data
		
		Masterchef theMasterchef = new Masterchef();
		
		//we are using this model binding fields in html to this model. 
		theModel.addAttribute("masterchef", theMasterchef);
		
		
		return "masterchef-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String updateMasterchef(@RequestParam("masterchefId") int theId,
			Model theModel) {
		
		//get the Masterchef from the database
		//set the Masterchef as a model attrubiute to pre-populate the form
		//send over our form
		
		Masterchef theMasterchef=masterchefService.getMasterchef(theId);
		
		theModel.addAttribute("masterchef", theMasterchef);
		
		
		
		return "masterchef-form";
	}
	
	
	//@ReqestParam -> it refers to the c:param name="masterchefId" in list-masterchef.jsp
	@RequestMapping("/deleteMasterchef")
	public String deleteMasterchef(@RequestParam("masterchefId") int theId, Model theModel) {
		
		masterchefService.deleteMasterchef(theId);
		
		
		return "redirect:/masterchef/list";
	}
	
	@PostMapping("/saveMasterchef")
	public String saveMasterchef(@ModelAttribute("masterchef") Masterchef theMasterchef) {
		
		//save Masterchef using our service
		masterchefService.saveMasterchef(theMasterchef);
		
		return "redirect:/masterchef/list";
	}
	
	@RequestMapping("/showRecipes")
	public String showRecipes(@RequestParam("masterchefId") int chefId, Model theModel) {
		
		List<Recipe> list = masterchefService.getRecipesList(chefId);
		Masterchef chef = masterchefService.getMasterchef(chefId);
		
		theModel.addAttribute("meal", MealType.values());
		theModel.addAttribute("cousine", CousineType.values()); 		
		theModel.addAttribute("list", list);
		theModel.addAttribute("masterchef", chef);
		
		
		return "masterchef-recipes";
	}
}
