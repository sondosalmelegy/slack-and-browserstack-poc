import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

public class BaseTests {

    protected static WebDriver driver;

    // Setup للـ driver

    public static void initializeDriver() throws MalformedURLException {
        String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
        String ACCESSKEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
        String projectName = System.getenv("BROWSERSTACK_PROJECT_NAME");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.setAcceptInsecureCerts(true);

        DesiredCapabilities caps = new DesiredCapabilities();

        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("os", "OS X");
        browserstackOptions.put("osVersion", "Ventura");
        browserstackOptions.put("projectName", projectName);
        browserstackOptions.put("buildName", buildName);
        browserstackOptions.put("sessionName", "Sample Test");

        caps.setCapability("browserName", "Chrome");
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("bstack:options", browserstackOptions);

// دمج الـ ChromeOptions
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(
                new URL("https://" + USERNAME + ":" + ACCESSKEY + "@hub-cloud.browserstack.com/wd/hub"),
                caps
        );

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
