package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * LoginPage class represents the page objects and actions for the login functionality.
 */
public class LoginPage {
    private WebDriver driver;

    // Locators for elements on the login page
    private By signInButton = By.id("signin");
    private By usernameField = By.id("react-select-2-input");
    private By passwordField = By.id("react-select-3-input");
    private By loginButton = By.id("login-btn");
    private By errorMsg = By.className("api-error");

    /**
     * Constructor to initialize LoginPage with WebDriver.
     * @param driver The WebDriver instance to use for interacting with the browser.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns the WebElement for the Sign In button.
     * @return WebElement for the Sign In button.
     */
    public WebElement getSignInButton() {
        return driver.findElement(signInButton);
    }

    /**
     * Returns the WebElement for the username field.
     * @return WebElement for the username field.
     */
    public WebElement getUsernameField() {
        return driver.findElement(usernameField);
    }

    /**
     * Returns the WebElement for the password field.
     * @return WebElement for the password field.
     */
    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    /**
     * Returns the WebElement for the Login button.
     * @return WebElement for the Login button.
     */
    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    /**
     * Returns the WebElement for the error message element.
     * @return WebElement for the error message element.
     */
    public WebElement getErrorMessage() {
        return driver.findElement(errorMsg);
    }

    /**
     * Performs login operation with given username and password.
     * @param username The username to enter in the username field.
     * @param password The password to enter in the password field.
     */
    public void login(String username, String password) {
        driver.findElement(signInButton).click(); // Click on Sign In button
        driver.findElement(usernameField).sendKeys(username); // Enter username
        driver.findElement(usernameField).sendKeys(Keys.RETURN); // Press Enter in username field
        driver.findElement(passwordField).sendKeys(password); // Enter password
        driver.findElement(passwordField).sendKeys(Keys.RETURN); // Press Enter in password field
        driver.findElement(loginButton).click(); // Click on Login button
    }
}
