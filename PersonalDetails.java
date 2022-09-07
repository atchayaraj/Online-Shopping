import java.util.ArrayList;

class PersonalDetails {
	private String name;
	private DateOfBirth dateOfBirth;
	private String gender;
	private Address residentialAddress;
	PersonalDetails(){
		setName();
		setDateOfBirth();
		setGender();
		setAddress();
	}
	public void setName() {
		while(true) {
			System.out.println("Enter the name :");
			name = Input.getString();
			if(!name.equals("")) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	public void setDateOfBirth() {
		dateOfBirth = new DateOfBirth();
	}
	public void setGender() {
		Storage storage = Storage.getInstance();
		while(true) {
			System.out.println("Enter the gender ");
			displayDefaultGenderValues(storage.getGender());
			gender = Input.getString();
			if(storage.getGender().contains(gender)) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	public void setAddress() {
		residentialAddress = new Address();
	}
	public String getName() {
		return name;
	}
	public DateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public Address getResidentialAddress() {
		return residentialAddress;
	}
	private void displayDefaultGenderValues(ArrayList<String> genders) {
		for(String gender : genders) {
			System.out.println(gender);
		}
		System.out.println("\n");
	}
}
