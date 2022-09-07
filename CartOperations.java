import java.util.ArrayList;
import java.util.Iterator;

class CartOperations {
	public static void addToCart(int userId,Product product) {
		Cart cart = getStorageInstance().getCart(userId);
		cart.addProduct(product);
	}
	public static float calculateProductPriceInCart(int userId) {
		float price = 0;
		for(Product product : getStorageInstance().getCart(userId).getProductList()) {
			price = price + product.getProductPrice();
		}
		return price;
	}
	public static int calculateQuantityOfProductsInCart(int userId) {
		ArrayList<Product> products = getStorageInstance().getCart(userId).getProductList();
		int size = products.size();
		return size;
	}
	public static void displayPriceDetailsOfCartProducts(int quantity,float totalPrice) {
		System.out.println("Quantity           : "+quantity);
		System.out.println("Price of "+quantity+"         : "+totalPrice);
		System.out.println("Delivery Charges   : Free");
		System.out.println("Total Price        : "+totalPrice);
	}
	public static void removeProductFromCart(Cart cart,Product product) {
		Iterator<Product> itr = cart.getProductList().iterator();
		while(itr.hasNext()) {
			int productId = itr.next().getProductId();
			if(product.getProductId() == productId) {
				itr.remove();
			}
		}
	}
	private static Storage getStorageInstance() {
		Storage storage = Storage.getInstance();
		return storage;
	}
}
