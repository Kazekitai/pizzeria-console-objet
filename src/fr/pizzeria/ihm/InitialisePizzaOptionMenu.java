package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class InitialisePizzaOptionMenu extends OptionMenu {
	private IPizzaDao dao; 
	
	public InitialisePizzaOptionMenu(IPizzaDao dao) {
		this.dao = dao;
	}

	/**
	 * Method Execute
	 */
	@Override
	public boolean execute() {
		initializePizzeria();
		return true;
	}

	/**
	 * Get label of option
	 * @return
	 */
	@Override
	public String getLabel() {
		return "Initialiser la liste des pizza";
	}
	
	/**
	 * Method to initialize pizza table
	 */
	public void initializePizzeria() {
		Pizza pep = new Pizza("PEP","Pépéroni",12.50,this.dao.getPizzas());
		this.dao.saveNewPizza(pep);
		Pizza mar = new Pizza("MAR","Margherita",14.00,this.dao.getPizzas());
		this.dao.saveNewPizza(mar);
		Pizza rein = new Pizza("REIN","La Reine",11.50,this.dao.getPizzas());
		this.dao.saveNewPizza(rein);
		Pizza fro = new Pizza("FRO","La 4 fromage",12.50,this.dao.getPizzas());
		this.dao.saveNewPizza(fro);
		Pizza can = new Pizza("CAN","La Cannibale",12.50,this.dao.getPizzas());
		this.dao.saveNewPizza(can);
		Pizza sav = new Pizza("SAV","La Savoyarde",13.00,this.dao.getPizzas());
		this.dao.saveNewPizza(sav);
		Pizza ori = new Pizza("ORI","L'Orientale",13.50,this.dao.getPizzas());
		this.dao.saveNewPizza(ori);
		Pizza ind = new Pizza("IND","L'Indienne",14.00,this.dao.getPizzas());
		this.dao.saveNewPizza(ind);
		
	}

}
