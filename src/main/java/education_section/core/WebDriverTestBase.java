package education_section.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners({education_section.core.TestListener.class})
public class WebDriverTestBase {

    protected WebDriver driver;
    private WebDriverManager manager;
    private String browser = System.getProperty("browser", "chrome");

    @BeforeClass
    protected void setup() {

        switch (browser) {
            case "firefox": {
                manager.firefoxdriver().setup();

                //To switch off firefox notifications should do this way
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("permissions.default.desktop-notification", 1);
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability(FirefoxDriver.PROFILE, profile);
                driver = new FirefoxDriver(capabilities);
                break;
            }
            case "chrome": {
                manager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            }
        }

        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(
                PropertiesCache.getProperty("wait.page")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(
                PropertiesCache.getProperty("wait.implicit")), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Long.parseLong(
                PropertiesCache.getProperty("wait.script")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }
}

