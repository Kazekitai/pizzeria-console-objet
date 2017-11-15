package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);

	public OptionMenu() {
	}

	/* METHODS */
	/**
	 * Method Execute
	 * @throws StockageException 
	 */
	public abstract boolean execute() throws StockageException;

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
		System.out.println("\nListe des pizzas (" + dao.getPizzas().size() + " pizza)\n");
		for (int i = 0; i < dao.getPizzas().size(); i++) {
			System.out.println(dao.getPizzas().get(i).toString());
			// System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
		return true;
	}

}
