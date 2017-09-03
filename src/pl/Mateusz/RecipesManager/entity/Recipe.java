package pl.Mateusz.RecipesManager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer  id;

	@Column(name = "name")
	private String name;

	@Column(name = "preparation")
	@Type(type="text")
	private String preparation;

	@Column(name = "cousine_type")
	@Enumerated(EnumType.STRING)
	private CousineType cousineType;

	@Column(name = "meal_type")
	@Enumerated(EnumType.STRING)
	private MealType mealType;

	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name="masterchef_id")
	Masterchef author;

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", preparation=" + preparation + ", cousineType=" + cousineType
				+ ", mealType=" + mealType + ", author=" + author + "]";
	}

	public Recipe() {
		super();
	}

	public Recipe(String name, String preparation, CousineType cousineType, MealType mealType, Masterchef author) {
		super();
		this.name = name;
		this.preparation = preparation;
		this.cousineType = cousineType;
		this.mealType = mealType;
		this.author = author;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public CousineType getCousineType() {
		return cousineType;
	}

	public void setCousineType(CousineType cousineType) {
		this.cousineType = cousineType;
	}

	public MealType getMealType() {
		return mealType;
	}

	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	public Masterchef getAuthor() {
		return author;
	}

	public void setAuthor(Masterchef author) {
		this.author = author;
	}


}
