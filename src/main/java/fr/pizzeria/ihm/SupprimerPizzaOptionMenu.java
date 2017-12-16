package fr.pizzeria.ihm;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

/**
 * Class to delete pizza
 * @author Sandra Le Thiec
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {
	/* ATTRIBUTES */
	/**
	 * A data access object
	 */
	private IPizzaDao dao;
	
	/**
	 * An object to interact with user
	 */
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Logger object for error messages
	 */
	private final Logger LOGGER = LoggerFactory.getLogger("logger2");
	
	/**
	 * Logger object for display information inside console
	 */
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1");
	/* CONSTRUCTOR */
	/**
	 * Constructor with one parameter
	 * @param dao
	 */
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
		LOGINFO.trace("\nSupression d'une pizza");
		super.displayPizzaList(dao);
		LOGINFO.trace("99 pour abandonner");
		LOGINFO.trace("Veuillez choisir la pizza à supprimer (saisir le code) : ");
		String choice = scanner.nextLine();
		if (!choice.equals("99")) {
			choice = choice.toUpperCase();
			if(dao.doesPizzaExist(choice) == false) {
				LOGGER.error("Erreur le code de la pizza n'est pas reconnu");
				throw new DeletePizzaException("Erreur le code de la pizza n'est pas reconnu");
			}
			return dao.deletePizza(choice);
		} else {
			return false;
		}
	}
}