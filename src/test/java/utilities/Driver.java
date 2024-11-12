package utilities;

import com.microsoft.playwright.*;

public class Driver {



    private static Playwright playwright;
    private static Browser browserObject;
    private static BrowserContext context;
    private static Page page;

    private Driver() {
        // Private constructor to prevent instantiation
    }

    public static Page getDriver() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browserObject == null) {
            String browser = ConfigReader.getProperty("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                case "chromium":
                    browserObject = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "chrome-headless":
                case "chromium-headless":
                    browserObject = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;

                case "firefox":
                    browserObject = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "firefox-headless":
                    browserObject = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;

                case "edge":
                    browserObject = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
                    break;

                case "edge-headless":
                    browserObject = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true));
                    break;

                case "webkit":
                case "safari":
                    browserObject = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    break;

                case "webkit-headless":
                case "safari-headless":
                    browserObject = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;

                default:
                    throw new IllegalArgumentException("Geçersiz tarayıcı türü: " + browser);
            }
        }
        if (context == null) {
            context = browserObject.newContext();
        }
        if (page == null) {
            page = context.newPage();
        }
        return page;
    }

    public static void closeDriver() {
        if (page != null) {
            page.close();
            context.close();
            browserObject.close();
            playwright.close();
            page = null;
            context = null;
            browserObject = null;
            playwright = null;
        }
    }
}
