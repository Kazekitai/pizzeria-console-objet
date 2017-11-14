package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	private IPizzaDao dao;

	/* CONSTRUCTOR */
	public AjouterPizzaOptionMenu(IPizzaDao dao) {
		super();
		this.dao = dao;
	}

	/* METHODS */

	/**
	 * Method Execute
	 */
	public boolean execute() {
		displayMenu2();
		return true;
	}

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public String getLabel() {
		return "Ajouter une pizza";
	}

	/**
	 * Display menu 2 to add pizza
	 */
	public boolean displayMenu2() {
		System.out.println("\nAjout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		System.out.println("Veuillez saisir le nom: ");
		String nom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix: ");
		String prixStr = scanner.nextLine();

		if (code != null && code.length() == 3) {
			/* Code has to be to upperCase */
			code = code.toUpperCase();
			if (nom != null && prixStr != null) {
				double prix = Double.parseDouble(prixStr);
				if (prix > 0) {
					Pizza pizza = new Pizza(code, nom, prix, this.dao.getPizzas());
					return this.dao.saveNewPizza(pizza);
				} else {
					System.out.println("Erreur de saisie: ");
					System.out.println(" Le prix doit être positif");
					return false;
				}
			} else {
				System.out.println("Erreur de saisie: ");
				System.out.println(" Le nom doit être saisi");
				System.out.println(" Le prix doit être saisi");
				return false;
			}

		} else {
			System.out.println("Erreur de saisie : ");
			System.out.println("le code doit comporter 3 lettres");
			return false;
			
		}

	}

}
