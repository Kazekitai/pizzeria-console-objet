package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	ArrayList<Pizza> findAllPizza();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza,Pizza pizza);
	boolean deletePizza(String codePizza);
	public ArrayList<Pizza> getPizzas();
	public void setPizzas(ArrayList<Pizza> pizzas);

}
