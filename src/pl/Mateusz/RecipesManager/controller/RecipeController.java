package pl.Mateusz.RecipesManager.controller;

import java.beans.PropertyEditor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import pl.Mateusz.RecipesManager.service.RecipeService;

@Controller
@SessionAttributes("recipe")
@RequestMapping("/recipe")
public class RecipeController {

	//need to inject recipeService
	@Autowired
	private RecipeService recipeService;
	
	@Autowired
	private MasterchefService masterchefService;

	@ModelAttribute("recipe")
    public Recipe getRecipe() {
        return new Recipe();

    }
	
	
	@RequestMapping("/list")
	public String recipesList(Model theModel) {
		
		//get Recipe from recipeService(service get it from DAO)
		//add the Recipe to the model
		
		List<Recipe> recipes = recipeService.getRecipes();

		theModel.addAttribute("meal", MealType.values());
		theModel.addAttribute("cousine", CousineType.values()); 
		theModel.addAttribute("recipe", recipes);
		
		return "list-recipes";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addingRecipe(Model theModel) {
		
		//create Recipe object, save this to the databse 
		//create model attribute to bind form data
		
		Recipe theRecipe = new Recipe();
		
		//we are using this model binding fields in html to this model.
		theModel.addAttribute("recipe", theRecipe);
		theModel.addAttribute("meal", MealType.values());
		theModel.addAttribute("cousine", CousineType.values()); 
		
		return "recipe-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String updateRecipe(@RequestParam("recipeId") int theId,
			Model theModel) {
		
		//get the Recipe from the database
		//set the Recipe as a model attrubiute to pre-populate the form
		//send over our form
		
		Recipe theRecipe=recipeService.getRecipe(theId);
		
		theModel.addAttribute("recipe", theRecipe);
		
		
		
		return "recipe-form";
	}
	
	
	//@ReqestParam -> it refers to the c:param name="recipeId" in list-recipes.jsp
	@RequestMapping("/showDetails")
	public String showDetails(@RequestParam("recipeId") int theId, Model theModel) {
		
		Recipe theRecipe=recipeService.getRecipe(theId);
		
		theModel.addAttribute("recipe", theRecipe);
			
		
		return "recipe-details";
	}
	
	@RequestMapping("/deleteRecipe")
	public String deleteRecipe(@RequestParam("recipeId") int theId, Model theModel) {
		
		recipeService.deleteRecipe(theId);
		
		
		return "redirect:/recipe/list";
	}
	
	@PostMapping("/saveRecipe")
	public String saveRecipe(@ModelAttribute("recipe") Recipe theRecipe) {
		
		recipeService.saveRecipe(theRecipe);
		
		return "redirect:/recipe/list";
	}
	
	
}
