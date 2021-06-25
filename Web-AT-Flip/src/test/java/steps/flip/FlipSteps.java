package steps.flip;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.flip.FlipPO;
import tests.TestBase;

import java.util.List;

public class FlipSteps extends TestBase {

    private FlipPO flip = new FlipPO(driver);

    @Then("user verify data table and data list user")
    public void userVerifyDataTableAndDataListUser(DataTable userDataList) {
        List<List<String>> userData = userDataList.asLists(String.class);

        for (int j = 0; j < userData.size(); j++) {
            Assert.assertTrue(flip.checkTitleColomn(userData.get(0).get(j)), "Title Colomn is not equals!");

            for (int i = j + 1; i < userData.size(); i++) {
                Assert.assertTrue(flip.checkValueDataList(userData.get(i).get(j)), "Something was wrong! Data value is not equals!");
            }
        }

    }

    @When("user sees homepage banner")
    public void userSeesHomepageBanner() {
        Assert.assertTrue(flip.isLogoFlipPresent(), "Logo flip is not present!");
    }

    @Then("user verifies the text buttons is {string}")
    public void userVerifiesTheTextButtonsIs(String help) {
        Assert.assertEquals(flip.getHelpTextButton(), help, "Something was wrong! Text Help button is not equals!");
    }

    @Then("user verifies the text1 buttons is {string}")
    public void userVerifiesTheText1ButtonsIs(String product) {
        Assert.assertEquals(flip.getTextButton(product), product, "Something was wrong! Text button is not equals!");
    }

    @And("user verifies the text2 buttons is {string}")
    public void userVerifiesTheText2ButtonsIs(String career) {
        Assert.assertTrue(flip.isCareerButtonPresent(), "Something was wrong! Text button Karir is not present!");
    }

    @And("user verifies the text3 buttons is {string}")
    public void userVerifiesTheText3ButtonsIs(String login) {
        Assert.assertTrue(flip.isLoginButtonPresent(), "Something was wrong! Text button Masuk is not present!");
    }

    @And("user clicks button {string}")
    public void userClicksButton(String button) throws InterruptedException {
        flip.clicknavbarButton(button);
    }

    @Then("user verifies the navigation of button {string}")
    public void userVerifiesTheNavigationOfButton(String button) throws InterruptedException {
        if(button.equalsIgnoreCase("Produk")){
            Assert.assertTrue(flip.isPopUpProductPresent(), "Something was wrong! The Pop up product not present!");
        } else if (button.equalsIgnoreCase("Karir")){
            Assert.assertTrue(flip.getCareerURL().contains("jobs"), "Something was wrong! The URL doesn't match!");
        } else {
            Assert.assertTrue(flip.getURL().contains("login"), "Something was wrong! The URL doesn't match!");
        }
    }


}
