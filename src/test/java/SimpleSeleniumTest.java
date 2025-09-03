import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SimpleSeleniumTest extends BaseTests {
    ChromeOptions options;


    @BeforeClass
    public void setUp() {

        waitingTime();
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.setAcceptInsecureCerts(true);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/118.0.5993.90 Safari/537.36");


        waitingTime();
        WebDriverManager.chromedriver().setup();

        waitingTime();
        driver = new ChromeDriver(options);
        waitingTime();

        waitingTime();
        driver.get("https://www.booking.com/");

        waitingTime();
        driver.manage().window().fullscreen();

        waitingTime();
    }


    @Test
    public void testCases() {
        waitingTime();

        String text = driver.findElement(By.cssSelector("span[class='b98ba2834c f77a73f1ba f0a26771c4']")).getText();

        Assert.assertEquals(text,"Find your next stay","Passed Test Case!");
        System.out.println(text);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}





