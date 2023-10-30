package weathershopper.pages.cartpage;
import static weathershopper.pages.cartpage.CartPageUI.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utils.CustomWaits;
import utils.WebInteractions;

public class CartPage {

    WebDriver driver;
    WebInteractions webInteractions;
    CustomWaits wait;

    SoftAssert softAssert = new SoftAssert();

    int cartVal;
    public CartPage(WebDriver driver, int cartVal){
        this.driver = driver;
        this.cartVal = cartVal;
        webInteractions = new WebInteractions(driver);
        wait = new CustomWaits(driver);
    }

    public void checkout(){

        wait.waitForVisibility(HEADING);
        webInteractions.clickElement(TASK_ICON);

        wait.waitForVisibility(CART_TOTAL_AMOUNT);
        int totalCartVal = Integer.parseInt(driver.findElement(CART_TOTAL_AMOUNT).getText().split(" ")[2]);
        softAssert.assertEquals(cartVal, totalCartVal);

        webInteractions.clickElement(PAYMENT_BUTTON);
    }

}
