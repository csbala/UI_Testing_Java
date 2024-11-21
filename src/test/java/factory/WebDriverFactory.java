package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

    private static WebDriver webDriver;

    public WebDriver getWebDriver(boolean headless) {
        if (webDriver == null) {
            webDriver = setUpChromeDriver(headless);
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

    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            logger.info("WebDriver was closed");
        }
    }
}