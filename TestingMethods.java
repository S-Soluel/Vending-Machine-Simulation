package Vending;

public class TestingMethods {

	public static void main(String[] args) {
		VendingMachine test = new VendingMachine(1, 1, 1);
		test.insertCents(200);
		test.makeSelection(0);
		test.purchaseSelection();
		test.returnUnspentCents();
		test.getProfits();
	}
}
