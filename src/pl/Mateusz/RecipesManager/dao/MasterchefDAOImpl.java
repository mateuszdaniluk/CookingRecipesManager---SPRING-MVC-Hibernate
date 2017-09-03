package pl.Mateusz.RecipesManager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.Mateusz.RecipesManager.entity.Masterchef;
import pl.Mateusz.RecipesManager.entity.Recipe;

@Repository
public class MasterchefDAOImpl implements MasterchefDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Masterchef> getMasterchefs() {

		Session session = sessionFactory.getCurrentSession();

		Query<Masterchef> theQuery = session.createQuery("from Masterchef", Masterchef.class);

		List<Masterchef> users = theQuery.getResultList();

		return users;
	}

	@Override
	public void saveMasterchef(Masterchef theMasterchef) {

		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theMasterchef);

	}

	@Override
	public Masterchef getMasterchef(int id) {

		Session session = sessionFactory.getCurrentSession();

		Masterchef chef = session.get(Masterchef.class, id);

		return chef;
	}

	@Override
	public void deleteMasterchef(int id) {

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Masterchef where id=" + id);
		
		query.executeUpdate();

	}

	@Override
	public List<Recipe> getRecipesList(int id) {

		Session session = sessionFactory.getCurrentSession();

		Query<Recipe> query = session.createQuery("from Recipe where masterchef_id=:id" , Recipe.class);
		query.setParameter("id", id);	
		List<Recipe> list = query.getResultList();
		list.forEach(e->{
			System.out.println(e.toString());
		});
		
		return list;
	}

}
