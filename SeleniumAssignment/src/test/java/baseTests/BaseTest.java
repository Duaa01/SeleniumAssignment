package baseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
//    public static HomePage homePage;
//    public static VerifyIdentity verifyIdentity;
//    public static CodeVerification codeVerification;
//    public static MyProfile myProfile;
//    public static AccountTab accountTab;

    public String getUrl(){
        String appUrl;
        Properties properties = new Properties();
        try (FileReader reader=new FileReader("src/test/resources/config.properties")) { // read file content
            properties.load(reader); // load the file content
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        // Get the application URL from the properties file
        appUrl = properties.getProperty("app.url");
        return appUrl;
    }

   @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();
        //driver.getTitle();
        String url = getUrl();
        driver.get(url);

//        homePage = new HomePage(driver);
//        verifyIdentity = new VerifyIdentity(driver);
//        codeVerification = new CodeVerification(driver);
    }

    public  void tearDown(){
        //driver.close();
    }
}
