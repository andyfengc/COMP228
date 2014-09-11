package ca.centennial.assignment;

import java.util.Scanner;

/**
 * calculate loan payments
 * 
 * @author Chen Feng
 * 
 */
public class LoanCalculator {
	private double annualInterestRate;
	private double loanAmount;
	private int numberOfYears;

	public static void main(String[] args) {
		LoanCalculator calc = new LoanCalculator();
		calc.readLoanInfo();
		calc.calculatePayment();
	}

	// read loan information
	public void readLoanInfo() {
		boolean inputIsValid = true;
		do {
			try {
				Scanner input = new Scanner(System.in);
				// get Annual Interest Rate
				System.out.print("Enter Annual Interest Rate as a double: ");
				annualInterestRate = input.nextDouble();
				// get Number of Years
				System.out.print("Enter Number of Years as an integer: ");
				numberOfYears = input.nextInt();
				// get Loan Amount
				System.out.print("Enter Loan Amount: ");
				loanAmount = input.nextDouble();
				inputIsValid = true;
			} catch (Exception e) {
				System.out.println("The input value is invalid, Try again! ");
				inputIsValid = false;
			}
		} while (!inputIsValid);
	}

	// calculate payments
	public void calculatePayment() {
		double monthlyPayment = (loanAmount * annualInterestRate / 100.0 / 12)
				/ (1 - (1 / Math.pow(1 + annualInterestRate / 100.0 / 12, numberOfYears * 12)));
		double totalPayment = monthlyPayment * numberOfYears * 12;
		System.out.println("The monthly payment is: $" + roundTwoDp(monthlyPayment));
		System.out.println("The total payment is: $" + roundTwoDp(totalPayment));
	}

	public static double roundTwoDp(double input) {
		return (Math.round(input * 100)) / 100.0;
	}
}
