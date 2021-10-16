package model;

import static org.junit.jupiter.api.Assertions.*;

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
	public void testAdd() throws IdentityCardException, EvenDayException, OddDayException {
		setupScenary1();
		
		String idType = "PASAPORTE";
		String idNumber = "123456789";
		
		miniMarket.addPerson(idType, idNumber);
		
		List<Person> persons = miniMarket.getPersons();
		assertEquals(1, persons.size());
		
		Person p = persons.get(0);
		assertEquals(idType, p.getIdType().name());
		assertEquals(idNumber, p.getIdNumber());
		
	}
}
