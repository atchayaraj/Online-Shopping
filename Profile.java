
class Profile {
	private PersonalDetails personalDetails;
	private ContactDetails contactDetails;
	Profile(PersonalDetails personalDetails,ContactDetails contactDetails){
		this.personalDetails = personalDetails;
		this.contactDetails = contactDetails;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
}
