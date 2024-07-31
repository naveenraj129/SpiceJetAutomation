package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;
import pageComponent.PaymentPage;

public class TestCase_08_ValidateHomePageMenus extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_08_validateHomePageMenus";
        testDescription = "PaymentPageFunctionality";
        testCategory = "Regression";
    }

    @Test()
    public void tc_08_validateHomePageMenus() throws Exception {

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
