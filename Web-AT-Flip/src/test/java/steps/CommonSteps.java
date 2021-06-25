package steps;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import tests.TestBase;
import utilities.SeleniumHelpers;

public class CommonSteps extends TestBase {

    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user navigates to mamikos homepage {string}")
    public void userNavigatesToMamikosHomepage(String url) {
        selenium.navigateToPage(url);
    }

    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        selenium.navigateToPage(url);
        Assert.assertEquals(selenium.getURL(), url, "URL not match!");
    }
}
