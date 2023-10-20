package testingEnvironment;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReportGenerator {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void startReport(String reportPath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void createTest(String testName) {
        test.set(extent.createTest(testName));
    }

    public static void pass(String details) {
        test.get().pass(details);
    }

    public static void fail(String details) {
        test.get().fail(details);
    }

    public static void flushReport() {
        extent.flush();
    }
}
