package Test;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import base.BaseClass;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class MainTest extends BaseClass {

	 @Test
	    public void TestingFunctionalities() throws InterruptedException, IOException {
	        LoginPage loginpage = new LoginPage(driver);
	        HomePage homepage = new HomePage(driver);
	        CheckoutPage checkoutpage = new CheckoutPage(driver);

	        test.info("Logging in with valid credentials");
	        loginpage.login(config.getProperty("username"), config.getProperty("password"));
	        Thread.sleep(2000);
	        takeScreenshot("Login Successful");
	        test.pass("Login successful");

	        test.info("Selecting Samsung category");
	        homepage.selectSamsung();
	        Thread.sleep(2000);
	        test.pass("Samsung category selected");

	        test.info("Sorting by lowest price");
	        homepage.sortByLowestPrice();
	        Thread.sleep(2000);
	        test.pass("Sorted by lowest price");

	        test.info("Adding item to favorites");
	        homepage.addToFavorites();
	        Thread.sleep(2000);
	        test.pass("Item added to favorites");

	        test.info("Checking favorite items");
	        homepage.checkFavorites();
	        Thread.sleep(2000);
	        driver.navigate().back();
	        test.pass("Favorite items checked");

	        test.info("Adding item to cart");
	        homepage.addToCart();
	        Thread.sleep(2000);
	        test.pass("Item added to cart");

	        test.info("Increasing item quantity");
	        homepage.increaseQuantity();
	        Thread.sleep(2000);
	        test.pass("Item quantity increased");

	        test.info("Decreasing item quantity");
	        homepage.decreaseQuantity();
	        Thread.sleep(2000);
	        test.pass("Item quantity decreased");

	        test.info("Proceeding to checkout");
	        homepage.proceedToCheckout();
	        Thread.sleep(2000);
	        test.pass("Proceeded to checkout");

	        test.info("Filling in shipping details");
	        checkoutpage.fillShippingDetails(config.getProperty("firstname"), config.getProperty("lastname"),
	                config.getProperty("address"), config.getProperty("state"), config.getProperty("postalCode"));
	        Thread.sleep(2000);
	        takeScreenshot("Shipping Details Filled");
	        test.pass("Shipping details filled");

	        test.info("Downloading receipt");
	        checkoutpage.downloadReciept();
	        Thread.sleep(2000);
	        test.pass("Receipt downloaded");

	        test.info("Continuing shopping");
	        checkoutpage.continueShopping();
	        Thread.sleep(2000);
	        test.pass("Continued shopping");

	        test.info("Viewing my orders");
	        homepage.viewMyOrders();
	        Thread.sleep(2000);
	        takeScreenshot("My Orders");
	        test.pass("My orders viewed");

	        driver.navigate().back();
	        Thread.sleep(2000);

	        test.info("Logging out");
	        homepage.logout();
	        test.pass("Logged out");
	    }

	    @Test
	    public void testInvalidLogin() {
	        LoginPage loginPage = new LoginPage(driver);

	        test.info("Attempting login with invalid credentials");
	        loginPage.getSignInButton().click();
	        loginPage.getUsernameField().sendKeys("invalidUser");
	        loginPage.getUsernameField().sendKeys(Keys.RETURN);
	        loginPage.getPasswordField().sendKeys("invalidPassword");
	        loginPage.getPasswordField().sendKeys(Keys.RETURN);
	        loginPage.getLoginButton().click();

	        WebElement errorMessage = loginPage.getErrorMessage();
	        if (errorMessage.isDisplayed()) {
	            test.pass("Error message displayed as expected");
	        } else {
	            test.fail("Error message not displayed");
	        }
	    }

	    public void takeScreenshot(String stepDescription) throws IOException {
	        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String screenshotPath = "./ScreenShorts/" + stepDescription + "-" + System.currentTimeMillis() + ".png";
	        Files.copy(f, new File(screenshotPath));
	        test.addScreenCaptureFromPath(screenshotPath, stepDescription);
	    }
}
