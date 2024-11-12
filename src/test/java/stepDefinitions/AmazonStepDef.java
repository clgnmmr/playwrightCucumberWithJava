package stepDefinitions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class AmazonStepDef {

    AmazonPage amazonPage = new AmazonPage();

    @Given("User go to {string}")
    public void user_go_to(String url) {
        Driver.getDriver().navigate(ConfigReader.getProperty(url));
    }

    @Then("User validation title")
    public void user_validation_title() throws InterruptedException {
        amazonPage.addressRejected.click();
        Driver.getDriver().waitForLoadState();
        System.out.println(Driver.getDriver().title());
        Assert.assertTrue(amazonPage.amazonAd.isVisible());
        //Assert.assertEquals("Zamazon",homePage.amazonAd.textContent());
    }

    @When("User searches {string} word")
    public void userSearchesWord(String word) throws InterruptedException {
        amazonPage.search.fill(ConfigReader.getProperty(word));
        amazonPage.search.press("Enter");
        Driver.getDriver().waitForLoadState(LoadState.DOMCONTENTLOADED);

        Driver.getDriver().waitForSelector("//div[@data-component-type='s-search-result']");



        System.out.println("amazonPage.productList.size() = " + amazonPage.getProductList().size());
        for (Locator product : amazonPage.getProductList()) {
            System.out.println(product.textContent());
            System.out.println(" ");

        }
        Thread.sleep(10000);
    }
}
