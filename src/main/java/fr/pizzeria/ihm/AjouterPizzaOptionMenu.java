package fr.pizzeria.ihm;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Class to add pizza
 * @author Sandra Le Thiec
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu {
	/* ATTRIBUTES */
	private IPizzaDao dao;
	Scanner scanner = new Scanner(System.in);
	private final Logger LOGGER = LoggerFactory.getLogger("logger2");
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");

	/* CONSTRUCTOR */
	/**
	 * Constructor with one parameter
	 * @param dao
	 */
	public AjouterPizzaOptionMenu(IPizzaDao dao) {
		super();
		this.dao = dao;
	}

	/* METHODS */

	/**
	 * Method Execute
	 * 
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
		LOGINFO.trace("\nAjout d'une nouvelle pizza");
		LOGINFO.trace("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		if (code.isEmpty()) {
			LOGGER.error("Erreur le code de la pizza est vide");
			throw new SavePizzaException("Erreur le code de la pizza est vide");

		}

		if (code.length() != 3) {
			LOGGER.error("Erreur le nombre de caractères du code de la pizza est différent de 3");
			throw new SavePizzaException("Erreur le nombre de caractères du code de la pizza est différent de 3");
		}

		LOGINFO.trace("Veuillez saisir le nom: ");
		String nom = scanner.nextLine();

		if (nom.isEmpty()) {
			LOGGER.error("Erreur le nom de la pizza est vide ");
			throw new SavePizzaException("Erreur le nom de la pizza est vide ");
		}

		LOGINFO.trace("*** Catégories ***");
		for (CategoriePizza categories : CategoriePizza.values()) {
			LOGINFO.info(categories.getValue());
		}
		LOGINFO.trace("Veuillez saisir la catégorie: ");
		String categorie = scanner.nextLine();
		categorie = upperCaseAllFirst(categorie);
		int exist = 0;
		for (CategoriePizza categories : CategoriePizza.values()) {
			if (categories.getValue().equals(categorie)) {
				exist++;
			}
		}
		if (exist == 0) {
			LOGGER.error("Erreur le code de la categorie n'est pas reconnu");
			throw new SavePizzaException("Erreur le code de la categorie n'est pas reconnu");
		}
		categorie = categorie.toUpperCase();
		categorie.replace(' ', '_');
		String categoryValue = CategoriePizza.valueOf(categorie).getValue();

		LOGINFO.trace("Veuillez saisir le prix: ");
		String prixStr = scanner.nextLine();

		if (prixStr.isEmpty()) {
			LOGGER.error("Erreur le prix de la pizza est vide");
			throw new SavePizzaException("Erreur le prix de la pizza est vide");
		}

		try {
			if (Double.parseDouble(prixStr) < 0) {
				LOGGER.error("Erreur le prix ne peux pas être négatif");
				throw new SavePizzaException("Erreur le prix ne peux pas être négatif");
			}
			double prix = Double.parseDouble(prixStr);
			code = code.toUpperCase();
			Pizza pizza = new Pizza(code, nom, categoryValue, prix);
			return this.dao.saveNewPizza(pizza);
		} catch (NumberFormatException e) {
			LOGGER.error("Le prix n'est pas un nombre. La pizza n'a pas pu tre ajoutée");
			return false;
		}
	}

}
