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
    WebElement oneWayTrip;

    @FindBy(xpath = "//div[contains(text(),'round trip')]")
    WebElement roundTrip;

    @FindBy(xpath = "(//input[contains(@class,'css-1cwyjr8 r-homxoj')])[1]")
    WebElement selectOrigin;

    @FindBy(xpath = "(//input[contains(@class,'css-1cwyjr8 r-homxoj')])[2]")
    WebElement selectDestination;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[53]")
    WebElement clickDepartureDate;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[54]")
    WebElement clickReturnDate;

    @FindBy(xpath = "(//div[text()='25'])[3]")
    WebElement selectDepartureDate;

    @FindBy(xpath = "(//div[text()='9'])[4]")
    WebElement selectReturnDate;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[56]")
    WebElement selectPassangers;

    @FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
    WebElement selectNumberOfPassangers;

    @FindBy(xpath = "//div[text() = 'INR']")
    WebElement selectCurrency;

    @FindBy(xpath = "(//div[text() ='INR'])[2]")
    WebElement selectCurrencyType;

    @FindBy(xpath = "(//div[@class='css-1dbjc4n'])[63]")
    WebElement selectPeople;

    @FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
    WebElement clickSearchFlight;

    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep r-7e3msg']//div[@class='css-1dbjc4n r-1d09ksm r-18u37iz']//div[1]")
    WebElement oneWayTripSuccessMessege;



    @FindBy(xpath = "//div[text() = 'check-in']")
    WebElement checkInButton;
    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[43]//child::input")
    WebElement ticketNumber;
    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[44]//child::input")
    WebElement emailId;
    @FindBy(xpath = "//div[text() = 'Search Booking']")
    WebElement searchBookingButton;

    @FindBy(xpath = "//div[text()='flight status']")
    WebElement flightStatusButton;
    @FindBy(xpath = "(//div[@class = 'css-1dbjc4n'])[43]")
    WebElement FSdepartureDate;
    @FindBy(xpath = "//div[text() ='Tomorrow']")
    WebElement FSdepartureTimeButton;
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
        elementClick(loginButton);
    }

    public String selectOneWayTrip() throws InterruptedException {

        elementClick(oneWayTrip);
        jsClickOn(selectOrigin);
        typeText(selectOrigin, "Del");
        Thread.sleep(2000);
        typeText(selectDestination, "Bom");
        elementClick(selectDepartureDate);
        elementClick(selectPassangers);
        elementClick(selectCurrency);
        elementClick(selectCurrencyType);
        elementClick(clickSearchFlight);

        Thread.sleep(4000);
        String actMsg = oneWayTripSuccessMessege.getText();
        return actMsg;
    }

    public String selectRoundTrip() throws InterruptedException {
        elementClick(roundTrip);
        jsClickOn(selectOrigin);
        typeText(selectOrigin, "Del");
        Thread.sleep(2000);
        typeText(selectDestination, "Bom");
        elementClick(selectDepartureDate);
        elementClick(selectReturnDate);
        elementClick(selectPassangers);
        elementClick(selectCurrency);
        elementClick(selectCurrencyType);
        elementClick(clickSearchFlight);
        Thread.sleep(4000);
        String actMsg = oneWayTripSuccessMessege.getText();
        return actMsg;
    }

    public void HomePageFlightMenus(){
        elementClick(checkInButton);
        checkMenusIsDisplayed(ticketNumber);
        checkMenusIsDisplayed(emailId);
        checkMenusIsDisplayed(searchBookingButton);
        elementClick(flightStatusButton);
        elementClick(FSdepartureDate);
        elementClick(FSdepartureTimeButton);
        typeText(selectOrigin , "Del");
        elementClick(selectDestination);
        typeText(selectDestination , "Mum");
        jsClickOn(SearchFlightsButton);
        elementClick(manageBookingButton);
        checkMenusIsDisplayed(ticketNumber);
        checkMenusIsDisplayed(emailId);
        checkMenusIsDisplayed(searchBookingButton);
    }

}
