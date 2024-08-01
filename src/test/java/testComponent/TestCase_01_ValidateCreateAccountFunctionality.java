package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.SignupPage;

public class TestCase_01_ValidateCreateAccountFunctionality extends BaseClass {
    @BeforeTest
    public void setup() {
        testName = "tc_01_validateCreateAccountFunctionality";
        testDescription = "CreatAccount Test";
        testCategory = "Regression";
    }


    @Test
    public void tc_01_validateSuccessCreateAccountFunctionality() throws Exception {
        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        SignupPage sp = new SignupPage();
        String actMsg = sp.createAccountSuccessFunctionality();
        String expMsg = "Member account exists with given mobile number";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
        } else {
            reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
        }
    }
}
