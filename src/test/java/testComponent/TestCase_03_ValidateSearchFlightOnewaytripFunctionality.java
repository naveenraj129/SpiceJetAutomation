package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_03_ValidateSearchFlightOnewaytripFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "SearchFlightFunctionality";
        testDescription = "SearchFlightFunctionality";
        testCategory = "Regression";

    }

    @Test(priority=3)
    public void testCase_03_ValidateSearchFlightOneWayFunctionality() throws Exception {
        HomePage hp=new HomePage();
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
