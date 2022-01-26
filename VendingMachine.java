/* Name: Sam Solheim
 * Date: 4/5/2021
 * Description: This class file is used to simulate a vending machine that has three potential candy options,
 * 				and is able to give back extra change after purchasing an item, and is able to return the 
 * 				profits from the machine to the owner.
 */


package Vending;

public class VendingMachine implements VendingMachineInterface {
	// Declares the int variables that will be used to store the amount of each candy type in the vending machine //
	private int snickers, twix, reeses;
	// Declares the total amount of cents put into the machine, the selection of candy, cents returned, and the profit made from the machine //
	private int cents, selection, cents_return, profit;
	
	
	public VendingMachine(int s, int t, int r) 
	{
		// Initializes cents, selection, and cents_returned so they can be used later in coding //
		cents = 0; cents_return = 0; profit = 0; selection = 0;
		// Stores the candy bars into their respective private vars //
		snickers = s;
		twix = t;
		reeses = r;
	}

	@Override
	public void insertCents(int c) 
	{
		if(c%5 == 0)
				{
					/*
					 * Adds the amount of coins inserted into the machine to its total amount of coins that 
					 * can be used to buy candy. In addition, temporarily sets the amount of coins that can be returned
					 * as the amount put in for the situation where someone does not buy a candy bar.
					 */
					cents += c;
					cents_return += c;
				}
		else
		{
			throw new ImproperCoinsException();
		}
	}

	@Override
	public void makeSelection(int select) 
	{
		// Following statement needs to go first, otherwise would not catch this exception //
		if(snickers == 0 | twix == 0 | reeses == 0)
		{
			throw new ImproperSelectionException();
		}
		else if(select != 0 && select != 1 && select != 2)
		{
			throw new ImproperSelectionException();
		}
		else if(select == 0 | select == 1 | select == 2)
		{
			// Stores the value of "select" into the private variable "selection" //
			selection = select;
		}
	}

	@Override
	public int purchaseSelection() 
	{
		// Purchasing Snickers //
		if(selection == 0)
		{
			// Checks if the user has enough money for their selection, if not throws ImproperPurchaseException. //
			if(cents >= 100)
			{
				/*
				 * The following lines increase the profit by the amount of the candy bar, set the new amount of
				 * money to be returned to the customer, subtract one candy bar from the machine, and return the 
				 * new amount of money to be returned to the customer
				 */
				profit += 100;
				cents_return = cents - 100;
				snickers -= 1;
				System.out.println("You purchase a Snickers candy bar. You have " + cents_return + " cents still in the machine.");
				return cents_return;
			}
			else
			{
				throw new ImproperPurchaseException();
			}
		}
		// Purchasing Twix //
		else if(selection == 1)
		{
			// Checks if the user has enough money for their selection, if not throws ImproperPurchaseException. //
			if(cents >= 115)
			{
				/*
				 * The following lines increase the profit by the amount of the candy bar, set the new amount of
				 * money to be returned to the customer, subtract one candy bar from the machine, and return the 
				 * new amount of money to be returned to the customer
				 */
				profit += 115;
				cents_return = cents - 115;
				twix -= 1;
				System.out.println("You purchase a Twix candy bar. You have " + cents_return + " cents still in the machine.");
				return cents_return;
			}
			else
			{
				throw new ImproperPurchaseException();
			}
		}
		// Purchasing Reeses //
		else if(selection == 2)
		{
			// Checks if the user has enough money for their selection, if not throws ImproperPurchaseException. //
			if(cents >= 130)
			{
				/*
				 * The following lines increase the profit by the amount of the candy bar, set the new amount of
				 * money to be returned to the customer, subtract one candy bar from the machine, and return the 
				 * new amount of money to be returned to the customer
				 */
				profit += 130;
				cents_return = cents - 130;
				reeses -= 1;
				System.out.println("You purchase a Reeses candy bar. You have " + cents_return + " cents still in the machine.");
				return cents_return;
			}
			else
			{
				throw new ImproperPurchaseException();
			}
		}
		else
		{
			// Throws exception if the user has not made a selection yet //
			throw new ImproperPurchaseException();
		}
	}

	@Override
	public int returnUnspentCents() 
	{
		// Sets the amount of cents in the machine (that are not profit) back to zero as the change is given back to the customer //
		cents = 0;
		// Returns the amount of unspent cents //
		System.out.println("Cents Returned: " + cents_return + " Cents");
		return cents_return;
	}

	@Override
	public int getProfits() 
	{
		// Returns the total amount of profits that were received from sales //
		System.out.println("Total Profit: " + profit + " Cents");
		return profit;
	}
}


