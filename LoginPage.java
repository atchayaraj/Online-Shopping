enum LoginType{USER,ADMIN;}

class LoginPage {
	private int userId;
	public boolean login(LoginType loginType) {
		System.out.println("Enter the username \n");
		String username = Input.getString();
		System.out.println("Enter the password \n");
		String password = Input.getString();
		switch(loginType) {
		case USER:
			return autheticateUser(username,password);
		case ADMIN:
			return authenticateAdmin(username,password);
		}
		return false;
	}
	public int getUserId() {
		return userId;
	}
	private boolean autheticateUser(String username,String password) {
		Storage storage = Storage.getInstance();
		for(UserAccount userAccount : storage.getUserAccountsList()) {
			if(username.equals(userAccount.getUsername()) && password.equals(userAccount.getPassword())){
				userId = userAccount.getUserId();
				return true;
			}
		}
		return false;
	}
	private boolean authenticateAdmin(String username,String password) {
		Storage storage = Storage.getInstance();
		if(username.equals(storage.getAdmin().getUsername()) &&  password.equals(storage.getAdmin().getPassword())){
			return true;
		}
		return false;
	}
}
