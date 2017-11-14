package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
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
	 * @throws SavePizzaException 
	 */
	public boolean execute() throws SavePizzaException {
		return displayMenu2();
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
	public boolean displayMenu2() throws SavePizzaException {
		System.out.println("\nAjout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		System.out.println("code: " + code);
		if (code.isEmpty()) {
			throw new SavePizzaException("Erreur le code de la pizza est vide");	
		} 
		
		if (code.length() != 3) {
			throw new SavePizzaException("Erreur le nombre de caractères du code de la pizza est différent 3");
		} 
		
		System.out.println("Veuillez saisir le nom: ");
		String nom = scanner.nextLine();
		
		if (nom.isEmpty()) {
			throw new SavePizzaException("Erreur le nom de la pizza est vide ");
		} 
		
		System.out.println("Veuillez saisir le prix: ");
		String prixStr = scanner.nextLine();
		
		if (prixStr.isEmpty()) {
			throw new SavePizzaException("Erreur le prix de la pizza est vide");
		} 
		
		try {
				if (Double.parseDouble(prixStr) < 0) {
					throw new SavePizzaException("Erreur le prix ne peux pas être négatif");
				} 
				double prix = Double.parseDouble(prixStr);
			 	code = code.toUpperCase();
				Pizza pizza = new Pizza(code, nom, prix, this.dao.getPizzas());
				return this.dao.saveNewPizza(pizza);		
			} catch (NumberFormatException  e) {
				System.out.println("Erreur: Le prix n'est pas un nombre. La pizza n'a pas pu être ajoutée");
				return false;
			}
	}

}
