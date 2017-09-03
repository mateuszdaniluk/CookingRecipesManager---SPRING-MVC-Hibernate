package pl.Mateusz.RecipesManager.dao;

import java.util.List;

import pl.Mateusz.RecipesManager.entity.Masterchef;
import pl.Mateusz.RecipesManager.entity.Recipe;

public interface MasterchefDAO {

	public List<Masterchef> getMasterchefs();

	public void saveMasterchef(Masterchef theUser);

	public Masterchef getMasterchef(int id);

	public void deleteMasterchef(int id);

	public List<Recipe> getRecipesList(int id);

}
