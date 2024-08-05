package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {
    @When("user click on sign in link")
    public void userClickOnSignInLink() {
        clickOnElement(HomePage.SING_IN_LINK);
    }
    @Then("validate user is in sign in page")
    public void validateUserIsInSignInPage() {
        String pageSignInTitle = getElementText(SignInPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign in", pageSignInTitle);
    }

    @When("user enter username and password and click on login")
    public void userEnterUsernameAndPasswordAndClickOnLogin() {
        sendKeys(SignInPage.EMAIL_INPUT, "jawid_g9@gmail.com");
        sendKeys(SignInPage.PASSWORD_INPUT, "Jawid123$");
        clickOnElement(SignInPage.LOGIN_BUTTON);
    }

    @When("user enter {string} and {string} and click on login")
    public void userEnterUsernameAndPassword(String username, String password) {
        sendKeys(SignInPage.EMAIL_INPUT, username);
        sendKeys(SignInPage.PASSWORD_INPUT, password);
        clickOnElement(SignInPage.LOGIN_BUTTON);
    }

    @Then("user should be able to see account link")
    public void userShouldBeAbleToSeeAccountLink() {
        boolean isAccountBtnIsDisplayed = isElementIsDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isAccountBtnIsDisplayed);
    }

    @Then("user should see error {string}")
    public void userShouldSeeError(String expectedErrorMessage) {
        String actualErrorMessage = getElementText(SignInPage.ERROR_MESSAGE);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}
