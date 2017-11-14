package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {
	/* ATTRIBUTES */
	IPizzaDao dao;

	/* CONSTRUCTOR */
	public ListerPizzasOptionMenu(IPizzaDao dao) {
		super();
		this.dao = dao;
	}

	/* METHODS */

	/**
	 * Method Execute
	 */
	public boolean execute() {
		return displayMenu1();
	}

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Lister les pizzas";
	}

	/**
	 * Display menu 1 to show list of pizza
	 */
	public boolean displayMenu1() {
		System.out.println("\nListe des pizzas");
		return super.displayPizzaList(dao);
	}


}
