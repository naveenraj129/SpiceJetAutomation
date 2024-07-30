package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

public class BookingPage extends WebUtility {

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[33]")
    WebElement flightSelection;

    @FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
    WebElement FScontinueButton;

    @FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
    WebElement firstName;

    @FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
    WebElement lastName;

    @FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
    WebElement contactNumber;

    @FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
    WebElement cityName;

    @FindBy(xpath = "//input[@data-testid='traveller-0-first-traveller-info-input-box']")
    WebElement travellerFirstName;

    @FindBy(xpath = "//input[@data-testid='traveller-0-last-traveller-info-input-box']")
    WebElement travellerLastName;

    @FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
    WebElement travellerMobileNumber;

    @FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
    WebElement continueButton;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr'])[3]")
    WebElement alert;

    @FindBy(xpath = "//div[@class = 'at_addon_close']")
    WebElement alert1;

    @FindBy(xpath = "(//div[@data-testid = 'add-ons-continue-footer-button'])[3]")
    WebElement continueButton2;
    @FindBy(xpath = "(//span[@id = 'skipfrompopup'])[1]")
    WebElement skipAlert;


    public BookingPage() {
        PageFactory.initElements(driver, this);
    }


    public String BookingPageFunctionality(String fName, String lName, String phone, String emailid, String cityname,
                                              String textXpath) throws InterruptedException {

        jsScrollUntillElement(flightSelection);
        jsClickOn(flightSelection);
        Thread.sleep(2000);
        elementClick(FScontinueButton);
        typeText(firstName, fName);
        typeText(lastName, lName);
        typeText(contactNumber , phone);
        typeText(emailAddress, emailid);
        typeText(cityName, cityname);

        String actMsg = driver.findElement(By.xpath("" + textXpath + "")).getText();
        return actMsg;
    }

    public void BookingPageSuccessFunctionality() throws InterruptedException {
        jsScrollUntillElement(flightSelection);
        jsClickOn(flightSelection);
        Thread.sleep(2000);
        elementClick(FScontinueButton);
        elementClick(firstName);
        typeText(firstName, "NAVEEN");
        elementClick(lastName);
        typeText(lastName, "Raj");
        elementClick(contactNumber);
        typeText(contactNumber, "8778335842");
        elementClick(emailAddress);
        typeText(emailAddress, "noreply@gmail.com");
        elementClick(cityName);
        typeText(cityName, "Coimbatore");
        elementClick(travellerFirstName);
        typeText(travellerFirstName, "Naveen");
        elementClick(travellerLastName);
        typeText(travellerLastName, "Raj");
        elementClick(travellerMobileNumber);
        typeText(travellerMobileNumber, "8778335842");
        elementClick(continueButton);
        Thread.sleep(4000);
        elementClick(continueButton2);
        elementClick(skipAlert);
        Thread.sleep(4000);

    }


}
