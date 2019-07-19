import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class SenderRecieverInfo {

    //checkForSomeone variables:
    static private String checkboxForSomeoneCssSelector = "label[data='forSomeone']";

    //fillSenderRecieveInfo variables:
    static private String recieverCssSelector = "input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']";
    static private String senderCssSelector = "input[data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']";
    static private String eventPartialLinkText = "לאיזה אירוע";
    static private String eventsListCssSelector = "li[class='active-result']";
    static private String congratsCssSelector = "textarea[placeholder='מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים, עד 100 תווים']";
    static private String senderName = "משה";
    static private String recieverName = "לינדה";
    static private String congratsText = "תודה לך!";

    //uploadImage variables:
    static private String imageUpName = "fileUpload";

    //sendNowClick variables:
    static private String sendNowClass = "send-now";

    //selectMail variables:
    static private String sendOptionsClass = "btn-send-option-inner";
    static private String recieverMailFieldCssSelector = "input[data-parsley-type='email']";
    static private String recieverMail = "Linda@gmail.com";
    static private String saveMailBtnCssSelector = "button[class='btn btn-theme btn-save']";

    //pay variables:
    static private String payBtnCssSelector = "button[data-target='#forgot-password']";

    //checkForSomeone checks "For Someone" checkbox
    static void checkForSomeone(){

        WebDriverWait wait3= new WebDriverWait(BrowserInitiation.driver, 5000);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(checkboxForSomeoneCssSelector)));

        BrowserInitiation.driver.findElement(By.cssSelector(checkboxForSomeoneCssSelector)).click();

    }

    //fillSenderRecieveInfo fills in sender and reciever info and congratulations
    static void fillSenderRecieverInfo(){

        BrowserInitiation.driver.findElement(By.cssSelector(recieverCssSelector)).sendKeys(recieverName);
        BrowserInitiation.driver.findElement(By.cssSelector(senderCssSelector)).clear();
        BrowserInitiation.driver.findElement(By.cssSelector(senderCssSelector)).sendKeys(senderName);

        BrowserInitiation.driver.findElement(By.partialLinkText(eventPartialLinkText)).click();
        List<WebElement> eventList= BrowserInitiation.driver.findElements(By.cssSelector(eventsListCssSelector));
        eventList.get(3).click();

        BrowserInitiation.driver.findElement(By.cssSelector(congratsCssSelector)).clear();
        BrowserInitiation.driver.findElement(By.cssSelector(congratsCssSelector)).sendKeys(congratsText);
    }


    //uploadImage upload the image from location
    static void uploadImage(){

        BrowserInitiation.driver.findElement(By.name(imageUpName)).sendKeys(Constants.IMAGE_LOCATION);

    }

    //sendNowClick checks the option of sending gift immediately after paying
    static void sendNowClick(){

        BrowserInitiation.driver.findElement(By.className(sendNowClass)).click();

    }

    //selectMail select Mail option to send the giftcard and fills in the reciever mail
    static void selectMail() throws IOException {

        //Creating list of send options. Clicking on the second option (mail).
        List<WebElement> sendOptions= BrowserInitiation.driver.findElements(By.className(sendOptionsClass));
        sendOptions.get(1).click();

        //Filling in the reciever mail
        BrowserInitiation.driver.findElement(By.cssSelector(recieverMailFieldCssSelector)).sendKeys(recieverMail);


        //Save mail
        BrowserInitiation.driver.findElement(By.cssSelector(saveMailBtnCssSelector)).click();

    }

    //pay clicks on Pay button
    static void pay(){

        BrowserInitiation.driver.findElement(By.cssSelector(payBtnCssSelector)).click();
    }

}
