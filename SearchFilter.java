import java.util.HashSet;

class SearchFilter{
	private String brandName;
	private String productType;
	private float minPriceRange;
	private float maxPriceRange;
	SearchFilter(){
		displayDefaultOptions(getStorageInstance().getBrandName());
		setBrandName();
	    displayDefaultOptions(getStorageInstance().getProductType());
		setProductType();
		setMinimumPriceRange();
		setMaximumPriceRange();
	}
	public void setBrandName(){
		while(true) {
			System.out.println("Enter Brand Name :");
			System.out.println("You can skip by press Enter !");
			brandName = Input.getString();
			if(brandName.equals("")) {
				brandName = "null";
				break;
			}
			else if(getStorageInstance().getBrandName().contains(brandName)) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
			
		}
	}
	public void setProductType() {		
		while(true) {
			System.out.println("Enter Product Type :");
			System.out.println("You can skip by press Enter !");
		    productType = Input.getString();
		    if(productType.equals("")) {
		    	productType = "null";
			    break;
			}
		    else if(getStorageInstance().getProductType().contains(productType)) {
		    	break;
		    }
		    else {
		    	System.out.println("Invalid Input \n");
		    }
		}
	}
	public void setMinimumPriceRange() {
		while(true) {
			System.out.println("Enter Minimum Price Range :");
			System.out.println("Enter 0 or Price Range");
			minPriceRange = Float.parseFloat(Input.getString());
			if(minPriceRange >= 0) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
		
	}
	public void setMaximumPriceRange() {
		while(true) {
			System.out.println("Enter Maximum Price Range :");
			System.out.println("Enter 0 or above "+minPriceRange);
			maxPriceRange = Float.parseFloat(Input.getString());
			if(maxPriceRange == 0 || maxPriceRange > minPriceRange) {
				break;
			}
			else {
				System.out.println("Invalid Input ! \n");
			}
		}
	}
	public String getBrandName() {
		return brandName;
	}
	public String getProductType() {
		return productType;
	}
	public float getMinimumPriceRange() {
		return minPriceRange;
	}
	public float getMaximumPriceRange() {
		return maxPriceRange;
	}
	private void displayDefaultOptions(HashSet<String> options) {
		for(String option : options) {
			System.out.println(option);
		}
		System.out.println("\n");
	}
	private Storage getStorageInstance() {
		Storage storage = Storage.getInstance();
		return storage;
	}
}
