### README.md

````
# Java UI Testing with Selenium and Cucumber

This repository is an example for anyone interested in Java UI testing using Selenium and Cucumber.

## Setup Instructions

### Prerequisites

- Ensure you have Java installed (preferably JDK 11 or higher).
- Maven should be installed and configured on your system.

### Initial Setup

1. Clone the repository to your local machine.

```bash
git clone <repository-url>
cd <repository-directory>
````

2. Run the following Maven command to clean and install the project dependencies.

```bash
mvn clean install
```

## Running the Tests

### Using Maven Command Line

You can specify different browsers and headless mode using Maven command line flags.

#### Example Commands

- To run tests on Chrome in headless mode:

```bash
mvn test -Dbrowser=chrome -Dheadless=true
```

- To run tests on Edge with a UI:

```bash
mvn test -Dbrowser=edge -Dheadless=false
```

## Project Structure

```
src
└── test
    └── java
        ├── factory
        │   └── WebDriverFactory.java
        ├── hooks
        │   └── Hooks.java
        ├── pageobjects
        │   ├── HomePage.java
        │   └── SignInPage.java
        ├── stepdefinitions
        │   └── StepDefinitions.java
        ├── testrunners
        │   └── TestRunner.java
    └── resources
        └── features
            └── SpotifyLogin.feature
```

## Description

This project demonstrates a simple framework for UI testing using Selenium and Cucumber in Java. It includes:

- **Page Object Pattern**: For maintaining clean and maintainable code.
- **Cucumber BDD**: To define test cases in a human-readable format.
- **Selenium WebDriver**: For automating web browser interaction.

Feel free to explore the code and adapt it to your testing needs. Happy testing!
