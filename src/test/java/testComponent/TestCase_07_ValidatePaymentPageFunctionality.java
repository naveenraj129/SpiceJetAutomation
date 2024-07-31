package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.BookingPage;
import pageComponent.HomePage;
import pageComponent.PaymentPage;


    public class TestCase_07_ValidatePaymentPageFunctionality extends BaseClass {

        @BeforeTest
        public void setup() {
            testName = "tc_07_validatePaymentPageFunctionality";
            testDescription = "PaymentPageFunctionality";
            testCategory = "Regression";

        }

        @Test()
        public void tc_07_validatePaymentPageFunctionality() throws Exception {
            HomePage hp = new HomePage();
            hp.selectOneWayTrip();
            BookingPage bp = new BookingPage();
            bp.bookingPageSuccessFunctionality();
            PaymentPage pp = new PaymentPage();
            String actMsg =   pp.paymentDetailsPage();
            String expMsg = "Payment Failure";
            softAssert(actMsg, expMsg);
            if (actMsg.equals(expMsg)) {
                test.log(Status.PASS, testName + " - Passed");
            } else {
                test.log(Status.FAIL, testName + " - Failed");
            }
        }
        }





