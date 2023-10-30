package weathershopper.pages.paymentframe;
import org.openqa.selenium.*;

public class PaymentModalUI {
    public static final By STRIPE_FRAME = By.xpath("//iframe[@name='stripe_checkout_app']");
    public static final By EMAIL_INPUT = By.xpath("//input[@id='email']");
    public static final By CARD_NUMBER = By.xpath("//input[@id='card_number']");
    public static final By EXP_DATE_INPUT = By.xpath("//input[@id='cc-exp']");
    public static final By CVC_INPUT = By.xpath("//input[@id='cc-csc']");
    public static final By ZIP_CODE_INPUT = By.xpath("//input[@name='zip']");
    public static final By CONFIRM_PAYMENT_BUTTON = By.xpath("//span[@class='iconTick']");
    public static final By PAYMENT_SUCCESS = By.xpath("//h2[contains(.,'SUCCESS')]");


}
