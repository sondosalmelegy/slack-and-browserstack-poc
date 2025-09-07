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

        WebElement element = waitForElement(By.xpath("//*[contains(text(),'Find your next stay')]"),20);
        String text = element.getText();
        Assert.assertEquals(text,"Find your next stay","Passed Test Case!");

        System.out.println(driver.getPageSource().substring(0, 2000));
        System.out.println(text);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





