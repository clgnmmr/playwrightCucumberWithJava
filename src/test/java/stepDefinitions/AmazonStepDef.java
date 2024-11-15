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
import utilities.*;

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
        if (!amazonPage.addressRejected.isVisible()) {
            Driver.getDriver().reload();
        }
        amazonPage.addressRejected.click();
        Driver.getDriver().waitForLoadState();
        System.out.println(Driver.getDriver().title());
        Assert.assertTrue(amazonPage.amazonAd.isVisible());
    }
    int  wordIndex;
    @When("User searches {int} word")
    public void userSearchesWord(Integer word) throws IOException {
        ExcelUtil.loadExcel(ConfigReader.getProperty("wordExcelPath"), 0);

        wordIndex=random.nextInt(0,ExcelUtil.getRowTotal(ConfigReader.getProperty("wordExcelPath")));

        amazonPage.search.fill(ExcelUtil.getCellData(wordIndex, 0));
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

        int productSize= random.nextInt(0,5);
        amazonPage.getProductList().get(productSize).click();

    }


    @And("User writes product information to {string}")
    public void userWritesProductInformationTo(String path) {
        fileExist(ConfigReader.getProperty(path));
        WriteToText.writeToMethod(amazonPage.productTitle.textContent().trim(), ConfigReader.getProperty(path));
        //WriteToText.writeToMethod(amazonPage.productPrice.textContent(), ConfigReader.getProperty(path));

    }

    @And("User clicks add to card")
    public void userClicksAddToCard() {
        try {
            if (!amazonPage.addToCardButton.isVisible()) {
                for (int i = 1; i < amazonPage.sizeList().size(); i++) {
                        amazonPage.productSizeDropDown.click();
                        amazonPage.sizeList().get(i).click();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        amazonPage.addToCardButton.click();

        try {
            if (amazonPage.sorryPage.isVisible()){
                Driver.getDriver().goBack();
                for (int i = 0; i < amazonPage.sizeList().size(); i++) {
                    if (amazonPage.productSizeDropDown.isVisible()) {
                        amazonPage.productSizeDropDown.click();
                        amazonPage.sizeList().get(i).click();
                    }
                }
            }
        } catch (Exception e) {
            Driver.getDriver().goBack();
            userClicksAddToCard();
        }
    }

    @And("User clicks go to card")
    public void userClicksGoToCard() {
        Driver.getDriver().waitForLoadState();
        amazonPage.goToCardButton.click();
    }

    @Then("User validation product information to {string}")
    public void userValidationProductInformationTo(String path) {
        Assert.assertTrue(amazonPage.productTitleOnCard.textContent().trim().toLowerCase().contains(ExcelUtil.getCellData(wordIndex,0).toLowerCase()));
    }

    @And("User increases the product to {int}")
    public void userIncreasesTheProductTo(Integer quantity) {
        amazonPage.quantityButton.click();

        for (int i = 0; i < amazonPage.getQuantityList().size(); i++) {
            if (amazonPage.getQuantityList().get(i).textContent().equals(quantity + "")) {
                amazonPage.getQuantityList().get(i).click();
            }

        }


    }

    @And("User delete product")
    public void userDeleteProduct() {
        for (int i = 0; i < amazonPage.getDeleteList().size(); i++) {
            amazonPage.getDeleteList().get(i).click();
        }
    }
}
