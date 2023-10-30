package weathershopper.pages.productspage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utils.CustomWaits;
import utils.WebInteractions;
import weathershopper.pages.paymentframe.PaymentPage;

import static weathershopper.pages.productspage.ProductsPageUI.*;
import java.util.List;

public class ProductsPage {

    WebDriver driver;
    WebInteractions webInteractions;
    CustomWaits wait;
    SoftAssert softAssert = new SoftAssert();

    Logger logger = LogManager.getLogger(ProductsPage.class);
    public ProductsPage(WebDriver driver){
        this.driver = driver;
        webInteractions = new WebInteractions(driver);
        wait =new CustomWaits(driver);
    }
    private int addMoisturizerToCart(List<WebElement> products){

        String firstProductPrice = products.get(0).findElements(By.xpath("*")).get(2).getText();
        int minProductPrice = Integer.parseInt(firstProductPrice.substring(firstProductPrice.length()-3));
        int minAlmondPrice = minProductPrice, minAloePrice = minProductPrice;
        int minAlmondIndex = -1, minAloeIndex = -1;

        for (int i = 0; i < products.size(); i++){
            List<WebElement> childElements = products.get(i).findElements(By.xpath("*"));

            int price = Integer.parseInt(childElements.get(2).getText().substring(childElements.get(2).getText().length() - 3));
            String productName = childElements.get(1).getText();

            if(productName.contains("Almond") || productName.contains("almond")){
                if(price < minAlmondPrice){
                    minAlmondIndex = i;
                    minAlmondPrice = price;
                }
            }
            if(productName.contains("Aloe") || productName.contains("aloe")){

                if(price < minAloePrice){
                    minAloeIndex = i;
                    minAloePrice = price;
                }
            }
        }

        if (minAlmondIndex > -1) {
            products.get(minAlmondIndex).findElements(By.xpath("*")).get(3).click();
        }
        if(minAloeIndex > -1){
            products.get(minAloeIndex).findElements(By.xpath("*")).get(3).click();
        }

        return minAlmondPrice + minAloePrice;
    }

    private int addSunscreenToCart(List<WebElement> products){

        String firstProductPrice = products.get(0).findElements(By.xpath("*")).get(2).getText();
        int minProductPrice = Integer.parseInt(firstProductPrice.substring(firstProductPrice.length()-3));
        int minSPF50Price = minProductPrice, minSPF30Price = minProductPrice;
        int minSPF50Index = -1, minSPF30Index = -1;

        for (int i = 0; i < products.size(); i++){
            List<WebElement> childElements = products.get(i).findElements(By.xpath("*"));

            int price = Integer.parseInt(childElements.get(2).getText().substring(childElements.get(2).getText().length() - 3));
            String productName = childElements.get(1).getText();

            if(productName.contains("SPF-50") || productName.contains("spf-50")){
                if(price < minSPF50Price){
                    minSPF50Index = i;
                    minSPF50Price = price;
                }
            }
            if(productName.contains("SPF-30") || productName.contains("spf-30")){

                if(price < minSPF30Price){
                    minSPF30Index = i;
                    minSPF30Price = price;
                }
            }
        }
        if (minSPF50Index > -1) {
            products.get(minSPF50Index).findElements(By.xpath("*")).get(3).click();
        }

        if(minSPF30Index > -1){
            products.get(minSPF30Index).findElements(By.xpath("*")).get(3).click();
        }

        return minSPF30Price + minSPF50Price;
    }
    public int  addProductToCart() {

        int cartVal;
        wait.waitForVisibility(MY_TASK_HEADING);
        List<WebElement> products = driver.findElements(PRODUCTS);
        String productType = driver.findElement(HEADING).getText();

        if(productType.equals("Sunscreens")){
            cartVal = this.addSunscreenToCart(products);
            int itemAmount = Integer.parseInt(driver.findElement(CART_ITEM_NUM).getText().substring(0,1));
            wait.waitForVisibility(COPY_RIGHT_TAG);

             if(itemAmount == 2){
                 webInteractions.clickElement(CART_BUTTON);
                 softAssert.assertEquals(itemAmount, 2);
             }
        }
        else{
           cartVal = this.addMoisturizerToCart(products);
            int itemAmount = Integer.parseInt(driver.findElement(CART_ITEM_NUM).getText().substring(0,1));
            wait.waitForVisibility(COPY_RIGHT_TAG);

            if(itemAmount == 2){
                webInteractions.clickElement(CART_BUTTON);
                softAssert.assertEquals(itemAmount, 2);

            }

        }

        return cartVal;
    }
}
