package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDef {


    @Given("User go to {string}")
    public void user_go_to(String url) {
        Driver.getDriver().navigate(ConfigReader.getProperty(url));
    }
    @Then("User validation title")
    public void user_validation_title() {
    }
}
