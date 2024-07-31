package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;


public class LoginPage extends WebUtility {
    @FindBy(xpath = "//input[@data-testid='user-mobileno-input-box']")
    WebElement phoneNumber;
    @FindBy(xpath = "//input[@data-testid='password-input-box-cta']")
    WebElement passwordBox;
    @FindBy(xpath = "//div[@data-testid='login-cta']")
    WebElement signInButton;
    @FindBy(xpath = "//div[text()='Hi Naveen']")
    WebElement successMessage;


    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    public String validateSignInPage() {
        explicitWait(phoneNumber, 15);
        typeText(phoneNumber, "8778335842");
        typeText(passwordBox, "EVANaura@129");
        waitExplicit(signInButton, 10);
        elementClick(signInButton);
        String actMsg = successMessage.getText();
        return actMsg;
//
    }
}
