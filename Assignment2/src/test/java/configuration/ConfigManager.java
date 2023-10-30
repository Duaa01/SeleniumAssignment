package configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    static WebDriver driver;
    public static String getUrl(){
        String appUrl;
        Properties properties = new Properties();
        try (FileReader reader=new FileReader("src/test/resources/app.properties")) { // read file content
            properties.load(reader); // load the file content
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Get the application URL from the properties file
        appUrl = properties.getProperty("app.url");
        return appUrl;
    }
    public static WebDriver getChrome(){
        ChromeOptions op = new ChromeOptions();
        op.addArguments("start-maximized");
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(op);
        return driver;
    }

    public static WebDriver getFireFox(){

        System.setProperty("webdriver.gecko.driver", "/snap/bin/firefox.geckodriver");
        FirefoxOptions op = new FirefoxOptions();
        //op.addArguments("start-maximized");
        //WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(op);
    }
}
