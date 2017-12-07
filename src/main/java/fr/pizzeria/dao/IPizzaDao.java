package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

/**
 * Interface de la pizzeria: manipulation des données
 * 
 * @author Sandra Le Thiec
 *
 */
public interface IPizzaDao {
	ArrayList<Pizza> findAllPizza();

	boolean saveNewPizza(Pizza pizza);

	boolean updatePizza(String codePizza, Pizza pizza);

	boolean deletePizza(String codePizza);

	public boolean doesPizzaExist(String codePizza);

}
