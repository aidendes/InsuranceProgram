package ie.atu.dip;

import java.util.Scanner;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
public class SetterMethod {

	/**
	 * setterMethod public interface to the scanner methods
	 * 
	 * @return array of two integers, as input by the user
	 */
	public int[] setterMethod() {

		int[] result = setter();
		return result;

	}

	/**
	 * Utility method to ensure the user enters a number
	 * 
	 * I was unable to write a test for this method.
	 * 
	 * @param printLine Line of text to be displayed to the user
	 * @param sc		Scanner which will accept the input
	 * @return			A valid integer
	 */
	private static int getInt(String printLine, Scanner sc) {
		int i = 0;
		System.out.println(printLine);

		while (!sc.hasNextInt()) {
			System.out.println("Please enter a number: ");
			sc.nextLine();
		}

		i = sc.nextInt();
		return i;
	}

	/**
	 * Private method providing the scanner interface
	 * 
	 * I was unsure if we were to test this scanner-reliant method
	 * 
	 * @return	an array of two integers, age and accidents
	 */
	private static int[] setter() {
		int age = 0;
		int acc = 0;
		Scanner scanner = new Scanner(System.in);
		age = getInt("Please enter your age: ", scanner);
		acc = getInt("How many accidents have you had: ", scanner);
		int[] result = { age, acc };
		scanner.close();
		return result;
	}

}
