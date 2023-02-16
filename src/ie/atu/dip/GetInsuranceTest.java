package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
class GetInsuranceTest {

	public static GetInsurance getInsurance;

	final static Logger log = Logger.getLogger(GetInsuranceTest.class.getSimpleName());

	/**
	 * Instantiates the methods under test Opens the logging system
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		getInsurance = new GetInsurance();

		log.info("Starting " + GetInsuranceTest.class.getSimpleName() + " tests...");
	}

	/**
	 * Each stage of the testing lifecycle is documented
	 */
	@BeforeEach
	public void initEach() {
		log.info("starting next test...");
	}

	@AfterEach
	public void cleanupEach() {
		log.info("finished test...");
	}

	@AfterAll
	static void cleanup() {
		log.info("Finished " + GetInsuranceTest.class.getSimpleName() + " tests...");
	}

	/**
	 * Test of the getInsurance() method. The first two elements are passed to
	 * getInsurance() the remaining elements are used to create a HashMap
	 * 
	 * @param age
	 * @param acc
	 * @param basic
	 * @param surcharge
	 * @param loading
	 */
	@ParameterizedTest
	@CsvSource({ "18, 2, 500, 100, 125", "24, 0, 500, 100, 0", "33, 5, 500, 0, 575", "44, 7, 500, 0, -1" })
	void testGetInsurance(int age, int acc, int basic, int surcharge, int loading) {
		HashMap<String, Integer> test = new HashMap<>();
		test.put("basic", basic);
		test.put("surcharge", surcharge);
		test.put("loading", loading);
		assertTrue(test.equals(getInsurance.getInsurance(age, acc)));
	}

	/**
	 * TimeOut test.
	 */
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	@RepeatedTest(100)
	public void testTimeGetInsurance() {
		int a = (int) Math.random() * 100;
		int b = (int) Math.random() * 100;
		getInsurance.getInsurance(a, b);
	}

	/**
	 * NullPointerException test
	 */
	@Test
	public void testNullException() {
		assertThrows(NullPointerException.class, () -> {
			HashMap<String, Integer> nullTest = getInsurance.getInsurance(19, 2);
			if(nullTest.get("null") == null) {
				throw new NullPointerException("There is no null key.");
			}
		});
	}
}
