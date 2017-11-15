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
		Pizza pep = new Pizza("PEP","Pépéroni","VIANDE",12.50,this.dao.getPizzas());
		this.dao.saveNewPizza(pep);
		Pizza mar = new Pizza("MAR","Margherita","SANS_VIANDE",14.00,this.dao.getPizzas());
		this.dao.saveNewPizza(mar);
		Pizza rein = new Pizza("REIN","La Reine","SANS_VIANDE",11.50,this.dao.getPizzas());
		this.dao.saveNewPizza(rein);
		Pizza fro = new Pizza("FRO","La 4 fromage","VIANDE",12.50,this.dao.getPizzas());
		this.dao.saveNewPizza(fro);
		Pizza can = new Pizza("CAN","La Cannibale","VIANDE",12.50,this.dao.getPizzas());
		this.dao.saveNewPizza(can);
		Pizza sav = new Pizza("SAV","La Savoyarde","VIANDE",13.00,this.dao.getPizzas());
		this.dao.saveNewPizza(sav);
		Pizza ori = new Pizza("ORI","L'Orientale","VIANDE",13.50,this.dao.getPizzas());
		this.dao.saveNewPizza(ori);
		Pizza ind = new Pizza("IND","L'Indienne","VIANDE",14.00,this.dao.getPizzas());
		this.dao.saveNewPizza(ind);
		
	}

}
