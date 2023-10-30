package utils.json;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileReader;

public class JsonData {
    private final static String JSON_PATH = "src/test/resources/data.json";
    static Logger logger = LogManager.getLogger(JsonData.class);

    private static JSONObject readJson(String key) {

        logger.info("Reading Json File");

        JSONObject obj = null;

        try {
            JSONTokener tokener = new JSONTokener(new FileReader(JSON_PATH));
            obj = new JSONObject(tokener).getJSONObject(key);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unable to read the File", e.getMessage());
        }

        return obj;
    }
    public static PaymentDetails getCredentials()  {

        logger.info("Fetch Login Data from SignIn Object");

        JSONObject data = readJson("Payment");

        PaymentDetails payment = new PaymentDetails();

        payment.setEmail(data.getString("email"));
        payment.setCardNum(data.getString("cardNum"));
        payment.setExpDate(data.getString("expDate"));
        payment.setcVC(data.getString("CVC"));
        payment.setZipCode(data.getString("zip"));

        return payment;
    }
}

