package hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Paths;
import java.util.Random;

public class Hook {

    public static Random random=new Random();
    @After
    public void tearDown(Scenario scenario) throws Exception {

        if (scenario.isFailed()) {
            byte[] screenshot = Driver.getDriver().screenshot(new Page.ScreenshotOptions().setPath(ReusableMethods.screen(scenario.getName())));
            scenario.attach(screenshot, "image/png", "screenshots");
            Driver.closeDriver();
        }


    }
}
