package exceptions;

public class OddDayException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public OddDayException() {
		super("Siguiendo las normas del gobierno, usted no puede entrar en el minimercado porque el pen�ltimo n�mero de su identificaci�n es impar.");
	}
}
