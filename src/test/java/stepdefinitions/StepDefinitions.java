package stepdefinitions;

import factory.WebDriverFactory;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageobjects.HomePage;
import pageobjects.SignInPage;

public class StepDefinitions {

    private static final Logger logger = LoggerFactory.getLogger(StepDefinitions.class);

    WebDriver driver = Hooks.driver;
    WebDriverFactory factory = new WebDriverFactory();
    HomePage homePage = new HomePage(factory);
    SignInPage signInPage = new SignInPage(factory);

    @Given("I open the Spotify home page")
    public void i_open_the_spotify_home_page() {
        homePage.navigateToHomePage();
        logger.info("Opened Spotify home page");
    }

    @Then("the sign-in button should be visible")
    public void the_sign_in_button_should_be_visible() {
        boolean isVisible = homePage.isSignUpButtonVisible();
        Assert.assertTrue(isVisible);
        logger.info("Sign-in button is visible");
    }

    @When("the sign-in button is clicked")
    public void the_sign_in_button_is_clicked() {
        homePage.clickSignUpButton();
        logger.info("Sign-in button clicked");
    }

    @And("the sign-in page is opened")
    public void the_sign_in_page_is_opened() {
        boolean isVisible = signInPage.isEmailFieldVisible();
        Assert.assertTrue(isVisible);
        logger.info("Sign-in page is opened");
    }

    @And("{string} is typed into Email address field")
    public void invalid_email_is_typed_into_email_address_field(String invalidEmail) {
        signInPage.typeInvalidEmail(invalidEmail);
        logger.info("Typed invalid email: {}", invalidEmail);
    }

    @And("enter is pressed")
    public void enter_is_pressed() {
        signInPage.pressEnterKey();
        logger.info("Enter key pressed");
    }

    @Then("Error message should be visible")
    public void error_message_should_be_visible() {
        boolean isVisible = signInPage.isErrorMessageVisible();
        Assert.assertTrue(isVisible);
        logger.info("Error message is visible");
    }
}