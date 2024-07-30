package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;

public class TestCase_05_ValidateBookingPageDetails extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "BookingPageFunctionality";
        testDescription = "BookingPageFunctionality";
        testCategory = "Regression";
        sheetName = "SpicejetBookingPageData";
    }


    @Test(dataProvider = "getFromExcel", priority = 3)
    public void tc_03_validateBookingPageFuntionality(String fName, String lName, String phone, String emailid, String cityname,
                                                         String textXpath, String expMsg) throws InterruptedException {
        HomePage hp = new HomePage();
        hp.selectOneWayTrip();
        BookingPage bp = new BookingPage();
        String actMsg = bp.BookingPageFunctionality(fName, lName, phone,emailid,cityname, textXpath);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

    @Test()
    public void testCase_05_ValidateBookingPageDetails() throws Exception {
        HomePage hp = new HomePage();
        hp.selectOneWayTrip();
        BookingPage bp = new BookingPage();
        bp.BookingPageSuccessFunctionality();
////        String expMsg = "Hi Naveen";
////        softAssert(actMsg, expMsg);
////        if (actMsg.equals(expMsg)) {
////            test.log(Status.PASS, testName + " - Passed");
////        } else {
////            test.log(Status.FAIL, testName + " - Failed");
////        }
//    }
    }
}
