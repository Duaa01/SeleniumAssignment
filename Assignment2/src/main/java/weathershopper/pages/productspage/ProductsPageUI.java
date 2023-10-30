package weathershopper.pages.productspage;

import org.openqa.selenium.By;

public class ProductsPageUI {

    public static final By PRODUCTS_TASK_ICON = By.xpath("//span[contains(@class,'octicon')]");
    public static final By HEADING = By.xpath("//h2");
    public static final By PRODUCTS = By.xpath("//div[@class='text-center col-4']");
    public static final By CART_BUTTON = By.xpath("//button[contains(.,'Cart')]");
    public static final By MY_TASK_HEADING = By.xpath("//h3[@class='popover-header']");
    public static final By CART_ITEM_NUM = By.xpath("//span[@id='cart']");
    public static final By COPY_RIGHT_TAG = By.xpath("//p[@class='ws_copyright']");
}
