import java.util.ArrayList;

class ShoppingOrder {
	static int number = 1;
	private String orderId;
	private ArrayList<Product> orderProducts = new ArrayList<Product>();
	private String orderStatus = "Ordered";
	private Address deliveryAddress;
	ShoppingOrder(Address deliveryAddress){
		this.deliveryAddress = deliveryAddress;
	}
	public void setOrderStatus(String status) {
		orderStatus = status;
	}
	public void addOrderProduct(Product product) {
		orderProducts.add(product);
	}
	public String getOrderId() {
		return orderId;
	}
	public ArrayList<Product> getOrderedProducts(){
		return orderProducts;
	}
	public Product getOrderedProduct(int productId) {
		for(Product product : orderProducts) {
			if(product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	public void createOrderId() {
		orderId = "od"+number;
		number++;
	}
}
