package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {
	/* ATTRIBUTES */
	private static Pizza [] pizzas = new Pizza[0];
	public Scanner scanner = new Scanner(System.in);
	private PizzaDao dao = new PizzaDao();
	
	public OptionMenu() {
	}
	
	/*METHODS*/
	/**
	 * Method Execute
	 */
	public abstract void execute();
	
	/**
	 * Get Libelle of option
	 * @return
	 */
	public abstract String getLibelle();
	
	/**
	 * Method to display list of pizza
	 */
	public void displayPizzaList() {
		System.out.println("\nListe des pizzas");
		for(int i=0;i<this.pizzas.length;i++) {
			this.pizzas[i].displayPizzaString();
//			System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
	}
	
	/* GETTERS AND SETTERS*/
	public Pizza[] getPizzas() {
		return pizzas;
	}

	public void setPizzas(Pizza[] pizzas) {
		this.pizzas = pizzas;
	}

	public PizzaDao getDao() {
		return dao;
	}

	public void setDao(PizzaDao dao) {
		this.dao = dao;
	}
	
	
	
}
