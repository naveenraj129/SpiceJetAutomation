package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_04_ValidateSearchFlightRoundtripFunctionality extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "SearchFlightFunctionality";
        testDescription = "SearchFlightFunctionality";
        testCategory = "Regression";

    }

    @Test()
    public void testCase_03_ValidateSearchFlightRoundTripFunctionality() throws Exception {
        HomePage hp = new HomePage();
        String actMsg = hp.selectRoundTrip();
        String expMsg = "Select your Departure to Mumbai";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
}
