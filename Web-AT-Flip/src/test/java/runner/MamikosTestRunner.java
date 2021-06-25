package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(
        plugin = {"pretty", "html:target/results/cucumber-reports/cucumber.html", "json:target/results/cucumber-reports/cucumber.json"},
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = "@soaldua"
)

public class MamikosTestRunner extends TestBase {

}
