package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Features/Customers.feature", // specify the path to your feature files
		glue = "StepsDefinition", // specify the package where your step definitions are located
		dryRun = false, 
		monochrome = true, 
		plugin = { "pretty", "junit:target/cucumber-reports/reports_xml.xml",
							 "html:target/cucumber-reports/reportsResult.html", 
							 "json:target/cucumber-reports/reports_json.json" 
				 })

public class Run {

	/* This class will be empty. */
}
