package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDef {

    HomePage homePage=new HomePage();

    @Given("User go to {string}")
    public void user_go_to(String url) {
        Driver.getDriver().navigate(ConfigReader.getProperty(url));
    }
    @Then("User validation title")
    public void user_validation_title() throws InterruptedException {
        homePage.addressRejected.click();
        Driver.getDriver().waitForLoadState();
        System.out.println(Driver.getDriver().title());
    }
}
