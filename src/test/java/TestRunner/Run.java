package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".//Features/LoginFeature.feature", // specify the path to your feature files
    glue = "StepsDefinition", // specify the package where your step definitions are located
    dryRun = false,
    monochrome = true,
    plugin = {"pretty", "html:target/cucumber-reports/reportsResult.html"}
)
public class Run {

	/* This class will be empty. */
}
