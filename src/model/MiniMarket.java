package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.IdentityCardException;

public class MiniMarket {
	private List<Person> persons;
	
	public MiniMarket() {
		this.persons = new ArrayList<Person>();
	}
	
	public void addPerson(String idType, String idNumber) throws IdentityCardException{
		if(idType.equals(IDType.TARJETA_DE_IDENTIDAD.name())) {
			throw new IdentityCardException();
		}
		persons.add(new Person(idType, idNumber));
		
	}
	
	public List<Person> getPersons(){
		return this.persons;
	}
}
