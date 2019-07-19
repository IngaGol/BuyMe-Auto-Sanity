import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectFromBrandOptions {

    //selectFirstOption variables:
    static private String brandFromListCssSelector ="a[class='btn btn-theme btn-purchase ember-view']";

    //selectFirstOption selects the first option from SeboCalm gifts options
    static void selectFirstOption(){

        WebDriverWait wait= new WebDriverWait(BrowserInitiation.driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(brandFromListCssSelector)));

        List<WebElement> brandOptionsList= BrowserInitiation.driver.findElements(By.cssSelector(brandFromListCssSelector));
        brandOptionsList.get(0).click();

    }

}
