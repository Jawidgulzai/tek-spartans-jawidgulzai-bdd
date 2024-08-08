package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {

    private static WebDriver driver;
    private Properties properties;
    //Find the full path to file
    //FileInputStream to read the file
    //properties and load the fileInputStream to the properties
    public BaseSetup(){
        try {
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/div-config.properties";
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex){
            throw new RuntimeException("something wrong with config file" + ex);
        }
    }

    public void setupBrowser(){
        driver = new ChromeDriver();
        String url = properties.getProperty("ui.url");
        driver.get(url);
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
