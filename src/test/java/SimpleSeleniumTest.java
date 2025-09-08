import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class SimpleSeleniumTest extends BaseTests {


    @BeforeTest
    public void setUp() throws MalformedURLException {
        initializeDriver();
        driver.get("https://www.airbnb.com/");
    }



    @Test
    public void testCases() {

        WebElement airbnbLink = waitForElement(By.cssSelector("a[aria-label='Airbnb homepage']"),20);
        Assert.assertTrue(airbnbLink.isDisplayed(), "Airbnb homepage element not displayed!");
    }

    @AfterTest
    public void teardown() {

            if (driver != null) {
                driver.quit();
            }

    }
}





