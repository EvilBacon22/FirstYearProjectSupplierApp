package part01;

public class Product {
	// Declaring the Instance variables for the Product class
	private int proCode, proQtyAvailable;
	private String proMake, proModel;
	private double proPrice;
	private boolean proDiscontinued;

	// The constructor for the Product instance variables.
	public Product(int proCode, int proQtyAvailable, String proMake, String proModel, double proPrice,
			boolean proDiscontinued) {

		this.proCode = proCode;
		this.proQtyAvailable = proQtyAvailable;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		this.proDiscontinued = proDiscontinued;
	}

	public void getProductDetails() { // Method which formats the data of the product
		System.out.println("------------Product------------");
		System.out.println("ProCode: " + getProCode());
		System.out.println("ProQualityAvailable: " + getProQtyAvailable());
		System.out.println("ProMake: " + getProMake());
		System.out.println("ProModel: " + getProModel());
		System.out.println("ProPrice: " + getProPrice());
		System.out.println("ProDiscontinued: " + getProDiscontinued());

	}

	// getters and setters for the product class
	public int getProCode() {
		return proCode;
	}

	public int getProQtyAvailable() {
		return proQtyAvailable;
	}

	public String getProMake() {
		return proMake;
	}

	public String getProModel() {
		return proModel;
	}

	public double getProPrice() {
		return proPrice;
	}

	public boolean getProDiscontinued() {
		return proDiscontinued;
	}

	public void setProCode(int proCode) {
		this.proCode = proCode;
	}

	public void setProQtyAvailable(int proQtyAvailable) {
		this.proQtyAvailable = proQtyAvailable;
	}

	public void setProMake(String proMake) {
		this.proMake = proMake;
	}

	public void setProModel(String proModel) {
		this.proModel = proModel;
	}

	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	public void setProDiscontinued(boolean proDiscontinued) {
		this.proDiscontinued = proDiscontinued;
	}

}