package pl.Mateusz.RecipesManager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "masterchef")
public class Masterchef {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "masterchef_id")
	private int id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "restaurant")
	private String restaurant;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "cooking_program")
	private String cookingProgram;
	
	
	@OneToMany(mappedBy="author",cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Recipe> recipeList;
	

	public Masterchef(String fullName, String restaurant, String website, String cookingProgram) {
		super();
		this.fullName = fullName;
		this.restaurant = restaurant;
		this.website = website;
		this.cookingProgram = cookingProgram;
	}

	public Masterchef(int id, String fullName, String restaurant, String website, String cookingProgram,
			List<Recipe> recipeList) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.restaurant = restaurant;
		this.website = website;
		this.cookingProgram = cookingProgram;
		this.recipeList = recipeList;
	}

	public Masterchef() {
		super();
	}

	@Override
	public String toString() {
		return fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCookingProgram() {
		return cookingProgram;
	}

	public void setCookingProgram(String cookingProgram) {
		this.cookingProgram = cookingProgram;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	
}
