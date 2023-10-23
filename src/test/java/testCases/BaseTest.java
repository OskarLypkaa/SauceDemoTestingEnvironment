package testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import testingEnvironment.Config;
import testingEnvironment.ErrorHandler;
import testingEnvironment.TestReportGenerator;

import java.time.LocalDate;

public class BaseTest {
    testingEnvironment.TestSetup testSetup = new testingEnvironment.TestSetup(Config.Users.STANDARD_USER);

    @Before
    public void setUp() {
        TestReportGenerator.startReport("D:\\atari\\Studia praca\\java\\saucedemo\\saucedemo\\src\\test\\test-output\\"+BaseTest.class.getSimpleName()+"_"+LocalDate.now()+".html");
        testSetup.setUp();
    }

    @Test
    public void baseTest_001() throws Exception {
        TestReportGenerator.createTest("Test_01");
        long startTime = System.currentTimeMillis();
        try {
            WebDriver driver = testSetup.testInitialization();
            // Main part of a test



            // End of a test's main part
            TestReportGenerator.pass("This test has passed.");
        }
        catch(Throwable e) {
            int errorLine = testSetup.errorLine(e.getStackTrace(), testSetup.getTestMethodName());
            ErrorHandler.warning(e.getMessage() ,testSetup.getTestMethodName(), errorLine, startTime, System.currentTimeMillis());
            TestReportGenerator.fail("This test has failed.");
            throw new Exception();
        }
    }

    @After
    public void tearDown() {
        testSetup.tearDown();
        TestReportGenerator.flushReport();
    }
}
