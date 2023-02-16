package ie.atu.dip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.logging.Logger;

/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 */
class QuoterTest {
	
	public static Quoter quoter;
	
	final static Logger log = Logger.getLogger(QuoterTest.class.getSimpleName());

	/**
	 * Initialises the interface to the class under test and prepares the log system
	 * 
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		quoter = new Quoter();
		
		log.info("Starting " + QuoterTest.class.getSimpleName() + " tests...");
	}
	
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
		log.info("Finished " + QuoterTest.class.getSimpleName() + " tests...");
	}
	
	/**
	 * Simple test. basicInsurance takes no arguments, always returns 500
	 */
	@Test
	public void testBasicInsurance() {
		int intBasicInsurance = quoter.basicInsurance();
		assertEquals(500, intBasicInsurance);
	}
	
	/**
	 * Tests the return from surcharge. Should always be 0 above 25, 100 below
	 * Use of @ParameterizedTest
	 * 
	 * @param age
	 * @param res
	 */
	@ParameterizedTest
	@CsvSource({"17, 100", "21, 100", "24, 100", "25, 0", "33, 0"})
	public void testSurcharge(int age, int res) {
		assertEquals(quoter.surcharge(age), res);
	}
	
	
	/**
	 * Use of @Test annotation: an age of 0 does not return a value of 0
	 */
	@Test
	public void testNullSurcharge() {
		assertNotEquals(quoter.surcharge(0), 0);
	}
	
	/**
	 * A @ParameterizedTest to check that different values are returned for accidents
	 * 
	 * @param acc
	 * @param res
	 */
	@ParameterizedTest
	@CsvSource({"0, 0", "1, 50", "2, 125", "3, 225", "4, 375", "5, 575", "6, -1", "10, -1"})
	public void testLoading(int acc, int res) {
		assertEquals(quoter.loading(acc), res);
	}
}
