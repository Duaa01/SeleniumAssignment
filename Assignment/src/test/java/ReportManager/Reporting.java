package ReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Reporting {

    private  static  ExtentReports extent;
    private static ExtentTest test;
    public static void setUpReporter(String filePath){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void failedTest(String path){

        test.fail("Test Failed!!!", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
    }
}
