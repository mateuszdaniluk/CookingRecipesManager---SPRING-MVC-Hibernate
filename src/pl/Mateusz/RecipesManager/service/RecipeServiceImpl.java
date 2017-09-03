package pl.Mateusz.RecipesManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.Mateusz.RecipesManager.dao.RecipeDAO;
import pl.Mateusz.RecipesManager.entity.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {


	//need to inject the recipeDAO
	@Autowired
	private RecipeDAO recipeDAO;
	
	@Override
	@Transactional
	public List<Recipe> getRecipes() {
		
		return recipeDAO.getRecipes();
	}

	@Override
	@Transactional
	public void saveRecipe(Recipe theRecipe) {
		recipeDAO.saveRecipe(theRecipe);
		
	}

	@Override
	@Transactional
	public Recipe getRecipe(int id) {
				
		return recipeDAO.getRecipe(id);
	}

	@Override
	@Transactional
	public void deleteRecipe(int id) {
		recipeDAO.deleteRecipe(id);
		
	}

	}
