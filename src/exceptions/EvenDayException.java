package exceptions;

public class EvenDayException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EvenDayException() {
		super("Siguiendo las normas del gobierno, usted no puede entrar en el minimercado porque el pen�ltimo n�mero de su identificaci�n es par.");
	}
}
