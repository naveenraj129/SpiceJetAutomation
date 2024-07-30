package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

import pageComponent.SignupPage;

public class TestCase_01_ValidateCreateAccountFunctionality extends BaseClass {
    @BeforeTest
    public void setup() {
        testName = "tc_03_validateCreateAccountFunctionality";
        testDescription = "CreatAccount Functionality";
        testCategory = "Regression";
    }


    @Test
    public void tc_01_validateSuccessCreateAccountFunctionality() throws InterruptedException {

        HomePage hp = new HomePage();
        hp.goToCreateAccount();
        SignupPage sp = new SignupPage();
        String actMsg = sp.createAccountSuccessFunctionality();
        String expMsg = "Member account exists with given mobile number";
        System.out.println(actMsg);
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }

    }
}
