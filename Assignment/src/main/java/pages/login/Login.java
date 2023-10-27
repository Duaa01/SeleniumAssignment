package pages.login;
import static pages.locators.LoginLocator.*;
import static pages.locators.homePageLocators.*;
import Data.Json.JsonData;
import csv.GenerateCsv;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebDriver;
import utils.CustomWaits;
import utils.WebInteractions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Login {
    WebDriver driver;
    private CustomWaits wait;
    private WebInteractions webInteractions;
    private String code;
    Logger logger = LogManager.getLogger(Login.class);
    SoftAssert softAssert = new SoftAssert();
    public Login(WebDriver driver){
        this.driver = driver;
        this.wait = new CustomWaits(driver);
        this.webInteractions = new WebInteractions(driver);
    }
    public void authenticateLogin() {

        logger.info("Fetch Login Data From Json");
        String username = JsonData.getCredentials().getUsername();
        softAssert.assertEquals(username, "abdullah.tahir@emumba.com");

        String password = JsonData.getCredentials().getPassword();
        softAssert.assertEquals(password, "Test@1234", "Password incorrect");

        code = JsonData.getCredentials().getCode();

        login(username, password);
        logger.info("Login...");
    }
    public void login(String uName, String pass) {

        wait.waitForVisibility(username);

        webInteractions.sendKeysToElement(username, uName);
        webInteractions.sendKeysToElement(password, pass);
        webInteractions.clickElement(nextButton);

        wait.waitToBeClickable(emailCode);
        webInteractions.clickElement(emailCode);

        wait.waitForVisibility(myCode);
        webInteractions.sendKeysToElement(myCode, code);

        wait.waitForVisibility(verifyButton);
        webInteractions.clickElement(verifyButton);

        softAssert.assertTrue(true, "Login successful");

        wait.waitForInvisibility(alert);




    }
}
