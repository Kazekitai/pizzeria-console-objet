package fr.pizzeria.model;

/**
 * Enumeration og categories
 * @author Sandra Le Thiec
 *
 */
public enum CategoriePizza {
	
	/* ENUMERATION */
	// L'énumération possède 3 instances
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	
	/* ATTRIBUE */
	private String value;
	
	/* CONSTRUCTOR */
	/**
	 * Constructor
	 * @param value
	 */
	private CategoriePizza(String value) {
		this.value = value;
	}
	
	/* GETTER */
	/**
	 * 
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	

}
