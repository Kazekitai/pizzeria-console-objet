package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;

public class Menu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);
	private PizzaDao dao = new PizzaDao();
	private String title;
	private OptionMenu[] optionMenus;
	private static final int DISPLAY_PIZZA = 0;
	private static final int ADD_PIZZA = 1;
	private static final int UPDATE_PIZZA = 2;
	private static final int DELETE_PIZZA = 3;
	private static final int INITIALIZE_PIZZA = 4;

	/* CONSTRUCTOR */
	public Menu() {
		title = "***** Pizzeria Administration *****";
		optionMenus = new OptionMenu[5];
		optionMenus[DISPLAY_PIZZA] = new ListerPizzasOptionMenu(dao);
		optionMenus[ADD_PIZZA] = new AjouterPizzaOptionMenu(dao);
		optionMenus[UPDATE_PIZZA] = new ModifierPizzaOptionMenu(dao);
		optionMenus[DELETE_PIZZA] = new SupprimerPizzaOptionMenu(dao);
		optionMenus[INITIALIZE_PIZZA] = new InitialisePizzaOptionMenu(dao);
	}

	/**
	 * Method to lunch application with class separated
	 */
	public void afficher() {
		int option = 0;
		/* Pizza initialization */
		try {
			optionMenus[INITIALIZE_PIZZA].execute();
		} catch (StockageException e) {
			e.printStackTrace();
		}

		/* Run application */
		while (option != 99) {
			displayMenu();
			option = Integer.parseInt(scanner.nextLine());
			
			switch (option) {
			case 1:
				try {
					optionMenus[DISPLAY_PIZZA].execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					optionMenus[ADD_PIZZA].execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					optionMenus[UPDATE_PIZZA].execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					optionMenus[DELETE_PIZZA].execute();
				} catch (StockageException e) {
					e.printStackTrace();
				}
				break;
			case 99:
				System.out.println("\nAurevoir " + ":(");
				break;
			default:
				System.out.println("\nCette option n'existe pas!");
				break;
			}
		}
		scanner.close();
	}

	/**
	 * Method to display Pizzeria menu for administrator
	 */
	public void displayMenu() {
		System.out.println("\n" + this.title);
		for (int i = 0; i < optionMenus.length - 1; i++) {
			if (optionMenus[i] != null) {
				System.out.println((i + 1) + ". " + optionMenus[i].getLabel());
			}
		}
		System.out.println("99. Sortir.");
		System.out.println("Quelle action voulez-vous effectuer?");
	}

	/* GETTER */
	public OptionMenu[] getOptionMenus() {
		return optionMenus;
	}

}
