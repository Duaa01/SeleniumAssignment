package accountTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import csv.GenerateCsv;
import org.testng.asserts.SoftAssert;
import pages.account.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.login.Login;
import static source.appSource.*;
import ReportManager.TestScreenshot;
public class SubAccountTest {
    WebDriver driver;
    Login loginPage;
    GenerateCsv generateCsv = new GenerateCsv();
    ExtentReports extent;
    Account account;

    @BeforeSuite
    public void setUpReport(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testReports/report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @BeforeClass
    public void setUp(){
        ChromeOptions op = new ChromeOptions();
        op.addArguments("start-maximized");
        driver = new ChromeDriver(op);
        String url = getUrl();
        driver.get(url);
    }

    @Test(priority = 1)
    public void logIn() {

        loginPage = new Login(driver);
        //ExtentReports extent = new ExtentReports();
        ExtentTest test = extent.createTest("Test 1", "Login Authentication");
        try {
            test.log(Status.INFO, "Starting User Authentication");
            loginPage.authenticateLogin();
            test.log(Status.PASS, "Login Successfull");
        }catch (Exception e){
            test.log(Status.FAIL, "Authentication Failed");
            String screenshotPath = TestScreenshot.takeScreenshot(driver, "screenshots/" + System.currentTimeMillis() + ".png");
            test.addScreenCaptureFromPath(screenshotPath, "SS");
            e.printStackTrace();
        }
    }

//    @Test (priority =  2)
//    public void subAccountDetails() throws InterruptedException {
//
//        ExtentReports extent = new ExtentReports();
//        account = new Account(driver);
//        ExtentTest test = extent.createTest("Test 2", "Fetch SubAccount Details");
//
//        try {
//            test.log(Status.INFO, "Generating CSV File");
//                generateCsv.createFileSchema();
//            test.log(Status.PASS, "CSV Generation Successful");
//
//            test.log(Status.INFO, "Starting CSV Formatting");
//                generateCsv.changeDelimiter();
//            test.log(Status.PASS, "Formatting Successful");
//
//            test.log(Status.INFO,"Get Sub-Account Data");
//            test.log(Status.INFO,"Add Sub-Account");
//                account.getAccountDetails();
//            test.log(Status.PASS, "Account Added");
//
//            test.log(Status.INFO,"Verify Generated Data");
//            //Thread.sleep(5000);
//                account.verifyAccountData();
//            test.log(Status.PASS,"New Account Verified");
//
//        }catch (Exception e){
//            test.log(Status.FAIL, "File Upload Failed" + e.getMessage());
//            String screenshotPath = TestScreenshot.takeScreenshot(driver, "screenshots/" + System.currentTimeMillis() + ".png");
//            test.addScreenCaptureFromPath(screenshotPath, "SS");
//        }
//    }

    @AfterClass
    public void tearDown(){

        extent.flush();
        //driver.quit();
    }


}
