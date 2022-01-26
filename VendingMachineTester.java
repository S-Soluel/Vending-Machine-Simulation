/* Name: Sam Solheim
 * Date: 4/5/2021
 * Description: This class file is utilized to test the VendingMachine class,
 * 				the first 5 tests are supposed to return errors from passing exceptions in VendingMachine, 
 * 				while the last three tests should run without issues if the program is working as intended
 */

package Vending;

import org.junit.Test;


public class VendingMachineTester {

	// Test to see if ImproperCoins Exception is thrown when customer inserts number of cents that is not a multiple of 5 //
	@Test
	public void ImproperCoinsTest() {
		VendingMachine test = new VendingMachine(3, 4, 5);
		// The following line should result in an error if the ImproperCoins Exception is thrown //
		test.insertCents(4);
	}
	// Tests if ImproperSelectionException is thrown when customer doesn't select item numbered 0, 1, or 2
	@Test
	public void ImproperSelectionTest() {
		VendingMachine test = new VendingMachine(3, 4, 5);
		// Following line will cause an error to be thrown if working properly //
		test.makeSelection(3);
	}
	
	@Test
	public void ImproperSelectionTest2() {
		VendingMachine test = new VendingMachine(0, 0, 0);
		// Throws exception for sold out candy //
		test.makeSelection(0);
	}
	
	@Test
	public void ImproperPurchaseTest() {
		VendingMachine test = new VendingMachine(3, 4, 5);
		// Throws exception for trying to purchase something before you have made a selection //
		test.purchaseSelection();
	}
	
	@Test
	public void ImproperPurchaseTest2() {
		VendingMachine test = new VendingMachine(3, 4, 5);
		// throws exception if customer tries to purchase an item before putting money needed in //
		// Selects Snickers, only puts in 5 cents //
		test.insertCents(5);
		test.makeSelection(0);
		test.purchaseSelection();
	}
	
	@Test
	public void ReturnUnspentCentsTest() {
		// Tests that correct amount of cents is returned if the customer purchases an item //
		VendingMachine test = new VendingMachine(1, 1, 1);
		test.insertCents(200);
		test.makeSelection(0);
		test.purchaseSelection();
		test.returnUnspentCents();
	}
	
	@Test
	public void ReturnUnspentCentsTest2() {
		// Tests that correct amount of cents is returned if the customer does not purchase anything //
		VendingMachine test = new VendingMachine(1, 1, 1);
		test.insertCents(200);
		test.makeSelection(0);
		test.returnUnspentCents();
	}
	
	@Test
	public void getProfitsTest() {
		// Makes several purchases and returns the correct amount of change for the customer //
		VendingMachine test = new VendingMachine(1, 1, 1);
		test.insertCents(2000);
		// Makes first selection //
		test.makeSelection(0);
		test.returnUnspentCents();
		// Makes second selection //
		test.makeSelection(1);
		test.returnUnspentCents();
		// Makes third selection //
		test.makeSelection(2);
		// Calls 'getProfits()' to check that it gives the correct amount of change //
		test.getProfits();
	}
	
	
	
}
