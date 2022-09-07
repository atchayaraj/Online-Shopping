
class DateOfBirth {
	private int day;
	private int month;
	private int year;
	private String dateOfBirth;
	DateOfBirth(){
		setBirthYear();
		setBirthMonth();
		setBirthDay();
		setDateOfBirth();
	}
	public void setBirthDay() {
		while(true) {
			System.out.println("Enter the Birth day : ");
			day = Integer.parseInt(Input.getString());
			if(day>0 && day<=31) {
				break;
			}
			System.out.println("Birth day should be within 1 - 31 : ");
		}
	}
	public void setBirthMonth() {
		while(true) {
			System.out.println("Enter the Birth month : ");
			month = Integer.parseInt(Input.getString());
			if(month>0 && month<=12) {
				break;
			}
			System.out.println("Birth month should be within 1 - 12");
		}
	}
	public void setBirthYear() {
		while(true) {
			System.out.println("Enter the Birth year : ");
			year = Integer.parseInt(Input.getString());
			String demoYear = Integer.toString(year);
			if((year>=1950 && year<=2004)&& demoYear.length()==4){
				break;
			}
			System.out.println("Birth year should be after 1950 and on or before 2004 \n");
		}
	}
	public void setDateOfBirth() {
		dateOfBirth = day+"/"+month+"/"+year;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
}
