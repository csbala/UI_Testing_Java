Feature: Spotify Home Page

  Scenario Outline: Check error message with invalid email input
    Given I open the Spotify home page
    Then the sign-in button should be visible
    When the sign-in button is clicked
    And the sign-in page is opened
    And <invalidEmail> is typed into Email address field
    And enter is pressed
    Then Error message should be visible

    Examples:
      | invalidEmail          |
      | "invalid-email"       |
      | "@missingusername.com"|
      | "missingatsymbol.com" |
      | "invalid.@domain"     |