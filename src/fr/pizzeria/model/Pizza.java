package fr.pizzeria.model;

import java.util.ArrayList;

public class Pizza {
	/* ATTRIBUTES */
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categoriePizza;

	/* CONSTRUCTOR */
	/**
	 * Default constructor
	 */
	public Pizza() {
	}

	/**
	 * Constructor with parameters except id
	 * @param code
	 * @param nom
	 * @param categorie
	 * @param prix
	 */
	public Pizza(String code, String nom, String categorie, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = CategoriePizza.valueOf(categorie.toUpperCase());
	}

	/**
	 * Constructor
	 * @param code
	 * @param nom
	 * @param categorie
	 * @param prix
	 * @param pizzas
	 */
	public Pizza(String code, String nom, String categorie, double prix,  ArrayList<Pizza> pizzas) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categoriePizza = CategoriePizza.valueOf(categorie.toUpperCase());
		int j = 0;
		for (int i = 0; i < pizzas.size(); i++) {
			j++;
		}
		this.id = j;
	}

	/* METHODS */
	/**
	 * Method to display list of pizza
	 */
	public void displayPizzaString() {
		System.out.println(this.getCode() + " -> " + this.getNom() +  " - " + this.categoriePizza.getValue() + " (" + this.getPrix() + " €)");
	}

	/**
	 * Method to return String value of Pizza object
	 */
	public String toString() {
		return this.getCode() + " -> " + this.getNom() +  " - " + this.categoriePizza.getValue() + " (" + this.getPrix() + " €)";
	}
	
	public CategoriePizza getCategory(String value) {
		CategoriePizza categorie= null;
		switch(value) {
		case "VIANDE": categorie = CategoriePizza.VIANDE;
			break;
		}
		return categorie;
	}

	/* GETTERS AND SETTERS */
	
	/**
	 * @return the categoriePizza
	 */
	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @param categoriePizza the categoriePizza to set
	 */
	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

	
}
