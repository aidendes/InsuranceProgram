package ie.atu.dip;

import java.util.HashMap;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
public class GetInsurance {

	
	/**
	 * getInsurance obtains a quote for the driver based on parameters
	 * it is a public interface to getQuote()
	 * 
	 * @param age Age of the Driver integer
	 * @param accidents Number of Accidents Driver has had integer
	 * @return	Hashmap<String, Integer> with the various elements of the quote
	 */
	public HashMap<String, Integer> getInsurance(int age, int accidents) {
		HashMap<String, Integer> quote = getQuote(age, accidents);
		
		return quote;
	}

	/**
	 * getQuote obtains a quote based on parameters passed
	 * it is a private method called from the public interface
	 * 
	 * @param age	Age of the Driver integer
	 * @param accidents	Number of Accidents Driver has had integer
	 * @return	Hashmap of the Insurance Quote
	 */
	private static HashMap<String, Integer> getQuote(int age, int accidents) {
		Quote q = new Quoter();
		HashMap<String, Integer> quote = new HashMap<>();
		quote.put("basic", q.basicInsurance());
		quote.put("surcharge", q.surcharge(age));
		quote.put("loading", q.loading(accidents));
		
		return quote;
	}

}
