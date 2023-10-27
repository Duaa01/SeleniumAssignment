package pages.locators;
import org.openqa.selenium.By;
public class AccountLocators {
    public static By filterInput = By.xpath("//input[@class='ant-input']");
    public static  By filter = By.xpath("//li[@id='downshift-multiple-item-0']");
    public static  By accountName = By.xpath(("//li[@id='downshift-multiple-item-0']"));
    public static  By accountVerify = By.xpath("//td[@title='Abdullah File Epic Testing']");
    public static By accountDetails = By.xpath("//span[@class='table-icons-group']");
    public static By subAccountVerify = By.xpath("//div[contains(@class,'tab-active')][contains(.,'Sub-Accounts')]");
    public static By importBtn = By.xpath("(//button[contains(@class,'ant-btn')])[3]");
    public static By importModal = By.xpath("//div[@class='ant-modal-content']");
    public static By chooseBtn = By.xpath("//span/input[@type='file']");
    public static By uploadFileBtn = By.xpath("(//button[contains(@class,'ant-btn-primary')])[4]");
    public static By subAccountNotif =By.xpath("//span[contains(@class,'notification-container')] ");
    public static By newAccount = By.xpath("(//table)[2]");
    public static By accountsTable = By.xpath("//div[@class='ant-table-body']");
}
