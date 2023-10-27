package Data.Json;
import Data.AccountName;
import Data.LoginCredentials;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;

public class JsonData {
    private final static String JSON_PATH = "src/test/resources/data.json";
    static Logger logger = LogManager.getLogger(JsonData.class);
    private static JSONObject readJson(String key)  {

        logger.info("Reading Json File");

        JSONObject obj = null;

            try {
                JSONTokener tokener = new JSONTokener(new FileReader(JSON_PATH));
                obj = new JSONObject(tokener).getJSONObject(key);
            }
            catch (Exception e){
                e.printStackTrace();
                logger.error("Unable to read the File", e.getMessage());
            }

            return obj;
        }

    public static LoginCredentials getCredentials()  {

        logger.info("Fetch Login Data from SignIn Object");

        JSONObject credentials = readJson("SignIn");

        LoginCredentials loginCredentials = new LoginCredentials();

        loginCredentials.setUsername(credentials.getString("username"));
        loginCredentials.setPassword(credentials.getString("password"));
        loginCredentials.setCode(credentials.getString("code"));

        return loginCredentials;
    }
    public static AccountName getAccountName() {

        logger.info("Fetch Login Data from Accounts Object");

        JSONObject account = readJson("Accounts");

        AccountName accountName = new AccountName();

        accountName.setAccoutName(account.getString("name"));

        return accountName;
    }

}


