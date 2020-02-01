package part01;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;

public class supplierAppTester {

	public static void main(String[] args) { // setting up the main method which contains the menu for the program

		Scanner sc = new Scanner(System.in);
		ArrayList<Supplier> allsuppliers = new ArrayList<Supplier>();
		allsuppliers = SupplierArrayList(); // creating a variable which equals the SupplierArrayList method.
		while (true) { // while loop which always loops the main menu after a command apart from when
						// the program is terminated
			printMenu();
			int menu = UserInput(sc); // calls on userInput method

			switch (menu) {// creating a switch method to allow the user to input select a choice.
			case 1:
				System.out.println("---Printing All Products---");
				for (Supplier eachsuppiler : allsuppliers) {// using a advance for loop to select each supplier in the
															// allSupplier ArrayList and formats each supplier
					eachsuppiler.printProductList();
				}
				break;
			case 2:
				System.out.println("---Adding New Supplier---");
				allsuppliers.add(newSupplier(sc)); // adds the method newSupplier to the allSuppiler ArrayList
				System.out.println("--- New Supplier Added---");
				break;
			case 3:
				System.out.println("---Adding New Product---");
				Scanner cs = new Scanner(System.in);// declares a new scanner because for some reason it would not
													// acknowledge the next line of code with the sc scanner.
				System.out.println("Please enter the supplier name you wish to add product too");
				String supName = cs.nextLine(); // declare a string name, which is used below
				for (Supplier supAdd : allsuppliers) { // this advance for loop calls on the supplier class and
														// allSupplier, and also contains a if statement
					if (supName.equals(supAdd.getSupName())) {// this if statement uses the string supName to equal the
																// supname in the supplier class
						supAdd.addProduct(sc);// which then calls on the add product method, the add product has to be
												// in the supplier class for the if statement to be able to call on it.
					}
				}
				System.out.println("--- New Product Added---");
				break;
			case 4:
				System.out.println("---Exiting Application---");
				System.exit(0); // terminates the program
				break;
			default:
				System.out.print("Please enter a integer between 1 and 4\n");
				break; // default message is the error message
			}

		}
	}

	public static void printMenu() { // method that prints menu on screen.
		System.out.println("-----Main Menu-----");
		System.out.println("(1)Print All Products");
		System.out.println("(2)Add New Supplier");
		System.out.println("(3)Add New Product");
		System.out.println("(4)Exit Application");
		System.out.println("Please enter your choice");

	}

	public static int UserInput(Scanner sc) {// this method uses a do and while loop to validated the input in the main
												// menu, by if the menu input = int then it is valid else it is false.
		boolean valid = false;
		int Menu = 0;
		do {
			valid = false;
			if (sc.hasNextInt()) {
				Menu = sc.nextInt();
				sc.nextLine();
				valid = true;
			} else {
				System.out.println("Please enter a integer between 1 and 4\n");
				printMenu(); // prints menu after error message
				sc.nextLine();
			}
		} while (!valid);

		return Menu;

	}

	public static ArrayList<Supplier> SupplierArrayList() { // this arraylist is made up of 3 arraylists which are named
															// after the variables in the supplier class but not linked
															// to that supplier class
		int[] supcode = { 210, 414, 978, 963, 851, 745 };
		String[] supName = { "Timmy Supplies", "PensOurUs", "PaperMark", "Tesco", "Asda", "BMQ" };
		supRegion[] SupRegion = { supRegion.UK, supRegion.EU, supRegion.OUTSIDE_EU, supRegion.UK, supRegion.EU,
				supRegion.OUTSIDE_EU };

		int Scode = -1; // declaring variables outside of the new array being declared.
		String SName = "";
		supRegion SRegion = null;

		ArrayList<Supplier> SupArray = new ArrayList<Supplier>(); // this arraylist takes the above arraylists data and
																	// puts
																	// them into one arraylist plus the methods of
																	// products
																	// and address.
		for (int i = 0; i < 6; i++) {
			Scode = supcode[i];
			SName = supName[i];
			SRegion = SupRegion[i];
			SupArray.add(new Supplier(Scode, SName, addressArraylist(), SRegion, productsArraylist()));
		}
		return SupArray;
	}

	public static Supplier newSupplier(Scanner sc) { // the new supplier method lets a user create their own supplier.
		System.out.println("Please enter the following details");
		System.out.println("What is the supplier code?");
		int scode = sc.nextInt();
		sc.nextLine();
		System.out.println("What is the name of the supplier?");
		String sname = sc.nextLine();
		System.out.println("Where is the supplier based?");
		int count = 1;
		for (supRegion eachType : EnumSet.allOf(supRegion.class)) { // this for loop calls on the enumset in supRegion
																	// class lists each type and then allowing the user
																	// to add that type to the supplier
			System.out.println(count + ": " + eachType.toString());
			count++;
		}
		int menu = sc.nextInt();
		sc.nextLine();
		supRegion region = supRegion.UK;
		switch (menu) { // i used a switch method to allow the user to select their chosen supRegion
		case 1:
			region = supRegion.UK;
			break;
		case 2:
			region = supRegion.EU;
			break;
		case 3:
			region = supRegion.OUTSIDE_EU;
			break;
		}

		ArrayList<Product> pEmptyList = new ArrayList<Product>(); // emptylist needs to be created in order to match the
																	// supplier constructor.
		Supplier newSupplier = new Supplier(scode, sname, CreateNewAddress(sc), region, pEmptyList);
		return newSupplier;

	}

	public static ArrayList<Product> productsArraylist() { // for the product ArrayList i decided to use the random
															// feature
															// in java
		int[] proCode = { 451, 125, 521, 741, 963, 123 };
		int[] proQtyAvailable = { 100, 1000, 200, 150, 180, 110 };
		String[] proMake = { "Bank paper", "Banana paper", "Bond paper", "Book paper", "Construction paper",
				"Cotton paper" };
		String[] proModel = { "A5", "A3", "A4", "A6", "A4", "A4" };
		double[] proPrice = { 100.45, 24.1, 41.45, 74.45, 1205.99, 44.54 };
		boolean[] proDiscontinued = { false, false, false, true, true, false };

		ArrayList<Product> randomProductsArray = new ArrayList<Product>(); // this array moves all the previous arrays
																			// into one
		Random rand = new Random();
		int randomNum = 0;
		int ProCode = 0;
		int ProQtyAvailable = 0;
		String ProMake = "";
		String ProModel = "";
		double ProPrice = 0;
		boolean ProDiscontinued = null != null;

		int randNumProducts = rand.nextInt(3) + 1; // allows a max of 3 random products to each supplier

		for (int i = 0; i < randNumProducts; i++) {
			ProCode = proCode[rand.nextInt(5)]; // allows 6 variables if the procode to swap around
			ProQtyAvailable = proQtyAvailable[rand.nextInt(5)];
			ProMake = proMake[rand.nextInt(5)];
			ProModel = proModel[rand.nextInt(5)];
			ProPrice = proPrice[rand.nextInt(5)];
			ProDiscontinued = proDiscontinued[rand.nextInt(5)];
			randomProductsArray
					.add(new Product(ProCode, ProQtyAvailable, ProMake, ProModel, ProPrice, ProDiscontinued));
		}
		return randomProductsArray;
	}

	public static ArrayList<Address> addressArraylist() { // addressArray is also randomised like product arraylist
		int[] bldNum = { 142, 485, 10, 854, 748, 97 };
		String[] bldStreet = { "Botanic Street", "Hoth Avenue", "Main Street", "Roddy Lane", "Amber Road",
				"Centre Street" };
		String[] bldTown = { "TemplePatrick", "Doagh", "Leeds", "Winterhelm", "Casterly rock", "Hill Down" };
		String[] bldPcode = { "APGT 23f", "BT39 5DG", "AE54 33F", "CG34 F2S", "HJ45 FJG", "D654 DFD" };
		String[] bldCountry = { "Russia", "Wales", "France", "Slovkia", "Poland", "Brazi", "India" };

		ArrayList<Address> randomAddressArray = new ArrayList<Address>();
		Random rand = new Random();
		int randomNum = 0;
		int BldNum = 0;
		String BldStreet = "";
		String BldTown = "";
		String BldPcode = "";
		String BldCountry = "";

		int randNumAddress = rand.nextInt(1) + 1;

		for (int i = 0; i < randNumAddress; i++) {
			BldNum = bldNum[rand.nextInt(6)];
			BldStreet = bldStreet[rand.nextInt(6)];
			BldTown = bldTown[rand.nextInt(6)];
			BldPcode = bldPcode[rand.nextInt(6)];
			BldCountry = bldCountry[rand.nextInt(6)];
			randomAddressArray.add(new Address(BldNum, BldStreet, BldTown, BldPcode, BldCountry));
		}
		return randomAddressArray;
	}

	public static ArrayList<Address> CreateNewAddress(Scanner sc) { // this method creates a new address object and adds
																	// it to the AddNewaddress arraylist, this method is
																	// then call further above and adds it to the new
																	// supplier
		System.out.println("-----Add new Address-----");
		System.out.println("Please enter the following details");
		System.out.println("What is the new Address nummber?");
		int bldNum = sc.nextInt();
		sc.nextLine();
		System.out.println("What is the new Address Street?");
		String bldStreet = sc.nextLine();
		System.out.println("What is the new Address Town?");
		String bldTown = sc.nextLine();
		System.out.println("What is the new Address Postcode?");
		String bldPcode = sc.nextLine();
		System.out.println("What is the new Address Country?");
		String bldCountry = sc.nextLine();
		ArrayList<Address> AddNewAddress = new ArrayList<Address>();
		AddNewAddress.add(new Address(bldNum, bldStreet, bldTown, bldPcode, bldCountry));

		return AddNewAddress;
	}
}