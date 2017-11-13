package fr.pizerria.console;

import java.util.Scanner;

public class PizzaAdmin {
	/* ATTRIBUTES */
	Pizza [] pizzas = new Pizza[0];
	Scanner scanner = new Scanner(System.in);
	
	/* CONSTRUCTOR */
	public PizzaAdmin() {

	}
	
	/* METHODS */
	/**
	 * Method to lunch application with class separated
	 */
	public void startApp() {
		int option = 0;		
		
//		/* Pizza initialization */
//		Pizza pep = new Pizza("PEP","Pépéroni",12.50);
//		Pizza mar = new Pizza("MAR","Margherita",14.00);
//		Pizza rein = new Pizza("REIN","La Reine",11.50);
//		Pizza fro = new Pizza("FRO","La 4 fromage",12.50);
//		Pizza can = new Pizza("CAN","La Cannibale",12.50);
//		Pizza sav = new Pizza("SAV","La Savoyarde",13.00);
//		Pizza ori = new Pizza("ORI","L'Orientale",13.50);
//		Pizza ind = new Pizza("IND","L'Indienne",14.00);
//		addPizza(pep);
//		addPizza(mar);
//		addPizza(rein);
//		addPizza(fro);
//		addPizza(can);
//		addPizza(sav);
//		addPizza(ori);
//		addPizza(ind);
		
		/* Class instantiation*/
//		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu(pizzas);
//		AjouterPizzaOptionMenu ajouterPizza = new AjouterPizzaOptionMenu(pizzas);
//		ModifierPizzaOptionMenu modifierPizza = new ModifierPizzaOptionMenu(pizzas);
//		SupprimerPizzaOptionMenu supprimerPizza = new SupprimerPizzaOptionMenu(pizzas);
		ListerPizzasOptionMenu listerPizza = new ListerPizzasOptionMenu();
		AjouterPizzaOptionMenu ajouterPizza = new AjouterPizzaOptionMenu();
		ModifierPizzaOptionMenu modifierPizza = new ModifierPizzaOptionMenu();
		SupprimerPizzaOptionMenu supprimerPizza = new SupprimerPizzaOptionMenu();
		
		//		System.out.println("taille du tableau: " + this.pizzas.length);
		while(option != 99) {
			displayMenu();
			option = Integer.parseInt(scanner.nextLine());
			switch (option) {
			case 1:
				listerPizza.execute();
				break;
			case 2:
				ajouterPizza.execute();
				break;
			case 3:
				modifierPizza.execute();
				break;
			case 4:
				supprimerPizza.execute();
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
	 * Method to lunch application with methods in this class
	 */
//	public void startApp() {
//		int option = 0;		
//		
//		/* Pizza initialization */
//		Pizza pep = new Pizza("PEP","Pépéroni",12.50);
//		Pizza mar = new Pizza("MAR","Margherita",14.00);
//		Pizza rein = new Pizza("REIN","La Reine",11.50);
//		Pizza fro = new Pizza("FRO","La 4 fromage",12.50);
//		Pizza can = new Pizza("CAN","La Cannibale",12.50);
//		Pizza sav = new Pizza("SAV","La Savoyarde",13.00);
//		Pizza ori = new Pizza("ORI","L'Orientale",13.50);
//		Pizza ind = new Pizza("IND","L'Indienne",14.00);
//		addPizza(pep);
//		addPizza(mar);
//		addPizza(rein);
//		addPizza(fro);
//		addPizza(can);
//		addPizza(sav);
//		addPizza(ori);
//		addPizza(ind);
//		
////		System.out.println("taille du tableau: " + this.pizzas.length);
//		while(option != 99) {
//			displayMenu();
//			option = Integer.parseInt(scanner.nextLine());
//			switch (option) {
//			case 1:
//				displayMenu1();
//				break;
//			case 2:
//				displayMenu2();
//				break;
//			case 3:
//				displayMenu3();
//				break;
//			case 4:
//				displayMenu4();
//				break;
//			case 99:
//				System.out.println("\nAurevoir "+ ":(");
//				break;
//			default:
//				System.out.println("\nCette option n'existe pas!");
//				break;
//			}
//		}
//	}
	
	/**
	 * Method to display Pizerria menu for administrator
	 */
	public void displayMenu() {
		System.out.println("\n***** Pizerria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour pizza");
		System.out.println("4. Supprimer pizza");
		System.out.println("99. Sortir");
		System.out.println("Quelle action voulez-vous effectuer?");
	}
	
	/**
	 * Method to display list of pizza
	 */
	public void displayPizzaList() {
		for(int i=0;i<this.pizzas.length;i++) {
			this.pizzas[i].displayPizzaString();
//			System.out.println("id pizza: "+ this.pizzas[i].getId());
		}
	}
	
	/**
	 * Method to add pizza
	 * @param pizza
	 */
	public void addPizza(Pizza pizza) {
		Pizza [] pizzasTmp = new Pizza [this.pizzas.length+1];
		int j=0;
		for(int i=0;i<this.pizzas.length;i++){
			pizzasTmp[j]=this.pizzas[i];
			j++;
		}
		pizzasTmp[this.pizzas.length]=pizza;
		pizzasTmp[this.pizzas.length].setId(j);
		this.pizzas = pizzasTmp;
		
	}
	
	/**
	 * Method to update chose pizza
	 * @param pizza
	 * @param choice - the code of the chose pizza
	 */
	public void updatePizza(Pizza pizza,String choice) {
		for(int i=0;i<this.pizzas.length;i++){
			if(this.pizzas[i].getCode().equals(choice)) {
				this.pizzas[i].setCode(pizza.getCode());
				this.pizzas[i].setNom(pizza.getNom());
				this.pizzas[i].setPrix(pizza.getPrix());
			}
		}
	}
	
	/**
	 * Method to delete chose pizza
	 * @param pizza
	 * @param choice - the code of the chose pizza
	 */
	public void deletePizza(String choice) {
		Pizza [] pizzasTmp = new Pizza [this.pizzas.length-1];
		int j=0;
		for(int i=0;i<this.pizzas.length;i++){
			if(!this.pizzas[i].getCode().equals(choice)) {
				pizzasTmp[j]=this.pizzas[i];
				j++;
			}
		}
		this.pizzas = pizzasTmp;
	}
	
	/**
	 * Display menu 1 to show list of pizzas
	 */
	public void displayMenu1() {
		System.out.println("\nListe des pizzas");
		displayPizzaList();
	}
	
	/**
	 * Display menu 2 to add pizza
	 */
	public void displayMenu2() {
		System.out.println("\nAjout d'une nouvelle pizza");
		System.out.println("Veuillez saisir le code: ");
		String code = scanner.nextLine();
		System.out.println("Veuillez saisir le nom: ");
		String nom = scanner.nextLine();
		System.out.println("Veuillez saisir le prix: ");
		String prixStr = scanner.nextLine(); 
		
		
		if(code != null && code.length() == 2 ) {
			/* Code has to be to upperCase */
			code = code.toUpperCase();
			if(nom != null && prixStr != null) {
				double prix = Double.parseDouble(prixStr);
				if(prix > 0) {
					Pizza pizza = new Pizza(code,nom,prix);
					addPizza(pizza);
				} else {
					System.out.println("Erreur de saisie: ");
					System.out.println(" Le prix doit être positif");
				}
			} else {
				System.out.println("Erreur de saisie: ");
				System.out.println(" - le nom doit être saisi");
				System.out.println(" Le prix doit être saisi");
			}
			
		} else {
			System.out.println("Erreur de saisie : ");
			System.out.println("le code doit comporter 3 lettres");
		}
		
	}
	

	
	/**
	 * Display menu 3 to update pizza
	 */
	public void displayMenu3() {
		System.out.println("\nMise à jour d'une pizza");
		displayMenu1();
		System.out.println("99 pour abandonner");
		System.out.println("Veuillez choisir la pizza à modifier (saisir le code) : ");
		String choice = scanner.nextLine();
		if(choice != "99") {
			System.out.println("Veuillez saisir le code: ");
			String code = scanner.nextLine();
			System.out.println("Veuillez saisir le nom: ");
			String nom = scanner.nextLine();
			System.out.println("Veuillez saisir le prix: ");
			String prixStr = scanner.nextLine(); 
			
			
			if(code != null && code.length() == 2 ) {
				/* Code has to be to upperCase */
				code = code.toUpperCase();
				if(nom != null && prixStr != null) {
					double prix = Double.parseDouble(prixStr);
					if(prix > 0) {
						Pizza pizza = new Pizza(code,nom,prix);
						updatePizza(pizza,choice);
					} else {
						System.out.println("Erreur de saisie: ");
						System.out.println(" Le prix doit être positif");
					}
				} else {
					System.out.println("Erreur de saisie: ");
					System.out.println(" - le nom doit être saisi");
					System.out.println(" Le prix doit être saisi");
					
				}
				
			} else {
				System.out.println("Erreur de saisie : ");
				System.out.println("le code doit comporter 3 lettres");
			}
		}
		
	}
	
	/**
	 * Display menu 4 to delete pizza
	 */
	public void displayMenu4() {
		System.out.println("\nSupression d'une pizza");
		displayMenu1();
		System.out.println("99 pour abandonner");
		System.out.println("Veuillez choisir la pizza à supprimer (saisir le code) : ");
		String choice = scanner.nextLine();
		if(choice != "99") {
			deletePizza(choice);
		}
		
	}

	
	
	
	
	

}
