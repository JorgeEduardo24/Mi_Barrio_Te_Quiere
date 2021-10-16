package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.EvenDayException;
import exceptions.IdentityCardException;
import exceptions.OddDayException;
import model.IDType;
import model.MiniMarket;
import model.Person;

public class Menu {
	private MiniMarket miniMarket;
	private String idType;
	
	public Menu() {
		miniMarket = new MiniMarket();
	}
	
	public void showMenu() {
		System.out.println("\nIngrese la opción que desee realizar: ");
		System.out.println("[1] Registrar el ingreso de una nueva persona.\n"+
		                   "[2] Consultar el número de personas que han intendado ingresar al minimercado\n"+
		                   "[3] Salir del programa.\n");
	}
	
	public int readOption(BufferedReader br) throws NumberFormatException, IOException {
		int option = Integer.parseInt(br.readLine());
		return option;
	}
	
	public void doOption(int option, BufferedReader br) throws NumberFormatException, IOException {
		switch(option) {
		
		case 1:
			System.out.println("-----------------------------------------------------");
			System.out.println("      REGISTRAR LA ENTRADA DE UNA NUEVA PERSONA");
			System.out.println("-----------------------------------------------------");
			
			String idType = readIDType(br);
			String idNumber = readIDNumber(br);
			registerPerson(idType, idNumber);
			break;
				
		case 2:
			System.out.println("-----------------------------------------------------");
			System.out.println("    CANTIDAD DE PERSONAS QUE HAN INTENTADO ENTRAR");
			System.out.println("-----------------------------------------------------");
			showTotalPeople();
			break;
			
		case 3:
			System.out.println("Bye!");
			break;
		}
	}
	
	public void startProgram() throws NumberFormatException, IOException {
		int option = 0;
		int exit = 3;
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			showMenu();
			option = readOption(br);
			doOption(option, br);
		}while(option != exit);
	}
	
	
	public String readIDType(BufferedReader br) throws NumberFormatException, IOException {
		System.out.println("Seleccione el tipo de documento que usted posee:");
		System.out.println("[1] "+IDType.CEDULA_DE_CIUDADANIA+"\n"
				+ "[2] "+IDType.CEDULA_DE_EXTRANJERIA+"\n"
				+"[3] "+IDType.PASAPORTE+"\n"
				+"[4] "+IDType.TARJETA_DE_IDENTIDAD);
		
		int option = Integer.parseInt(br.readLine());

		switch(option) {
		case 1:
			idType = IDType.CEDULA_DE_CIUDADANIA.name();
			break;
			
		case 2:
			idType = IDType.CEDULA_DE_EXTRANJERIA.name();
			break;
			
		case 3:
			idType = IDType.PASAPORTE.name();
			break;
			
		case 4:
			idType = IDType.TARJETA_DE_IDENTIDAD.name();
			break;

		default:
			System.out.println("Elección incorrecta.");
		}

		return idType;
		
	}
	
	
	public String readIDNumber(BufferedReader br) throws IOException {
		System.out.println("Escribe tu número de identificación: ");
		String IDNumber = br.readLine();
		return IDNumber;
	}
	
	public void registerPerson(String idType, String idNumber) throws NumberFormatException, IOException {
		try {
			miniMarket.addPerson(idType ,idNumber);
			System.out.println("Persona agregada satisfactoriamente al minimercado!");
		}catch(IdentityCardException ice) {
			System.err.println(ice.getMessage());
		}catch(EvenDayException ede) {
			System.err.println(ede.getMessage());
		}catch(OddDayException ode) {
			System.err.println(ode.getMessage());
		}
	}
	
	public void showTotalPeople() {
		int successfulAttempts = Person.getPeopleCounter();
		int failedAttempts = miniMarket.getFaultCounter();
		int totalAttempts = successfulAttempts+failedAttempts;
		System.out.println("Intentos exitosos de ingreso: "+successfulAttempts+"\n"
				+"Intentos fallidos de ingreso: "+failedAttempts+"\n"
				+"Intentos totales de ingreso: "+totalAttempts);
	}
	
}
