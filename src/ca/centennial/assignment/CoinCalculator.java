package ca.centennial.assignment;
/**
 * 1.	Develop an application using Java Console that changes 
 * a given amount of money into smaller monetary units. 
 * The program lets the user enter an amount as double value
 *  representing the total amount in dollars and cents, 
 *  and outputs a report listing the monetary equivalent in dollars,
 *   quarters, dimes, and nickels, in this order, to obtain 
 *   the minimum number of coins. A  test run is shown below:

               Enter an amount, for example, 11.58:   15.85

       Your amount 15.85 consists of 
	         15 dollars,
	          3 quarters,
	          1 Dimes
	          0 nickels.
	@author Andy(Chen Feng)
 */
import java.util.Scanner;

public class CoinCalculator {
	// set unit as cents
	private final static int DOLLAR = 100;
	private final static int QUARTER = 15;
	private final static int DIME = 10;
	private final static int NICKEL = 5;
	private final static int CENT_THRESHLOLD = 3;
	// given amount of money
	private double amount;

	public CoinCalculator(double amount) {
		this.amount = amount;
	}

	public static void main(String[] args) {
		System.out.print("Enter an amount, for example, 11.58: ");
		Scanner input = new Scanner(System.in);
		try {
			// read input
			double amount = input.nextDouble();
			if (amount < 0)
				throw new Exception();
			// calculate coins
			CoinCalculator calc = new CoinCalculator(amount);
			calc.calculateNumberOfCoins();
		} catch (Exception e) {
			System.out.println("Sorry, the input amount is invalid (e.g. 11.58).");
		}
	}

	public void calculateNumberOfCoins() {
		// convert unit from dollar to coin
		int amountOfCoin = convertDollarToCoin();
		// caculate number of dollar
		int numberOfDollar = amountOfCoin / DOLLAR;
		amountOfCoin -= numberOfDollar * DOLLAR;
		// caculate number of quarter
		int numberOfQuarter = amountOfCoin / QUARTER;
		amountOfCoin -= numberOfQuarter * QUARTER;
		// caculate number of dime
		int numberOfDime = amountOfCoin / DIME;
		amountOfCoin -= numberOfDime * DIME;
		// caculate number of nickel
		int numberOfNickel = amountOfCoin / NICKEL;
		amountOfCoin -= numberOfNickel * NICKEL;
		// convert cents to nickel if applicable
		if (amountOfCoin >= CENT_THRESHLOLD) {
			numberOfNickel++;
		}
		System.out.println("Your amount " + amount + " consists of ");
		System.out.println("\t" + numberOfDollar + " dollars");
		System.out.println("\t" + numberOfQuarter + " quarters");
		System.out.println("\t" + numberOfDime + " Dimes");
		System.out.println("\t" + numberOfNickel + " nickels");
	}

	private int convertDollarToCoin() {
		return (int) (amount * 100);
	}

}
