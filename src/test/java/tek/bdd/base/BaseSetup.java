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

/**
 * This class provides a base setup for initializing and managing a WebDriver instance.
 * It reads the configuration from a properties file and sets up the browser based on that configuration.
 */
public abstract class BaseSetup {

    // Logger to record information and errors during the setup process
    public static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);

    // Static WebDriver instance shared across tests
    private static WebDriver driver;

    // Properties object to hold configuration settings
    private final Properties properties;

    /**
     * Constructor for BaseSetup.
     * Reads configuration from a properties file and initializes the properties' object.
     */
    public BaseSetup() {
        try {
            // Determine the full path to the configuration file
            String configFilePath = System.getProperty("user.dir") + "/src/test/resources/configs/qa-config.properties";
            LOGGER.info("Reading Config file {}", configFilePath);

            // Create a File object and FileInputStream to read the properties file
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);

            // Initialize the properties' object and load the configuration from the file
            properties = new Properties();
            properties.load(fileInputStream);

        } catch (IOException ex) {
            // Log error if there is an issue reading the configuration file
            LOGGER.error("Error reading config file", ex);
            throw new RuntimeException("Something went wrong with the config file: " + ex);
        }
    }

    /**
     * Sets up the WebDriver instance based on the browser type and headless mode specified in the configuration file.
     */
    public void setupBrowser() {
        // Get the browser type and headless mode setting from the properties
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser {} and isHeadless {}", browserType, isHeadless);

        // Initialize the WebDriver based on the specified browser type
        if (browserType.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (browserType.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new EdgeDriver(options);

        } else if (browserType.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (isHeadless) options.addArguments("--headless");
            driver = new FirefoxDriver(options);

        } else {
            // Throw an exception if an unsupported browser type is specified
            throw new RuntimeException("Wrong browser type. Choose between chrome, firefox, or edge.");
        }

        // Get the URL from properties and configure WebDriver
        String url = properties.getProperty("ui.url");
        driver.get(url); // Open the specified URL
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Set implicit wait time
    }

    /**
     * Quits the WebDriver instance and closes all associated browser windows.
     */
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    /**
     * Returns the WebDriver instance.
     * @return the WebDriver instance
     */
    public WebDriver getDriver() {
        return driver;
    }
}