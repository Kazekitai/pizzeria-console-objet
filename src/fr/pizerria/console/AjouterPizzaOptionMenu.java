package fr.pizerria.console;

public class AjouterPizzaOptionMenu extends OptionMenu{
	
	/* CONSTRUCTOR */
//	public AjouterPizzaOptionMenu(Pizza [] pizzas) {
//		super(pizzas);
//	}
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
		System.out.println("\nPizzas size: "+ this.getPizzas().length);
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
					addPizza(pizza);
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
