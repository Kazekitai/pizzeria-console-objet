package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu{
	
	/* CONSTRUCTOR */
	public AjouterPizzaOptionMenu() {
		super();
	}
	
	/* METHODS */
	
	/**
	 * Method Execute
	 */
	public void execute() {
		displayMenu2();
	}
	
	/**
	 * Get Libelle of option
	 * @return
	 */
	public String getLibelle() {
		return "Ajouter une pizza";
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
		
		
		if(code != null && code.length() == 3 ) {
			/* Code has to be to upperCase */
			code = code.toUpperCase();
			if(nom != null && prixStr != null) {
				double prix = Double.parseDouble(prixStr);
				if(prix > 0) {
					Pizza pizza = new Pizza(code,nom,prix);
					this.getDao().saveNewPizza(pizza);
//					addPizza(pizza);
				} else {
					System.out.println("Erreur de saisie: ");
					System.out.println(" Le prix doit être positif");
				}
			} else {
				System.out.println("Erreur de saisie: ");
				System.out.println(" Le nom doit être saisi");
				System.out.println(" Le prix doit être saisi");
			}
			
		} else {
			System.out.println("Erreur de saisie : ");
			System.out.println("le code doit comporter 3 lettres");
		}
		
	}
	
}
