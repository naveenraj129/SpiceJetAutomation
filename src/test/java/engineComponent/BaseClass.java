package engineComponent;

import org.testng.annotations.*;

import utils.WebUtility;


public class BaseClass extends WebUtility {


    @BeforeSuite
    public void startReport() {
        reportInit();
    }

    @BeforeClass
    public void testDetails() {
        test = report.createTest(testName, testDescription);
        test.assignCategory(testCategory);
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        openBrowser(readProperty("browser"));
        openWebsite(readProperty("url"));
    }

    @AfterMethod
    public void afterMethod() {
        closeBrowser();
    }

    @DataProvider
    public Object[][] getFromExcel() throws Exception {
        Object[][] data = dataReader(sheetName);
        return data;
    }

    @AfterSuite
    public void endReport() {

        report.flush();
    }
}