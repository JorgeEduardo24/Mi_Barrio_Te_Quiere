package model;

public class Person {
	
	private IDType idType;
	private String idNumber;
	
	public Person(String idType, String idNumber) {
		this.idType = IDType.valueOf(idType);
		this.idNumber = idNumber;
	}

	public IDType getIdType() {
		return idType;
	}

	public String getIdNumber() {
		return idNumber;
	}
	
	
	
}
