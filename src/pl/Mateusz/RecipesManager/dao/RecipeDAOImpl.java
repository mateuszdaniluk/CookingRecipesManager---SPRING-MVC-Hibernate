package pl.Mateusz.RecipesManager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.Mateusz.RecipesManager.entity.Recipe;

@Repository
public class RecipeDAOImpl implements RecipeDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Recipe> getRecipes() {

		Session session = sessionFactory.getCurrentSession();

		Query<Recipe> theQuery = session.createQuery("from Recipe order by cousineType", Recipe.class);

		List<Recipe> recipes = theQuery.getResultList();

		return recipes;
	}

	@Override
	public void saveRecipe(Recipe theRecipe) {

		Session session = sessionFactory.getCurrentSession();

		// save or update(if object exist) recipe using hibernate
		session.saveOrUpdate(theRecipe);

	}

	@Override
	public Recipe getRecipe(int id) {

		Session session = sessionFactory.getCurrentSession();

		// get recipe from database using hibernate session
		Recipe recipe = session.get(Recipe.class, id);

		return recipe;
	}

	@Override
	public void deleteRecipe(int id) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Recipe where id=" + id);
		
		query.executeUpdate();

	}


}
