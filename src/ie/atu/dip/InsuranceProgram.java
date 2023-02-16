package ie.atu.dip;

import java.util.HashMap;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
public class InsuranceProgram {

	/**
	 * Main Method
	 * 
	 * Not possible to write a test against this.
	 * 
	 * Calls the setterMethod, which uses the scanner.
	 * Then obtains the quote - which is heavily tested
	 * Then prints the quote to screen.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GetInsurance gi = new GetInsurance();
		int[] person = setterMethod();
		
		HashMap<String, Integer> quote = gi.getInsurance(person[0], person[1]);

		printQuote(quote);
		
	}

	/**
	 * Simple Quote printer to sysout.
	 * Obtains each of the elements of the quote by key name.
	 * 
	 * @param quote
	 */
	private static void printQuote(HashMap<String, Integer> quote) {
		if (quote.get("loading") < 0) {
			endThis();
		}
		System.out.println("\tQuote Generated\n");
		System.out.println("Basic Insurance:\t" + quote.get("basic"));
		System.out.println("Age Surcharge:\t\t" + quote.get("surcharge"));
		System.out.println("Accident Loading:\t" + quote.get("loading"));
		System.out.println("Total Cost:\t\t" + (quote.get("basic") + quote.get("surcharge") + quote.get("loading")));
		
	}

	/**
	 * Calls the setterMethod, which is a scanner interface
	 * 
	 * @return
	 */
	private static int[] setterMethod() {
		SetterMethod sm = new SetterMethod();
		return sm.setterMethod();
	}

	/**
	 * If the user has too many accidents, kills the program before outputting the quote
	 */
	private static void endThis() {
		System.out.println("Too many accidents.");
		System.out.println("Unable to quote for this driver. Goodbye");
		System.exit(0);
	}

}
