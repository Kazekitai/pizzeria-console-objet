package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;

public class Menu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);
	private PizzaDao dao = new PizzaDao();
	private String title;
	private HashMap<Integer,OptionMenu> optionMenus = new HashMap<Integer,OptionMenu>();
	private static final int DISPLAY_PIZZA = 0;
	private static final int ADD_PIZZA = 1;
	private static final int UPDATE_PIZZA = 2;
	private static final int DELETE_PIZZA = 3;
	private static final int INITIALIZE_PIZZA = 4;

	/* CONSTRUCTOR */
	public Menu() {
		title = "***** Pizzeria Administration *****";
		optionMenus.put(DISPLAY_PIZZA, new ListerPizzasOptionMenu(dao));
		optionMenus.put(ADD_PIZZA, new AjouterPizzaOptionMenu(dao));
		optionMenus.put(UPDATE_PIZZA, new ModifierPizzaOptionMenu(dao));
		optionMenus.put(DELETE_PIZZA, new SupprimerPizzaOptionMenu(dao));
		optionMenus.put(INITIALIZE_PIZZA, new InitialisePizzaOptionMenu(dao));
	}

	/**
	 * Method to lunch application with class separated
	 */
	public void afficher() {
		int option = 0;
		/* Pizza initialization */
		try {
			optionMenus.get(INITIALIZE_PIZZA).execute();
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
		for (int i = 0; i < optionMenus.size() - 1; i++) {
			if (optionMenus.get(i) != null) {
				System.out.println((i + 1) + ". " + optionMenus.get(i).getLabel());
			}
		}
		System.out.println("99. Sortir.");
		System.out.println("Quelle action voulez-vous effectuer?");
	}

	/* GETTER */
	public HashMap<Integer,OptionMenu> getOptionMenus() {
		return optionMenus;
	}

}
