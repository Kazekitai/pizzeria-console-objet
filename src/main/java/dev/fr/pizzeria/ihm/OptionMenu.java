package main.java.dev.fr.pizzeria.ihm;

import java.util.Scanner;

import main.java.dev.fr.pizzeria.console.PizerriaAdminConsoleApp;
import main.java.dev.fr.pizzeria.dao.IPizzaDao;
import main.java.dev.fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	/* ATTRIBUTES */
	Scanner scanner = new Scanner(System.in);

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
		PizerriaAdminConsoleApp.getLog().trace("\nListe des pizzas (" + dao.getPizzas().size() + " pizza)\n");
		for (int i = 0; i < dao.getPizzas().size(); i++) {
			PizerriaAdminConsoleApp.getLog().trace(dao.getPizzas().get(i).toString());
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
