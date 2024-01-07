package org.example.cucumber.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.AfterStep;
import org.example.cucumber.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {
    WebDriver driver;

    @Before
    public void setup() throws IOException {
        driver = BaseClass.initializeBrowser();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        driver.quit();
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        // this is for cucumber junit report
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
