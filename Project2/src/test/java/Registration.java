import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Registration {

    //goToSignIn variables:
    static private String signInBtnClass = "seperator-link";
    static private String signInFormClass = "text-btn";

    //fillUser variables:
    static private String nameTag = "Name";
    static private String mailTag = "Mail";
    static private String passTag = "Password";
    static private String nameCssSelector = "input[placeholder='שם פרטי']";
    static private String mailCssSelector = "input[placeholder='מייל']";
    static private String passCssSelector = "input[placeholder='סיסמה']";
    static private String passConfirmCssSelector = "input[placeholder='אימות סיסמה']";

    //iAgree variables:
    static private String agreeCheckboxXpath = "//i [@class='fa fa-check ']";
    static private String javaScriptString = "arguments[0].click();";

    //signIn variables
    static private String signInBtnCssSelector = "button[type='submit']";



    //goToSignIn presses sign in on the main screen and on the pop up dialog, so user gets to the sign in form for new user
    static void goToSignIn(){

        //Press "sign in | enter" button
        BrowserInitiation.driver.findElement(By.className(signInBtnClass)).click();
        //Press "להרשמה" button
        BrowserInitiation.driver.findElement(By.className(signInFormClass)).click();

    }
    //fill User fills user details, according to the details in userData.xml
    static void fillUser() throws IOException, SAXException, ParserConfigurationException {

        //Getting data from userData.xml
        String userName = InputOutput.getUserData(nameTag);
        String userMail = InputOutput.getUserData(mailTag);
        String userPass = InputOutput.getUserData(passTag);

        BrowserInitiation.driver.findElement(By.cssSelector(nameCssSelector)).sendKeys(userName);
        BrowserInitiation.driver.findElement(By.cssSelector(mailCssSelector)).sendKeys(userMail);
        BrowserInitiation.driver.findElement(By.cssSelector(passCssSelector)).sendKeys(userPass);
        BrowserInitiation.driver.findElement(By.cssSelector(passConfirmCssSelector)).sendKeys(userPass);
    }

    //iAgree checks the checkbox for user agreement
    static void iAgree(){

        WebElement checkBox= BrowserInitiation.driver.findElement(By.xpath(agreeCheckboxXpath));
        ((JavascriptExecutor) BrowserInitiation.driver).executeScript(javaScriptString,checkBox);
    }

    //signIn presses the final sign in button
    static void signIn(){

        BrowserInitiation.driver.findElement(By.cssSelector(signInBtnCssSelector)).click();
    }
}
