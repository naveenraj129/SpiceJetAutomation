package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_03_ValidateSearchFlightOnewayTripFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_03_validateSearchFlightOneWayTripFunctionality";
        testDescription = "Search flight Oneway trip Test";
        testCategory = "Regression";
    }

    @Test(priority = 3)
    public void tc_03_validateSearchFlightOneWayTripFunctionality() throws Exception {
        HomePage hp = new HomePage();
        String actMsg = hp.selectOneWayTrip();

        String expMsg = "Select your Departure to Mumbai";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            reportStep("Validating Oneway Trip Functionality - Pass", "Pass", testName);
        } else {
            reportStep("Validating Oneway Trip Functionality - Fail", "Fail", testName);
        }
    }
}
