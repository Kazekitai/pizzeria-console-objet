package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	IPizzaDao dao;

	/* CONSTRUCTOR */
	public SupprimerPizzaOptionMenu(IPizzaDao dao) {
		super();
		this.dao = dao;
	}

	/* METHODS */

	/**
	 * Method Execute
	 */
	public boolean execute() {
		return displayMenu4();
	}

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Supprimer une pizza";
	}

	/**
	 * Display menu 4 to delete pizza
	 */
	public boolean displayMenu4() {
		System.out.println("\nSupression d'une pizza");
		displayPizzaList(dao);
		System.out.println("99 pour abandonner");
		System.out.println("Veuillez choisir la pizza à supprimer (saisir le code) : ");
		String choice = scanner.nextLine();
		if (!choice.equals("99")) {
			return this.dao.deletePizza(choice);
		} else {
			return false;
		}
	}

	/**
	 * Method to delete chose pizza
	 * 
	 * @param pizza
	 * @param choice
	 */
	public void deletePizza(String choice) {
		Pizza[] pizzasTmp = new Pizza[this.dao.getPizzas().length - 1];
		int j = 0;
		for (int i = 0; i < this.dao.getPizzas().length; i++) {
			if (!this.dao.getPizzas()[i].getCode().equals(choice)) {
				pizzasTmp[j] = this.dao.getPizzas()[i];
				j++;
			}
		}
		this.dao.setPizzas(pizzasTmp);
	}
}