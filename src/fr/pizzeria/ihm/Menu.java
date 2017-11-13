package fr.pizzeria.ihm;

import java.util.Scanner;

public class Menu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);
	private String title;
	private OptionMenu[] optionMenus;
	private static final int DISPLAY_PIZZA = 0;
	private static final int ADD_PIZZA = 1;
	private static final int UPDATE_PIZZA = 2;
	private static final int DELETE_PIZZA = 3;
	private static final int INITIALIZE_PIZZA = 4;
	
	/* CONSTRUCTOR */
	public Menu(){
		title = "***** Pizzeria Administration *****";
		optionMenus = new OptionMenu[5];
		optionMenus[DISPLAY_PIZZA] = new ListerPizzasOptionMenu();
		optionMenus[ADD_PIZZA] = new AjouterPizzaOptionMenu();
		optionMenus[UPDATE_PIZZA] = new ModifierPizzaOptionMenu();
		optionMenus[DELETE_PIZZA] = new SupprimerPizzaOptionMenu();
		optionMenus[INITIALIZE_PIZZA] = new InitialisePizzaOptionMenu();
	}
	
	/**
	 * Method to lunch application with class separated
	 */
	public void startApp() {
		int option = 0;
		/* Pizza initialization */
		optionMenus[INITIALIZE_PIZZA].execute();
		
		/* Run application */
		while(option != 99) {
			displayMenu();
			option = Integer.parseInt(scanner.nextLine());
			switch (option) {
			case 1:
				optionMenus[DISPLAY_PIZZA].execute();
				break;
			case 2:
				optionMenus[ADD_PIZZA].execute();
				break;
			case 3:
				optionMenus[UPDATE_PIZZA].execute();
				break;
			case 4:
				optionMenus[DELETE_PIZZA].execute();
				break;
			case 99:
				System.out.println("\nAurevoir "+ ":(");
				break;
			default:
				System.out.println("\nCette option n'existe pas!");
				break;
			}
		}
	}
	
	/**
	 * Method to display Pizzeria menu for administrator
	 */
	public void displayMenu(){
		System.out.println(this.title);
		for (int i=0; i<optionMenus.length-1; i++){
			if (optionMenus[i]!=null){
				System.out.println(optionMenus[i].getLibelle());
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
