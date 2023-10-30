package weathershopper.pages.cartpage;
import org.openqa.selenium.By;

public class CartPageUI {

    public static final By TASK_ICON = By.xpath("//span[contains(@class,'octicon')]");
    public static final By HEADING = By.xpath("//h2");
    public static final By CART_TOTAL_AMOUNT = By.xpath("//p[@id='total']");
    public static final By PAYMENT_BUTTON = By.xpath("//button[@class='stripe-button-el']");
}
