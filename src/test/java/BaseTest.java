import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.matrix.context.ThreadWebDriver;
import org.matrix.context.WebDriverContext;
//import selenium.tests.listeners.LogListener;
//import selenium.tests.listeners.ReportListener;
//import selenium.tests.util.LoggerUtil;
//import selenium.tests.util.TestProperties;

import org.matrix.infra.TestProperties;

import java.util.concurrent.TimeUnit;

/**
 * Every test class should extend this calss.
 *
 * @Abed Zoabi
 */
public class BaseTest {

    /**
     * The driver.
     */
    protected WebDriver driver;

    /**
     * Global setup.
     */
    @BeforeSuite(alwaysRun = true)
    public void globalSetup() {
        System.out.println("************************** Test Execution Started ************************************");
        TestProperties.loadAllPropertie();
    }

    /**
     * Setup.
     */
    @BeforeClass
    protected void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.setBinary(TestProperties.getProperty("chrome_binary"));
        driver = new ChromeDriver(ops);
        ThreadWebDriver.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverContext.setDriver(driver);
    }

    /**
     * Wrap up.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
