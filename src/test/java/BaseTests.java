import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {

        protected static WebDriver driver;

        // Setup للـ driver
        public static void initializeDriver() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");


            options.setAcceptInsecureCerts(true);

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        // Explicit wait لعنصر لحد ما يبقى visible
        public WebElement waitForElement(By locator, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        // Explicit wait لعنصر لحد ما يبقى clickable
        public WebElement waitForClickable(By locator, int timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
    }

