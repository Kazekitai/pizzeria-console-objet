package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public abstract class OptionMenu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);

	public OptionMenu() {
	}

	/* METHODS */
	/**
	 * Method Execute
	 */
	public abstract boolean execute();

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public abstract String getLabel();

	/**
	 * Method to display list of pizza
	 */
	public boolean displayPizzaList(IPizzaDao dao) {
		System.out.println("\nListe des pizzas");
		for (int i = 0; i < dao.getPizzas().length; i++) {
			System.out.println(dao.getPizzas()[i].toString());
			// System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
		return true;
	}

}
