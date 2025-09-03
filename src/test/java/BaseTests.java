import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTests {
    static ChromeDriver driver = new ChromeDriver();
    public static void waitingTime() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(250));
    }
}
