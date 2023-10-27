package pages.locators;
import org.openqa.selenium.By;
public class LoginLocator {

    public static By username = By.xpath("//input[@name='userName']");
    public static By password = By.xpath("//input[@name='loginPassword']");
    public static By nextButton = By.xpath("//button[@type='submit']");
    public static By emailCode = By.xpath("//div[contains(text(),'Email')]");
    public   static By myCode= By.xpath("//input[@name='otp']");
    public   static By verifyButton = By.xpath("//button[@type='submit']");

}
