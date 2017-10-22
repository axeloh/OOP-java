package interfaces;

public class Person1 implements Named {
	private String givenName;
	private String familyName;
	private String fullName;

	public Person1(String givenName, String familyName){
		this.givenName = givenName;
		this.familyName = familyName;
		fullName = givenName + " " + familyName; 
	}
	@Override
	public void setGivenName(String givenName) {
		this.givenName = givenName;
		setFullName(givenName+" "+familyName);
		
		
	}

	@Override
	public String getGivenName() {
		return givenName;
	}

	@Override
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
		setFullName(givenName+" "+familyName);
		
	}

	@Override
	public String getFamilyName() {
		return familyName;
	}

	@Override
	public void setFullName(String fullName) {
		String[] parts = fullName.split(" ");
		givenName = parts[0];
		familyName = parts[1];
		this.fullName = fullName;
		
	}

	@Override
	public String getFullName() {
		return fullName;
	}

}
