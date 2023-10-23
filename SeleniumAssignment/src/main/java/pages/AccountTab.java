package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountTab {

    WebDriver driver;
    public AccountTab(WebDriver driver){
        this.driver = driver;
    }

    WebElement dropdown = driver.findElement(By.xpath("//section[@class='input-with-dropdown-container']"));

//    public void selectOption(String option){
//        //getDropdown().getOptions();
//        Select select = new Select(dropdown);
//        // select an item with text visible
//        select.selectByVisibleText(option);
//        // get selected option with getFirstSelectedOption() with its text
//        WebElement op = select.getFirstSelectedOption();
//    }
//    public Select getDropdown() {
//        return new Select(dropdown);
//    }
}
