package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

/**
 * Pizzeria interface : data manipulation
 * 
 * @author Sandra Le Thiec
 *
 */
public interface IPizzaDao {
	
	/**
	 * Method to find all pizza from database
	 * @return list of pizza
	 */
	ArrayList<Pizza> findAllPizza();

	/**
	 * Method to save a pizza into database
	 * @param pizza
	 * @return
	 */
	boolean saveNewPizza(Pizza pizza);

	/**
	 * Method to update a pizza into database
	 * @param codePizza
	 * @param pizza
	 * @return
	 */
	boolean updatePizza(String codePizza, Pizza pizza);

	/**
	 * Method to delete a pizza into database
	 * @param codePizza
	 * @return
	 */
	boolean deletePizza(String codePizza);

	/**
	 * Method to test if pizza exist into database
	 * @param codePizza
	 * @return
	 */
	public boolean doesPizzaExist(String codePizza);

}
