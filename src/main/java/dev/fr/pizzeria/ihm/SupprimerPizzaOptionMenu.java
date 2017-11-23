package main.java.dev.fr.pizzeria.ihm;

import main.java.dev.fr.pizzeria.console.PizerriaAdminConsoleApp;
import main.java.dev.fr.pizzeria.dao.IPizzaDao;
import main.java.dev.fr.pizzeria.exception.DeletePizzaException;

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
		PizerriaAdminConsoleApp.getLog().trace("\nSupression d'une pizza");
		super.displayPizzaList(dao);
		PizerriaAdminConsoleApp.getLog().trace("99 pour abandonner");
		PizerriaAdminConsoleApp.getLog().trace("Veuillez choisir la pizza à supprimer (saisir le code) : ");
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
				throw new DeletePizzaException("Erreur le code de la pizza n'est pas reconnu");
			}
			return dao.deletePizza(choice);
		} else {
			return false;
		}
	}
}