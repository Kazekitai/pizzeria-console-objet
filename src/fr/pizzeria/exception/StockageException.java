package fr.pizzeria.exception;

public class StockageException extends Exception{
	
	public StockageException() {
		
	}
	
	public StockageException(String msg) {
		super(msg);
	}
	
	public StockageException(Exception e) {
		super(e.getMessage());
	}

}
