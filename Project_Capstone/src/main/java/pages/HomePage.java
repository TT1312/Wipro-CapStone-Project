package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	WebDriver driver;

	By samsungButton = By.xpath("//span[normalize-space()='Samsung']");
	By dropdown = By.xpath("//div[@class='sort']//select");
	By addFavorite = By.className("MuiIconButton-label");
	By checkFavItems = By.id("favourites");
	By addToCartButton = By.className("shelf-item__buy-btn");
	By increaseQuantityButton = By.xpath("//button[normalize-space()='+']");
	By decreaseQuantityButton = By.xpath("//button[normalize-space()='-']");
	By checkoutButton = By.xpath("//div[@class='buy-btn']");
	By myOrdersButton = By.xpath("//strong[normalize-space()='Orders']");
	By logoutButton = By.id("logout");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSamsung() {
		driver.findElement(samsungButton).click();
	}

	public void sortByLowestPrice() 
	{
		Select select = new Select(driver.findElement(dropdown));
        select.selectByValue("lowestprice");
	}

	public void addToFavorites() 
	{
		driver.findElement(addFavorite).click();
	}

	public void checkFavorites() 
	{
		driver.findElement(checkFavItems).click();
	}

	public void addToCart() 
	{
		driver.findElement(addToCartButton).click();
	} 
	public void increaseQuantity()
	{
		driver.findElement(increaseQuantityButton).click();
	}
	public void decreaseQuantity() 
	{
        driver.findElement(decreaseQuantityButton).click();
    }

    public void proceedToCheckout() 
    {
        driver.findElement(checkoutButton).click();
    }

    public void viewMyOrders() 
    {
        driver.findElement(myOrdersButton).click();
    }

    public void logout() 
    {
        driver.findElement(logoutButton).click();
    }
}
	
	
