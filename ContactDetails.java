
class ContactDetails {
	private String emailId;
	private String mobileNumber;
	ContactDetails(){
		setMobileNumber();
		setEmailId();
	}
	public void setEmailId() {
		while(true) {
			System.out.println("Enter the email Id ");
			String emailId = Input.getString();
			if(emailId.contains("@gmail.com") && checkEmailIdIsExist(emailId)) {
				this.emailId = emailId;
				break;
			}
			else {
				System.out.println("Invalid Email Id \n");
			}
		}
	}
	public void setMobileNumber() {
		while(true) {
			System.out.println("Enter the mobile number ");
			String mobileNumber = Input.getString();
			if(mobileNumber.length() == 10 && checkMobileNumberIsExist(mobileNumber)) {
				this.mobileNumber = mobileNumber;
				break;
			}
			else {
				System.out.println("Invalid Mobile Number \n");
			}
		}
	}
	public String getEmailId() {
		return emailId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	private boolean checkMobileNumberIsExist(String number) {
		Storage storage = Storage.getInstance();
		for(UserAccount userAccount : storage.getUserAccountsList()) {
			String mobileNumber = userAccount.getProfile().getContactDetails().getMobileNumber();
			if(number.equals(mobileNumber)) {
				return false;
			}
		}
		return true;
	}
	private boolean checkEmailIdIsExist(String emailId) {
		Storage storage = Storage.getInstance();
		for(UserAccount userAccount : storage.getUserAccountsList()) {
			String emailId1 = userAccount.getProfile().getContactDetails().getEmailId();
			if(emailId.equals(emailId1)) {
				return false;
			}
		}
		return true;
	}
}
