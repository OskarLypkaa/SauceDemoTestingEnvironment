package testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import testingEnvironment.Config;
import testingEnvironment.ErrorHandler;

public class BaseTest {

    testingEnvironment.TestSetup testSetup = new testingEnvironment.TestSetup(Config.Users.STANDARD_USER);
    @Before
    public void setUp() {
        testSetup.setUp();
    }

    @Test
    public void baseTest_001() {
        long startTime = System.currentTimeMillis();
        try
        {
            testSetup.testInitialization();
            // Main part of a test




            // End of a test's main part
        } catch(Throwable e) {
            String methodName = getTestMethodName();
            ErrorHandler.warning(e.getMessage() ,methodName ,startTime);
        }
    }

    @After
    public void tearDown() {
        testSetup.tearDown();
    }


    private String getTestMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            if (element.getClassName().equals(getClass().getName()) && !element.getMethodName().equals("getTestMethodName")) {
                return element.getMethodName();
            }
        }
        return "";
    }

}
