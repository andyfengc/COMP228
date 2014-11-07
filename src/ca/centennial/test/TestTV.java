package ca.centennial.test;

/**
 * Tester for TV
 * @author Chen
 */

import java.util.Scanner;

public class TestTV {

	public static void main(String[] args) {
		TV tv1 = new TV();
		// display current tv status
		System.out.println(tv1.getStatus());
		// flag for validating user input
		boolean inputIsValid = true;
		
		// prompt user to switch tv on
		do {
			System.out.println("Want to switch it on? [1 for yes, 2 for no]: ");
			try {
				Scanner input = new Scanner(System.in);
				int value = input.nextInt();
				if (value == 1) {
					tv1.turnOn();
					inputIsValid = true;
				} else if (value == 2) {
					tv1.turnOff();
					inputIsValid = false;
				} else {
					inputIsValid = false;
					throw new Exception();
				}
			} catch (Exception e) {
				inputIsValid = false;
				System.out
						.println("Sorry, your enter is invalid. Please try again.");
			}
		} while (!inputIsValid);
		System.out.println(tv1.getStatus());
		System.out.println();
		
		// set the channel
		do {
			System.out.println("Please select the channel: ");
			try {
				Scanner input = new Scanner(System.in);
				int value = input.nextInt();
				tv1.setChannel(value);
				inputIsValid = true;
			} catch (Exception e) {
				System.out.println("Please enter a integer:");
				inputIsValid = false;
			}
		} while (!inputIsValid);
		System.out.println("You are currently watching channel no.: "
				+ tv1.getChannel());
		System.out.println();
		
		// set the volume level
		System.out.println("The volume level now is: " + tv1.getVolumeLevel());
		System.out.println();
		System.out.println("Select volume level: ");
		do {
			try {
				Scanner input = new Scanner(System.in);
				int value = input.nextInt();
				tv1.setVolumeLevel(value);
				inputIsValid = true;
			} catch (Exception e) {
				inputIsValid = false;
				System.out.println("Please enter a integer:");
			}
		} while (!inputIsValid);
		System.out.println("The volume level now is: " + tv1.getVolumeLevel());
		System.out.println();
		
		// turn off tv
		do {
			System.out.println("Enter 1 to switch it off");
			try {
				Scanner input = new Scanner(System.in);
				int value = input.nextInt();
				if (value == 1) {
					tv1.turnOff();
					inputIsValid = true;
				} else if (value == 2){
					System.out.println(tv1.getStatus());
					inputIsValid = true;
				}
				else{
					inputIsValid = false;
					throw new Exception();
				}
			} catch (Exception e) {
				inputIsValid = false;
				System.out.println("Sorry, you cannot turn off tv.");
			}
		} while (!inputIsValid);
		
		// finish testing
		System.out.println("Bye");
	}

}
