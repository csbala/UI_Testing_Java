package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static final String CHROME = "chrome";
    private static final String EDGE = "edge";

    private static WebDriver webDriver;

    public WebDriver getWebDriver(String browserName, boolean headless) {
        if (webDriver == null) {
            switch (browserName.toLowerCase()) {
                case CHROME:
                    webDriver = setUpChromeDriver(headless);
                    break;
                case EDGE:
                    webDriver = setUpEdgeDriver(headless);
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browserName);
            }
        }

        webDriver.manage().window().maximize();
        return webDriver;
    }

    private WebDriver setUpChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        logger.info("ChromeDriver was created");
        return new ChromeDriver(options);
    }

    private WebDriver setUpEdgeDriver(boolean headless) {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        logger.info("EdgeDriver was created");
        return new EdgeDriver(options);
    }

    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            logger.info("WebDriver was closed");
        }
    }
}