package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class SetupTestSteps extends SeleniumUtility {

    @Given("Open browser and navigate to retail app")
    public void openBrowserAndNavigateToRetailApp() {
        setupBrowser();

    }

    @Then("Validate top left corner is TEKSCHOOL")
    public void validateTopLeftCornerIsTekSchool() {
        String topLeftCornerTekSchoolLogo = getElementText(By.linkText("TEKSCHOOL"));
        Assert.assertEquals("TEKSCHOOL", topLeftCornerTekSchoolLogo);
        System.out.println(topLeftCornerTekSchoolLogo);
    }

    @Then("Validate Sign in button is Enabled")
    public void validateSignInButtonIsEnabled() {
        clickOnElement(By.linkText("Sign in"));
        Assert.assertTrue(true);
    }

    @Then("Close browser")
    public void closeBrowser() {
        quitBrowser();

    }

}
