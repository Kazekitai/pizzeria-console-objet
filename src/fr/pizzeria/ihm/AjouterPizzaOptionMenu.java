package fr.pizzeria.ihm;

import fr.pizzeria.console.PizerriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
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
		PizerriaAdminConsoleApp.getLog().trace("\nAjout d'une nouvelle pizza");
		PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		if (code.isEmpty()) {
			PizerriaAdminConsoleApp.getLogfull().error("Erreur le code de la pizza est vide");
			throw new SavePizzaException("Erreur le code de la pizza est vide");
			
		} 
		
		if (code.length() != 3) {
			PizerriaAdminConsoleApp.getLogfull().error("Erreur le nombre de caractères du code de la pizza est différent de 3");
			throw new SavePizzaException("Erreur le nombre de caractères du code de la pizza est différent de 3");
		} 
		
		PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir le nom: \"");
		String nom = scanner.nextLine();
		
		if (nom.isEmpty()) {
			PizerriaAdminConsoleApp.getLogfull().error("Erreur le nom de la pizza est vide ");
			throw new SavePizzaException("Erreur le nom de la pizza est vide ");
		} 
		
		PizerriaAdminConsoleApp.getLog().trace("*** Catégories ***");
		for (CategoriePizza categories : CategoriePizza.values()  ) {
			System.out.println(categories.getValue());
			PizerriaAdminConsoleApp.getLog().info(categories.getValue());
		}
		PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir la catégorie: ");
		String categorie = scanner.nextLine();
		categorie = upperCaseAllFirst(categorie);
		int exist = 0;
		for (CategoriePizza categories : CategoriePizza.values()  ) {
			if (categories.getValue().equals(categorie)) {
				exist++;
			}
		}
		if(exist == 0) {
			PizerriaAdminConsoleApp.getLogfull().error("Erreur le code de la categorie n'est pas reconnu");
			throw new SavePizzaException("Erreur le code de la categorie n'est pas reconnu");
		}
		categorie = categorie.toUpperCase();
		categorie.replace(' ', '_');
		
		if (nom.isEmpty()) {
			PizerriaAdminConsoleApp.getLogfull().error("Erreur le nom de la pizza n'est pas reconnu ");
			throw new SavePizzaException("Erreur le nom de la pizza n'est pas reconnu ");
		}
		
		PizerriaAdminConsoleApp.getLogfull().trace("Veuillez saisir le prix: ");
		String prixStr = scanner.nextLine();
		
		if (prixStr.isEmpty()) {
			PizerriaAdminConsoleApp.getLogfull().error("Erreur le prix de la pizza est vide");
			throw new SavePizzaException("Erreur le prix de la pizza est vide");
		} 
		
		try {
				if (Double.parseDouble(prixStr) < 0) {
					PizerriaAdminConsoleApp.getLogfull().error("Erreur le prix ne peux pas être négatif");
					throw new SavePizzaException("Erreur le prix ne peux pas être négatif");
				} 
				double prix = Double.parseDouble(prixStr);
			 	code = code.toUpperCase();
				Pizza pizza = new Pizza(code, nom, categorie, prix, this.dao.getPizzas());
				return this.dao.saveNewPizza(pizza);		
			} catch (NumberFormatException  e) {
				PizerriaAdminConsoleApp.getLogfull().error("Le prix n'est pas un nombre. La pizza n'a pas pu tre ajoutée");
				System.out.println("Erreur: Le prix n'est pas un nombre. La pizza n'a pas pu tre ajoutée");
				return false;
			}
	}

}
