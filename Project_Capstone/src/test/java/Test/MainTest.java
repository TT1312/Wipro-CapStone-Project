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

		loginpage.login(config.getProperty("username"), config.getProperty("password"));
		Thread.sleep(2000);
		
		//File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Files.copy(f, new File("C:\\Users\\HP\\eclipse-workspace\\Project_Capstone\\ScreenShorts\\login.png"));
	

		homepage.selectSamsung();
		Thread.sleep(2000);

		homepage.sortByLowestPrice();
		Thread.sleep(2000);

		homepage.addToFavorites();
		Thread.sleep(2000);

		homepage.checkFavorites();
		Thread.sleep(2000);
		driver.navigate().back();

		homepage.addToCart();
		Thread.sleep(2000);

		homepage.increaseQuantity();
		Thread.sleep(2000);

		homepage.decreaseQuantity();
		Thread.sleep(2000);

		homepage.proceedToCheckout();
		Thread.sleep(2000);

		checkoutpage.fillShippingDetails(config.getProperty("firstname"), config.getProperty("lastname"),
				config.getProperty("address"), config.getProperty("state"), config.getProperty("postalCode"));
		Thread.sleep(2000);

		checkoutpage.downloadReciept();
		Thread.sleep(2000);

		checkoutpage.continueShopping();
		Thread.sleep(2000);

		homepage.viewMyOrders();
		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);

		homepage.logout();
	}

	@Test
	public void testInvalidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);

		loginPage.getSignInButton().click();
		loginPage.getUsernameField().sendKeys("invalidUser");
		loginPage.getUsernameField().sendKeys(Keys.RETURN);
		loginPage.getPasswordField().sendKeys("invalidPassword");
		loginPage.getPasswordField().sendKeys(Keys.RETURN);
		loginPage.getLoginButton().click();

		WebElement errorMessage = loginPage.getErrorMessage();
		System.out.println(errorMessage.isDisplayed());

	}

	

}
