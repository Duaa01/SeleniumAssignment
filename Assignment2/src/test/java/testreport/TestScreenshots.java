package testreport;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestScreenshots {

    public static String takeScreenshot(WebDriver driver, String path){

        try {
            // Capture screenshot as Bytes
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);

            // Specify the screenshot file path
            File screenshotFile = new File(path);

            // Write the screenshot to the file
            Files.write(screenshotFile.toPath(), screenshotBytes);

            // Return the path of the saved screenshot
            return screenshotFile.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null in case of an exception
        }
    }
}
