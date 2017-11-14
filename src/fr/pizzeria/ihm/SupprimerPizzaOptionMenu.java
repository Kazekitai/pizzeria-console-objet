package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
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
	 * @throws DeletePizzaException 
	 */
	public boolean execute() throws DeletePizzaException {
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
	 * @throws DeletePizzaException 
	 */
	public boolean displayMenu4() throws DeletePizzaException {
		System.out.println("\nSupression d'une pizza");
		displayPizzaList(dao);
		System.out.println("99 pour abandonner");
		System.out.println("Veuillez choisir la pizza à supprimer (saisir le code) : ");
		String choice = scanner.nextLine();
		if (!choice.equals("99")) {
			choice = choice.toUpperCase();
			int exist = 0;
			for (int i = 0; i < dao.getPizzas().length; i++) {
				if (dao.getPizzas()[i].getCode().equals(choice)) {
					exist++;
				}
			}
			if(exist == 0) {
				throw new DeletePizzaException("Erreur le code de la pizza n'est pas reconnu");
			}
			return true;
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