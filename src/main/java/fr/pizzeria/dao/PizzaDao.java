package fr.pizzeria.dao;

import java.util.ArrayList;
import fr.pizzeria.model.Pizza;

public class PizzaDao implements IPizzaDao {
	/* ATTRIBUTES */
	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	
	/* CONSTRUCTOR */
	/**
	 * Constructor PizzaDao
	 */
	public PizzaDao() {
		/* Initialization of pizza list */
		pizzas.add(new Pizza("PEP","Pépéroni","VIANDE",12.50,getPizzas()));
		pizzas.add(new Pizza("MAR","Margherita","SANS_VIANDE",14.00,getPizzas()));
		pizzas.add(new Pizza("REI","La Reine","SANS_VIANDE",11.50,getPizzas()));
		pizzas.add(new Pizza("FRO","La 4 fromage","VIANDE",12.50,getPizzas()));
		pizzas.add(new Pizza("CAN","La Cannibale","VIANDE",12.50,getPizzas()));
		pizzas.add(new Pizza("SAV","La Savoyarde","VIANDE",13.00,getPizzas()));
		pizzas.add(new Pizza("ORI","L'Orientale","VIANDE",13.50,getPizzas()));
		pizzas.add(new Pizza("IND","L'Indienne","VIANDE",14.00,getPizzas()));
		
	}

	/* METHODS */
	/**
	 * Find all pizza
	 */
	@Override
	public ArrayList<Pizza> findAllPizza() {
		return pizzas;
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
				this.getPizzas().get(i).setCategoriePizza(pizza.getCategoriePizza());
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
	
	/**
	 * Test if pizza exist
	 * @param codePizza
	 * @return
	 */
	public boolean doesPizzaExist(String codePizza) {
		int exist = 0;
		for (int i = 0; i < this.getPizzas().size(); i++) {
			if (this.getPizzas().get(i).getCode().equals(codePizza)) {
				exist++;
			}
		}
		if(exist == 0) {
			return false;
		} else {
			return true;
		}

		
	}
	
	/* GETTERS AND SETTERS */
	/**
	 * Getter for pizzas
	 * @return the pizzas
	 */
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}

	/**
	 * Setters for pizzas
	 * @param pizzas the pizzas to set
	 */
	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}


}
