import java.util.ArrayList;

class UserAccount {
    private Profile profile;
	private int userId;
	private String username;
	private String password;
	private Address deliveryAddress;
	private ArrayList<ShoppingOrder> myOrders = new ArrayList<ShoppingOrder>();
	UserAccount(Profile profile,String username,String password,int userId){
		this.profile = profile;
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	public void addOrder(ShoppingOrder myOrder) {
		myOrders.add(myOrder);
	}
	public void setDeliveryAddress(Address address) {
		this.deliveryAddress = address;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ArrayList<ShoppingOrder> getMyOrderList() {
		return myOrders;
	}
	public ShoppingOrder getMyOrder(String orderId) {
		for(ShoppingOrder order : myOrders) {
			if(order.getOrderId().equals(orderId)) {
				return order;
			}
		}
		return null;
	}
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Address getDeliveryAddress(){
		return deliveryAddress;
	}
	public Profile getProfile() {
		return profile;
	}
}
