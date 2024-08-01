package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.WebUtility.driver;

public class GeneralUtility {
    public static ExtentReports report;
    public static ExtentTest test;
    public static String sheetName;
    public String testName;
    public String testDescription;
    public String testCategory;


    public static void switchingTabs() {
        Set<String> WindowHandles = driver.getWindowHandles();
        List<String> listwindow = new ArrayList(WindowHandles);
        driver.switchTo().window((String) listwindow.get(1));
    }

    public static void softAssert(String actResult, String expResult) {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actResult, expResult);
    }

    public static Object[][] dataReader(String sheetName) throws IOException {
        String excelPath = "/Users/evanjalinmuthuraj/Desktop/SpiceJet Automation/src/test/resource/SpicejetData.xlsx";
        FileInputStream excelFile = new FileInputStream(excelPath);
        XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workBook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        excelFile.close();
        return data;
    }

    public static int screenShot(String testName) throws Exception {
        int ranNum = (int) (Math.random() * 9999999 + 1000000);
        Thread.sleep(3000);
        String projectPath = System.getProperty("user.dir");
        FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
                new File(projectPath + "/Screenshot/" + testName + ranNum + ".png"));
        return ranNum;
    }

    public void reportStep(String stepDetails, String stepStatus, String testName) throws Exception {
        int ranNum = screenShot(testName);
        String projectPath = System.getProperty("user.dir");
        if (stepStatus.equalsIgnoreCase("pass")) {
            test.pass(stepDetails,
                    MediaEntityBuilder.createScreenCaptureFromPath(projectPath + "/Screenshot/" + testName + ranNum + ".png").build());
        } else if (stepStatus.equalsIgnoreCase("fail")) {
            test.fail(stepDetails,
                    MediaEntityBuilder.createScreenCaptureFromPath(projectPath + "/Screenshot/" + testName + ranNum + ".png").build());
            throw new RuntimeException("See extent report for more details");
        }
    }


}
