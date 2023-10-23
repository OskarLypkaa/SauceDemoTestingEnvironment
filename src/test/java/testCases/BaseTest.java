package testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import testingEnvironment.Config;
import testingEnvironment.ErrorHandler;
import testingEnvironment.TestReportGenerator;

import java.time.LocalDate;

public class BaseTest {

    testingEnvironment.TestSetup testSetup = new testingEnvironment.TestSetup(Config.Users.STANDARD_USER);

    @Before
    public void setUp() {
        String className = BaseTest.class.getSimpleName();
        LocalDate currentDate = LocalDate.now();
        TestReportGenerator.startReport("D:\\atari\\Studia praca\\java\\saucedemo\\saucedemo\\src\\test\\test-output\\"+className+"_"+currentDate+".html");
        testSetup.setUp();
    }

    @Test
    public void baseTest_001() throws Exception {
        TestReportGenerator.createTest("Test_01");
        long startTime = System.currentTimeMillis();
        try
        {
            testSetup.testInitialization();
            // Main part of a test



            // End of a test's main part
            TestReportGenerator.pass("This test has passed.");
        } catch(Throwable e) {
            long endTime = System.currentTimeMillis();
            String methodName = testSetup.getTestMethodName();
            ErrorHandler.warning(e.getMessage() ,methodName ,startTime, endTime);
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
