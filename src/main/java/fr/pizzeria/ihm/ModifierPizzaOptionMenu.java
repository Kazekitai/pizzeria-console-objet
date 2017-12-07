package fr.pizzeria.ihm;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Class to update pizza
 * 
 * @author Sandra Le Thiec
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu {
	/* ATTRIBUTES */
	IPizzaDao dao;
	Scanner scanner = new Scanner(System.in);
	private final Logger LOGGER = LoggerFactory.getLogger("logger2");
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");

	/* CONSTRUCTOR */
	public ModifierPizzaOptionMenu(IPizzaDao dao) {
		super();
		this.dao = dao;
	}

	/* METHODS */

	/**
	 * Method Execute
	 * 
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
		LOGINFO.trace("\nMise à jour d'une pizza");
		super.displayPizzaList(dao);
		LOGINFO.trace("99 pour abandonner");
		LOGINFO.trace("Veuillez choisir la pizza à modifier (saisir le code) : ");
		String choice = scanner.nextLine();

		if (!choice.equals("99")) {
			choice = choice.toUpperCase();
			if (dao.doesPizzaExist(choice) == false) {
				LOGGER.error("Erreur le code de la pizza n'est pas reconnu");
				throw new UpdatePizzaException("Erreur le code de la pizza n'est pas reconnu");
			}

			LOGINFO.trace("Veuillez saisir le code: ");
			String code = scanner.nextLine();
			if (code.isEmpty()) {
				LOGGER.error("Erreur le code de la pizza est vide");
				throw new UpdatePizzaException("Erreur le code de la pizza est vide");
			}

			if (code.length() != 3) {
				LOGGER.error("Erreur le nombre de caractères du code de la pizza est diff�rent 3");
				throw new UpdatePizzaException("Erreur le nombre de caractères du code de la pizza est diff�rent 3");
			}

			LOGINFO.trace("Veuillez saisir le nom: ");
			String nom = scanner.nextLine();

			if (nom.isEmpty()) {
				LOGGER.error("Erreur le nom de la pizza est vide ");
				throw new UpdatePizzaException("Erreur le nom de la pizza est vide ");
			}

			LOGINFO.trace("*** Catégories ***");
			for (CategoriePizza categories : CategoriePizza.values()) {
				LOGINFO.trace(categories.getValue());
			}
			LOGINFO.trace("Veuillez saisir la catégorie: ");
			String categorie = scanner.nextLine();
			categorie = upperCaseAllFirst(categorie);
			int categoryExist = 0;
			for (CategoriePizza categories : CategoriePizza.values()) {
				if (categories.getValue().equals(categorie)) {
					categoryExist++;
				}
			}
			if (categoryExist == 0) {
				LOGGER.error("Erreur le code de la categorie n'est pas reconnu");
				throw new UpdatePizzaException("Erreur le code de la categorie n'est pas reconnu");
			}
			categorie = categorie.toUpperCase();
			categorie.replace(' ', '_');
			String categoryValue = CategoriePizza.valueOf(categorie).getValue();
			// PizerriaAdminConsoleApp.getLog().trace(categorie);

			LOGINFO.trace("Veuillez saisir le prix: ");
			String prixStr = scanner.nextLine();

			if (prixStr.isEmpty()) {
				LOGGER.error("Erreur le prix de la pizza est vide");
				throw new UpdatePizzaException("Erreur le prix de la pizza est vide");
			}

			try {
				if (Double.parseDouble(prixStr) < 0) {
					LOGGER.error("Erreur le prix ne peux pas être négatif");
					throw new UpdatePizzaException("Erreur le prix ne peux pas être négatif");
				}
				double prix = Double.parseDouble(prixStr);
				code = code.toUpperCase();
				Pizza pizza = new Pizza(code, nom, categoryValue, prix);
				return this.dao.updatePizza(choice, pizza);
			} catch (NumberFormatException e) {
				LOGGER.error("Erreur: Le prix n'est pas un nombre. La pizza n'a pas pu être ajoutée");
				return false;
			}

		} else {
			return false;
		}
	}
}
