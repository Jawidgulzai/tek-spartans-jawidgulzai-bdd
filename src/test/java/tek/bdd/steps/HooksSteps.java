package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.bdd.utility.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {

    @Before
    public void beforeEachScenario(){
        setupBrowser();
    }

    @After
    public void afterEachScenario(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenShot = takeScreenShot();
            scenario.attach(screenShot, "image/png" , "screenshot");
        }
        quitBrowser();
    }

}
