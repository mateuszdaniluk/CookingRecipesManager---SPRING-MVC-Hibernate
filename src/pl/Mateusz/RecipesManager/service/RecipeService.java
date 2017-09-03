package pl.Mateusz.RecipesManager.service;

import java.util.List;

import pl.Mateusz.RecipesManager.entity.Recipe;

public interface RecipeService {

	public List<Recipe> getRecipes();
	
	public void saveRecipe(Recipe theRecipe);
	
	public Recipe getRecipe(int id);
	
	public void deleteRecipe(int id);
	
}
