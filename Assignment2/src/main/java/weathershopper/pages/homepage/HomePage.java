package weathershopper.pages.homepage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CustomWaits;
import utils.WebInteractions;
import weathershopper.pages.paymentframe.PaymentPage;

import static weathershopper.pages.productspage.ProductsPageUI.*;

public class HomePage {

    WebDriver driver;
    WebInteractions webInteractions;
    CustomWaits wait;

    Logger logger = LogManager.getLogger(HomePage.class);
    public HomePage(WebDriver driver){
        this.driver = driver;
        webInteractions = new WebInteractions(driver);
        wait =new CustomWaits(driver);
    }
    public void SelectProduct(){

        wait.waitForVisibility(HomePageUI.TASK_ICON);
        webInteractions.clickElement(HomePageUI.TASK_ICON);

        wait.waitForVisibility(HomePageUI.WEATHER_INFO);

        WebElement element = driver.findElement(HomePageUI.WEATHER_INFO);
        String elementText = element.getText().substring(0,element.getText().length() - 2).trim();
        int weatherTemp = Integer.parseInt(elementText);

        try{
            if (weatherTemp < 19) {
                logger.info("Choose Moisturizer when temp < 19");
                wait.waitToBeClickable(HomePageUI.MOISTURIZER_BUTTON);
                webInteractions.clickElement(HomePageUI.MOISTURIZER_BUTTON);

                wait.waitForVisibility(PRODUCTS_TASK_ICON);
                webInteractions.clickElement(PRODUCTS_TASK_ICON);

            }

            else if (weatherTemp > 34){
                logger.info("Choose Moisturizer when temp > 34");
                wait.waitToBeClickable(HomePageUI.SUNSCREEN_BUTTON);
                webInteractions.clickElement(HomePageUI.SUNSCREEN_BUTTON);

                wait.waitForVisibility(PRODUCTS_TASK_ICON);
                webInteractions.clickElement(PRODUCTS_TASK_ICON);
            }
            else{
                logger.warn("Invalid Value");
            }
        }catch (NumberFormatException exception){
            exception.printStackTrace();
        }

    }

}
