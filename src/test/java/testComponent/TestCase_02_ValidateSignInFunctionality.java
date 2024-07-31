package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LoginPage;

public class TestCase_02_ValidateSignInFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_02_validateSignInFunctionality";
        testDescription = "Sign-In Functionality";
        testCategory = "Regression";
    }

    @Test(priority = 2)
    public void tc_02_validateSignInFunctionality() throws InterruptedException {
        HomePage hp = new HomePage();
        hp.goToLogin();
        LoginPage ln = new LoginPage();
        String actMsg = ln.validateSignInPage();
        String expMsg = "Hi Naveen";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

}
