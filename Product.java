
class Product {
	private String name;
	private String type;
	private String brand;
	private float price;
	private String specification;
	private int productId;
	static int number = 1000;
	Product(){
		setModelName();
		setType();
		setBrand();
		setPrice();
		setSpecification();
		setProductId();
	}
	public void setModelName() {
		while(true) {
			System.out.println("Enter the Model name : ");
			name = Input.getString();
			if(!name.equals("")) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	public void setType() {
		while(true) {
			System.out.println("Enter the product type : ");
			type = Input.getString();
			if(!type.equals("")) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	public void setBrand() {
		while(true) {
			System.out.println("Enter the product brand name : ");
			brand = Input.getString();
			if(!brand.equals("")) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		} 
	}
	public void setPrice() {
		while(true) {
			System.out.println("Enter the product price : ");
			price = Float.parseFloat(Input.getString());
			if(price != 0.0) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	public void setSpecification() {		
		while(true) {
			System.out.println("Enter the Specification : ");
			specification = Input.getString();
		    if(!specification.equals("")) {
		    	break;
		    }
		    else {
		    	System.out.println("Invalid Input \n");
		    }
		}
	}
	private void setProductId() {
		productId = number;
		number++;
	}
	public String getProductName() {
		return name;
	}
	public String getProductType() {
		return type;
	}
	public String getProductBrand() {
		return brand;
	}
	public float getProductPrice() {
		return price;
	}
	public String getSpecification() {
		return specification;
	}
	public int getProductId() {
		return productId;
	}
}
