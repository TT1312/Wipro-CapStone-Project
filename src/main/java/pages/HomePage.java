package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * HomePage class represents the page objects and actions for the home page of an e-commerce site.
 */
public class HomePage 
{
    private WebDriver driver;

    // WebElements defined using @FindBy annotations
    @FindBy(xpath = "//span[normalize-space()='Samsung']")
    WebElement samsungButton;

    @FindBy(xpath = "//div[@class='sort']//select")
    WebElement dropdown;

    @FindBy(className = "MuiIconButton-label")
    WebElement addFavorite;

    @FindBy(id = "favourites")
    WebElement checkFavItems;

    @FindBy(className = "shelf-item__buy-btn")
    WebElement addToCartButton;

    @FindBy(xpath = "//button[normalize-space()='+']")
    WebElement increaseQuantityButton;

    @FindBy(xpath = "//button[normalize-space()='-']")
    WebElement decreaseQuantityButton;

    @FindBy(xpath = "//div[@class='buy-btn']")
    WebElement checkoutButton;

    @FindBy(xpath = "//strong[normalize-space()='Orders']")
    WebElement myOrdersButton;

    @FindBy(id = "logout")
    WebElement logoutButton;

    /**
     * Constructor to initialize HomePage with WebDriver and PageFactory.
     * @param driver The WebDriver instance to use for interacting with the browser.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    /**
     * Clicks on the Samsung button to select Samsung products.
     */
    public void selectSamsung() {
        samsungButton.click();
    }

    /**
     * Selects the option to sort products by lowest price from the dropdown.
     */
    public void sortByLowestPrice() {
        Select select = new Select(dropdown);
        select.selectByValue("lowestprice");
    }

    /**
     * Clicks on the Add to Favorites button.
     */
    public void addToFavorites() {
        addFavorite.click();
    }

    /**
     * Clicks on the link to check favorite items.
     */
    public void checkFavorites() {
        checkFavItems.click();
    }

    /**
     * Clicks on the Add to Cart button.
     */
    public void addToCart() {
        addToCartButton.click();
    }

    /**
     * Clicks on the button to increase the quantity of an item in the cart.
     */
    public void increaseQuantity() {
        increaseQuantityButton.click();
    }

    /**
     * Clicks on the button to decrease the quantity of an item in the cart.
     */
    public void decreaseQuantity() {
        decreaseQuantityButton.click();
    }

    /**
     * Clicks on the Checkout button to proceed to the checkout process.
     */
    public void proceedToCheckout() {
        checkoutButton.click();
    }

    /**
     * Clicks on the My Orders button to view past orders.
     */
    public void viewMyOrders() {
        myOrdersButton.click();
    }

    /**
     * Clicks on the Logout button to log out from the application.
     */
    public void logout() {
        logoutButton.click();
    }

    /**
     * Retrieves the WebElement for the Add to Favorites button.
     * @return WebElement for the Add to Favorites button.
     */
    public WebElement getAddFavoriteButton() {
        return addFavorite;
    }

    /**
     * Retrieves the WebElement for the Add to Cart button.
     * @return WebElement for the Add to Cart button.
     */
    public WebElement getAddToCartButton() {
        return addToCartButton;
    }
}
