package org.example.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='ico-account' and text()='My account']") // MyAccount Page heading
    WebElement msgHeading;

    @FindBy(linkText = "Log out")
    WebElement lnkLogout;

    public boolean isMyAccountPageExists()   // MyAccount Page heading display status
    {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return (false);
        }
    }

    public void clickLogout() {
        lnkLogout.click();
    }
}