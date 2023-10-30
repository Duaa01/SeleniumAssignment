package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CustomWaits {
    WebDriver driver;
    public CustomWaits(WebDriver driver){ this.driver = driver; }
    public void waitForVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForInvisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}

