package fr.pizzeria.model;

public class Pizza {
	/* ATTRIBUTES */
	private int id;
	private String code;
	private String nom;
	private double prix;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Pizza() {
	}

	/**
	 * Constructor with parameters except id
	 * 
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public Pizza(String code, String nom, double prix, Pizza[] pizzas) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		int j = 0;
		for (int i = 0; i < pizzas.length; i++) {
			j++;
		}
		this.id = j;
	}

	/* METHODS */
	public void displayPizzaString() {
		System.out.println(this.getCode() + " -> " + this.getNom() + " (" + this.getPrix() + " €)");
	}

	public String toString() {
		return this.getCode() + " -> " + this.getNom() + " (" + this.getPrix() + " €)";
	}

	/* GETTERS AND SETTERS */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
