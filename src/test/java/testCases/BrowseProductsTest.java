package testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testingEnvironment.Config;
import testingEnvironment.ErrorHandler;
import testingEnvironment.TestReportGenerator;

import java.time.LocalDate;

public class BrowseProductsTest {
    testingEnvironment.TestSetup testSetup = new testingEnvironment.TestSetup(Config.Users.STANDARD_USER);

    @Before
    // Set up test environment and start the test report
    public void setUp() {
        TestReportGenerator.startReport("D:\\atari\\Studia praca\\java\\saucedemo\\saucedemo\\src\\test\\test-output\\" + BaseTest.class.getSimpleName() + "_" + LocalDate.now() + ".html");
        testSetup.setUp();
    }

    @Test
    // Test scenario: Browsing products, adding to cart, and completing a purchase
    public void browseProductsTest_001() throws Exception {
        TestReportGenerator.createTest("Test_01");
        long startTime = System.currentTimeMillis();
        try {
            // Initialize the WebDriver and set up the test environment
            WebDriver driver = testSetup.testInitialization();

            // Main part of a test
            // Browse and add a product to the cart
            WebElement product1 = driver.findElement(By.id("item_1_title_link"));
            WebElement addToCartButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));

            product1.click();
            addToCartButton1.isDisplayed();

            // Go to the cart
            WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
            cartButton.click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("cart.html"));

            // Proceed through the purchase process (entering details, selecting delivery, payment)
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();

            // Enter details
            WebElement firstNameField = driver.findElement(By.id("first-name"));
            WebElement lastNameField = driver.findElement(By.id("last-name"));
            WebElement zipCodeField = driver.findElement(By.id("postal-code"));
            WebElement continueButton = driver.findElement(By.id("continue"));

            firstNameField.sendKeys("John");
            lastNameField.sendKeys("Doe");
            zipCodeField.sendKeys("12345");
            continueButton.click();

            // Select delivery option
            WebElement finishButton = driver.findElement(By.id("finish"));
            finishButton.click();

            // Check if the order was successfully placed
            wait.until(ExpectedConditions.urlContains("checkout-complete.html"));

            // End of a test's main part
            TestReportGenerator.pass("This test has passed.");
        } catch (Throwable e) {
            // Handle test failure and report it
            int errorLine = testSetup.errorLine(e.getStackTrace(), testSetup.getTestMethodName());
            ErrorHandler.warning(e.getMessage(), testSetup.getTestMethodName(), errorLine, startTime, System.currentTimeMillis());
            TestReportGenerator.fail("This test has failed.");
            throw new Exception();
        }
    }
    @Test
    // Test scenario: Browsing and adding products to the cart on the inventory page
    public void browseProductsTest_002() throws Exception {
        TestReportGenerator.createTest("Test_02");
        long startTime = System.currentTimeMillis();
        try {
            // Initialize the WebDriver and set up the test environment
            WebDriver driver = testSetup.testInitialization();

            // Main part of the test
            // Browse and add multiple products to the cart
            WebElement product1 = driver.findElement(By.id("item_1_title_link"));
            WebElement product2 = driver.findElement(By.id("item_2_title_link"));
            WebElement product3 = driver.findElement(By.id("item_3_title_link"));

            // Add the first product to the cart
            WebElement addToCartButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
            product1.click();
            addToCartButton1.isDisplayed();

            // Add the second product to the cart
            WebElement addToCartButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
            product2.click();
            addToCartButton2.isDisplayed();

            // Add the third product to the cart
            WebElement addToCartButton3 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
            product3.click();
            addToCartButton3.isDisplayed();

            // Go to the cart
            WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
            cartButton.click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("cart.html"));

            // Proceed through the purchase process (entering details, selecting delivery, payment)
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();

            // Enter details
            WebElement firstNameField = driver.findElement(By.id("first-name"));
            WebElement lastNameField = driver.findElement(By.id("last-name"));
            WebElement zipCodeField = driver.findElement(By.id("postal-code"));
            WebElement continueButton = driver.findElement(By.id("continue"));

            firstNameField.sendKeys("John");
            lastNameField.sendKeys("Doe");
            zipCodeField.sendKeys("12345");
            continueButton.click();

            // Select delivery option
            WebElement finishButton = driver.findElement(By.id("finish"));
            finishButton.click();

            // Check if the order was successfully placed
            wait.until(ExpectedConditions.urlContains("checkout-complete.html"));

            // End of the test's main part
            TestReportGenerator.pass("This test has passed.");
        } catch (Throwable e) {
            // Handle test failure and report it
            int errorLine = testSetup.errorLine(e.getStackTrace(), testSetup.getTestMethodName());
            ErrorHandler.warning(e.getMessage(), testSetup.getTestMethodName(), errorLine, startTime, System.currentTimeMillis());
            TestReportGenerator.fail("This test has failed.");
            throw new Exception();
        }
    }

    @Test
    // Test scenario: Browsing and adding specific products to the cart on the inventory page
    public void browseProductsTest_003() throws Exception {
        TestReportGenerator.createTest("Test_03");
        long startTime = System.currentTimeMillis();
        try {
            // Initialize the WebDriver and set up the test environment
            WebDriver driver = testSetup.testInitialization();

            // Main part of the test
            // Browse and add specific products to the cart
            WebElement product1 = driver.findElement(By.id("item_1_title_link"));
            WebElement product2 = driver.findElement(By.id("item_2_title_link"));
            WebElement product3 = driver.findElement(By.id("item_3_title_link"));

            // Add the first product to the cart
            WebElement addToCartButton1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            product1.click();
            addToCartButton1.isDisplayed();

            // Add the second product to the cart
            WebElement addToCartButton2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
            product2.click();
            addToCartButton2.isDisplayed();

            // Add the third product to the cart
            WebElement addToCartButton3 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
            product3.click();
            addToCartButton3.isDisplayed();

            // Go to the cart
            WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
            cartButton.click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.urlContains("cart.html"));

            // Proceed through the purchase process (entering details, selecting delivery, payment)
            WebElement checkoutButton = driver.findElement(By.id("checkout"));
            checkoutButton.click();

            // Enter details
            WebElement firstNameField = driver.findElement(By.id("first-name"));
            WebElement lastNameField = driver.findElement(By.id("last-name"));
            WebElement zipCodeField = driver.findElement(By.id("postal-code"));
            WebElement continueButton = driver.findElement(By.id("continue"));

            firstNameField.sendKeys("Jane");
            lastNameField.sendKeys("Smith");
            zipCodeField.sendKeys("54321");
            continueButton.click();

            // Select delivery option
            WebElement finishButton = driver.findElement(By.id("finish"));
            finishButton.click();

            // Check if the order was successfully placed
            wait.until(ExpectedConditions.urlContains("checkout-complete.html"));

            // End of the test's main part
            TestReportGenerator.pass("This test has passed.");
        } catch (Throwable e) {
            // Handle test failure and report it
            int errorLine = testSetup.errorLine(e.getStackTrace(), testSetup.getTestMethodName());
            ErrorHandler.warning(e.getMessage(), testSetup.getTestMethodName(), errorLine, startTime, System.currentTimeMillis());
            TestReportGenerator.fail("This test has failed.");
            throw new Exception();
        }
    }

    @After
    // Clean up and finalize the test report
    public void tearDown() {
        testSetup.tearDown();
        TestReportGenerator.flushReport();
    }
}
