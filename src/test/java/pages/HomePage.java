package pages;

import com.microsoft.playwright.Page;
import utilities.Driver;

public class HomePage {

    private final Page page;

    public HomePage(){
        page= Driver.getDriver();
    }
}
