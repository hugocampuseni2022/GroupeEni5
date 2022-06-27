package fr.eni.enchere.bll;

public class BLLException extends Exception {
	
	public BLLException(String message) {
		super (message);
	}
	
	public BLLException(String message , Throwable exc) {
		super (message,exc);
	}
	
	

}
