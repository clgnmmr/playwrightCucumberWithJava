package stepDefinitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Belirtilen URL'ye gitme
            page.navigate("https://www.amazon.com/s?k=pencil&crid=1YKC4N8OEO94F&sprefix=pencil%2Caps%2C236&ref=nb_sb_noss_1");

            // Sayfanın tamamen yüklenmesini bekle
            page.waitForLoadState(LoadState.DOMCONTENTLOADED);

            // Ürünleri seçme
            Locator productList = page.locator("//div[@data-component-type='s-search-result']");
            List<Locator> items = productList.all();

            // Listedeki öğe sayısını yazdırma
            System.out.println("Ürün sayısı: " + items.size());

            // Listedeki öğeleri işleme
            for (Locator item : items) {
                String productName = item.locator("h2 a span").textContent();
                System.out.println("Ürün Adı: " + productName);
            }
        }
    }
}
