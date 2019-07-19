import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {

    static private String sumLinkText= "סכום";
    static private String sumFromListCssSelector= "li[class='active-result']";

    //selectArea variables:
    static private String areaLinkText = "אזור";
    static private String areaFromListCssSelector = "li[class='active-result']";

    //selectCategory variables:
    static private String categoryLinkText = "קטגוריה";
    static private String categoryFromListCssSelector = "li[class='active-result']";

    //find variables:
    static private String findPartialLinkText = "תמצאו";

    static void selectSum(){

        BrowserInitiation.driver.findElement(By.linkText(sumLinkText)).click();
        //List of all options from sum drop down
        List<WebElement> sumList= BrowserInitiation.driver.findElements(By.cssSelector(sumFromListCssSelector));

        //selecting 300-499 option
        sumList.get(3).click();

    }

    static void selectArea(){
        BrowserInitiation.driver.findElement(By.linkText(areaLinkText)).click();
        //List of all options from area drop down
        List<WebElement> areaList= BrowserInitiation.driver.findElements(By.cssSelector(areaFromListCssSelector));
        //selecting השרון option
        areaList.get(6).click();
    }

    static void selectCategory(){
        BrowserInitiation.driver.findElement(By.linkText(categoryLinkText)).click();
        //List of all options from category drop down
        List<WebElement> categoryList= BrowserInitiation.driver.findElements(By.cssSelector(categoryFromListCssSelector));
        //selecting טיפוח option
        categoryList.get(13).click();
    }

    static void find(){

        //clicking on "Find me a present"
        BrowserInitiation.driver.findElement(By.partialLinkText(findPartialLinkText)).click();
    }


}
