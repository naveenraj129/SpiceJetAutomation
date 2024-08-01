package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;

public class TestCase_05_ValidateBookingPageFailureFunctionality extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_05_validateBookingPageFailureFunctionality";
        testDescription = " Booking Page Failure Functionality";
        testCategory = "Regression";
        sheetName = "SpicejetBookingPageData";
    }

    @Test(dataProvider = "getFromExcel", priority = 5)
    public void tc_05_validateBookingPageFailureFunctionality(String fName, String lName, String phone, String emailid, String cityname,
                                                              String textXpath, String expMsg) throws Exception {
        HomePage hp = new HomePage();
        hp.selectOneWayTrip();
        BookingPage bp = new BookingPage();
        String actMsg = bp.bookingPageFunctionality(fName, lName, phone, emailid, cityname, textXpath);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            reportStep("Validating BookingPage Failure Functionality - Pass", "Pass", testName);
        } else {
            reportStep("Validating BookingPage Failure Functionality - Fail", "Fail", testName);
        }
    }

}
