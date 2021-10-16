package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import exceptions.EvenDayException;
import exceptions.IdentityCardException;
import exceptions.OddDayException;

class MiniMarketTest {
	private MiniMarket miniMarket;
	
	public void setupScenary1() {
		miniMarket = new MiniMarket();
	}
	
	@Test
	public void testAdd() {
		setupScenary1();
		
		String idType = "PASAPORTE";
		String idNumber = "159786479";
		try {
			miniMarket.addPerson(idType, idNumber);
		}catch(IdentityCardException ice) {
		}catch(EvenDayException ede) {
		}catch(OddDayException ode) {
		}
		
		List<Person> persons = miniMarket.getPersons();
		assertEquals(1, persons.size());
		
		Person p = persons.get(0);
		assertEquals(idType, p.getIdType().name());
		assertEquals(idNumber, p.getIdNumber());
	}
	
	@Test
	public void testAdd2() {
		setupScenary1();
		String idType = "CEDULA_DE_EXTRANJERIA";
		
		Calendar date = new GregorianCalendar();
		String idNumber;
		int today = date.get(Calendar.DAY_OF_MONTH);
		if(today%2==0) {
			idNumber = "1234567899";
		}else {
			idNumber = "1234567889";
		}
		try {
			miniMarket.addPerson(idType, idNumber);
		}catch(IdentityCardException ice) {
		}catch(EvenDayException ede) {
		}catch(OddDayException ode) {
		}
		
	}
	
	@Test
	public void testAdd3(){
		setupScenary1();
		String idType = "TARJETA_DE_IDENTIDAD";
		String idNumber = "123456789";
		try {
			miniMarket.addPerson(idType, idNumber);
		}catch(IdentityCardException ice) {
		}catch(EvenDayException ede) {
		}catch(OddDayException ode) {
		}
	}
}
