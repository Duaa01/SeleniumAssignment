package pages.account;
import Data.Json.JsonData;
import dev.failsafe.internal.util.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.login.Login;
import utils.CustomWaits;
import utils.WebInteractions;
import csv.ReadCSV;
import java.util.List;
import static pages.locators.AccountLocators.*;
import static pages.locators.homePageLocators.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {
    WebDriver driver;
    CustomWaits wait;
    WebInteractions webInteractions;
    private  String path = "/home/duaasyed/IdeaProjects/Assignment/src/test/resources/converted_update.csv";
    Logger logger = LogManager.getLogger(Account.class);
    public Account(WebDriver driver){
        this.driver = driver;
        this.wait = new CustomWaits(driver);
        this.webInteractions = new WebInteractions(driver);
    }
    public void verifyAccountData(){

        List<String> csvData = ReadCSV.read("src/test/resources/converted_update.csv");

        wait.waitForInvisibility(subAccountNotif);
        WebElement table = driver.findElement(newAccount);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<WebElement> cells = rows.get(1).findElements(By.tagName("td")); //get the first row of table

        String name = cells.get(3).getText();
        String id = cells.get(4).getText();

        if(name.equals(csvData.get(0)) && id.equals(csvData.get(1)) ){
            System.out.print("SUCCESS!!!!!!");
            logger.info("Data matches with the Table");

        }
        else{
            System.out.println("FAILED :(");
            logger.warn("The Data doesn't match");
            logger.info("Wait 5 seconds for New Data to load");
        }
    }
    public void getAccountDetails(){
        wait.waitForVisibility(accountsNavBtn);
        webInteractions.clickElement(accountsNavBtn);

        wait.waitToBeClickable(filterInput);
        webInteractions.clickElement(filterInput);
        wait.waitForVisibility(filter);
        webInteractions.clickElement(filter);

        webInteractions.clickElement(filterInput);
        webInteractions.sendKeysToElement(filterInput, JsonData.getAccountName().getAccoutName() + Keys.ENTER);

        wait.waitForVisibility(accountName);
        webInteractions.clickElement(accountName);

        wait.waitForVisibility(accountVerify);
        webInteractions.clickElement(accountDetails);

        wait.waitForVisibility(subAccountVerify);

        wait.waitToBeClickable(importBtn);
        webInteractions.clickElement(importBtn);

        wait.waitForVisibility(importModal);
        webInteractions.sendKeysToElement(chooseBtn,path);

        wait.waitForVisibility(uploadFileBtn);
        webInteractions.clickElement(uploadFileBtn);
        wait.waitForVisibility(accountsTable);

        wait.waitForVisibility(subAccountNotif);

    }
}
