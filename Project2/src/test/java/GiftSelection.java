import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftSelection {

    //searchResultsAssert variables:
    static private String expectedUrl = "https://buyme.co.il/search?budget=4&category=13&region=2835";
    static private String pageLocator = "page-title";

    //selectGiftBrand variables:
    static private String selectedGiftBrand = "SeboCalm";

    //searchResultsAssert verifies that the URL of the page we got from selecting specific sum, area and category, is as expected.
    static void searchResultsAssert(){

        WebDriverWait wait= new WebDriverWait(BrowserInitiation.driver, 10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(pageLocator)));

        String currentUrl = BrowserInitiation.driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, currentUrl);

    }

    //selectGiftBrand selects the brand of the gift from searched results
    static void selectGiftBrand(){

        BrowserInitiation.driver.findElement(By.partialLinkText(selectedGiftBrand)).click();
    }

    //selectFromBrand selects one of the options from specific brand
    static void selectFromBrand(){

        SelectFromBrandOptions.selectFirstOption();

    }


}
