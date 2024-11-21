package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import factory.WebDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String HOME_PAGE_URL = "https://www.spotify.com";

    @FindBy(css = "button[data-testid='signup-button']")
    private WebElement signUpButton;

    public HomePage(WebDriverFactory factory) {
        this.driver = factory.getWebDriver(System.getProperty("browser", "chrome"),
                Boolean.parseBoolean(System.getProperty("headless", "false")));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.get(HOME_PAGE_URL);
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
        signUpButton.click();
    }

    public boolean isSignUpButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        return signUpButton.isDisplayed();
    }
}