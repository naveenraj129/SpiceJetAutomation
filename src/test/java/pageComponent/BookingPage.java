package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;

public class BookingPage extends WebUtility {

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[33]")
    WebElement flightSelectionRadioButton;

    @FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
    WebElement fsContinueButton;

    @FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
    WebElement contactNumberInput;

    @FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
    WebElement emailAddressInput;

    @FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
    WebElement cityNameInput;

    @FindBy(xpath = "//input[@data-testid='traveller-0-first-traveller-info-input-box']")
    WebElement travellerFirstNameInput;

    @FindBy(xpath = "//input[@data-testid='traveller-0-last-traveller-info-input-box']")
    WebElement travellerLastNameInput;

    @FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
    WebElement travellerMobileNumberInput;

    @FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
    WebElement continueButton;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n r-1loqt21 r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr'])[3]")
    WebElement alert;

    @FindBy(xpath = "//div[@class = 'at_addon_close']")
    WebElement alert1;

    @FindBy(xpath = "(//div[@data-testid = 'add-ons-continue-footer-button'])[3]")
    WebElement continueButton2;

    @FindBy(xpath = "(//span[@id = 'skipfrompopup'])[1]")
    WebElement skipAlertButton;

    @FindBy(xpath = "//div[text() ='Payment Methods']")
    WebElement bookingPageSuccessValidate;


    public BookingPage() {
        PageFactory.initElements(driver, this);
    }


    public String bookingPageFunctionality(String fName, String lName, String phone, String emailid, String cityname,
                                           String textXpath) throws InterruptedException {

        jsScrollUntillElement(flightSelectionRadioButton);
        jsClickOn(flightSelectionRadioButton);
        explicitWait(fsContinueButton, 15);
        elementClick(fsContinueButton);
        Thread.sleep(4000);
        typeText(firstNameInput, fName);
        typeText(lastNameInput, lName);
        typeText(contactNumberInput, phone);
        typeText(emailAddressInput, emailid);
        typeText(cityNameInput, cityname);

        String actMsg = driver.findElement(By.xpath("" + textXpath + "")).getText();
        return actMsg;
    }

    public String bookingPageSuccessFunctionality() throws InterruptedException {
        jsScrollUntillElement(flightSelectionRadioButton);
        jsClickOn(flightSelectionRadioButton);
        waitExplicit(fsContinueButton, 20);
        elementClick(fsContinueButton);
        Thread.sleep(5000);
        elementClick(firstNameInput);
        typeText(firstNameInput, "NAVEEN");
        elementClick(lastNameInput);
        typeText(lastNameInput, "Raj");
        elementClick(contactNumberInput);
        typeText(contactNumberInput, "8778335842");
        elementClick(emailAddressInput);
        typeText(emailAddressInput, "noreply@gmail.com");
        elementClick(cityNameInput);
        typeText(cityNameInput, "Coimbatore");
        elementClick(travellerFirstNameInput);
        typeText(travellerFirstNameInput, "Naveen");
        elementClick(travellerLastNameInput);
        typeText(travellerLastNameInput, "Raj");
        elementClick(travellerMobileNumberInput);
        typeText(travellerMobileNumberInput, "8778335842");
        elementClick(continueButton);
        Thread.sleep(5000);
        jsClickOn(continueButton2);
        waitExplicit(skipAlertButton, 20);
        jsClickOn(skipAlertButton);
        explicitWait(bookingPageSuccessValidate, 25);
        String actMsg = bookingPageSuccessValidate.getText();
        return actMsg;
    }

}
