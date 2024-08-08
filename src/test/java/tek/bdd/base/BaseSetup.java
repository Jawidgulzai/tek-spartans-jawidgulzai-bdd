package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
    public static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);

    private static WebDriver driver;
    private final Properties properties;
    //Find the full path to file
    //FileInputStream to read the file
    //properties and load the fileInputStream to the properties
    public BaseSetup(){
        try {
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/qa-config.properties";
            LOGGER.info("Reading Config file{}", configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex){
            LOGGER.error("Error reading config file", ex);
            throw new RuntimeException("something is going wrong with the config file" + ex);
        }
    }

    public void setupBrowser(){
        //To Open Chrome browser in headless mode
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser");

        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new EdgeDriver(options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless)
                options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Wrong browser type choose between chrome, firefox or edge");
        }

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
