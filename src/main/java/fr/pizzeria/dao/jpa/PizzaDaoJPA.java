package fr.pizzeria.dao.jpa;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 *Dao Class to manipulate data from database using JPA
 * 
 * @author Sandra Le Thiec
 *
 */
public class PizzaDaoJPA implements IPizzaDao {
	
	/* CONSTRUCTOR */
	/**
	 * Constructor PizzaDaoJPA
	 */
	public PizzaDaoJPA() {
		/* Initialization of pizza list */
		saveNewPizza(new Pizza("PEP","Pépéroni","Viande",12.50));
		saveNewPizza(new Pizza("MAR","Margherita","Sans Viande",14.00));
		saveNewPizza(new Pizza("REI","La Reine","Sans Viande",11.50));
		saveNewPizza(new Pizza("FRO","La 4 fromage","Viande",12.50));
		saveNewPizza(new Pizza("CAN","La Cannibale","Viande",12.50));
		saveNewPizza(new Pizza("SAV","La Savoyarde","Viande",13.00));
		saveNewPizza(new Pizza("ORI","L'Orientale","Viande",13.50));
		saveNewPizza(new Pizza("IND","L'Indienne","Viande",14.00));
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
		Pizza pizzaExist = getPizzaBycode(pizza.getCode());
		if(pizzaExist == null) {
			DbManagerJPA.getInstance().getEntityManager().getTransaction().begin();	
			DbManagerJPA.getInstance().getEntityManager().persist(pizza);
			DbManagerJPA.getInstance().getEntityManager().getTransaction().commit();
			DbManagerJPA.getInstance().getEntityManager().close();
			DbManagerJPA.getInstance().getEntityManagerFactory().close();
			return true;
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
		Pizza pizzaToUpdate = getPizzaBycode(codePizza);
		if(pizzaToUpdate != null) {
			pizzaToUpdate.setCategoriePizza(pizza.getCategoriePizza());
			pizzaToUpdate.setCode(pizza.getCode());
			pizzaToUpdate.setNom(pizza.getNom());
			pizzaToUpdate.setPrix(pizza.getPrix());
			DbManagerJPA.getInstance().getEntityManager().getTransaction().begin();
			DbManagerJPA.getInstance().getEntityManager().merge(pizzaToUpdate);
			DbManagerJPA.getInstance().getEntityManager().getTransaction().commit();
			DbManagerJPA.getInstance().getEntityManager().close();
			DbManagerJPA.getInstance().getEntityManagerFactory().close();
			return true;
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
		
		Pizza pizza = getPizzaBycode(codePizza);
		if(pizza != null) {
			DbManagerJPA.getInstance().getEntityManager().getTransaction().begin();
			DbManagerJPA.getInstance().getEntityManager().remove(pizza);
			DbManagerJPA.getInstance().getEntityManager().getTransaction().commit();
			DbManagerJPA.getInstance().getEntityManager().close();
			DbManagerJPA.getInstance().getEntityManagerFactory().close();
			return true;
		}
				
		return false;
	}
	
	/**
	 * Get pizza by pizza code
	 * 
	 * @param codePizza
	 */
	public Pizza getPizzaBycode(String codePizza) {
		TypedQuery<Pizza> query = DbManagerJPA.getInstance().getEntityManager().createQuery("SELECT p FROM Pizza p WHERE p.code= :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza pizza = null;
		List<Pizza> pizzas = query.getResultList();
		if(pizzas.size() > 0) {
			pizza = pizzas.get(0);
		}			
		return pizza;
	}
	
	/**
	 * Test if pizza exist
	 * @param codePizza
	 * @return
	 */
	public boolean doesPizzaExist(String codePizza) {
		Pizza pizza = getPizzaBycode(codePizza);
		if(pizza != null) {
			return true;
		}	
		return false;	
	}
		


}
