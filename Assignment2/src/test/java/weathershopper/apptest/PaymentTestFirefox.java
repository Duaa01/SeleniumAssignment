package weathershopper.apptest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static configuration.ConfigManager.*;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import testreport.TestScreenshots;
import weathershopper.pages.cartpage.CartPage;
import weathershopper.pages.homepage.HomePage;
import weathershopper.pages.paymentframe.PaymentPage;
import weathershopper.pages.productspage.ProductsPage;

public class PaymentTestFirefox {
    WebDriver driver;
    String url = getUrl();
    HomePage page;
    ProductsPage productsPage;
    CartPage  cartPage;
    PaymentPage paymentPage;
    private ExtentReports extent;
    private ExtentTest test;
    int cartVal;

    @BeforeSuite
    public void setupReport(){

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("testreport/extentreport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

    }
    @BeforeClass
    public void setUp(){
        driver= getFireFox();
        driver.get(url);
    }
    @Test (priority = 1)
    public void chooseProduct(){

        try{
            test = extent.createTest("Test Case 1", "Select Product Type");
            page = new HomePage(driver);
            test.log(Status.INFO,"Select Product Type based on Weather");
            page.SelectProduct();
            test.log(Status.PASS, "Product Type Selected");

        }catch (Exception e){
            test.log(Status.FAIL, e.getMessage());
            String screenshotPath = TestScreenshots.takeScreenshot(driver, "screenshots/" + System.currentTimeMillis() + ".png");
            test.addScreenCaptureFromPath(screenshotPath, "SS");
        }
    }
    @Test (priority = 2)
    public void addToCart() {

        try{
            test = extent.createTest("Test Case 2", "Add Products to Cart");
            productsPage = new ProductsPage(driver);
            test.log(Status.INFO,"Add least Expensive Products");
            cartVal= productsPage.addProductToCart();
            test.log(Status.PASS, "Products Added to Cart");

        }catch (Exception e){
            test.log(Status.FAIL, e.getMessage());
            String screenshotPath = TestScreenshots.takeScreenshot(driver, "screenshots/" + System.currentTimeMillis() + ".png");
            test.addScreenCaptureFromPath(screenshotPath, "SS");
        }
    }
    @Test (priority = 3)
    public void checkoutFromCart(){

        try{
            test = extent.createTest("Test Case 3", "Checkout from Cart");
            cartPage = new CartPage(driver, cartVal);
            test.log(Status.INFO,"Verify Cart Products");
            cartPage.checkout();
            test.log(Status.PASS, "Checked Out of Cart");

        }catch(Exception e){
            test.log(Status.INFO, e.getMessage());
            String screenshotPath = TestScreenshots.takeScreenshot(driver, "screenshots/" + System.currentTimeMillis() + ".png");
            test.addScreenCaptureFromPath(screenshotPath, "SS");
        }
    }
    @Test (priority = 4)
    public void checkPaymentDetails(){

        try{
            test = extent.createTest("Test Case 4", "Make Payment");
            paymentPage = new PaymentPage(driver);
            test.log(Status.INFO,"Add Your Payment Details");
            paymentPage.addPaymentDetails();
            test.log(Status.PASS, "Payment Successful");

        }catch (Exception e){
            test.log(Status.FAIL, e.getMessage());
            String screenshotPath = TestScreenshots.takeScreenshot(driver, "screenshots/" + System.currentTimeMillis() + ".png");
            test.addScreenCaptureFromPath(screenshotPath, "SS");
        }
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
        extent.flush();
    }
}
