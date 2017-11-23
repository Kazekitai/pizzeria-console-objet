package fr.pizzeria.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.ihm.Menu;

public class PizerriaAdminConsoleApp {
	
	private static final Logger LOG = LoggerFactory.getLogger("logger1");
	private static final Logger LOGFULL = LoggerFactory.getLogger("logger2");

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.afficher();
	}

	public static Logger getLog() {
		return LOG;
	}

	public static Logger getLogfull() {
		return LOGFULL;
	}


}
