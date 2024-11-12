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
import utilities.ExcelUtil;

import java.io.IOException;
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
    }

    @When("User searches {int} word")
    public void userSearchesWord(Integer word) throws  IOException {
        ExcelUtil.loadExcel(ConfigReader.getProperty("wordExcelPath"), 0);

        amazonPage.search.fill(ExcelUtil.getCellData(word-1,0));
        amazonPage.search.press("Enter");
        Driver.getDriver().waitForLoadState(LoadState.DOMCONTENTLOADED);

        Driver.getDriver().waitForSelector("//div[@data-component-type='s-search-result']");

        System.out.println("amazonPage.productList.size() = " + amazonPage.getProductList().size());
        for (Locator product : amazonPage.getProductList()) {
            System.out.println(product.textContent());
            System.out.println(" ");
        }
    }
}
