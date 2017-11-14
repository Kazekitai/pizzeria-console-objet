package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	Pizza [] findAllPizza();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza,Pizza pizza);
	boolean deletePizza(String codePizza);
	public Pizza[] getPizzas();
	public void setPizzas(Pizza[] pizzas);

}
