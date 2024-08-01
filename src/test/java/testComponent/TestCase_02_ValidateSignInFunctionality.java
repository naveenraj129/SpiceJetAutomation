package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LoginPage;

public class TestCase_02_ValidateSignInFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_02_validateSignInFunctionality";
        testDescription = "Sign-In Test";
        testCategory = "Regression";
    }

    @Test(priority = 2)
    public void tc_02_validateSignInFunctionality() throws Exception {
        HomePage hp = new HomePage();
        hp.goToLogin();
        LoginPage ln = new LoginPage();
        String actMsg = ln.validateSignInPage();
        String expMsg = "Hi Naveen";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            reportStep("Validating SignIn Functionality - Pass", "Pass", testName);
        } else {
            reportStep("Validating SignIn Functionality - Fail", "Fail", testName);
        }
    }

}
