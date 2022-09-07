import java.util.ArrayList;

class UserAccountOperations {
    public static void displayProfile(int userId){
    	System.out.println("-------Personal Details-------\n");
    	System.out.println("Name          : "+getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails().getName());
    	System.out.println("DOB           : "+getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails().getDateOfBirth().getDateOfBirth());
    	System.out.println("Gender        : "+getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails().getGender());
    	System.out.println("Address       : "+getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails().getResidentialAddress().getAddress()+"\n");
    	System.out.println("-------Contact Information-------\n");
    	System.out.println("Mobile Number : "+getStorageInstance().getUserAccount(userId).getProfile().getContactDetails().getMobileNumber());
    	System.out.println("Email id      : "+getStorageInstance().getUserAccount(userId).getProfile().getContactDetails().getEmailId()+"\n");
    }
    public static void displayUsernameAndPassword(int userId) {
    	System.out.println("Username      : "+getStorageInstance().getUserAccount(userId).getUsername());
    	System.out.println("Password      : "+getStorageInstance().getUserAccount(userId).getPassword());
    }
    public static void addDeliveryAddress(int userId,Address deliveryAddress) {
	getStorageInstance().getUserAccount(userId).setDeliveryAddress(deliveryAddress);
    }
    public static void editDeliveryAddress(int userId) {
	Address deliveryAddress = new Address();
	getStorageInstance().getUserAccount(userId).setDeliveryAddress(deliveryAddress);
    }
    public static void deleteDeliveryAddress(int userId) {
    	getStorageInstance().getUserAccount(userId).setDeliveryAddress(null);
    }
    public static void editProfile(int userId) {
	System.out.println("Enter 1 : Gender");
	System.out.println("Enter 2 : Address");
	System.out.println("Enter 3 : Mobile Number");
	System.out.println("Enter 4 : Email Id");
	int choice = Integer.parseInt(Input.getString());
	switch(choice) {
	case 1:
		PersonalDetails personalDetails = getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails();
		personalDetails.setGender();
		break;
	case 2:
		personalDetails = getStorageInstance().getUserAccount(userId).getProfile().getPersonalDetails();
		personalDetails.setAddress();
		break;
	case 3:
		ContactDetails contactDetails = getStorageInstance().getUserAccount(userId).getProfile().getContactDetails();
		contactDetails.setMobileNumber();
		break;
	case 4:
		contactDetails = getStorageInstance().getUserAccount(userId).getProfile().getContactDetails();
		contactDetails.setEmailId();
		break;
	default:
		System.out.println("Invalid Choice \n");
		break;
	}
    }
    public static void changeUsername(int userId) {
    	while(true) {
    		System.out.println("Enter new username : ");
    		String username = Input.getString();
    		if(autheticateUsername(username)) {
    			UserAccount userAccount = getStorageInstance().getUserAccount(userId);
    			userAccount.setUsername(username);
    			 break;
    		}
    		else {
    			System.out.println("username is already exist \n");
    		}
    	}
    }
    public static void changePassword(int userId) {
    	while(true) {
    		System.out.println("Enter new password : ");
    		String password = Input.getString();
    		if(autheticatePassword(password)) {
    			UserAccount userAccount = getStorageInstance().getUserAccount(userId);
    			userAccount.setPassword(password);
    			 break;
    		}
    		else {
    			System.out.println("password is already exist \n");
    		}
    	}
    }
    private static boolean autheticateUsername(String username) {
    	ArrayList<UserAccount> userAccounts = getStorageInstance().getUserAccountsList();
    	for(UserAccount userAccount :userAccounts) {
    		if(username.equals(userAccount.getUsername())) {
    			return false;
    		}
    	}
    	return true;
    }
    private static boolean autheticatePassword(String password) {
    	ArrayList<UserAccount> userAccounts = getStorageInstance().getUserAccountsList();
    	for(UserAccount userAccount : userAccounts) {
    		if(password.equals(userAccount.getPassword())) {
    			return false;
    		}
    	}
    	return true;
    }
    private static Storage getStorageInstance() {
    	Storage storage = Storage.getInstance();
    	return storage;
    }
}
