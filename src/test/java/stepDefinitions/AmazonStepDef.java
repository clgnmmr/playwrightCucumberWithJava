package stepDefinitions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.WriteToText;

import java.io.IOException;

import static hooks.Hook.random;
import static utilities.ReusableMethods.fileExist;

@UsePlaywright
public class AmazonStepDef {

    AmazonPage amazonPage = new AmazonPage();

    @Given("User goes to {string}")
    public void user_goes_to(String url) {
        Driver.getDriver().navigate(ConfigReader.getProperty(url));
    }

    @Then("User validation title")
    public void user_validation_title() throws InterruptedException {
        System.out.println("amazonPage.addressRejected.isVisible() = " + amazonPage.addressRejected.isVisible());
        if (!amazonPage.addressRejected.isVisible()){
            Driver.getDriver().reload();
        }
        amazonPage.addressRejected.click();
        Driver.getDriver().waitForLoadState();
        System.out.println(Driver.getDriver().title());
        Assert.assertTrue(amazonPage.amazonAd.isVisible());
    }

    @When("User searches {int} word")
    public void userSearchesWord(Integer word) throws IOException {
        ExcelUtil.loadExcel(ConfigReader.getProperty("wordExcelPath"), 0);

        amazonPage.search.fill(ExcelUtil.getCellData(word - 1, 0));
        amazonPage.search.press("Enter");
        Driver.getDriver().waitForLoadState(LoadState.DOMCONTENTLOADED);

        Driver.getDriver().waitForSelector("//div[@data-component-type='s-search-result']");

        System.out.println("amazonPage.productList.size() = " + amazonPage.getProductList().size());
       // for (Locator product : amazonPage.getProductList()) {
       //     System.out.println(product.textContent());
       //     System.out.println(" ");
       // }
    }


    @And("User chooses a product")
    public void userChoosesAProduct() throws InterruptedException {
        Driver.getDriver().waitForLoadState();

        int oneProduct = random.nextInt(0, amazonPage.getProductList().size());

        Locator product = amazonPage.getProductList().get(oneProduct);
        product.scrollIntoViewIfNeeded();

        if (product.isVisible()) {
            Thread.sleep(2000);
            product.hover();
            product.click();
        } else {
            System.out.println("Ürün görünür değil: " + oneProduct);
        }
    }


    @And("User writes product information to {string}")
    public void userWritesProductInformationTo(String path) {
        fileExist(ConfigReader.getProperty(path));
        WriteToText.writeToMethod(amazonPage.productTitle.textContent(), ConfigReader.getProperty(path));
        //WriteToText.writeToMethod(amazonPage.productPrice.textContent(), ConfigReader.getProperty(path));
        amazonPage.productSizeDropDown.click();
        amazonPage.xLarge.click();
    }

    @And("User clicks add to card")
    public void userClicksAddToCard() {
        amazonPage.addToCardButton.click();
    }

    @And("User clicks go to card")
    public void userClicksGoToCard() {
        Driver.getDriver().waitForLoadState();
        amazonPage.goToCardButton.click();
    }
}
