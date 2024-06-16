package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "F:\\wipro\\Project3\\Project\\src\\test\\java\\resources\\login.feature",
    glue = "stepDefinitions" // Package where your step definitions are located
)
public class TestRunner {

}


//C:\\Users\\Administrator\\eclipse-workspace\\Project\\src\\test\\java\\resources\\login.feature