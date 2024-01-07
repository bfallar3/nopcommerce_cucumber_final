package org.example.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(linkText = "My account")
    WebElement lnkMyaccount;

    @FindBy(linkText = "Register")
    WebElement lnkRegister;

    @FindBy(linkText = "Log in")   // Login link added in step6
    WebElement linkLogin;

    @FindBy(xpath="//input[@id='small-searchterms']")  //For Search Product Test
    WebElement txtSearchbox;

    @FindBy(xpath="//button[normalize-space()='Search']") //For Search Product Test
    WebElement btnSearch;

    // Action Methods
    public void clickMyAccount() {
        lnkMyaccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }

    public void clickLogin()
    {
        linkLogin.click();
    }

    public void enterProductName(String pName)
    {
        txtSearchbox.sendKeys(pName);
    }

    public void clickSearch()
    {
        btnSearch.click();
    }
}
