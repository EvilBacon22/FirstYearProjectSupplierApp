package part02;

public class Address {
	// Declaring the Instance variables for the address class
	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPcode;
	private String bldCountry;

	// the Constructor for the Address Object
	public Address(int bldNum, String bldStreet, String bldTown, String bldPcode, String bldCountry) {

		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPcode = bldPcode;
		this.bldCountry = bldCountry;
	}

	public void getAddressDetails() { // Method which formats the data of the Address
		System.out.println("------------Address------------");
		System.out.println("Address Number: " + getBldNum());
		System.out.println("Street: " + getBldStreet());
		System.out.println("Town: " + getBldTown());
		System.out.println("Postcode: " + getBldPcode());
		System.out.println("Country: " + getBldCountry());

	}

	// Below are the getter and setters for the Address object
	public int getBldNum() {
		return bldNum;
	}

	public String getBldStreet() {
		return bldStreet;
	}

	public String getBldTown() {
		return bldTown;
	}

	public String getBldPcode() {
		return bldPcode;
	}

	public String getBldCountry() {
		return bldCountry;
	}

	public void setBldNum(int bldNum) {
		this.bldNum = bldNum;
	}

	public void setBldStreet(String bldStreet) {
		this.bldStreet = bldStreet;
	}

	public void setBldTown(String bldTown) {
		this.bldTown = bldTown;
	}

	public void setBldPcode(String bldPcode) {
		this.bldPcode = bldPcode;
	}

	public void setBldCountry(String bldCountry) {
		this.bldCountry = bldCountry;
	}

}
