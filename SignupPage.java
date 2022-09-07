
class SignupPage {
	static int number = 100;
	public void signup() {
		int userId = getUserId();
		Storage storage = Storage.getInstance();
		PersonalDetails personalDetails = new PersonalDetails();
		ContactDetails contactDetails = new ContactDetails();
		Profile profile = new Profile(personalDetails,contactDetails);
		UserAccount userAccount = (new UserAccount(profile,getUsername(),getPassword(),userId));
		storage.addUserAccount(userAccount);
		storage.addCart(new Cart(userId));
	}
	private String getUsername() {
		String username;
		while(true) {
			System.out.println("Enter the username : ");
			username = Input.getString();
			if(checkUsernameIsExist(username)) {
				break;
			}
			else {
				System.out.println("Username is Exist \n");
			}
		}
		return username;
	}
	private String getPassword() {
		String password;
		while(true) {
			System.out.println("Enter the password : ");
			password = Input.getString();
			if(checkPasswordIsExist(password)) {
				break;
			}
			else {
				System.out.println("Password is Exist \n");
			}
		}
		return password;
	}
	private boolean checkUsernameIsExist(String username) {
		Storage storage = Storage.getInstance();
		for(UserAccount userAccount : storage.getUserAccountsList()) {
			if(username.equals(userAccount.getUsername())) {
				return false;
			}
		}
		return true;
	}
	private boolean checkPasswordIsExist(String password) {
		Storage storage = Storage.getInstance();
		for(UserAccount userAccount : storage.getUserAccountsList()) {
			if(password.equals(userAccount.getPassword())) {
				return false;
			}
		}
		return true;
	}
	private int getUserId() {
		int userId = number;
		number++;
		return userId;
	}
}
