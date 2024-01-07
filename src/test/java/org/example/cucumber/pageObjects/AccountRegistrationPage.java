package org.example.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(name = "FirstName")
    WebElement txtFirstname;

    @FindBy(name = "LastName")
    WebElement txtLastname;

    @FindBy(name = "Email")
    WebElement txtEmail;

    @FindBy(name = "Password")
    WebElement txtPassword;

    @FindBy(name = "ConfirmPassword")
    WebElement txtConfirmPassword;

    @FindBy(name = "Newsletter")
    WebElement cbNewsletter;

    @FindBy(xpath = "//*[@id=\"register-button\"]")
    WebElement btnContinue;

    @FindBy(xpath = "//div[@class='result']")
    WebElement msgConfirmation;

    public void setFirstName(String fname) {
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastname.sendKeys(lname);

    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);

    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);

    }

    public void setConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);

    }

    public void uncheckNewsletter() {
        cbNewsletter.click();
    }

    public void clickContinue() {
        btnContinue.click();

    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }
    }
}
