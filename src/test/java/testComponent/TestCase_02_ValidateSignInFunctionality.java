package testComponent;

import com.aventstack.extentreports.Status;
import engineComponent.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;
import pageComponent.LoginPage;

import static utils.WebUtility.*;
import static utils.WebUtility.driver;

public class TestCase_02_ValidateSignInFunctionality extends BaseClass {


    @BeforeTest
    public void setup() {
        testName = "tc_04_SignInFunctionality";
        testDescription = "Sign-In Functionality";
        testCategory = "Regression";

    }

    @Test(priority=2)
    public void testCase_02_validateSignInFunctionality() throws Exception {
        HomePage hp=new HomePage();
        hp.goToLogin();
        LoginPage ln =new LoginPage();
        String actMsg = ln.validateSignInPage();
        System.out.println(actMsg);
        String expMsg = "Hi Naveen";
        softAssert(actMsg, expMsg);
        if (actMsg.equals(expMsg)) {
            test.log(Status.PASS, testName + " - Passed");
        } else {
            test.log(Status.FAIL, testName + " - Failed");
        }
    }

}
