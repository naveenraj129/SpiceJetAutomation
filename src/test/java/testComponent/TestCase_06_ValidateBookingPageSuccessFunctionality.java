package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;

public class TestCase_06_ValidateBookingPageSuccessFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_06_validateBookingPageSuccessFunctionality";
        testDescription = "BookingPageFunctionality";
        testCategory = "Regression";

    }

    @Test()
    public void tc_06_validateBookingPageSuccessFunctionality() throws Exception {
        HomePage hp = new HomePage();
        hp.selectOneWayTrip();
        BookingPage bp = new BookingPage();
        String actMsg = bp.bookingPageSuccessFunctionality();
        String expMsg = "Payment Methods";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }
    }

