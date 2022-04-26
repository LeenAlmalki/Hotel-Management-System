
public class Person {

	private String name;
	private String phoneNumber;
	private String email;

	public Person() {
		name = null;
		phoneNumber = null;
		email = null;
	}
	
	public Person(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
	public String getphoneNumber() {
		return phoneNumber;
	}
	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
