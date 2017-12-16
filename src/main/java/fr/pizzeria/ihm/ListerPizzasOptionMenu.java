package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Class to display pizza list
 * @author Sandra Le Thiec
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {
	
	/* ATTRIBUTES */
	
	/**
	 * A data access object
	 */
	IPizzaDao dao;

	/* CONSTRUCTOR */
	/**
	 * Constructor with one parameter
	 * 
	 * @param dao
	 */
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
