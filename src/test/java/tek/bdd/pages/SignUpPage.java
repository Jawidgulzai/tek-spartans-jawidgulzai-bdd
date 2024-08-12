package tek.bdd.pages;

import org.openqa.selenium.By;

public class SignUpPage {
    public static final By NAME_INPUT = By.name("name");
    public static final By EMAIL_INPUT = By.name("email");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By CONFIRM_PASSWORD = By.name("confirmPassword");
    public static final By ERROR_MESSAGE = By.className("error");
    public static final By NAME_ERROR = By.id("nameError");
    public static final By EMAIL_ERROR = By.id("emailError");
    public static final By PASSWORD_ERROR = By.id("passwordError");
    public static final By CONFIRM_PASSWORD_ERROR = By.id("confirmPasswordError");

}
