package ie.atu.dip;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
public class Quoter implements Quote {

	/**
	 * Simple method which always returns 500
	 */
	@Override
	public int basicInsurance() {
		return 500;
	}

	/**
	 * If age is below 25, returns a value of 100, otherwise 0
	 */
	@Override
	public int surcharge(int age) {
		if (age < 25) {
			return 100;
		} else {
			return 0;
		}
	}

	/**
	 * If user has more than 5 accidents, returns a -1 value
	 * otherwise returns loading according to number of accidents
	 */
	@Override
	public int loading(int acc) {
		if (acc >= 6) {
			return -1;
		}
		int[] rates = new int[] { 0, 50, 125, 225, 375, 575 };

		int rate = rates[acc];
		return rate;
	}
}
