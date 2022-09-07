import java.util.ArrayList;

class Address {
	private String doorNo;
	private String streetName;
	private String city;
	private String state;
	private String address;
	Address(){
		setDoorNo();
		setStreetName();
		setCityName();
		setState();
		setAddress();
	}
	public void setDoorNo() {
		while(true) {
			System.out.println("Enter the door number ");
			doorNo = Input.getString();
			if(!doorNo.equals("")) {
				break;
			}
		}
	}
	public void setStreetName() {
		while(true) {
			System.out.println("Enter the street name ");
			streetName = Input.getString();
			if(!streetName.equals("")) {
				break;
			}
		}
	}
	public void setCityName() {
		while(true) {
			System.out.println("Enter the city ");
			city = Input.getString();
			if(!city.equals("")) {
				break;
			}
		}
	}
	public void setState() {
		Storage storage = Storage.getInstance();
		while(true) {
			System.out.println("Enter the state ");
			displayDefaultStateValues(storage.getState());
			state = Input.getString();
			if(storage.getState().contains(state)) {
				break;
			}
			else {
				System.out.println("Invalid Input \n");
			}
		}
	}
	public void setAddress() {
		address = doorNo+"\n                "+streetName+"\n                "+city+"\n                "+state;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getAddress() {
		return address;
	}
	private void displayDefaultStateValues(ArrayList<String> states) {
		for(String state : states) {
			System.out.println(state);
		}
		System.out.println("\n");
	}
}
