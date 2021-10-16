package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.GregorianCalendar;
import exceptions.EvenDayException;
import exceptions.IdentityCardException;
import exceptions.OddDayException;

public class MiniMarket {
	private List<Person> persons;
	private Calendar date;
	private int faultCounter;
	
	public MiniMarket() {
		this.persons = new ArrayList<Person>();
		this.date = new GregorianCalendar();
	}
	
	public int getFaultCounter() {
		return this.faultCounter;
	}
	
	public void addPerson(String idType, String idNumber) throws IdentityCardException, EvenDayException, OddDayException{
		int day = date.get(Calendar.DAY_OF_MONTH);
		char[] digits = idNumber.toCharArray();
		int penultimateDigit = Character.getNumericValue(digits[digits.length-2]);
		
		
		if(idType.equals(IDType.TARJETA_DE_IDENTIDAD.name())) {
			faultCounter++;
			throw new IdentityCardException();
		}else if( checkEvenDay(day) && checkPenultimateEvenDigit(penultimateDigit) ) {
			faultCounter++;
			throw new EvenDayException();
		}else if(!checkEvenDay(day)&& !checkPenultimateEvenDigit(penultimateDigit) ) {
			faultCounter++;
			throw new OddDayException();
		}
		
		persons.add(new Person(idType, idNumber));
		
	}
	
	public List<Person> getPersons(){
		return this.persons;
	}
	
	public boolean checkEvenDay(int day) {
		boolean check = false;
		if(day%2==0) {
			check = true;
		}
			
		return check;
	}
	
	public boolean checkPenultimateEvenDigit(int penultimateDigit) {
		boolean check = false;
		if(penultimateDigit%2==0) {
			check = true;
		}
		return check;
	}
	
}
