package ca.centennial.assignment;
/**
 * 1.	Develop a Java console application that reverses an array. 
 * The original array is sent as an argument to a method named 
 * reverseArray which receives the array, reverses it, and returns
 *  the reversed array to the caller. The application should display
 *   the original array, and the reversed array from the main().
 *   @author Chen Feng
 */

public class ArraySorter {

	public static void main(String[] args) {
		// init a int array
		int[] integers = { 18, 5, 70, 3, 56, 8, 12, 13, 1, 8, 49, 63, 37 };
		// print original array
		System.out.println("The original array is: ");
		ArraySorter.displayIntArray(integers);
		// reverse array
		ArraySorter.reverseIntArray(integers);
		// print reversed array
		System.out.println("The reversed array is: ");
		ArraySorter.displayIntArray(integers);
	}
	/**
	 * reverse a int array
	 * @param numbers
	 * @return reversed array
	 */
	public static int[] reverseIntArray(int[] numbers) {
		for (int i = 0; i < numbers.length / 2; i++) {
			int temp = numbers[i];
			numbers[i] = numbers[numbers.length - i - 1];
			numbers[numbers.length - i - 1] = temp;
		}
		return numbers;
	}
	/**
	 * print a int array
	 * @param numbers
	 */
	public static void displayIntArray(int[] numbers) {
		for (int number : numbers) {
			System.out.print(number + "  ");
		}
		System.out.println();
	}
}
