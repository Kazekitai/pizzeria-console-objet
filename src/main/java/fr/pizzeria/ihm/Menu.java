package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.dao.jpa.PizzaDaoJPA;
import fr.pizzeria.exception.StockageException;

/**
 * Class Menu from Pizzeria application
 * @author Sandra Le Thiec
 *
 */
public class Menu {
	
	/* ATTRIBUTES */
	
	/**
	 * An object to interact with user
	 */
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * Logger object for display information inside console
	 */
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1"); 
	
	/**
	 * A data access object
	 */
	private PizzaDaoJPA dao = new PizzaDaoJPA();
	
	/**
	 * Menu title
	 */
	private String title;
	
	/**
	 * Menu options
	 */
	private HashMap<Integer,OptionMenu> optionMenus = new HashMap<Integer,OptionMenu>();
	
	/**
	 * Menu index to instantiate ListerPizzasOptionMenu class
	 */
	private static final int DISPLAY_PIZZA = 0;
	
	/**
	 * Menu index to instantiate AjouterPizzaOptionMenu class
	 */
	private static final int ADD_PIZZA = 1;
	
	/**
	 * Menu index to instantiate ModifierPizzaOptionMenu class
	 */
	private static final int UPDATE_PIZZA = 2;
	
	/**
	 * Menu index to instantiate SupprimerPizzaOptionMenu class
	 */
	private static final int DELETE_PIZZA = 3;

	/* CONSTRUCTOR */
	/**
	 * Constructor
	 */
	public Menu() {
		title = "***** Pizzeria Administration *****";
		optionMenus.put(DISPLAY_PIZZA, new ListerPizzasOptionMenu(dao));
		optionMenus.put(ADD_PIZZA, new AjouterPizzaOptionMenu(dao));
		optionMenus.put(UPDATE_PIZZA, new ModifierPizzaOptionMenu(dao));
		optionMenus.put(DELETE_PIZZA, new SupprimerPizzaOptionMenu(dao));
	}

	/**
	 * Method to lunch application with class separated
	 */
	public void afficher() {
		int option = 0;
		/* Run application */
		while (option != 99) {
			displayMenu();
			option = Integer.parseInt(scanner.nextLine());
			
			switch (option) {
			case 1:
				try {
					optionMenus.get(DISPLAY_PIZZA).execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					optionMenus.get(ADD_PIZZA).execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					optionMenus.get(UPDATE_PIZZA).execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					optionMenus.get(DELETE_PIZZA).execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 99:
				LOGINFO.trace("\nAu revoir " + ":(");
				break;
			default:
				LOGINFO.trace("\nCette option n'existe pas!");
				break;
			}
		}
		scanner.close();
	}

	/**
	 * Method to display Pizzeria menu for administrator
	 */
	public void displayMenu() {
		LOGINFO.trace("\n" + this.title);
		for (int i = 0; i < optionMenus.size() ; i++) {
			if (optionMenus.get(i) != null) {
				LOGINFO.trace((i + 1) + ". " + optionMenus.get(i).getLabel());
			}
		}
		LOGINFO.trace("99. Sortir.");
		LOGINFO.trace("Quelle action voulez-vous effectuer?");
	}

	/* GETTER */
	/**
	 * Get menu options
	 * @return
	 */
	public HashMap<Integer,OptionMenu> getOptionMenus() {
		return optionMenus;
	}

}
