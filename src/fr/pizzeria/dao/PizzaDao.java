package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	/* ATTRIBUTES */
	private static Pizza [] pizzas = new Pizza[0];

	/* METHODS */
	/**
	 * Find all pizza
	 */
	@Override
	public Pizza[] findAllPizza() {
		for(int i=0;i<this.getPizzas().length;i++) {
			this.getPizzas()[i].displayPizzaString();
		}
		return null;
	}

	/**
	 * Add and save new pizza to table
	 * @param pizza
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		Pizza [] pizzasTmp = new Pizza [this.getPizzas().length+1];
		int j=0;
		for(int i=0;i<this.getPizzas().length;i++){
			pizzasTmp[j]=this.getPizzas()[i];
			j++;
		}
		pizzasTmp[this.getPizzas().length]=pizza;
		pizzasTmp[this.getPizzas().length].setId(j);
		this.setPizzas(pizzasTmp);
		return false;
	}

	/**
	 * Update a pizza into table by pizza code
	 * @param codePizza
	 * @param pizza
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for(int i=0;i<this.getPizzas().length;i++){
			if(this.getPizzas()[i].getCode().equals(codePizza)) {
				this.getPizzas()[i].setCode(pizza.getCode());
				this.getPizzas()[i].setNom(pizza.getNom());
				this.getPizzas()[i].setPrix(pizza.getPrix());
			}
		}
		return false;
	}

	/**
	 * Delete pizza into table by pizza code
	 * @param codePizza
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		Pizza [] pizzasTmp = new Pizza [this.getPizzas().length-1];
		int j=0;
		for(int i=0;i<this.getPizzas().length;i++){
			if(!this.getPizzas()[i].getCode().equals(codePizza)) {
				pizzasTmp[j]=this.getPizzas()[i];
				j++;
			}
		}
		this.setPizzas(pizzasTmp);
		return false;
	}
	
	/* GETTERS AND SETTERS */
	public static Pizza[] getPizzas() {
		return pizzas;
	}

	public static void setPizzas(Pizza[] pizzas) {
		PizzaDao.pizzas = pizzas;
	}

}
