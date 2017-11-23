package main.java.dev.fr.pizzeria.model;

public enum CategoriePizza {
	
	/* ENUMERATION */
	// L'�num�ration poss�de 3 instances
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	
	/* ATTRIBUE */
	private String value;
	
	/* CONSTRUCTOR */
	private CategoriePizza(String value) {
		this.value = value;
	}
	
	/* GETTER */
	public String getValue() {
		return value;
	}
	

}
