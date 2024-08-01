package testComponent;

import engineComponent.BaseClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageComponent.HomePage;

public class TestCase_08_ValidateHomePageMenus extends BaseClass {

    @BeforeTest
    public void setup() {
        testName = "tc_08_validateHomePageMenus";
        testDescription = "Home Page Menu Test";
        testCategory = "Regression";
    }

    @Test(priority = 8)
    public void tc_08_validateHomePageMenus() throws Exception {
        try {
            HomePage hp = new HomePage();
            hp.HomePageFlightMenus();
            reportStep("Validating HometPage Menus Functionality - Pass", "Pass", testName);
        } catch (Exception e) {
            reportStep("Validating  HometPage Menus Functionality - Fail", "Fail", testName);
        }
    }
}
