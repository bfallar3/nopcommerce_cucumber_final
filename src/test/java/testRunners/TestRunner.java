package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/login.feature",
                "src/test/resources/features/registration.feature"},
        glue = "org.example.cucumber",
        plugin = {"pretty",
                "html:reports/my_report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"
            }
)
public class TestRunner {
}
