package fr.pizerria.console;

public class SupprimerPizzaOptionMenu extends OptionMenu{
	
	/* CONSTRUCTOR */
//	public SupprimerPizzaOptionMenu(Pizza [] pizzas) {
//		super(pizzas);
//	}
	public SupprimerPizzaOptionMenu() {
		super();
	}
	
	/* METHODS */
	
	/**
	 * Method Execute
	 */
	public void execute() {
		displayMenu4();
	}
	
	
	/**
	 * Display menu 4 to delete pizza
	 */
	public void displayMenu4() {
		System.out.println("\nSupression d'une pizza");
		displayPizzaList();
		System.out.println("99 pour abandonner");
		System.out.println("Veuillez choisir la pizza à supprimer (saisir le code) : ");
		String choice = scanner.nextLine();
		if(choice != "99") {
			deletePizza(choice);
		}
	}
	
	/**
	 * Method to delete chose pizza
	 * @param pizza
	 * @param choice - the code of the chose pizza
	 */
	public void deletePizza(String choice) {
		Pizza [] pizzasTmp = new Pizza [this.getPizzas().length-1];
		int j=0;
		for(int i=0;i<this.getPizzas().length;i++){
			if(!this.getPizzas()[i].getCode().equals(choice)) {
				pizzasTmp[j]=this.getPizzas()[i];
				j++;
			}
		}
		this.setPizzas(pizzasTmp);
	}
}
