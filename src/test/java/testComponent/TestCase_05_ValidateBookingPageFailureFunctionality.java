package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;

public class TestCase_05_ValidateBookingPageFailureFunctionality extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_05_validateBookingPageFailureFunctionality";
        testDescription = "BookingPageFunctionality";
        testCategory = "Regression";
        sheetName = "SpicejetBookingPageData";
    }


    @Test(dataProvider = "getFromExcel", priority = 5)
    public void tc_05_validateBookingPageFailureFunctionality(String fName, String lName, String phone, String emailid, String cityname,
                                                         String textXpath, String expMsg) throws InterruptedException {
        HomePage hp = new HomePage();
        hp.selectOneWayTrip();
        BookingPage bp = new BookingPage();
        String actMsg = bp.bookingPageFunctionality(fName, lName, phone,emailid,cityname, textXpath);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

}
