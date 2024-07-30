package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WebUtility extends GeneralUtility {

    public static WebDriver driver;

    public static void openBrowser() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        waitImplicit();

    }


    public static void openWebsite() {

        driver.get("https://www.spicejet.com/");
    }


    public static void typeText(WebElement element, String value) {

        element.sendKeys(value);

    }


    public static void chooseFromDropDown(WebElement element, String value) {
        Select ele = new Select(element);
        ele.selectByValue(value);
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

    public static void waitImplicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
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

    public static void selectDRopDown(WebElement element) {
        Select dropdown = new Select(element);
        dropdown.selectByValue("India");
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