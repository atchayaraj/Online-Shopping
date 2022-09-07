import java.util.ArrayList;

class Cart {
	private ArrayList<Product> products = new ArrayList<Product>();
	private int userId;
	Cart(int userId){
		this.userId = userId;
	}
	public void addProduct(Product product) {
		products.add(product);
	}
	public int getUserId() {
		return userId;
	}
	public ArrayList<Product> getProductList() {
		return products;
	}
	public Product getProduct(int productId) {
		for(Product product : products) {
			if(productId == product.getProductId()) {
				return product;
			}
		}
		return null;
	}
}
