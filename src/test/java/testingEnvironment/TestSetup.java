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
    public TestSetup(String userType) {
        this.userType = userType;
    }

    private static WebDriver driver;

    public void setUp() {
        // Initialization of Google Chrome webdriver
        System.setProperty("webdriver.chrome.driver", "D:\\atari\\Studia praca\\java\\saucedemo\\saucedemo\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void testInitialization(){
        // Opening starting site
        driver.get("https://www.saucedemo.com");

        // Website login
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(userType);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(Config.PASSWORD);

        WebElement loginButton = driver.findElement(By.id("login-buttton"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Waiting for website to be fully loaded
        wait.until(ExpectedConditions.titleIs("Swag Labs"));
        wait.until(ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
