package base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import utils.ConfigReader;

public class BaseClass 
{
	protected WebDriver driver;
    protected ConfigReader config;
	

    @BeforeClass
    public void setUp() throws IOException {
        config = new ConfigReader();
        String browser = config.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
            	driver = new EdgeDriver();
            
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.getProperty("url"));
    }

}

