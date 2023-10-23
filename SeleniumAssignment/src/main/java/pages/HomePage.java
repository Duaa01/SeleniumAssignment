package pages;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    private String code, search;
    //DriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));

    WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
    private By password = By.xpath("//input[@name='loginPassword']");
    private By nextButton = By.xpath("//button[@type='submit']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void readJsonData( String filePath ){

        JSONParser parser = new JSONParser();

        try {
            //Object obj = parser.parse(new FileReader(filePath));

            JSONObject jsonObject =  (JSONObject) parser.parse(new FileReader(filePath));;

            String username = (String) jsonObject.get("username");
            //System.out.println(username);

            String password = (String) jsonObject.get("password");
            code = (String) jsonObject.get("code");
            search = (String) jsonObject.get("searchOption");
            //System.out.println(password);

            setCredentials(username,password);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public String getCode() {
        return code;
    }

    public String getSearchOption() {
        return search;
    }
 public VerifyIdentity setCredentials(String uName, String pass){

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(username));

       username.sendKeys(uName);
       driver.findElement(password).sendKeys(pass);
       driver.findElement(nextButton).click();
       //button.click();

      //wait.until(ExpectedConditions.elementToBeClickable(button)).click();

       return new VerifyIdentity(driver);
    }

}
