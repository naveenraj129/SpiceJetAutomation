package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_03_ValidateSearchFlightOnewayTripFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_03_validateSearchFlightOneWayTripFunctionality";
        testDescription = "SearchFlightOnewayFunctionality";
        testCategory = "Regression";

    }

    @Test(priority = 3)
    public void tc_03_validateSearchFlightOneWayTripFunctionality() throws InterruptedException {
        HomePage hp = new HomePage();
        String actMsg = hp.selectOneWayTrip();

        String expMsg = "Select your Departure to Mumbai";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
}
