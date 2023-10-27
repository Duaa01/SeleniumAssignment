package source;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class appSource {
    public static String getUrl(){
        String appUrl;
        Properties properties = new Properties();
        try (FileReader reader=new FileReader("src/test/resources/app.properties")) { // read file content
            properties.load(reader); // load the file content
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        // Get the application URL from the properties file
        appUrl = properties.getProperty("app.url");
        return appUrl;
    }
}
