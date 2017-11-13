package fr.pizerria.console;

public class ListerPizzasOptionMenu extends OptionMenu {

	/* CONSTRUCTOR */
//	public ListerPizzasOptionMenu(Pizza [] pizzas) {
//		super(pizzas);
//	}
	public ListerPizzasOptionMenu() {
		super();
	}
	
	/* METHODS */
	
	/**
	 * Method Execute
	 */
	public void execute() {
		displayMenu1();
	}
	
	/**
	 * Display menu 1 to show list of pizzas
	 */
	public void displayMenu1() {
		System.out.println("\nListe des pizzas");
		displayPizzaList();
	}
	
	/**
	 * Method to display list of pizza
	 */
	public void displayPizzaList() {
		System.out.println("\nPizzas size: "+ this.getPizzas().length);
		for(int i=0;i<this.getPizzas().length;i++) {
			this.getPizzas()[i].displayPizzaString();
//			System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
	}
	


}
