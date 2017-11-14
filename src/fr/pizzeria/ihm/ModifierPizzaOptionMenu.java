package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	IPizzaDao dao;

	/* CONSTRUCTOR */
	public ModifierPizzaOptionMenu(IPizzaDao dao) {
		super();
		this.dao = dao;
	}

	/* METHODS */

	/**
	 * Method Execute
	 * @throws UpdatePizzaException 
	 */
	public boolean execute() throws UpdatePizzaException {
		return displayMenu3();
	}

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Mettre à jour une pizza";
	}

	/**
	 * Display menu 3 to update pizza
	 */
	public boolean displayMenu3() throws UpdatePizzaException {
		System.out.println("\nMise à jour d'une pizza");
		System.out.println("\nMise à jour d'une pizza");
		System.out.println("\nPizzas size: " + this.dao.getPizzas().length);
		displayPizzaList(dao);
		System.out.println("Veuillez choisir la pizza à modifier (saisir le code) : ");
		String choice = scanner.nextLine();
		choice = choice.toUpperCase();
		int exist = 0;
		for (int i = 0; i < dao.getPizzas().length; i++) {
			if (dao.getPizzas()[i].getCode().equals(choice)) {
				exist++;
			}
		}
		if(exist == 0) {
			throw new UpdatePizzaException("Erreur le code de la pizza n'est pas reconnu");
		}
		
		System.out.println("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		if (code.isEmpty()) {
			throw new UpdatePizzaException("Erreur le code de la pizza est vide");
		}

		if (code.length() != 3) {
			throw new UpdatePizzaException("Erreur le nombre de caractères du code de la pizza est différent 3");
		}

		System.out.println("Veuillez saisir le nom: ");
		String nom = scanner.nextLine();

		if (nom.isEmpty()) {
			throw new UpdatePizzaException("Erreur le nom de la pizza est vide ");
		}

		System.out.println("Veuillez saisir le prix: ");
		String prixStr = scanner.nextLine();

		if (prixStr.isEmpty()) {
			throw new UpdatePizzaException("Erreur le prix de la pizza est vide");
		}

		try {
			if (Double.parseDouble(prixStr) < 0) {
				throw new UpdatePizzaException("Erreur le prix ne peux pas être négatif");
			}
			double prix = Double.parseDouble(prixStr);
			code = code.toUpperCase();
			Pizza pizza = new Pizza(code, nom, prix);
			return this.dao.updatePizza(choice, pizza);
		} catch (NumberFormatException e) {
			System.out.println("Erreur: Le prix n'est pas un nombre. La pizza n'a pas pu être ajoutée");
			return false;
		}
	}
}
