package pl.Mateusz.RecipesManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.Mateusz.RecipesManager.dao.MasterchefDAO;
import pl.Mateusz.RecipesManager.entity.Masterchef;
import pl.Mateusz.RecipesManager.entity.Recipe;


@Service
public class MasterchefServiceImpl implements MasterchefService {

	//need to inject the userDAO
	@Autowired
	private MasterchefDAO masterchefDAO;
	
	@Override
	@Transactional
	public List<Masterchef> getMasterchefs() {
		
		//we just delegate the logic to the customerDAO. 
		return masterchefDAO.getMasterchefs();
	}

	@Override
	@Transactional
	public void saveMasterchef(Masterchef theMasterchef) {
		masterchefDAO.saveMasterchef(theMasterchef);
		
	}

	@Override
	@Transactional
	public Masterchef getMasterchef(int id) {
				
		return masterchefDAO.getMasterchef(id);
	}

	@Override
	@Transactional
	public void deleteMasterchef(int id) {
		masterchefDAO.deleteMasterchef(id);
		
	}
	
	@Override
	@Transactional
	public List<Recipe> getRecipesList(int id) {
		return masterchefDAO.getRecipesList(id);
	}
	
	}
