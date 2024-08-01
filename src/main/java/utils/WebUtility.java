package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;


public class WebUtility extends GeneralUtility {

    public static WebDriver driver;


    public static String readProperty(String key) throws Exception {
        String projectPath = System.getProperty("user.dir");
        File file = new File(projectPath + "/SpiceJetApplication.properties");
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop.get(key).toString();
    }

    public static void openBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Opening Chrome browser as Default browser");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        waitImplicit();
    }

    public static void openWebsite(String url) {
        driver.get(url);
    }


    public static void typeText(WebElement element, String value) {
        element.sendKeys(value);
    }


    public static void elementClick(WebElement element) {
        element.click();
    }

    public static String getTitleOfMenus() {
        waitExplicitUntillTitle(driver.getTitle());
        return driver.getTitle();
    }

    public static String getUrlOfCurrentPage() {
        waitExplicitUntillTitle(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public static boolean checkMenusIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static boolean checkButtonIsClickable(WebElement element) {
        return element.isSelected();
    }

    public static void waitImplicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public static void waitExplicitUntillTitle(String titleToWait) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs(titleToWait));
    }

    public static void jsScrollUntillElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void jsClickOn(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void explicitWait(WebElement ele, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static void waitExplicit(WebElement ele, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public static void selectDropDown(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public static void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }


    public static void switchBackFromFrame() {
        driver.switchTo().defaultContent();
    }


    public static String extractText(WebElement element) {
        return element.getText();
    }


    public static void closeBrowser() {
        driver.quit();
    }

}