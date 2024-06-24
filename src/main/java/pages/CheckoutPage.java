package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * CheckoutPage class represents the page objects and actions for the checkout process.
 */
public class CheckoutPage {
    private WebDriver driver;

    // Locators for shipping details form fields
    By firstNameField = By.id("firstNameInput");
    By lastNameField = By.id("lastNameInput");
    By addressField = By.id("addressLine1Input");
    By stateField = By.id("provinceInput");
    By postalCodeField = By.id("postCodeInput");

    // Locator for submit button on shipping details form
    By submitButton = By.id("checkout-shipping-continue");

    // Locator for download receipt button
    By downloadReceiptButton = By.id("downloadpdf");

    // Locator for continue shopping button
    By continueShoppingButton = By.xpath("//button[@class='button button--tertiary optimizedCheckout-buttonSecondary']");

    /**
     * Constructor to initialize CheckoutPage with WebDriver.
     * @param driver The WebDriver instance to use for interacting with the browser.
     */
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Fills the shipping details form with provided information.
     * @param firstName The first name to enter in the first name field.
     * @param lastName The last name to enter in the last name field.
     * @param address The address to enter in the address field.
     * @param state The state to enter in the state field.
     * @param postalCode The postal code to enter in the postal code field.
     */
    public void fillShippingDetails(String firstName, String lastName, String address, String state, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName); // Enter first name
        driver.findElement(lastNameField).sendKeys(lastName); // Enter last name
        driver.findElement(addressField).sendKeys(address); // Enter address
        driver.findElement(stateField).sendKeys(state); // Enter state
        driver.findElement(postalCodeField).sendKeys(postalCode); // Enter postal code
        driver.findElement(submitButton).click(); // Click on submit button to proceed
    }

    /**
     * Clicks on the download receipt button.
     */
    public void downloadReceipt() {
        driver.findElement(downloadReceiptButton).click(); // Click on download receipt button
    }

    /**
     * Clicks on the continue shopping button.
     */
    public void continueShopping() {
        driver.findElement(continueShoppingButton).click(); // Click on continue shopping button
    }
}
