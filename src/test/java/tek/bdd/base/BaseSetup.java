package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseSetup {

    private static WebDriver driver;

    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.get("https://tek-retail-ui.azurewebsites.net/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void quitBrowser(){
        if (driver != null){
            driver.quit();

        }
    }
    public WebDriver getDriver(){
        return driver;
    }
}
