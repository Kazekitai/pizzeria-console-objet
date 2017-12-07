package fr.pizzeria.ihm;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public abstract class OptionMenu {
	/* ATTRIBUTES */
	private final Logger LOGINFO = LoggerFactory.getLogger("logger1"); 

	public OptionMenu() {
	}

	/* METHODS */
	/**
	 * Method Execute
	 * @throws StockageException 
	 */
	public abstract boolean execute() throws StockageException;

	/**
	 * Get label of option
	 * 
	 * @return
	 */
	public abstract String getLabel();

	/**
	 * Method to display list of pizza
	 */
	public boolean displayPizzaList(IPizzaDao dao) {
		ArrayList<Pizza> pizzas = dao.findAllPizza();
		LOGINFO.trace("\nListe des pizzas (" + pizzas.size() + " pizza)\n");
		for (int i = 0; i < pizzas.size(); i++) {
			LOGINFO.trace(pizzas.get(i).toString());
		}
		return true;
	}
	
	/**
	 * Method to format string
	 * @param value
	 * @return
	 */
	public String upperCaseAllFirst(String value) {

        char[] array = value.toCharArray();
        // Uppercase first letter.
        array[0] = Character.toUpperCase(array[0]);

        // Uppercase all letters that follow a whitespace character.
        for (int i = 1; i < array.length; i++) {
            if (Character.isWhitespace(array[i - 1])) {
                array[i] = Character.toUpperCase(array[i]);
            }
        }

        // Result.
        return new String(array);
    }


}
