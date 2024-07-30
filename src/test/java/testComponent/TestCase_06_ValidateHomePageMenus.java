package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;
import pageComponent.PaymentPage;

public class TestCase_06_ValidateHomePageMenus extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "PaymentPageFunctionality";
        testDescription = "PaymentPageFunctionality";
        testCategory = "Regression";

    }

    @Test()
    public void testCase_05_validateBookingPageDetails() throws Exception {

        try {
            HomePage hp = new HomePage();
            hp.HomePageFlightMenus();
            test.log(Status.PASS, testName + " - Passed");
            System.out.println("Passed");
        } catch (Exception e) {
            test.log(Status.FAIL, testName + " - Failed");
            System.out.println("Failed");
        }
    }
}
