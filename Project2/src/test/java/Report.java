import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class Report {

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    private static String testName = "BuyMe Sanity Test";
    private static String testDescription = "Tests the basic functionality of BuyMe.co.il";
    private static String testerTitle = "Tester";
    private static String testerName = "Inga Golovko";
    private static String environmentTitle = "Environment";
    private static String environmentActual = "Win10, Browsers: Chrome or Firefox";

    //takeScreenshot variables:
    private static String screenShotTitle = "Screenshot:";

    //takeScreenShot variables:
    private static String pngFile = ".png";


    //reportInitiation initiates and creates report with basic information
    public static void reportInitiation(){
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Constants.REPORT_LOCATION_FILE);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest(testName, testDescription);

        // add custom system info
        extent.setSystemInfo(environmentTitle, environmentActual);
        extent.setSystemInfo(testerTitle, testerName);

    }

    //takeScreenshot takes screenshot with current tinme, using takeScreenShot function
    public static void takeScreenshot()throws IOException{
        String currentTime = String.valueOf(System.currentTimeMillis());
        test.pass(screenShotTitle, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(Constants.REPORT_LOCATION + currentTime)).build());
    }

    //createLogLine created PASS log line, with message passed in 'message' variable
    public static void createLogLine(String message){
        test.log(Status.PASS, message);
    }

    //createFinalReport uses flush() function to create the test report.
    public static void createFinalReport(){
        extent.flush();
    }

    //takeScreenShot takes screenshot and creates image from current state
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) BrowserInitiation.driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+pngFile);
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+pngFile;
    }
}
