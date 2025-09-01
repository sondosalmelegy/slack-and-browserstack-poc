import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleSeleniumTest extends BaseTests {

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        System.out.println("Starting test...");

        driver = new ChromeDriver();
        System.out.println("Starting test...");

        waitingTime();
        driver.get("https://www.booking.com/");
        System.out.println("Starting test...");

        waitingTime();
        driver.manage().window().fullscreen();
        System.out.println("Starting test...");

        waitingTime();
    }

    @Test
    public void testCases() {
        waitingTime();
        System.out.println("Starting test...");

        String text = driver.findElement(By.cssSelector("span[class='b98ba2834c f77a73f1ba f0a26771c4']")).getText();
        System.out.println("Starting test...");

        Assert.assertEquals(text,"Find your next stay","Passed Test Case!");
        System.out.println(text);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}





