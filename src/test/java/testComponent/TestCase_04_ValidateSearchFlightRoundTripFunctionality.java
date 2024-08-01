package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_04_ValidateSearchFlightRoundTripFunctionality extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_04_validateSearchFlightRoundTripFunctionality";
        testDescription = "Search flight round trip Test";
        testCategory = "Regression";
    }

    @Test(priority = 4)
    public void tc_04_validateSearchFlightRoundTripFunctionality() throws Exception {
        HomePage hp = new HomePage();
        String actMsg = hp.selectRoundTrip();
        String expMsg = "Select your Departure to Mumbai";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            reportStep("Validating Round Trip Functionality - Pass", "Pass", testName);
        } else {
            reportStep("Validating Round Trip Functionality - Fail", "Fail", testName);
        }
    }
}
