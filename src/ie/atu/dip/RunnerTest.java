package ie.atu.dip;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


/**
 * @author aiden desmond <G00398273@atu.ie>
 *
 * Agile Software Development Project
 * 
 * Test Suite Runner.
 */
@Suite
@SelectClasses({
	QuoterTest.class,
	GetInsuranceTest.class
})

class RunnerTest {

}
