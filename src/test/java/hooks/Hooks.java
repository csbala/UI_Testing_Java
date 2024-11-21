package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import factory.WebDriverFactory;

public class Hooks {
        private static final Logger logger = LoggerFactory.getLogger(Hooks.class);
        public static WebDriver driver;

        private WebDriverFactory factory = new WebDriverFactory();

        @Before
        public void setUp() {
                boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

                logger.info("Initializing WebDriver with headless={}", headless);
                driver = factory.getWebDriver(headless);
        }

        @After
        public void tearDown() {
                if (driver != null) {
                        factory.closeWebDriver();
                }
        }
}