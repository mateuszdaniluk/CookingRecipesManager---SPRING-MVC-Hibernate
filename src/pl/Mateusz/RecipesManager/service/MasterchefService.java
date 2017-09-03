package pl.Mateusz.RecipesManager.service;

import java.util.List;

import pl.Mateusz.RecipesManager.entity.Masterchef;
import pl.Mateusz.RecipesManager.entity.Recipe;

public interface MasterchefService {

	public List<Masterchef> getMasterchefs();
	
	public void saveMasterchef(Masterchef theMasterchef);
	
	public Masterchef getMasterchef(int id);
	
	public void deleteMasterchef(int id);
	
	public List<Recipe> getRecipesList(int id);
	
}
