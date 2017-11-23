package main.java.dev.fr.pizzeria.ihm;

import main.java.dev.fr.pizzeria.dao.IPizzaDao;

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
		return super.displayPizzaList(dao);
	}


}
