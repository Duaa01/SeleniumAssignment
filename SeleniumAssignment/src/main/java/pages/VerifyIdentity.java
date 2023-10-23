package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class VerifyIdentity {

    WebDriver driver;
    private By emailCode = By.xpath("//div[@class ='mfa-text' and contains(.,'Email ')]");
    private By heading = By.xpath("//h2");

    //String file = "src/test/resources/data.json";
    public VerifyIdentity(WebDriver driver){
        this.driver = driver;
    }
    public CodeVerification sendCode(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.elementToBeClickable(emailCode));
        //driver.findElement(heading).isDisplayed();
        driver.findElement(emailCode).click();
        return new CodeVerification(driver);
    }



}
