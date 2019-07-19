import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class BrowserInitiation extends InputOutput{

    static WebDriver driver;

    //browserSelection variables:
    static private String browserTag = "BROWSER";
    static private String brFirefox = "Friefox";
    static private String brChrome = "Chrome";
    static private String chromeProperty = "webdriver.chrome.driver";
    static private String firefoxProperty = "webdriver.gecko.driver";

    //goToLink variables:
    static private String urlTag="URL";

    //browserSelection reads the browser type from config.xml file and returns the driver accordingly
    static WebDriver browserSelection() throws IOException, SAXException, ParserConfigurationException {

        String browser = getData(browserTag);

        if (browser.equals(brFirefox)) {
        System.setProperty(firefoxProperty, Constants.FIREFOX_DRIVER_LOCATION);
        driver = new FirefoxDriver();

        }else if (browser.equals(brChrome)){
        System.setProperty(chromeProperty, Constants.CHROME_DRIVER_LOCATION);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();


        return driver;
        }

    //goToLink navigates to the link from config.xml
    static void goToLink() throws IOException, SAXException, ParserConfigurationException{

        driver.navigate().to(getData(urlTag));
        }
}
