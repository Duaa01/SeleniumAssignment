package testreport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReportManager {

    private  static  ExtentReports extent;
    private static ExtentTest test;

    public static void setUpReporter(String filePath){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

}
