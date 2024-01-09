package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onStart(ITestContext context) {
        String fileName = ExtentReportsManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportsManager.createInstance(fullReportPath, "Test API Automation Report", "Test Execution Report");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null)
            extentReports.flush();
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName(),
                result.getMethod().getDescription());
        extentTest.set(test);
    }
}
