package pageComponent;

import engineComponent.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BaseClass {


    @FindBy(tagName = "iframe")
    WebElement iFrameCardNumber;

    @FindBy(xpath = "//div[@class= 'name_on_card']//child::iframe")
    WebElement iFrameCardName;

    @FindBy(xpath = "//div[@class= 'card_exp_month_div']//child::iframe")
    WebElement iFrameExpMonth;

    @FindBy(xpath = "//div[@class= 'card_exp_year_div']//child::iframe")
    WebElement iFrameExpYear;

    @FindBy(xpath = "//div[@class= 'security_code_div']//child::iframe")
    WebElement iFrameCVV;


    @FindBy(xpath = "//input[@id='card_number']")
    WebElement cardNumber;

    @FindBy(xpath = "//input[@id='name_on_card']")
    WebElement nameOnCard;

    @FindBy(xpath = "//input[@id='card_exp_month']")
    WebElement expMonthNumber;

    @FindBy(xpath = "//input[@id='card_exp_year']")
    WebElement expYearNumber;

    @FindBy(xpath = "//input[@id='security_code']")
    WebElement securityCode;

    @FindBy(xpath = "//div[@data-testid='common-proceed-to-pay']")
    WebElement proceedToPayButton;


    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }


    public void paymentDetailsPage() throws InterruptedException {
        switchToFrame(iFrameCardNumber);
        typeText(cardNumber, "5425233430109903");
        switchBackFromFrame();
        Thread.sleep(2000);
        switchToFrame(iFrameCardName);
        typeText(nameOnCard, "Naveen");
        switchBackFromFrame();
        Thread.sleep(2000);
        switchToFrame(iFrameExpMonth);
        typeText(expMonthNumber, "09");
        switchBackFromFrame();
        Thread.sleep(2000);
        switchToFrame(iFrameExpYear);
        typeText(expYearNumber, "28");
        switchBackFromFrame();
        Thread.sleep(2000);
        switchToFrame(iFrameCVV);
        typeText(securityCode, "167");
        switchBackFromFrame();
        Thread.sleep(2000);
        elementClick(proceedToPayButton);

    }

}