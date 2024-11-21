package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import factory.WebDriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input[name='username']")
    private WebElement emailField;

    @FindBy(css = "div#username-error-message")
    private WebElement errorMessage;

    public SignInPage(WebDriverFactory factory) {
        this.driver = factory.getWebDriver(
                Boolean.parseBoolean(System.getProperty("headless", "false")));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void typeInvalidEmail(String invalidEmail) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(invalidEmail);
    }

    public void pressEnterKey() {
        emailField.sendKeys(Keys.ENTER);
    }

    public boolean isErrorMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }

    public boolean isEmailFieldVisible() {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        return emailField.isDisplayed();
    }
}