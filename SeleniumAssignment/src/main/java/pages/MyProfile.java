package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProfile {
    WebDriver driver;
    public MyProfile(WebDriver driver){
        this.driver = driver;
    }
    WebElement profile = driver.findElement(By.xpath("//div[@class='user-name' and contains(.,'abdullah.tahir@emumba.com')]"));
    private By accountsTab = By.xpath("//span[contains(.,'Accounts')]");

    public void verifyprofile(){
        profile.isDisplayed();
    }

    public AccountTab getAccountsTab() {
        verifyprofile();
        driver.findElement(accountsTab).click();
        return new AccountTab(driver);

    }
}
