import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;


public class SimpleSeleniumTest extends BaseTests {


    @BeforeTest
    public void setUp() throws MalformedURLException {
        initializeDriver();
        driver.get("https://www.booking.com/index.en-gb.html");
    }



    @Test
    public void testCases() {

        WebElement pageOutline = waitForElement(By.id("flights"),60);
        Assert.assertTrue(pageOutline.isDisplayed(), "Booking Opened Successfully!");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





