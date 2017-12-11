package fr.pizzeria.dao.jpa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 *Dao Class to manipulate data from database
 * 
 * @author Sandra Le Thiec
 *
 */
public class PizzaDaoJPA implements IPizzaDao {
	/* ATTRIBUTES */
	private final Logger LOGGER = LoggerFactory.getLogger("logger2");

	/* CONSTRUCTOR */
	/**
	 * Constructor PizzaDaoJdbc
	 */
	public PizzaDaoJPA() {
	}

	/* METHODS */

	/**
	 * Find all pizza
	 */
	@Override
	public ArrayList<Pizza> findAllPizza() {
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		TypedQuery<Pizza> query = DbManagerJPA.getInstance().getEntityManager().createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> pizzasList = query.getResultList();
		if (!pizzasList.isEmpty()) {
			pizzasList.stream().forEach(a -> pizzas.add(a) );
		}
		return pizzas;
	}

	/**
	 * Add and save new pizza to table
	 * 
	 * @param pizza
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		if (doesPizzaExist(pizza.getCode()) == false) {
			DbManagerJPA.getInstance().getEntityManager().getTransaction().begin();
			DbManagerJPA.getInstance().getEntityManager().persist(pizza);
			DbManagerJPA.getInstance().getEntityManager().getTransaction().commit();
			DbManagerJPA.getInstance().getEntityManager().close();
			DbManagerJPA.getInstance().getEntityManagerFactory().close();
		}
				
		return false;
	}

	/**
	 * Update a pizza into table by pizza code
	 * 
	 * @param codePizza
	 * @param pizza
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		if (doesPizzaExist(codePizza) == false) {
			DbManagerJPA.getInstance().getEntityManager().getTransaction().begin();
			DbManagerJPA.getInstance().getEntityManager().merge(pizza);
			DbManagerJPA.getInstance().getEntityManager().getTransaction().commit();
			DbManagerJPA.getInstance().getEntityManager().close();
			DbManagerJPA.getInstance().getEntityManagerFactory().close();
		}
				
		return false;
	}

	/**
	 * Delete pizza into table by pizza code
	 * 
	 * @param codePizza
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		
		return false;
	}

	/**
	 * Test if pizza exist
	 * 
	 * @param codePizza
	 * @return
	 */
	public boolean doesPizzaExist(String codePizza) {
//		try {
//			DbManagerJPA.getInstance().openDbConnection();
//			String selectQuery = "SELECT * FROM pizza";
//			PreparedStatement selectPizzaSt = DbManagerJPA.getInstance().getConnection().prepareStatement(selectQuery);
//			ResultSet resultats = selectPizzaSt.executeQuery();
//			while (resultats.next()) {
//				if (resultats.getString("CODE").equals(codePizza)) {
//					return true;
//				}
//			}
//			selectPizzaSt.close();
//			DbManagerJPA.getInstance().getConnection().close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return false;
	}

}
