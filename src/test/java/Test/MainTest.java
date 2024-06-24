package Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import base.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelReadUtils;

/**
 * MainTest class contains test scenarios for testing ecommerce functionalities.
 */
public class MainTest extends BaseClass {

    /**
     * Test case to test various functionalities of an ecommerce site.
     * @throws InterruptedException If thread is interrupted while waiting.
     * @throws IOException If an I/O error occurs while taking screenshots.
     */
    @Test
    public void TestingFunctionalities() throws InterruptedException, IOException {
        test = extent.createTest("Check Ecommerce Functionality");

        // Initialize page objects
        LoginPage loginpage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        CheckoutPage checkoutpage = new CheckoutPage(driver);

        // Login with valid credentials
        test.info("Logging in with valid credentials");
        loginpage.login(config.getProperty("username"), config.getProperty("password"));
        waitForPageLoad(); // Wait for page to load after login
        takeScreenshot("Login Successful");
        test.pass("Login successful");

        // Select Samsung category
        test.info("Selecting Samsung category");
        homepage.selectSamsung();
        waitForPageLoad(); // Wait for page to load after selecting category
        test.pass("Samsung category selected");

        // Sort by lowest price
        test.info("Sorting by lowest price");
        homepage.sortByLowestPrice();
        waitForPageLoad(); // Wait for page to load after sorting
        test.pass("Sorted by lowest price");

        // Add item to favorites
        test.info("Adding item to favorites");
        homepage.addToFavorites();
        waitForElementToBeClickable(homepage.getAddFavoriteButton()); // Wait for element to be clickable
        test.pass("Item added to favorites");

        // Check favorite items
        test.info("Checking favorite items");
        homepage.checkFavorites();
        waitForPageLoad(); // Wait for page to load after checking favorites
        driver.navigate().back();
        test.pass("Favorite items checked");

        // Add item to cart
        test.info("Adding item to cart");
        homepage.addToCart();
        waitForElementToBeClickable(homepage.getAddToCartButton()); // Wait for element to be clickable
        test.pass("Item added to cart");

        // Increase item quantity
        test.info("Increasing item quantity");
        homepage.increaseQuantity();
        test.pass("Item quantity increased");

        // Decrease item quantity
        test.info("Decreasing item quantity");
        homepage.decreaseQuantity();
        test.pass("Item quantity decreased");

        // Proceed to checkout
        test.info("Proceeding to checkout");
        homepage.proceedToCheckout();
        waitForPageLoad(); // Wait for page to load after proceeding to checkout
        test.pass("Proceeded to checkout");

        // Fill in shipping details
        test.info("Filling in shipping details");
        checkoutpage.fillShippingDetails(config.getProperty("firstname"), config.getProperty("lastname"),
                config.getProperty("address"), config.getProperty("state"), config.getProperty("postalCode"));
        takeScreenshot("Shipping Details Filled");
        test.pass("Shipping details filled");

        // Download receipt
        test.info("Downloading receipt");
        checkoutpage.downloadReceipt();
        test.pass("Receipt downloaded");

        // Continue shopping
        test.info("Continuing shopping");
        checkoutpage.continueShopping();
        test.pass("Continued shopping");

        // View my orders
        test.info("Viewing my orders");
        homepage.viewMyOrders();
        waitForPageLoad(); // Wait for page to load after viewing orders
        takeScreenshot("My Orders");
        test.pass("My orders viewed");

        driver.navigate().back();
        waitForPageLoad(); // Wait for page to load after navigating back
        test.pass("Navigated back");

        // Logout
        test.info("Logging out");
        homepage.logout();
        test.pass("Logged out");
    }

    /**
     * Test case to test invalid login with credentials from Excel.
     * @throws IOException If an I/O error occurs while reading Excel or taking screenshots.
     */
    @Test
    public void testInvalidLogin() throws IOException {
        test = extent.createTest("Check Invalid Credentials");

        // Initialize LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Read credentials from Excel
        String excelPath = "C:\\Users\\Administrator\\Documents\\data.xlsx";
        String sheetName = "Sheet1";
        ExcelReadUtils.openExcel(excelPath, sheetName);

        String username = ExcelReadUtils.getCellValue(1, 0); // Assuming row 1 (0-indexed) is for credentials
        String password = ExcelReadUtils.getCellValue(1, 1); // Column 0 is for username, column 1 is for password

        ExcelReadUtils.closeExcel();

        // Attempt login with invalid credentials
        test.info("Attempting login with invalid credentials");
        loginPage.getSignInButton().click();
        loginPage.getUsernameField().sendKeys(username);
        loginPage.getUsernameField().sendKeys(Keys.RETURN);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getPasswordField().sendKeys(Keys.RETURN);
        loginPage.getLoginButton().click();

        test.fail("Entered Invalid Credentials");

        // Take screenshot of invalid login attempt
        takeScreenshot("Invalid Login Attempt");
    }

    /**
     * Takes a screenshot and attaches it to the Extent report.
     * @param stepDescription Description of the step for which screenshot is taken.
     * @throws IOException If an I/O error occurs while taking or saving the screenshot.
     */
    public void takeScreenshot(String stepDescription) throws IOException {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "C:\\Users\\Administrator\\eclipse-workspace\\Project\\ScreenShots\\" + stepDescription + "-" + System.currentTimeMillis() + ".png";
        Files.copy(f, new File(screenshotPath));
        test.addScreenCaptureFromPath(screenshotPath, stepDescription);
    }

    /**
     * Waits for the page to load completely.
     */
    public void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
    }

    /**
     * Waits for the specified element to be clickable.
     * @param element The WebElement to wait for.
     */
    public void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
