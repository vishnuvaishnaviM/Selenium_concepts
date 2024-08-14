package com.sample.TestNG;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//listener utility files
public class TestNG10 implements ITestListener{
    public ExtentSparkReporter sparkReporter; //UI of the report
    public ExtentReports extent; //populate common info on the report
    public ExtentTest test; //creating test case entries in the report and update status of the test methods
    public void onStart(ITestContext context) { //will run only once before starting test cases execution
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional testing");
        sparkReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Vaishnavi");
        extent.setSystemInfo("os", "windows11");
        extent.setSystemInfo("Browser name", "Chrome");
    }
   public void onTestSuccess(ITestResult result) { //will run on each testcase success
    test = extent.createTest(result.getName()); //create a new entry in the report
    test.log(Status.PASS, "Test case PASSED is: " + result.getName());//update status p/f/s
   }
   public void onTestFailure(ITestResult result) { // will run on each test case failure
    test = extent.createTest(result.getName());
    test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
    test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());
   }
   public void onTestSkipped(ITestResult result) { //will run when a test case is skipped
    test = extent.createTest(result.getName());
    test.log(Status.SKIP, "Test case SKIPPED is: " + result.getName());
   }
   public void onFinish(ITestContext context) {
    extent.flush();
   }
}
