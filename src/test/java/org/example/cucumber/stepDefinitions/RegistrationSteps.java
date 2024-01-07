package org.example.cucumber.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.cucumber.BaseClass;
import org.example.cucumber.pageObjects.AccountRegistrationPage;
import org.example.cucumber.pageObjects.HomePage;
import org.junit.Assert;

import java.util.Map;

public class RegistrationSteps {
    HomePage hp;
    AccountRegistrationPage regpage;

    @Given("the user navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        hp = new HomePage(BaseClass.getDriver());
        hp.clickRegister();
    }

    @When("the user enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        regpage = new AccountRegistrationPage(BaseClass.getDriver());
        regpage.setFirstName(dataMap.get("firstName"));
        regpage.setLastName(dataMap.get("lastName"));
        regpage.setEmail(BaseClass.randomString() + "@gmail.com");
        regpage.setPassword(dataMap.get("password"));
        regpage.setConfirmPassword(dataMap.get("password"));

    }

    @When("the user unselect Newsletter checkbox")
    public void user_unselect_newsletter() {
        regpage.uncheckNewsletter();
    }

    @When("the user clicks on Register button")
    public void user_clicks_on_continue_button() {
        regpage.clickContinue();
    }

    @Then("the user account should get created successfully")
    public void user_account_should_get_created_successfully() {
        String confmsg = regpage.getConfirmationMsg();
        Assert.assertEquals(confmsg, "Your registration completed");
    }
}
