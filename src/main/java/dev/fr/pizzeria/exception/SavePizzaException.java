package main.java.dev.fr.pizzeria.exception;

public class SavePizzaException extends StockageException {
	
	public SavePizzaException() {
		
	}
	
	public SavePizzaException(String msg) {
		super(msg);
	}
}