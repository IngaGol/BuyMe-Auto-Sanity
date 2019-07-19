import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Pro2 extends InputOutput{

    private static WebDriver driver;

    //Report messages strings:
    private static String reportMainScreen = "BuyMe Main Screen";
    private static String reportSignIn = "Sign in was performed.";
    private static String reportSumAreaCategorySearch = "Sum, area and category were selected. Search clicked.";
    private static String reportAssertPass = "The link after the search is as expected.";
    private static String reportSelectBrand = "Brand selection.";
    private static String reportSelectFromBrand = "A gift from the selected brand was selected.";
    private static String reportForSomeoneChecked = "Gift selected for someone checkbox is checked.";
    private static String reportSenderRecieverInfo = "Sender and Receiver info was filled.";
    private static String reportImageNowRecieverMail = "Image was uploaded. Send after the payment was checked. Mail option was selected, receiver mail was filled.";
    private static String reportAllDetailsPay = "All details were filled. Pay was pressed.";


    @BeforeClass
    public static void beforeAll() throws IOException, SAXException, ParserConfigurationException{

        driver= BrowserInitiation.browserSelection();
        BrowserInitiation.goToLink();

        //Initializing and creating report
        Report.reportInitiation();

        //Taking log and screenshot of the main page
        Report.createLogLine(reportMainScreen);
        Report.takeScreenshot();

    }

     @Test
     public void test01_RegistrationScreen() throws IOException, SAXException, ParserConfigurationException{

        Registration.goToSignIn();
        Report.takeScreenshot();
        Registration.fillUser();
        Registration.iAgree();
        Registration.signIn();
        Report.createLogLine(reportSignIn);
        Report.takeScreenshot();

    }

    @Test
    public void test02_HomeScreen()throws IOException{

        Home.selectSum();
        Home.selectArea();
        Home.selectCategory();
        Home.find();

        Report.createLogLine(reportSumAreaCategorySearch);
        Report.takeScreenshot();

    }

    @Test
    public void test03_GiftSelection() throws IOException{

        GiftSelection.searchResultsAssert();
        Report.createLogLine(reportAssertPass);
        Report.takeScreenshot();


        GiftSelection.selectGiftBrand();
        Report.createLogLine(reportSelectBrand);
        Report.takeScreenshot();

        GiftSelection.selectFromBrand();
        Report.createLogLine(reportSelectFromBrand);
        Report.takeScreenshot();
    }

    @Test
    public void test04_SenderReciever() throws IOException {
        SenderRecieverInfo.checkForSomeone();
        Report.createLogLine(reportForSomeoneChecked);
        Report.takeScreenshot();

        SenderRecieverInfo.fillSenderRecieverInfo();
        Report.createLogLine(reportSenderRecieverInfo);
        Report.takeScreenshot();

        SenderRecieverInfo.uploadImage();
        SenderRecieverInfo.sendNowClick();

        SenderRecieverInfo.selectMail();
        Report.createLogLine(reportImageNowRecieverMail);
        Report.takeScreenshot();

        SenderRecieverInfo.pay();
        Report.createLogLine(reportAllDetailsPay);
        Report.takeScreenshot();

    }

    @AfterClass
    public static void afterAll() throws IOException {
        driver.quit();
        Report.createFinalReport();
    }
}
