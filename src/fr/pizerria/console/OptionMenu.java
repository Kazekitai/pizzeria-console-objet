package fr.pizerria.console;

import java.util.Scanner;

public abstract class OptionMenu {
	/* ATTRIBUTES */
	private static Pizza [] pizzas = new Pizza[0];
	Scanner scanner = new Scanner(System.in);
	
	/* CONSTRUCTOR */
//	public OptionMenu(Pizza [] pizzas) {
//		this.pizzas = pizzas;
//	}
	public OptionMenu() {
		/* Pizza initialization */
		initializePizzeria();
	}
	
	/*METHODS*/
	/**
	 * Method Execute
	 */
	public abstract void execute();
	
	/**
	 * Method to display list of pizza
	 */
	public void displayPizzaList() {
		System.out.println("\nListe des pizzas");
		for(int i=0;i<this.pizzas.length;i++) {
			this.pizzas[i].displayPizzaString();
//			System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
	}
	/**
	 * Method to initialize pizza table
	 */
	public void initializePizzeria() {
//		Pizza pep = new Pizza("PEP","Pépéroni",12.50);
//		Pizza mar = new Pizza("MAR","Margherita",14.00);
//		Pizza rein = new Pizza("REIN","La Reine",11.50);
//		Pizza fro = new Pizza("FRO","La 4 fromage",12.50);
//		Pizza can = new Pizza("CAN","La Cannibale",12.50);
//		Pizza sav = new Pizza("SAV","La Savoyarde",13.00);
//		Pizza ori = new Pizza("ORI","L'Orientale",13.50);
//		Pizza ind = new Pizza("IND","L'Indienne",14.00);
//
//		addPizza(pep);
//		addPizza(mar);
//		addPizza(rein);
//		addPizza(fro);
//		addPizza(can);
//		addPizza(sav);
//		addPizza(ori);
//		addPizza(ind);
	}
	
	/**
	 * Method to add pizza
	 * @param pizza
	 */
	public void addPizza(Pizza pizza) {
		Pizza [] pizzasTmp = new Pizza [this.getPizzas().length+1];
		int j=0;
		for(int i=0;i<this.getPizzas().length;i++){
			pizzasTmp[j]=this.getPizzas()[i];
			j++;
		}
		pizzasTmp[this.getPizzas().length]=pizza;
		pizzasTmp[this.getPizzas().length].setId(j);
		this.setPizzas(pizzasTmp);
	}
	
	/* GETTERS AND SETTERS*/
	public Pizza[] getPizzas() {
		return pizzas;
	}

	public void setPizzas(Pizza[] pizzas) {
		this.pizzas = pizzas;
	}
	
}
