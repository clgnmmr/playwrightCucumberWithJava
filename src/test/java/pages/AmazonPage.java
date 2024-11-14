package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    private static final Page page;

    static {

        page = Driver.getDriver();

    }

    public Locator addressRejected = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).first();
    public Locator amazonAd = page.getByLabel("Amazon", new Page.GetByLabelOptions().setExact(true));
    public Locator search = page.getByPlaceholder("Search Amazon");
    public Locator product = page.locator("//div[@class='a-section a-spacing-base']");

    public List<Locator> getProductList() {
        return product.all();
    }

    public Locator productTitle = page.locator("#productTitle");
    public Locator productPrice = page.locator("#corePrice_desktop");
    public Locator productSizeDropDown = page.locator("//span[@class='twister-dropdown-highlight transparentTwisterDropdownBorder']");
    public Locator xLarge = page.getByLabel("X-Large", new Page.GetByLabelOptions().setExact(true)).getByText("X-Large");
    public Locator addToCardButton = page.getByLabel("Add to Cart");
    public Locator goToCardButton =  page.locator("//span[@id='sw-gtc']");
}
