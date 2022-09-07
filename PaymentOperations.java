
class PaymentOperations {
	private static BankCard bankCard;
	public static void choosePaymentGateway() {
		boolean flag = true;
		while(flag) {
			System.out.println("Enter 1 : Credit Card ");
			System.out.println("Enter 2 : Debit Card ");
			int choice = Integer.parseInt(Input.getString());
			switch(choice) {
			case 1:
				bankCard = new CreditCard();
				flag = false;
				break;
			case 2:
				bankCard =  new DebitCard();
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice \n");
				break;
			}
		}
	}
	public static void proceedPayment(float amount) {
		bankCard.doTransaction(amount);
	}
}
