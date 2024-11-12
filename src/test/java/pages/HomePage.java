package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utilities.Driver;

public class HomePage {

    private static final Page page;

    static {

        page=Driver.getDriver();

    }

    public Locator addressRejected=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).first();


}
