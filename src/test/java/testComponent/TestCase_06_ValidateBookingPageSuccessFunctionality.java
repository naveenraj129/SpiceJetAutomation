package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;

public class TestCase_06_ValidateBookingPageSuccessFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_06_validateBookingPageSuccessFunctionality";
        testDescription = "Booking page successfully validated";
        testCategory = "Regression";

    }

    @Test(priority = 6)
    public void tc_06_validateBookingPageSuccessFunctionality() throws Exception {
        HomePage hp = new HomePage();
        hp.selectOneWayTrip();
        BookingPage bp = new BookingPage();
        String actMsg = bp.bookingPageSuccessFunctionality();
        String expMsg = "Payment Methods";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            reportStep("Validating BookingPage Success Functionality - Pass", "Pass", testName);
        } else {
            reportStep("Validating BookingPage Success Functionality - Fail", "Fail", testName);
        }
    }
}

