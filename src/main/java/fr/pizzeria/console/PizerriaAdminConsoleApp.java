package fr.pizzeria.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.lalyos.jfiglet.FigletFont;
import fr.pizzeria.ihm.Menu;

/**
 * Main class to lunch application
 * 
 * @author Sandra Le Thiec
 *
 */
public class PizerriaAdminConsoleApp {

	public static void main(String[] args) {
		final Logger LOG = LoggerFactory.getLogger("logger1");
		Menu menu = new Menu();
		String asciiArt = FigletFont.convertOneLine("Pizzeria");
		LOG.trace(asciiArt);
		menu.afficher();
	}

}
