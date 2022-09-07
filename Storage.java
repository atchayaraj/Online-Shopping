import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Storage {
	private static Storage storage;
	private Storage() {
		addState();
		addGender();
		addOrderStatus();
	}
	public static Storage getInstance() {
		if(storage == null) {
			storage = new Storage();
		}
		return storage;
	}
	private ArrayList<Product> products = new ArrayList<Product>();
	private ArrayList<ShoppingOrder> orders = new ArrayList<ShoppingOrder>();
	private ArrayList<UserAccount> userAccounts = new ArrayList<UserAccount>();
	private ArrayList<Cart> userCarts = new ArrayList<Cart>();
	private Admin admin = new Admin();
	private ArrayList<String> states = new ArrayList<String>();
	private ArrayList<String> gender = new ArrayList<String>();
	private ArrayList<String> orderStatus = new ArrayList<String>();
	public void addProduct(Product product) {
		products.add(product);
	}
	public void addOrder(ShoppingOrder order) {
		orders.add(order);
	}
	public void addCart(Cart cart) {
		userCarts.add(cart);
	}
	public void addUserAccount(UserAccount userAccount) {
		userAccounts.add(userAccount);
	}
	public Admin getAdmin() {
		return admin;
	}
	public ShoppingOrder getOrder(String orderId) {
		for(ShoppingOrder order : orders) {
			if(orderId.equals(order.getOrderId())) {
				return order;
			}
		}
		return null;
	}
	public Cart getCart(int userId) {
		for(Cart cart : userCarts) {
			if(userId == cart.getUserId()) {
				return cart;
			}
		}
		return null;
	}
	public UserAccount getUserAccount(int userId) {
		for(UserAccount userAccount : userAccounts) {
			if(userId == userAccount.getUserId()) {
				return userAccount;
			}
		}
		return null;
	}
	public ArrayList<ShoppingOrder> getOrderList(){
		return orders;
	}
	public ArrayList<Product> getProductList() {
		return products;
	}
	public ArrayList<Cart> getCartList(){
		return userCarts;
	}
	public ArrayList<UserAccount> getUserAccountsList(){
		return userAccounts;
	}
	public HashSet<String> getBrandName(){
		HashSet<String> brandNames = new HashSet<String>();
		for(Product product : products) {
			brandNames.add(product.getProductBrand());
		}
		return brandNames;
	}
	public HashSet<String> getProductType(){
		HashSet<String> productTypes = new HashSet<String>();
		for(Product product : products) {
			productTypes.add(product.getProductType());
		}
		return productTypes;
	}
	public ArrayList<String> getState(){
		return states;
	}
	public ArrayList<String> getGender(){
		return gender;
	}
	public ArrayList<String> getOrderStatus(){
		return orderStatus;
	}
	private void addState() {
		Collections.addAll(states,"Tamil Nadu","Andra Pradesh","Kerala","Karnataka","Telagana");
	}
	private void addGender() {
		Collections.addAll(gender,"Male","Female");
	}
	private void addOrderStatus() {
		Collections.addAll(orderStatus, "Dispatched","Shipped","Delivered");
	}
}
