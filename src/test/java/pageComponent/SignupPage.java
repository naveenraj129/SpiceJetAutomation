package pageComponent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtility;


public class SignupPage extends WebUtility {

    @FindBy(xpath = "//select[@class = 'form-control form-select ']")
    WebElement selectTitle;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstName;

    @FindBy(xpath = "//option[text() = 'Mr']")
    WebElement dropDown;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='dobDate']")
    WebElement datePicker;
    @FindBy(xpath = "//div[text() = '12']")
    WebElement dateOfBirth;

    @FindBy(xpath = "//input[@class = ' form-control']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='email_id']")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='new-password']")
    WebElement newPassword;

    @FindBy(xpath = "//input[@id='c-password']")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@id='defaultCheck1']")
    WebElement termsAndConditionCheckBox;

    @FindBy(xpath = "//button[text() ='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[text()='Member account exists with given mobile number']")
    WebElement errorMessege;

    public SignupPage() {

        PageFactory.initElements(driver, this);
    }

    public String createAccountSuccessFunctionality() throws InterruptedException {
        explicitWait(selectTitle, 15);
        elementClick(selectTitle);
        elementClick(dropDown);
        typeText(firstName, "Naveen");
        typeText(lastName, "Raj");
        elementClick(datePicker);
        elementClick(dateOfBirth);
        jsClickOn(phoneNumber);
        typeText(phoneNumber, "8778335842");
        Thread.sleep(2000);
        explicitWait(emailId, 15);
        elementClick(emailId);
        typeText(emailId, "naveen1@gmail.com");
        typeText(newPassword, "EVANaura@129");
        typeText(confirmPassword, "EVANaura@129");
        jsScrollUntillElement(termsAndConditionCheckBox);
        jsClickOn(termsAndConditionCheckBox);
        Thread.sleep(2000);
        jsClickOn(submitButton);
        Thread.sleep(2000);
        String actMsg = errorMessege.getText();
        return actMsg;
    }


}
