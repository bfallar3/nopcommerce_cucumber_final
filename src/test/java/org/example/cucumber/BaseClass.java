package org.example.cucumber;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    static WebDriver driver;

    static Logger logger;

    public static WebDriver initializeBrowser()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Logger getLogger()
    {
        logger = LogManager.getLogger();
        return logger;
    }

    public static String randomString()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomNumber()
    {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String randomAlphaNumeric()
    {
        String str=RandomStringUtils.randomAlphabetic(5);
        String num=RandomStringUtils.randomNumeric(10);
        return str+num;
    }

}
