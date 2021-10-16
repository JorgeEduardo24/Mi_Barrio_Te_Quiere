package exceptions;

public class IdentityCardException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public IdentityCardException() {
		super("No puede ingresar al minimercado. Usted es menor de edad.");
	}
}
