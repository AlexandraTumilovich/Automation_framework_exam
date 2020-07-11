package by.stormnet.core;

import by.stormnet.core.utils.BrowserConstants;
import by.stormnet.core.utils.MyIOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkCore {
    private static WebDriver driver;
    public static String browser = MyIOUtils.loadGenericProperty("browser", "configuration");
    public static String baseUrl = MyIOUtils.loadGenericProperty("baseUrl", "configuration");
    public static String elemaUrl = MyIOUtils.loadGenericProperty("elemaUrl", "configuration");

    public static WebDriver getInstance() {
        if (browser.equals(BrowserConstants.CHROME)) {
            driver = new ChromeDriver();
        } else {
            if (browser.equals(BrowserConstants.FIREFOX)) {
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Browser value from property file is incorrect!");
            }
        }


        return driver;
    }
}
