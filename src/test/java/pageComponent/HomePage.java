package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;


public class HomePage extends WebUtility {

    @FindBy(xpath = "//div[text()='Signup']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[text()='one way']")
    WebElement oneWayTripRadioButton;

    @FindBy(xpath = "//div[contains(text(),'round trip')]")
    WebElement roundTripRadioButton;

    @FindBy(xpath = "(//input[contains(@class,'css-1cwyjr8 r-homxoj')])[1]")
    WebElement originDropdown;

    @FindBy(xpath = "(//input[contains(@class,'css-1cwyjr8 r-homxoj')])[2]")
    WebElement destinationDropdown;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[53]")
    WebElement departureDatePicker;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[54]")
    WebElement returnDatePicker;

    @FindBy(xpath = "(//div[text()='25'])[3]")
    WebElement departureDateValue;

    @FindBy(xpath = "(//div[text()='9'])[4]")
    WebElement returnDateValue;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[56]")
    WebElement passangersDropdown;

    @FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
    WebElement numberOfPassangersButton;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[57]")
    WebElement currencyDropdown;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[58]//div[text()='INR']")
    WebElement currencyTypeDropdown;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[63]")
    WebElement peopleDropdown;

    @FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
    WebElement searchFlightButton;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep r-7e3msg']//div[@class='css-1dbjc4n r-1d09ksm r-18u37iz']//div[1]")
    WebElement oneWayTripSuccessMessege;

    @FindBy(xpath = "//div[text() = 'check-in']")
    WebElement checkInButton;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[43]//child::input")
    WebElement ticketNumberInput;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[44]//child::input")
    WebElement emailIdInput;

    @FindBy(xpath = "//div[text() = 'Search Booking']")
    WebElement searchBookingButton;

    @FindBy(xpath = "//div[text()='flight status']")
    WebElement flightStatusButton;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[43]")
    WebElement fsDepartureDatePicker;

    @FindBy(xpath = "//div[text() ='Tomorrow']")
    WebElement fsDepartureTimeButton;

    @FindBy(xpath = "//div[text()='Search Flights']")
    WebElement SearchFlightsButton;

    @FindBy(xpath = "//div[text()='manage booking']")
    WebElement manageBookingButton;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[43]//child::input")
    WebElement MBticketNumber;

    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[44]//child::input")
    WebElement MBemailId;

    @FindBy(xpath = "//div[text() = 'Search Booking']")
    WebElement MBsearchBookingButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void goToCreateAccount() {
        elementClick(signUpButton);
        switchingTabs();
    }

    public void goToLogin() {
        waitExplicit(loginButton, 10);
        elementClick(loginButton);
    }

    public String selectOneWayTrip() throws InterruptedException {
        elementClick(oneWayTripRadioButton);
        jsClickOn(originDropdown);
        typeText(originDropdown, "Del");
        Thread.sleep(3000);
        typeText(destinationDropdown, "Mumbai");
        Thread.sleep(2000);
        elementClick(departureDateValue);
        explicitWait(searchFlightButton, 10);
        elementClick(searchFlightButton);
        String actMsg = oneWayTripSuccessMessege.getText();
        return actMsg;
    }

    public String selectRoundTrip() throws InterruptedException {
        elementClick(roundTripRadioButton);
        jsClickOn(originDropdown);
        typeText(originDropdown, "Del");
        Thread.sleep(3000);
        typeText(destinationDropdown, "Mumbai");
        elementClick(departureDateValue);
        elementClick(returnDateValue);
        elementClick(currencyDropdown);
        explicitWait(currencyTypeDropdown, 10);
        elementClick(currencyTypeDropdown);
        explicitWait(searchFlightButton, 10);
        elementClick(searchFlightButton);
        explicitWait(oneWayTripSuccessMessege , 10);
        String actMsg = oneWayTripSuccessMessege.getText();
        return actMsg;
    }

    public void HomePageFlightMenus() {
        elementClick(checkInButton);
        checkMenusIsDisplayed(ticketNumberInput);
        checkMenusIsDisplayed(emailIdInput);
        checkMenusIsDisplayed(searchBookingButton);
        elementClick(flightStatusButton);
        elementClick(fsDepartureDatePicker);
        elementClick(fsDepartureTimeButton);
        typeText(originDropdown, "Del");
        elementClick(destinationDropdown);
        typeText(destinationDropdown, "Mum");
        jsClickOn(SearchFlightsButton);
        elementClick(manageBookingButton);
        checkMenusIsDisplayed(ticketNumberInput);
        checkMenusIsDisplayed(emailIdInput);
        checkMenusIsDisplayed(searchBookingButton);
    }

}
