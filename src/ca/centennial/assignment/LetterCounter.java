package ca.centennial.assignment;

/**
 * 2.	Develop a java console application that counts the occurrences
 *  of each letter in an array of 100 characters. [Hint: The application
 *   should generate 100 lowercase letters randomly, and assigns them
 *    to an array of characters. In order to count the occurrences of
 *     each letter in the array, create an array, say counts, 
 *     of 26 int value, each of which counts the occurrences of a letter. 
 *     That is, counts[0] counts the number of a’s, counts[1] counts
 *      the number of b’s as so on.
 *      @author Chen Feng
 */
import java.util.Random;

public class LetterCounter {
	private static final int Charater_Number = 100;
	private static final int MaxNumber_Perline = 20;

	public static void main(String[] args) {
		// generate 100 lowercase charaters as a char array
		char[] chars = generateLowercaseLetters(Charater_Number);
		// display char array
		System.out.println(Charater_Number + " letters was created: ");
		displayCharArray(chars);
		// count the charater occurences
		System.out.println("occurrences of letters:");
		countCharacters(chars);
	}

	// generate lowercase letters
	public static char[] generateLowercaseLetters(int size) {
		Random random = new Random();
		char[] chars = new char[size];
		for (int i = 0; i < size; i++) {
			int randomNumber = random.nextInt();
			chars[i] = (char) (Math.abs(randomNumber % 26) + 'a');
		}
		return chars;
	}

	// print char array
	public static void displayCharArray(char[] chars) {
		int printCount = 0;
		for (char ch : chars) {
			System.out.print(ch + "  ");
			printCount++;
			if (printCount == MaxNumber_Perline) {
				System.out.println();
				printCount = 0;
			}
		}
		System.out.println();
	}

	// display the letter occurrences
	public static void countCharacters(char[] chars) {
		int[] counts = new int[26];
		// count letter occurences
		for (char ch : chars) {
			counts[(int) (ch - 'a')]++;
		}
		// display results
		for (int i = 0; i < counts.length; i++) {
			System.out.printf("%c", (int) 'a' + i);
			System.out.printf("%5d", counts[i]);
			System.out.println();
		}

	}

}
