package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;
import pageComponent.PaymentPage;


    public class TestCase_05_ValidatePaymentpageDetails extends BaseClass {

        @BeforeTest
        public void setup() {
            testName = "PaymentPageFunctionality";
            testDescription = "PaymentPageFunctionality";
            testCategory = "Regression";

        }

        @Test()
        public void testCase_05_validateBookingPageDetails() throws Exception {
            HomePage hp = new HomePage();
            hp.selectOneWayTrip();
            BookingPage bp = new BookingPage();
            bp.BookingPageSuccessFunctionality();
            PaymentPage pp = new PaymentPage();
            pp.paymentDetailsPage();
        }

    }



