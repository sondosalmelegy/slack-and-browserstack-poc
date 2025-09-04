import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;


public class SimpleSeleniumTest extends BaseTests {


    @BeforeTest
    public void setUp() {
        initializeDriver();
        driver.get("https://www.booking.com/");
    }



    @Test
    public void testCases() {

        WebElement element = waitForElement(By.xpath("//span[text()='Find your next stay']"),20);
        String text = element.getText();
        Assert.assertEquals(text,"Find your next stay","Passed Test Case!");
        System.out.println(text);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}





