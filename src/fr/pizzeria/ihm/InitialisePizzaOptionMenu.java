package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class InitialisePizzaOptionMenu extends OptionMenu {

	/**
	 * Method Execute
	 */
	@Override
	public void execute() {
		initializePizzeria();

	}

	/**
	 * Get Libelle of option
	 * @return
	 */
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Method to initialize pizza table
	 */
	public void initializePizzeria() {
		Pizza pep = new Pizza("PEP","Pépéroni",12.50);
		Pizza mar = new Pizza("MAR","Margherita",14.00);
		Pizza rein = new Pizza("REIN","La Reine",11.50);
		Pizza fro = new Pizza("FRO","La 4 fromage",12.50);
		Pizza can = new Pizza("CAN","La Cannibale",12.50);
		Pizza sav = new Pizza("SAV","La Savoyarde",13.00);
		Pizza ori = new Pizza("ORI","L'Orientale",13.50);
		Pizza ind = new Pizza("IND","L'Indienne",14.00);
		
		this.getDao().saveNewPizza(pep);
		this.getDao().saveNewPizza(pep);
		this.getDao().saveNewPizza(mar);
		this.getDao().saveNewPizza(rein);
		this.getDao().saveNewPizza(fro);
		this.getDao().saveNewPizza(can);
		this.getDao().saveNewPizza(sav);
		this.getDao().saveNewPizza(ori);
		this.getDao().saveNewPizza(ind);
	}

}
