import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		boolean flag = true;
		while(flag) {
			System.out.println("Welcome to Online Shopping ! \n");
			System.out.println("Enter 1 : Singup ");
			System.out.println("Enter 2 : Login as User ");
			System.out.println("Enter 3 : Login as Admin ");
			System.out.println("Enter 4 : Exit ");
			int choice = Integer.parseInt(Input.getString());
			switch(choice) {
			case 1:
				SignupPage signupPage = new SignupPage();
				signupPage.signup();
				System.out.println("Account Registered Succefully \n");
				break;
			case 2:
				LoginPage loginPage = new LoginPage();
				if(loginPage.login(LoginType.USER)) {
					System.out.println("Logged in successfully \n");
					userFunctionality(loginPage.getUserId());
				}
				else {
					System.out.println("Invalid Username or Password \n");
				}
				break;
			case 3:
				loginPage = new LoginPage();
				if(loginPage.login(LoginType.ADMIN)) {
					System.out.println("Logged in successfully \n");
					adminFunctionality();
				}
				else {
					System.out.println("Invalid Username or Password \n");
				}
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice \n");
				break;
			}
		}
	}
	public static void userFunctionality(int userId) {
		boolean flag = true;
		while(flag) {
			System.out.println("Enter 1 : Search Products ");
			System.out.println("Enter 2 : Add to Cart ");
			System.out.println("Enter 3 : check Cart ");
			System.out.println("Enter 4 : check Account ");
			System.out.println("Enter 5 : logout ");
			int choice = Integer.parseInt(Input.getString());
			switch(choice) {
			case 1:
				if(!getStorageInstance().getProductList().isEmpty()) {
					boolean flag1 = true;
					while(flag1) {
						System.out.println("Enter 1 : Search Products by Product Type ");
						System.out.println("Enter 2 : Search Products by Brand Name ");
						System.out.println("Enter 3 : Search Products by Filter ");
						System.out.println("Enter 4 : Go Back ");
						int choice1 = Integer.parseInt(Input.getString());
						switch(choice1) {
						case 1: 
							displayDefaultOptions(getStorageInstance().getProductType());
							String productType = getProductType();
							displayProducts(ProductOperations.searchProductsByProductType(productType));
							break;
						case 2:
							displayDefaultOptions(getStorageInstance().getBrandName());
							String brandName = getBrandName();
							displayProducts(ProductOperations.searchProductsByBrandName(brandName));
							break;
						case 3:
							SearchFilter searchfilter = new SearchFilter();
							displayProducts(ProductOperations.searchProductsByFilter(searchfilter));
							break;
						case 4:
							flag1 = false;
							break;
						default:
							System.out.println("Invalid Choice \n");
							break;
						}
					}
				}
				else {
					System.out.println("No Products Available \n");
				}
				break;
			case 2:
				int cartItemSize = getStorageInstance().getCart(userId).getProductList().size();
				int productListSize = getStorageInstance().getProductList().size();
				if( cartItemSize != productListSize) {
					CartOperations.addToCart(userId,getProductByProductId(userId));
				}
				else {
					System.out.println("No Products is Available To Add \n");
				}
				
				break;
			case 3:
				boolean flag1 = true;
				while(flag1) {
					System.out.println("Enter 1 : View Products From Cart ");
					System.out.println("Enter 2 : Remove products From Cart ");
					System.out.println("Enter 3 : Place order ");
					System.out.println("Enter 4 : Go Back ");
					choice = Integer.parseInt(Input.getString());
					switch(choice) {
					case 1:
						if(!getStorageInstance().getCart(userId).getProductList().isEmpty()) {
							displayProducts(getStorageInstance().getCart(userId).getProductList());
							int quantity = CartOperations.calculateQuantityOfProductsInCart(userId);
							float totalPrice = CartOperations.calculateProductPriceInCart(userId);
							CartOperations.displayPriceDetailsOfCartProducts(quantity,totalPrice);
							System.out.println("\n");
						}
						else {
							System.out.println("Your Cart is Empty \n");
						}
						break;
					case 2:
						if(!getStorageInstance().getCart(userId).getProductList().isEmpty()) {
							int productId = getProductId(userId);
							CartOperations.removeProductFromCart(getStorageInstance().getCart(userId),getProduct(productId));
						}
						else {
							System.out.println("Your Cart is Empty \n");
						}
						break;
					case 3:
						if(!getStorageInstance().getCart(userId).getProductList().isEmpty()) {
							float totalPrice = CartOperations.calculateProductPriceInCart(userId);
							ShoppingOrder order = placeOrder(userId,getStorageInstance().getCart(userId).getProductList(),totalPrice);
							if(order!=null) {
								executeAddOrder(userId,order);
								executeRemoveProducts(order.getOrderedProducts());
							}
							else {
								System.out.println("Payment Cancelled \n");
							}
						}
						else {
							System.out.println("Cart is Empty \n");
						}
						break;
					case 4:
						flag1 = false;
						break;
					default:
						System.out.println("Invalid Input \n");
						break;
					}
				}
				break;
			case 4:
				boolean flag3 = true;
				while(flag3) {
					System.out.println("Enter 1 : View Profile ");
					System.out.println("Enter 2 : Edit Profile ");
					System.out.println("Enter 3 : check MyOrders ");
					System.out.println("Enter 4 : Add Delivery Address ");
					System.out.println("Enter 5 : Edit Delivery Address ");
					System.out.println("Enter 6 : Delete Delivery Address ");
					System.out.println("Enter 7 : Change Username ");
					System.out.println("Enter 8 : Change Password ");
					System.out.println("Enter 9 : Go Back ");
					int choice2 = Integer.parseInt(Input.getString());
					switch(choice2) {
					case 1:
						UserAccountOperations.displayProfile(userId);
						break;
					case 2:
						UserAccountOperations.editProfile(userId);
						break;
					case 3:
						if(!getStorageInstance().getUserAccount(userId).getMyOrderList().isEmpty()) {
							boolean flag2 = true;
							while(flag2) {
								System.out.println("Enter 1 : View My Orders ");
								System.out.println("Enter 2 : Cancel Order ");
								System.out.println("Enter 3 : Go Back ");
								choice = Integer.parseInt(Input.getString());
								switch(choice) {
								case 1:
									if(!getStorageInstance().getUserAccount(userId).getMyOrderList().isEmpty()) {
										displayOrders(getStorageInstance().getUserAccount(userId).getMyOrderList());
									}
									else {
										System.out.println("No Orders Found");
									}
									break;
								case 2:
									if(!getStorageInstance().getUserAccount(userId).getMyOrderList().isEmpty()) {
										ShoppingOrder order = getOrderByOrderId(userId);
										if(order!=null) {
											addProductsToStorage(order);
											OrderOperations.cancelOrder(order.getOrderId(),userId);
										    System.out.println("Order Cancelled ");
										}
									}
									else {
										System.out.println("No Orders Found");
									}
									break;
								case 3:
									flag2 = false;
									break;
								default:
									System.out.println("Invalid Input \n");
									break;
								}
							}
						}
						else {
							System.out.println("No Orders Found");
						}
						break;
					case 4:
						Address deliveryAddress = new Address();
						UserAccountOperations.addDeliveryAddress(userId,deliveryAddress);
						break;
					case 5:
						if(getStorageInstance().getUserAccount(userId).getDeliveryAddress()!=null) {
							UserAccountOperations.editDeliveryAddress(userId);
						}
						else {
							System.out.println("You didn't add delivery address yet \n");
						}
						break;
					case 6:
						if(getStorageInstance().getUserAccount(userId).getDeliveryAddress()!=null) {
							UserAccountOperations.deleteDeliveryAddress(userId);
						}
						else {
							System.out.println("You didn't add delivery address yet \n");
						}
						break;
					case 7:
						if(validateExistingUsername(userId)) {
							UserAccountOperations.changeUsername(userId);
						}
						else {
							System.out.println("Username doesn't exist \n");
						}
						break;
					case 8:
						if(validateExistingPassword(userId)) {
							UserAccountOperations.changePassword(userId);
						}
						else {
							System.out.println("Password doesn't exist \n");
						}
						break;
					case 9:
						flag3 = false;
						break;
					default:
						System.out.println("Invalid Choice  \n");
						break;
					}
				}
				break;
			case 5:
				LogoutPage logoutPage = new LogoutPage();
				flag = logoutPage.logout();
				break;
			default:
				System.out.println("Invalid Choice \n");
				break;
			}
		}
	}
	public static void adminFunctionality() {
		boolean flag = true;
		while(flag) {
			System.out.println("Enter 1 : View Orders");
			System.out.println("Enter 2 : Add Products ");
			System.out.println("Enter 3 : View Products ");
			System.out.println("Enter 4 : Change status of the order ");
			System.out.println("Enter 5 : View Complete Users Details ");
			System.out.println("Enter 6 : Go Back ");
			int choice = Integer.parseInt(Input.getString());
			switch(choice) {
			case 1:
				if(!getStorageInstance().getOrderList().isEmpty()) {
					displayOrders(getStorageInstance().getOrderList());
				}
				else {
					System.out.println("No order is Found \n");
				}
				break;
			case 2:
				ProductOperations.addProduct(new Product());
				break;
			case 3:
				if(!getStorageInstance().getProductList().isEmpty()) {
					displayProducts(getStorageInstance().getProductList());
				}
				else {
					System.out.println("No Products Found \n");
				}
				break;
			case 4:
				if(!getStorageInstance().getOrderList().isEmpty()) {
					displayOrders(getStorageInstance().getOrderList());
					ShoppingOrder order= getOrderByOrderId(0);
					if(order!=null) {
						OrderOperations.changeOrderStatus(order);
					}
				}
				else {
					System.out.println("No order is Found \n");
				}
				break;
			case 5:
				if(!getStorageInstance().getUserAccountsList().isEmpty()) {
					viewCompleteUsersDetails();
				}
				else {
					System.out.println("No Users Found \n");
				}
				break;
			case 6:
				flag = false;
				break;
			default :
				System.out.println("Invalid Choice \n");
				break;
			}
		}
	}
	private static Product getProductByProductId(int userId){
		while(true) {
			System.out.println("Enter product Id : ");
			int productId = Integer.parseInt(Input.getString());
			if(validateProductId(productId) && !checkProductExistenceInCart(productId,userId)){
				Product product = getProduct(productId);
				return product;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	private static String getProductType() {
		while(true) {
			System.out.println("Enter Product Type :");
			String productType = Input.getString();
		    if(validateDefaultInput(getStorageInstance().getProductType(),productType)) {
		    	return productType;
		    }
		    else {
		    	System.out.println("Invalid Input \n");
		    }
		}
	}
	private static String getBrandName() {
		while(true) {
			System.out.println("Enter Brand Name :");
			String brandName = Input.getString();
			if(validateDefaultInput(getStorageInstance().getBrandName(),brandName)) {
				return brandName;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}	
	private static boolean validateDefaultInput(HashSet<String> defaultValues,String defaultValue) {
		if(defaultValues.contains(defaultValue)) {
			return true;
		}
		return false;
	}
	private static boolean checkProductExistenceInCart(int productId,int userId) {
		for(Product product : getStorageInstance().getCart(userId).getProductList()) {
			if(productId == product.getProductId()) {
				return true;
			}
		}
		return false;
	}
	private static int getProductId(int userId) {
		while(true) {
			System.out.println("Enter product Id : ");
			int productId = Integer.parseInt(Input.getString());
			if(validateProductId(productId) && checkProductExistenceInCart(productId,userId)){
				return productId;
			}
			else {
				System.out.println("Entered Id doesn't Exist \n");
			}
		}
	}
	private static Product getProduct(int productId) {
		for(Product product : getStorageInstance().getProductList()) {
			if(productId == product.getProductId()) {
				return product;
			}
		}
		return null;
	}
	private static void displayProducts(ArrayList<Product> products) {
		for(Product product : products) {
			ProductOperations.displayProduct(product);
			System.out.println("\n");
		}
	}
	private static void executeAddOrder(int userId,ShoppingOrder order) {
		getStorageInstance().getUserAccount(userId).addOrder(order);
		getStorageInstance().addOrder(order);
	}
	private static void executeRemoveProducts(ArrayList<Product> products) {
		removeProductsFromCart(products);
		removeProductsFromStorage(products);
	}
	private static void removeProductsFromCart(ArrayList<Product> products) {
		for(Cart cart : getStorageInstance().getCartList()) {
			for(Product product : products) {
				CartOperations.removeProductFromCart(cart,product);
			}
		}
	}
	private static void removeProductsFromStorage(ArrayList<Product> products) {
		for(Product product : products) {
			ProductOperations.removeProduct(product);
		}
	}
	private static ShoppingOrder placeOrder(int userId,ArrayList<Product> products,float totalPrice) {
		ShoppingOrder order = OrderOperations.placeOrder(products,getDeliveryAddress(userId));
		OrderOperations.displayOrderSummary(products);
		System.out.println("\n");
		if(getUserStatusOnPayment()) {
			prodceedPayment(totalPrice);
			System.out.println("\n");
			order.createOrderId();
			return order;
		}
		else {
			return null;
		}
	}
	private static Address getDeliveryAddress(int userId) {
		Address deliveryAddress = getStorageInstance().getUserAccount(userId).getDeliveryAddress();
		if(deliveryAddress != null) {
			return deliveryAddress;
		}
		else {
			deliveryAddress = getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails().getResidentialAddress();
			return deliveryAddress;
		}
	}
	private static boolean getUserStatusOnPayment() {
		while(true){
			System.out.println("Enter 1 : Proceed Payemnt ");
			System.out.println("Enter 2 : Cancel Payment ");
			int choice = Integer.parseInt(Input.getString());
			switch(choice) {
			case 1:
				return true;
			case 2:
				return false;
			default:
				System.out.println("Invald Choice \n");
				break;
			}
		}
	}
	private static void prodceedPayment(float totalAmount) {
		PaymentOperations.choosePaymentGateway();
		PaymentOperations.proceedPayment(totalAmount);
	}
	private static ShoppingOrder getOrderByOrderId(int userId){
		System.out.println("Enter Order Id : ");
		String orderId = Input.getString();
		if(validateOrderId(userId,orderId)) {
			return getStorageInstance().getOrder(orderId);
		}
		else {
			System.out.println("Invalid Input \n");
		}
		return null;
	}
	private static void addProductsToStorage(ShoppingOrder order) {
		for(Product product : order.getOrderedProducts()) {
			ProductOperations.addProduct(product);
		}
	}
	private static void displayOrders(ArrayList<ShoppingOrder> orders) {
		for(ShoppingOrder order : orders) {
			OrderOperations.displayOrder(order);
			System.out.println("\n");
		}
	}
	private static boolean validateExistingPassword(int userId) {
		String password = getStorageInstance().getUserAccount(userId).getPassword();
		if(password.equals(getOldPassword())){
			return true;
		}
		return false;
	}
	private static boolean validateExistingUsername(int userId) {
		String username = getStorageInstance().getUserAccount(userId).getUsername();
		if(username.equals(getOldUsername())){
			return true;
		}
		return false;
	}
	private static String getOldUsername() {
		while(true) {
			System.out.println("Enter the old username : ");
			String username = Input.getString();
			if(!username.equals("")) {
				return username;
			}
		}
	}
	private static String getOldPassword() {
		while(true) {
			System.out.println("Enter the old password : ");
			String password = Input.getString();
			if(!password.equals("")) {
				return password;
			}
		}
	}
	private static boolean validateProductId(int productId) {
		for(Product product : getStorageInstance().getProductList()) {
			if(productId == product.getProductId()) {
				return true;
			}
		}
		return false;
	}
	private static void viewCompleteUsersDetails() {
		for(UserAccount userAccount : getStorageInstance().getUserAccountsList()) {
			UserAccountOperations.displayProfile(userAccount.getUserId());
			UserAccountOperations.displayUsernameAndPassword(userAccount.getUserId());
			System.out.println("\n");
		}
	}
	private static boolean validateOrderId(int userId,String orderId) {
		if(getStorageInstance().getOrder(orderId)!= null && 
				!getStorageInstance().getOrder(orderId).getOrderStatus().equals("Delivered") && (userId == 0 &&
				getStorageInstance().getUserAccount(userId).getMyOrder(orderId)!=null)) {
			return true;
		}
		return false;
	}
	private static void displayDefaultOptions(HashSet<String> options) {
		for(String option : options) {
			System.out.println(option);
		}
		System.out.println("\n");
	}
	private static Storage getStorageInstance() {
		Storage storage = Storage.getInstance();
		return storage;
	}
}
