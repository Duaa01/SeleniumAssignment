package loginTests;
import baseTests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;


public class LoginTest extends BaseTest {
    WebDriver driver = new ChromeDriver();
    HomePage home;

    @Test
    public void launch(){
        driver.get("https://portal-uat.myhousecallspro.com/");
        home = new HomePage(driver);
    }

    @Test
    public void signIn() {
      home.readJsonData("src/test/resources/data.json");
    }

//    @Test
//    public void sendCode(){
//        verifyIdentity.sendCode();
//    }





}
