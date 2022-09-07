
class CreditCard implements BankCard{
	public void doTransaction(float amount) {
		System.out.println(amount+" is credited from your credit card");
	}
}
