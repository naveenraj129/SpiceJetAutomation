package engineComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.*;
import utils.WebUtility;


public class BaseClass extends WebUtility {

    @BeforeSuite
    public void startReport() {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
        report = new ExtentReports();
        report.attachReporter(reporter);
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