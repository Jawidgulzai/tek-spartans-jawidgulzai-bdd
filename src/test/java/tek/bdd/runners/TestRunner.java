package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Use the @RunWith annotation to tell JUnit to run this test with the Cucumber class.
@RunWith(Cucumber.class)
// Use the @CucumberOptions annotation to specify configuration options for Cucumber.
@CucumberOptions(
        // Specify the location of the feature files. These files contain the Gherkin syntax for your tests.
        features = "classpath:features",
        // Define the package where the step definitions are located.
        // Step definitions are methods that implement the steps in the feature files.
        glue = "tek.bdd.steps",
        // Set dryRun to false.
        // When dryRun is true, Cucumber will check for missing step definitions but won't run the tests.
        dryRun = false,

        tags = "@ValidateFieldErrorUsingMap",

        plugin = {
                "html:target/cucumber_report/index.html"
        }
)
// The TestRunner class is used to configure and run your Cucumber tests.
public class TestRunner {
// The class remains empty because JUnit and Cucumber will handle the test execution based on the annotations.
}
