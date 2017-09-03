package pl.Mateusz.testDb;


import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import pl.Mateusz.RecipesManager.entity.CousineType;
import pl.Mateusz.RecipesManager.entity.Masterchef;
import pl.Mateusz.RecipesManager.entity.MealType;
import pl.Mateusz.RecipesManager.entity.Recipe;

public class DBTest {

	public static void main(String[] args) {
					//setup connection varaibles 
			
			String user = "root";
			String password = "root";
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/customerrecipesmanager?useSSL=false";
			
			String driver = "com.mysql.jdbc.Driver";
			//get connection to the database

			try {
				
				Connection conn=DriverManager.getConnection(jdbcUrl, user, password);
				System.out.println("\n\nconnection succes");
				
				System.out.println(conn.isClosed());
				
				conn.close();
				System.out.println(conn.isClosed());
				
			} catch (Exception e) {
				System.out.println("there is an exception:");
				e.printStackTrace();
			}
			
			
			//just populate the database so We can see if the app is working properly
			// if data is displayed right way
			
			createRecipes();

	}
	
	
	public static void createRecipes() {
		
		 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
					addAnnotatedClass(Recipe.class)
					.addAnnotatedClass(Masterchef.class)
					.buildSessionFactory();
		 
		 Session session = factory.getCurrentSession();
		 
			System.out.println("start the transaction");
			session.beginTransaction();
			
			System.out.println("making a bunch of objects");
			
			Masterchef u1 = new Masterchef("Mateusz", "Zdorwa knajpa", "www.garzdrowia.pl", "Gotowanie z MAtim");

			Masterchef u2 = new Masterchef("Magda Gessler", "uFukiera", "www.fukier.pl", "Kuchenne Rewolucje");

			Masterchef u3 = new Masterchef("Masterchef", "Master Restaurant", "masterchef.tvn.pl", "Masterchef - tvn");
			
			Masterchef u4 = new Masterchef("Kucharz po technikum", "stolówka@gessler.pl", "", "");

			Masterchef u5 = new Masterchef("Kucharz amator", "amatorka@tvn.pl", "", "");
			
			
			Recipe rec11 = new Recipe("Wloska salatka", "pokroic warzywa i jesc", 
					CousineType.Italian, MealType.Salad, u1);
			Recipe rec12 = new Recipe("miecho", "pokroic i ugotowac, jesc", 
					CousineType.Spanish, MealType.Meat, u1);

			Recipe rec21 = new Recipe("schabowe z mlekiem", "rozbic i smazyc, jesc", 
					CousineType.Polish, MealType.Meat, u2);
			Recipe rec22 = new Recipe("zupka wloska", "ugotowac, no i tyle. jesc", 
					CousineType.Italian, MealType.Soup, u2);

			Recipe rec23 = new Recipe("omlecik jajeczny", "maka jaja i jesc po smazeniu", 
					CousineType.Polish, MealType.Supper, u2);
			Recipe rec33 = new Recipe("pancakes", "posmazyc i jesc", 
					CousineType.American, MealType.Breakfast, u3);
			
			Recipe rec31 = new Recipe("ruskie pierogi", "ciasto, farsz. ulepic i ugotowac", 
					CousineType.Russian, MealType.Supper, u3);
			Recipe rec32 = new Recipe("pancakes z syropem", "usmazyc, polac syropem i zjesc", 
					CousineType.American, MealType.Breakfast, u3);
			
			Recipe rec41 = new Recipe("salateczka francuska", "jakies warzywka, przyprawa prowansalnska. bla bla ", 
					CousineType.French, MealType.Salad, u4);
			Recipe rec42 = new Recipe("miecho", "pokroic i ugotowac, jesc", 
					CousineType.Oriental, MealType.Supper, u4);

			Recipe rec43 = new Recipe("kompot owocowy", "ugotowac wode z owocami", 
					CousineType.Polish, MealType.Fruit, u4);
			Recipe rec51 = new Recipe("zupa z Wloch", "za trudna sprawa dla mnie.", 
					CousineType.Italian, MealType.Soup, u5);

			
			
			System.out.println("saving objects");
			
			session.save(u1);
			session.save(u2);
			session.save(u3);

			session.save(u4);
			session.save(u5);
			
			session.save(rec11);
			session.save(rec12);

			session.save(rec21);
			session.save(rec22);
			session.save(rec23);

			session.save(rec31);
			session.save(rec32);
			session.save(rec33);
			
			session.save(rec41);
			session.save(rec42);
			session.save(rec43);
			
			session.save(rec51);
			
			System.out.println("commit transaction");
			session.getTransaction().commit();
		
	}

}
