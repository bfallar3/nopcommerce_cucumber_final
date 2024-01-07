package org.example.cucumber.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.cucumber.BaseClass;
import org.example.cucumber.pageObjects.HomePage;
import org.example.cucumber.pageObjects.LoginPage;
import org.example.cucumber.pageObjects.MyAccountPage;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class LoginSteps {
    HomePage hp;
    LoginPage lp;
    MyAccountPage macc;

    List<HashMap<String, String>> datamap; //Data driven

    @Given("the user navigates to login page")
    public void user_navigate_to_login_page() {
        BaseClass.getLogger().info("Logging in...");

        hp = new HomePage(BaseClass.getDriver());
        hp.clickLogin();
    }

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
        BaseClass.getLogger().info("Entering email and password.. ");

        lp = new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);
    }

    @When("the user clicks on the Login button")
    public void click_on_login_button() {
        BaseClass.getLogger().info("clicked on login button...");

        lp = new LoginPage(BaseClass.getDriver());
        lp.clickLogin();
    }

    @Then("the user should be redirected to the MyAccount Page")
    public void user_navigates_to_my_account_page() {
        macc = new MyAccountPage(BaseClass.getDriver());
        boolean targetpage = macc.isMyAccountPageExists();
        Assert.assertTrue(targetpage);
    }
}
