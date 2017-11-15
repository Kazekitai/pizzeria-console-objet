package fr.pizzeria.dao;

import java.util.ArrayList;

import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	/* ATTRIBUTES */
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	/* METHODS */
	/**
	 * Find all pizza
	 */
	@Override
	public ArrayList<Pizza> findAllPizza() {
		for(int i=0;i<this.getPizzas().size();i++) {
			/* display all pizza */
			this.getPizzas().get(i).displayPizzaString();
		}
		return null;
	}

	/**
	 * Add and save new pizza to table
	 * @param pizza
	 */
	@Override
	public boolean saveNewPizza(Pizza pizza) {
		this.getPizzas().add(pizza);
		return true;
	}

	/**
	 * Update a pizza into table by pizza code
	 * @param codePizza
	 * @param pizza
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		for(int i=0;i<this.getPizzas().size();i++){
			if(this.getPizzas().get(i).getCode().equals(codePizza)) {
				this.getPizzas().get(i).setCode(pizza.getCode());
				this.getPizzas().get(i).setNom(pizza.getNom());
				this.getPizzas().get(i).setPrix(pizza.getPrix());
			}
		}
		return true;
	}

	/**
	 * Delete pizza into table by pizza code
	 * @param codePizza
	 */
	@Override
	public boolean deletePizza(String codePizza) {
		for(int i=0;i<this.getPizzas().size();i++){
			if(this.getPizzas().get(i).getCode().equals(codePizza)) {
				this.getPizzas().remove(i);
			}
		}
		return true;
	}
	
	/* GETTERS AND SETTERS */
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}
