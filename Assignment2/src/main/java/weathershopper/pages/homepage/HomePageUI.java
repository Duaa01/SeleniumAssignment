package weathershopper.pages.homepage;
import org.openqa.selenium.*;

public class HomePageUI {
    public static final By TASK_ICON = By.xpath("//span[contains(@class,'octicon')]");
    public  static final By WEATHER_INFO = By.xpath("//span[@id='temperature']");
    public static final By MOISTURIZER_BUTTON = By.xpath("(//button[contains(@class, 'btn-primary')])[1]");
    public static final By SUNSCREEN_BUTTON = By.xpath("(//button[contains(@class, 'btn-primary')])[2]");

}
