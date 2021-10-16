package model;

public class Person {
	
	private IDType idType;
	private String idNumber;
	private final int personNumber;
	private static int peopleCounter;
	
	
	private Person() {
		this.personNumber = ++Person.peopleCounter;
	}
	
	public Person(String idType, String idNumber) {
		this();
		this.idType = IDType.valueOf(idType);
		this.idNumber = idNumber;
	}

	public IDType getIdType() {
		return idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public static int getPeopleCounter() {
		return peopleCounter;
	}
	
	
	
}
