package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_04_ValidateSearchFlightRoundTripFunctionality extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_04_validateSearchFlightRoundTripFunctionality";
        testDescription = "SearchFlightRoundTripFunctionality";
        testCategory = "Regression";

    }

    @Test(priority = 4)
    public void tc_04_validateSearchFlightRoundTripFunctionality() throws InterruptedException {
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
