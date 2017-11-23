package main.java.dev.fr.pizzeria.ihm;

import main.java.dev.fr.pizzeria.console.PizerriaAdminConsoleApp;
import main.java.dev.fr.pizzeria.dao.IPizzaDao;
import main.java.dev.fr.pizzeria.exception.UpdatePizzaException;
import main.java.dev.fr.pizzeria.model.CategoriePizza;
import main.java.dev.fr.pizzeria.model.Pizza;

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
		PizerriaAdminConsoleApp.getLog().trace("\nMise à jour d'une pizza");
		super.displayPizzaList(dao);
		PizerriaAdminConsoleApp.getLog().trace("99 pour abandonner");
		PizerriaAdminConsoleApp.getLog().trace("Veuillez choisir la pizza à modifier (saisir le code) : ");
		String choice = scanner.nextLine();
		
		if (!choice.equals("99")) {
			choice = choice.toUpperCase();
			int exist = 0;
			for (int i = 0; i < dao.getPizzas().size(); i++) {
				if (dao.getPizzas().get(i).getCode().equals(choice)) {
					exist++;
				}
			}
			if(exist == 0) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur le code de la pizza n'est pas reconnu");
				throw new UpdatePizzaException("Erreur le code de la pizza n'est pas reconnu");
			}
			PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir le code: ");
			String code = scanner.nextLine();
			if (code.isEmpty()) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur le code de la pizza est vide");
				throw new UpdatePizzaException("Erreur le code de la pizza est vide");
			}

			if (code.length() != 3) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur le nombre de caract�res du code de la pizza est diff�rent 3");
				throw new UpdatePizzaException("Erreur le nombre de caract�res du code de la pizza est diff�rent 3");
			}

			PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir le nom: ");
			String nom = scanner.nextLine();

			if (nom.isEmpty()) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur le nom de la pizza est vide ");
				throw new UpdatePizzaException("Erreur le nom de la pizza est vide ");
			}
			
			PizerriaAdminConsoleApp.getLog().trace("*** Catégories ***");
			for (CategoriePizza categories : CategoriePizza.values()  ) {
				PizerriaAdminConsoleApp.getLog().trace(categories.getValue());
			}
			PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir la catégorie: ");
			String categorie = scanner.nextLine();
			categorie = upperCaseAllFirst(categorie);
			int categoryExist = 0;
			for (CategoriePizza categories : CategoriePizza.values()  ) {
				if (categories.getValue().equals(categorie)) {
					categoryExist++;
				}
			}
			if(categoryExist == 0) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur le code de la categorie n'est pas reconnu");
				throw new UpdatePizzaException("Erreur le code de la categorie n'est pas reconnu");
			}
			categorie = categorie.toUpperCase();
			categorie.replace(' ', '_');
			PizerriaAdminConsoleApp.getLog().trace(categorie);

			PizerriaAdminConsoleApp.getLog().trace("Veuillez saisir le prix: ");
			String prixStr = scanner.nextLine();

			if (prixStr.isEmpty()) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur le prix de la pizza est vide");
				throw new UpdatePizzaException("Erreur le prix de la pizza est vide");
			}
			
			try {
				if (Double.parseDouble(prixStr) < 0) {
					PizerriaAdminConsoleApp.getLogfull().error("Erreur le prix ne peux pas être négatif");
					throw new UpdatePizzaException("Erreur le prix ne peux pas être négatif");
				}
				double prix = Double.parseDouble(prixStr);
				code = code.toUpperCase();
				Pizza pizza = new Pizza(code, nom, categorie,prix);
				return this.dao.updatePizza(choice, pizza);
			} catch (NumberFormatException e) {
				PizerriaAdminConsoleApp.getLogfull().error("Erreur: Le prix n'est pas un nombre. La pizza n'a pas pu être ajoutée");
				return false;
			}
			
		} else {
			return false;
		}
	}
}
