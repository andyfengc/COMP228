package ca.centennial.assignment;

import java.util.Scanner;

public class PrintCalendar {
	private final static int START_YEAR = 1800;
	private final static int START_DAYOFWEEK_JAN_1_1800 = 3;
	private final static int LEAP_YEAR_DAYS = 366;
	private final static int COMMON_YEAR_DAYS = 365;

	public static void main(String[] args) {
		int year = 0;
		int month = 0;
		boolean isInputOk = true;
		// receive the year and month through console
		do {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("Please enter a full year (e.g. 2012): ");
				year = input.nextInt();
				if (year < 1800) {
					throw new Exception();
				}
				System.out
						.print("Please enter a month as a number between 1 and 12: ");
				month = input.nextInt();
				if (month < 1 || month > 12) {
					throw new Exception();
				}
				isInputOk = true;
			} catch (Exception e) {
				System.out.println("Sorry, the input is not correct.");
				isInputOk = false;
			}
		} while (!isInputOk);
		// display calendar
		PrintCalendar.displayCalendar(year, month);
	}

	public static void displayCalendar(int year, int month) {
		// print calendar title
		displayCalendarTitle(year, month);
		// print calendar body
		displayCalendarBody(year, month);
	}

	private static void displayCalendarBody(int year, int month) {
		int numberOfDaysUntilLastMonth = calculateNumberOfDays(year, month,
				START_YEAR);
		int dayOfWeek = calculateDayOfWeek(numberOfDaysUntilLastMonth);
		// System.out.println(dayOfWeek);
		int numberOfDaysThisMonth = calculateNumberOfDaysThisMonth(year, month);
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("     ");
		}
		for (int day = 1; day <= numberOfDaysThisMonth; day++) {
			System.out.printf("%3d", day);
			System.out.print("  ");
			if ((day + dayOfWeek) % 7 == 0) {
				System.out.println();
			}
		}
	}
	/**
	 * calculate the number of days in the month of year
	 * @param year
	 * @param month
	 * @return number of days
	 */
	public static int calculateNumberOfDaysThisMonth(int year, int month) {
		int numberOfDaysInMonth = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numberOfDaysInMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDaysInMonth = 30;
			break;
		case 2:
			if (isLeapYear(year)) {
				numberOfDaysInMonth = 29;
			} else {
				numberOfDaysInMonth = 28;
			}
			break;
		}
		return numberOfDaysInMonth;
	}
	/**
	 * calculate the day of week
	 * @param numberOfDays
	 * @return day of week
	 */
	public static int calculateDayOfWeek(int numberOfDays) {
		return (numberOfDays + START_DAYOFWEEK_JAN_1_1800) % 7;
	}

	// calculate the number of days from Jan. 1 of sinceYear to the previous
	// month this year
	public static int calculateNumberOfDays(int year, int month, int sinceYear) {
		int numberOfDaysSinceYearToLastYear = 0;
		int numberOfDaysJanToLastMonth = 0;
		// calculate the number of days from sinceYear to last year
		for (int i = sinceYear; i < year; i++) {
			if (isLeapYear(i)) {
				numberOfDaysSinceYearToLastYear += LEAP_YEAR_DAYS;
			} else {
				numberOfDaysSinceYearToLastYear += COMMON_YEAR_DAYS;
			}
		}
		// calculate the number of days from January to the last month this
		// year
		for (int i = 1; i < month; i++) {
			numberOfDaysJanToLastMonth += calculateNumberOfDaysThisMonth(year,
					i);
		}
		return numberOfDaysSinceYearToLastYear + numberOfDaysJanToLastMonth;
	}
	/**
	 * print the calendar title
	 * @param year
	 * @param month
	 */
	private static void displayCalendarTitle(int year, int month) {
		System.out.println("-----------------------------------");
		System.out.println("           " + getMonthDesc(month) + ", " + year+ "");
		System.out.println("-----------------------------------");
		System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");
	}
	/**
	 * get the description of month
	 * @param month
	 * @return
	 */
	private static String getMonthDesc(int month) {
		String monthDesc = "";
		switch (month) {
		case 1:
			monthDesc = "January";
			break;
		case 2:
			monthDesc = "Feburary";
			break;
		case 3:
			monthDesc = "March";
			break;
		case 4:
			monthDesc = "April";
			break;
		case 5:
			monthDesc = "May";
			break;
		case 6:
			monthDesc = "June";
			break;
		case 7:
			monthDesc = "July";
			break;
		case 8:
			monthDesc = "August";
			break;
		case 9:
			monthDesc = "September";
			break;
		case 10:
			monthDesc = "October";
			break;
		case 11:
			monthDesc = "November";
			break;
		case 12:
			monthDesc = "December";
			break;
		}
		return monthDesc;
	}

	// determines if it is a leap year
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
}
