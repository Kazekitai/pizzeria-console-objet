package fr.pizzeria.ihm;

public class ListerPizzasOptionMenu extends OptionMenu {

	/* CONSTRUCTOR */
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
	 * Get Libelle of option
	 * @return
	 */
	public String getLibelle() {
		return "Lister les pizzas";
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
		System.out.println("\nPizzas size: "+ this.getDao().getPizzas().length);
		for(int i=0;i<this.getDao().getPizzas().length;i++) {
			this.getDao().getPizzas()[i].displayPizzaString();
//			System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
	}
	


}
