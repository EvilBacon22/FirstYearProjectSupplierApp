package part02;

import java.util.ArrayList;
import java.util.Scanner;

public class Supplier {
	// Declaring the Instance variables for the Supplier class and setting up the
	// ArrayList for supProduct and supAddress
	private int supcode;
	private String supName;
	private ArrayList<Address> supAddress;
	private supRegion SupRegion;
	private ArrayList<Product> supProduct = new ArrayList<Product>();

	// The constructor for the supplier instance variables.
	public Supplier(int supcode, String supName, ArrayList<Address> supAddress, supRegion supRegion,
			ArrayList<Product> supProduct) {

		this.supcode = supcode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.SupRegion = supRegion;
		this.supProduct = supProduct;
	}

	// -----methods----
	public void checkStock() {
		System.out.println("And the current availablity of" + this.getSupcode() + "is:" + this.getSupName());
	}

	public void printProductList() { // Method which formats the data of the Supplier
		System.out.println("Supplier:" + this.supName);
		System.out.println("--------------------------------");
		System.out.println("Supplier Code: " + this.supcode);
		System.out.println("Supplier Name:" + this.supName);
		System.out.println("Supplier Region:" + this.SupRegion);
		for (Address eachAddress : this.supAddress) {
			eachAddress.getAddressDetails();
		}
		System.out.println(this.supName + " supplies the following products:");
		for (Product eachProduct : this.supProduct) {
			eachProduct.getProductDetails();
		}
		System.out.println();
	}

	public static double DoubleInput(Scanner sc) {// this valids the double value in the addproduct method
		boolean valid = false;
		double Value = 0;
		do {
			valid = false;
			if (sc.hasNextDouble()) {
				Value = sc.nextDouble();
				sc.nextLine();
				valid = true;
			} else {
				System.out.println("Please enter a double\n");
				sc.nextLine();
			}
		} while (!valid);

		return Value;

	}

	public static boolean booleanInput(Scanner sc) {// this method valids the boolean input in the addproduct method.
		boolean valid = false;
		boolean Value = null != null;
		do {
			valid = false;
			if (sc.hasNextBoolean()) {
				Value = sc.nextBoolean();
				sc.nextLine();
				valid = true;
			} else {
				System.out.println("Please enter true or false\n");
				sc.nextLine();
			}
		} while (!valid);

		return Value;

	}

	public void addProduct(Scanner sc) { // this method creates a new product and adds it to the array of supProduct
		supplierAppTester Import = new supplierAppTester();
		System.out.println("What is the new ProCode?");
		int PCode = Import.UserInput(sc);
		// sc.nextLine();
		System.out.println("What is the Availability of the new product?");
		int PQualityAvailable = Import.UserInput(sc);
		System.out.println("What is the Product Make?");
		String PMake = sc.nextLine();
		System.out.println("What is the product model");
		String PModel = sc.nextLine();
		System.out.println("What is the price of the product?");
		double PPrice = DoubleInput(sc); // create method to catch error...........................
		System.out.println("Is the product discontinued?(True Or False)");
		boolean PDiscontinued = booleanInput(sc); // create method to catch error.............................

		Product newProduct = new Product(PCode, PQualityAvailable, PMake, PModel, PPrice, PDiscontinued);
		getSupProduct().add(newProduct);

	} // below are the getters and setters for the instance variables of the supplier
		// class

	public int getSupcode() {
		return supcode;
	}

	public String getSupName() {
		return supName;
	}

	public ArrayList<Address> getSupAddress() {
		return supAddress;
	}

	public supRegion getSupRegion() {
		return SupRegion;
	}

	public ArrayList<Product> getSupProduct() {
		return supProduct;
	}

	public void setSupcode(int supcode) {
		this.supcode = supcode;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public void setSupAddress(ArrayList<Address> supAddress) {
		this.supAddress = supAddress;
	}

	public void setSupRegion(supRegion supRegion) {
		this.SupRegion = supRegion;
	}

	public void setSupProduct(ArrayList<Product> supProduct) {
		this.supProduct = supProduct;
	}

}
	
	

