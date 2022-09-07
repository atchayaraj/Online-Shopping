import java.util.ArrayList;
import java.util.Iterator;

class ProductOperations {
	public static void addProduct(Product product) {
		getStorageInstance().addProduct(product);
	}
	public static void removeProduct(Product product) {
		Iterator<Product> itr = getStorageInstance().getProductList().iterator();
		while(itr.hasNext()) {
			int productId = itr.next().getProductId();
			if(product.getProductId() == productId) {
				itr.remove();
			}
		}
	}
	public static ArrayList<Product> searchProductsByProductType(String productType) {
		ArrayList<Product> products = new ArrayList<Product>();
		for(Product product : getStorageInstance().getProductList()) {
			if(productType.equals(product.getProductType())){
				products.add(product);
			}
		}
		return products;
	}
	public static ArrayList<Product> searchProductsByBrandName(String brandName) {
		ArrayList<Product> products = new ArrayList<Product>();
		for(Product product : getStorageInstance().getProductList()) {
			if(brandName.equals(product.getProductBrand())){
				products.add(product);
			}
		}
		return products;
	}
	public static ArrayList<Product> searchProductsByFilter(SearchFilter searchFilter){
		ArrayList<Product> products = new ArrayList<Product>();
		for(Product product :getStorageInstance().getProductList()) {
			if((searchFilter.getBrandName().equals(product.getProductBrand()) || searchFilter.getBrandName().equals("null")) && 
					(searchFilter.getProductType().equals(product.getProductType()) || searchFilter.getProductType().equals("null")) && 
					(searchFilter.getMinimumPriceRange() <= product.getProductPrice() || searchFilter.getMinimumPriceRange() == 0) && 
					(searchFilter.getMaximumPriceRange() >= product.getProductPrice() || searchFilter.getMaximumPriceRange() == 0)) {
				products.add(product);
			}
		}
		return products;
	}
	public static void displayProduct(Product product) {
		System.out.println("Name          : "+product.getProductName());
		System.out.println("Type          : "+product.getProductType());
		System.out.println("Brand         : "+product.getProductBrand());
		System.out.println("Specification : "+product.getSpecification());
		System.out.println("Price         : "+product.getProductPrice());
		System.out.println("Product Id    : "+product.getProductId());
	}
	private static Storage getStorageInstance() {
		Storage storage = Storage.getInstance();
		return storage;
	}
}
