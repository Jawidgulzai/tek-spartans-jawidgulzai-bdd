package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {
    @When("user click on sign in link")
    public void userClickOnSignInLink() {
        clickOnElement(By.linkText("Sign in"));
    }
    @Then("validate user is in sign in page")
    public void validateUserIsInSignInPage() {
        String pageSignInTitle = getElementText(By.className("login__subtitle"));
        Assert.assertEquals("Sign in", pageSignInTitle);
    }

    @When("user enter username and password and click on login")
    public void userEnterUsernameAndPasswordAndClickOnLogin() {
        sendKeys(By.id("email"), "jawid_g9@gmail.com");
        sendKeys(By.id("password"), "Jawid123$");
        clickOnElement(By.id("loginBtn"));
    }

    @Then("user should be able to see account link")
    public void userShouldBeAbleToSeeAccountLink() {
        boolean isAccountBtnIsDisplayed = isElementIsDisplayed(By.linkText("Account"));
        Assert.assertTrue(isAccountBtnIsDisplayed);
    }

}
