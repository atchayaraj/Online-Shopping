import java.util.ArrayList;
import java.util.Iterator;

class OrderOperations {
	public static ShoppingOrder placeOrder(ArrayList<Product> products,Address deliveryAddress) {
		ShoppingOrder order = new ShoppingOrder(deliveryAddress);
		for(Product product : products) {
			order.addOrderProduct(product);
		}
		return order;
	}
	public static void displayOrderSummary(ArrayList<Product> products) {
		System.out.println("-------Order Summary-------\n");
		for(Product product : products) {
			ProductOperations.displayProduct(product);
			System.out.println("\n");
		}
	}
	public static void displayOrder(ShoppingOrder order) {
		displayOrderSummary(order.getOrderedProducts());
		System.out.println("Order Id      : "+order.getOrderId());
		System.out.println("Order Status  : "+order.getOrderStatus());
		System.out.println("Deliver To    : "+order.getDeliveryAddress().getAddress());
	}
	public static void changeOrderStatus(ShoppingOrder order) {
		for(ShoppingOrder order1 : getStorageInstance().getOrderList()) {
			if(order.getOrderId().equals(order1.getOrderId())) {
				String orderStatus = getOrderStatus();
				order.setOrderStatus(orderStatus);
			}
		}
	}
	public static void cancelOrder(String orderId,int userId) {
		Iterator<ShoppingOrder> itr = getStorageInstance().getOrderList().iterator();
		Iterator<ShoppingOrder> itr1 = getStorageInstance().getUserAccount(userId).getMyOrderList().iterator();
		while(true) {
			if(itr.hasNext()) {
				String orderId1 = itr.next().getOrderId();
			    if(orderId.equals(orderId1)) {
			    	itr.remove();
			    }
			}
			else if(itr1.hasNext()) {
				String orderId1 = itr1.next().getOrderId();
				if(orderId.equals(orderId1)){
					itr1.remove();
				}
			}
			else {
				break;
			}
		}
	}
	private static String getOrderStatus() {
		while(true) {
			System.out.println("Enter the order status ");
			displayDefaultOrderStatus();
			String orderStatus = Input.getString();
			if(getStorageInstance().getOrderStatus().contains(orderStatus)) {
				return orderStatus;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	private static void displayDefaultOrderStatus() {
		ArrayList<String> defaultOrderStatus = getStorageInstance().getOrderStatus();
		for(String status :defaultOrderStatus) {
			System.out.println(status);
		}
		System.out.println("\n");
	}
	private static Storage getStorageInstance(){
		Storage storage = Storage.getInstance();
		return storage;
	}
}
