import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTests {

    protected static WebDriver driver;

    public static void initializeDriver() {
        try {
            String username = System.getenv("BROWSERSTACK_USERNAME");
            String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
            String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
            String projectName = System.getenv("BROWSERSTACK_PROJECT_NAME");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.setAcceptInsecureCerts(true);

            // BrowserStack capabilities
            options.setCapability("os", "Windows");
            options.setCapability("osVersion", "11");
            options.setCapability("browserName", "Chrome");
            options.setCapability("browserVersion", "latest");
            options.setCapability("Notifying Browserstack and slack", buildName);
            options.setCapability("project", projectName);
            options.setCapability("name", "Sample Test");

            driver = new RemoteWebDriver(
                    new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
                    options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack hub URL", e);
        }
    }


    public WebElement waitForElement(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
