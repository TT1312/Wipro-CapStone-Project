package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

/**
 * LoginSteps class defines step definitions for login-related scenarios using Cucumber.
 */
public class LoginSteps {

    WebDriver driver; // WebDriver instance for browser interaction

    /**
     * Step definition for navigating to the login page.
     * Opens Chrome browser, maximizes window, sets implicit wait, and navigates to the login page URL.
     */
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
        driver.get("https://bstackdemo.com/?signin=true"); // Navigate to the login page URL
        driver.findElement(By.id("signin")).click(); // Click on the sign-in button
    }

    /**
     * Step definition for entering username and password.
     * @param username Username to enter into the username field.
     * @param password Password to enter into the password field.
     */
    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("react-select-2-input"));
        usernameField.sendKeys(username); // Enter username
        usernameField.sendKeys(org.openqa.selenium.Keys.RETURN); // Press Enter after entering username

        WebElement passwordField = driver.findElement(By.id("react-select-3-input"));
        passwordField.sendKeys(password); // Enter password
        passwordField.sendKeys(org.openqa.selenium.Keys.RETURN); // Press Enter after entering password
    }

    /**
     * Step definition for clicking on the login button.
     */
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click(); // Click on the login button
    }

    /**
     * Step definition for verifying the presence of an error message.
     * Prints appropriate message based on whether the error message element is displayed.
     * Quits the browser session after verification.
     */
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        WebElement errorMsg = driver.findElement(By.className("api-error"));
        if (errorMsg.isDisplayed()) {
            System.out.println("Error message displayed: Login failed");
        } else {
            System.out.println("Error message not displayed");
        }
        driver.quit(); // Quit the browser session
    }

    /**
     * Step definition for verifying successful login.
     * Prints appropriate message based on the absence of any error message elements.
     * Quits the browser session after verification.
     */
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        List<WebElement> errorMsgs = driver.findElements(By.className("api-error"));
        if (errorMsgs.isEmpty()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
        driver.quit(); // Quit the browser session
    }
}
