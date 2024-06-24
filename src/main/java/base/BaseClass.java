package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ConfigReader;

/**
 * BaseClass is the base class for Selenium WebDriver initialization and ExtentReports setup.
 */
public class BaseClass 
{
	// WebDriver instance to be used across test cases
	 protected WebDriver driver;
	 
	 // ConfigReader instance to read configuration properties
	 protected ConfigReader config;
	 
	 // ExtentReports instance for generating HTML reports
	 protected ExtentReports extent;
	 
	 // ExtentTest instance to log test steps
	 protected ExtentTest test;
	 
	 // ExtentSparkReporter instance to configure HTML report details
	 protected ExtentSparkReporter htmlReporter;
	
    /**
     * Initializes configuration settings and sets up ExtentReports configuration.
     */
    @BeforeClass
    public void initConfig()
    {
    	config = new ConfigReader(); // Initialize ConfigReader to read configuration properties
    	
    	// Setup ExtentSparkReporter with basic report settings
    	htmlReporter = new ExtentSparkReporter("extentReport.html");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Functional Test Report");

        extent = new ExtentReports(); // Initialize ExtentReports
        extent.attachReporter(htmlReporter); // Attach ExtentSparkReporter to ExtentReports
    }
    
    /**
     * Sets up WebDriver instance based on configuration before each test method.
     */
    @BeforeMethod
    public void setUp() {
        String browser = config.getProperty("browser"); // Get browser name from configuration
        
        // Initialize WebDriver based on specified browser
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
            	driver = new EdgeDriver();
            	break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
        }

        driver.manage().window().maximize(); // Maximize browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait
        driver.get(config.getProperty("url")); // Navigate to application URL
    }
    
    /**
     * Tears down WebDriver after each test method execution.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Quit WebDriver instance
        }
    }
    
    /**
     * Flushes ExtentReports instance after all test suite execution.
     */
    @AfterSuite
    public void tearDownSuite() {
        if (extent != null) {
            extent.flush(); // Flush ExtentReports to write all logs to the report
        }
    }
}
