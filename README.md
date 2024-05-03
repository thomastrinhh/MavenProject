# CEN 4072 Software Testing Project

This repository contains the project work for the CEN 4072 Software Testing course. The project focuses on testing the login functionality of Mathway.com using Selenium with the Firefox WebDriver Browser. The tests are automated and implemented in Java.

## Project Structure

- `LoginPageTest.java`: This file contains the automated tests for the Login Page unit of chat.openai.com.
- `pom.xml`: Maven project configuration file containing dependencies required for testing.

## Setup Instructions

To run the tests locally, follow these instructions:

1. Clone this repository to your local machine:

```
git clone https://github.com/your-username/your-repository.git
```

2. Ensure you have Maven installed. If not, you can download it from [Maven's official website](https://maven.apache.org/download.cgi) and follow the installation instructions.

3. Install Chrome WebDriver. You can download it from the [official ChromeDriver website](https://sites.google.com/chromium.org/driver/). Make sure to place the driver executable in a location accessible from your system's PATH.

4. Navigate to the project directory:

```
cd your-repository
```

5. Execute Maven test command to run the tests:

```
mvn test
```

## Test Cases

### MW_1_01 Verify that landing page is functional

- Opens the landing page of chat.openai.com and verifies the title and URL.

### MW_1_02 Verify that sign-in button is functional

- Clicks the account icon and verifies the functionality of the sign-in button.

### MW_1_03 Verify that email address input field is functional

- Inputs an email address and verifies the functionality of the email address input field.

### MW_1_04 Verify that password input field is functional

- Inputs a fake password and verifies the functionality of the password input field.

### MW_1_05 Verify that unauthorized log-in credentials do not allow the user to log in

- Attempts to log in with incorrect credentials and verifies that the user is not logged in.

### MW_1_06 Verify that authorized log-in credentials allow the user to log in

- Attempts to log in with correct credentials and verifies that the user is logged in.

## Contributors

- Brett Anderson
- Thomas Trinh
