package fr.pizzeria.exception.runtime;

public class StopApplicationException extends RuntimeException {

	public StopApplicationException() {
		
	}

	public StopApplicationException(String msg) {
		super(msg);
	}

}
