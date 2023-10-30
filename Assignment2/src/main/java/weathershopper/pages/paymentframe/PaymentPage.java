package weathershopper.pages.paymentframe;
import static weathershopper.pages.paymentframe.PaymentModalUI.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utils.CustomWaits;
import utils.WebInteractions;
import utils.json.JsonData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentPage {

    WebDriver driver;
    WebInteractions webInteractions;
    CustomWaits wait;

    SoftAssert softAssert = new SoftAssert();

    Logger logger = LogManager.getLogger(PaymentPage.class);
    public PaymentPage(WebDriver driver){
        this.driver = driver;
        webInteractions = new WebInteractions(driver);
        wait =new CustomWaits(driver);
    }

    public void addPaymentDetails(){

        logger.info("Read Data from Json");
        String email = JsonData.getCredentials().getEmail();
        String cardNum = JsonData.getCredentials().getCardNum();
        String exp = JsonData.getCredentials().getExpDate();
        String cvc = JsonData.getCredentials().getcVC();
        String zip = JsonData.getCredentials().getZipCode();

        logger.info("Input Json Data");
        this.makePayment(email,cardNum,exp,cvc,zip);
    }
    public void makePayment(String email, String num, String exp, String cvc, String zip){

        logger.info("Switching to Iframe");
        wait.waitForVisibility(STRIPE_FRAME);
        webInteractions.switchToIframe(STRIPE_FRAME);

        logger.info("Interacting with Payment Modal Elements");
        wait.waitForVisibility(EMAIL_INPUT);
        webInteractions.sendKeysToElement(EMAIL_INPUT, email);

        for(int i = 0; i < num.length(); i++){
            String cardNumChar = String.valueOf(num.charAt(i));
            webInteractions.sendKeysToElement(CARD_NUMBER, cardNumChar);

        }
        wait.waitForVisibility(ZIP_CODE_INPUT);
        webInteractions.sendKeysToElement(EXP_DATE_INPUT, exp);
        webInteractions.sendKeysToElement(CVC_INPUT, cvc);

        webInteractions.sendKeysToElement(ZIP_CODE_INPUT, zip);

        webInteractions.clickElement(CONFIRM_PAYMENT_BUTTON);

        logger.info("Verifying Payment Success");
        wait.waitForVisibility(PAYMENT_SUCCESS);

        String paymentVerification = driver.findElement(PAYMENT_SUCCESS).getText();

        softAssert.assertEquals(paymentVerification, "PAYMENT SUCCESS");


    }
}
