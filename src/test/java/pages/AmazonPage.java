package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    private static final Page page;

    static {

        page=Driver.getDriver();

    }

    public Locator addressRejected=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).first();
    public Locator amazonAd=page.getByLabel("Amazon", new Page.GetByLabelOptions().setExact(true));
    public Locator search=page.getByPlaceholder("Search Amazon");
    public Locator  product=page.locator("//div[@class='a-section a-spacing-base']");

    public List<Locator> getProductList(){
        return product.all();
    }

}
