package testingEnvironment;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSetup {
    private String userType;
    public static WebDriver driver;

    public TestSetup(String userType) {
        this.userType = userType;
    }

    // Initialize the WebDriver (ChromeDriver)
    public void setUp() {
        // Initialization of Google Chrome webdriver
        System.setProperty("webdriver.chrome.driver", "D:\\atari\\Studia praca\\java\\saucedemo\\saucedemo\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    // Initialize the test environment and perform login
    public WebDriver testInitialization() {
        // Opening starting site
        driver.get("https://www.saucedemo.com");

        // Website login
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(userType);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(Config.PASSWORD);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Waiting for the website to be fully loaded
        wait.until(ExpectedConditions.titleIs("Swag Labs"));
        wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));

        return driver;
    }

    // Get the name of the currently executing test method
    public String getTestMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement element = stackTrace[i];
            if (element.getClassName().startsWith("testCases.") && !element.getMethodName().equals("getTestMethodName")) {
                return element.getMethodName();
            }
        }
        return "";
    }

    // Get the line number in the code where an error occurred for a specific test method
    public int errorLine(StackTraceElement[] stackTrace, String methodName) {
        for (StackTraceElement element : stackTrace) {
            if (element.getMethodName() == methodName) {
                return element.getLineNumber();
            }
        }
        return 0;
    }

    @After
    // Close the WebDriver after the test
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
