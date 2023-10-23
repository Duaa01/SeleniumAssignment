package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CodeVerification {

    WebDriver driver;
    HomePage home = new HomePage(driver);
    private  By myCode= By.xpath("//input");
    public CodeVerification(WebDriver driver){
        this.driver = driver;
    }

    public MyProfile enterCode(String code){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeSelected(myCode));

        driver.findElement(myCode).sendKeys(code);
        return new MyProfile(driver);
    }


}
