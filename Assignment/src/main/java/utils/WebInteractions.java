package utils;
import org.openqa.selenium.*;
public class WebInteractions {
    WebDriver driver;
    public WebInteractions(WebDriver driver) {
        this.driver = driver;
    }
    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
    public void sendKeysToElement(By locator, String data){
        WebElement element = driver.findElement(locator);
        element.sendKeys(data);

    }

}






