//      File: SignupPageTest.java
// Author(s): Brett Anderson, Thomas Trinh
//      Date: 03/31/2024
//   Purpose: This file contains the tests for the Sign Up Page unit of mathway.com.
//            These automated web tests are performed using Selenium with the Chrome
//            WebDriver Browser.


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;
import java.util.List;
import java.util.NoSuchElementException;


public class SignupPageTest {
    // Initialize web driver
    WebDriver driver = new FirefoxDriver();
    // Create a JavaScriptExecutor object for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // MW_2_01 Verify that sign-up button on landing page is functional
    @Test (priority = 1)
    void verifySignupButton() throws InterruptedException {
        // Open https://www.mathway.com and display site properties
        driver.get("https://www.mathway.com/");
        driver.manage().window().maximize();

        // Click the Account icon on landing page
        driver.findElement(By.xpath("//*[@id=\"top-menu\"]/div/div[2]/div[2]/i")).click();
        //Thread.sleep(1000);
        // Click the "Sign Up" button from dropdown
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a[2]/div[2]")).click();
    }

    // MW_2_02 Verify that email address input is functional
    @Test (priority = 2)
    void verifyEmailAddressInput() {
        // Input test email
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys
                ("testemail@domain.org");
    }

    // MW_2_03 Verify that password input field is functional
    @Test(priority = 3)
    void verifyPasswordInput() throws InterruptedException {
        // Input test password
        driver.findElement(By.id("signup_password_input")).sendKeys("123Test");

        // Clear text from password input field
        driver.findElement(By.id("signup_password_input")).clear();
    }

    // MW_2_04 Verify that an email already linked to an account will prompt the user to log in
    @Test(priority = 4)
    void verifyInvalidEmail() throws InterruptedException {
        driver.findElement(By.id("signup_email_autocomplete")).clear();
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys
                ("test");
        Thread.sleep(2000);
        driver.findElement(By.id("signup_email_autocomplete")).clear();

    }

    // MW_2_05 Verify that an email already linked to an account will prompt the user to log in
    @Test(priority = 5)
    void verifyExistingEmail() throws InterruptedException {
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys("testemail@domain.org");
        Thread.sleep(2000);
        driver.findElement(By.id("signup_email_autocomplete")).clear();

    }

    // MW_2_06 Verify that password requirement criteria is dynamic and
    // provides real-time updates as user meets password criteria
    @Test(priority = 6)
    void verifyPasswordCriteriaDynamic() throws InterruptedException {
        Thread.sleep(2000);
        // Input test email address (this will allow us to get the final 'Looks Good!' checkmark)
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys
                ("testemail_2@domain.org");
        // Click on sign up password input field to generate dynamic password criteria
        driver.findElement(By.id("signup_password_input")).click();
        Thread.sleep(1000);

        // Test the presence of the first checkmark (6 characters minimum requirement):
        boolean firstCheckmarkPresent = isElementPresent("svg.icon__Icon-sc-18q4eit-0:nth-child(1)", "aaaaaa");
        Assert.assertTrue(firstCheckmarkPresent, "First checkmark not present.");


        // Test the presence of the second checkmark (Upper/lower case letter requirement):
        boolean secondCheckmarkPresent = isElementPresent("li.sc-li3k8m-1:nth-child(2) > svg:nth-child(1)", "A");
        Assert.assertTrue(secondCheckmarkPresent, "Second checkmark not present.");

        // Test the presence of the third checkmark (Number or punctuation requirement):
        boolean thirdCheckmarkPresent = isElementPresent(".sc-1w81iwp-0", "!");
        Assert.assertTrue(thirdCheckmarkPresent, "Third checkmark not present.");
    }

    // Helper function to:
    // 1. Individually locate each checkmark element by cssSelector
    // 2. Input the corresponding password to satisfy the given requirement
    private boolean isElementPresent(String cssSelector, String key) {
        try {
            driver.findElement(By.id("signup_password_input")).sendKeys(key);
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(cssSelector));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // MW_2_07 Verify that a valid email address and valid password will allow the user to create an account
    @Test(priority = 7)
    void verifyAccountCreation() throws InterruptedException {
        // Clear previous input fields
        driver.findElement(By.id("signup_email_autocomplete")).clear();
        driver.findElement(By.id("signup_password_input")).clear();

        // Generating random numbers between[10000, 99999] and appending to different email address components
        // Allows this test case to be run multiple times without issues relating to repeated email addresses
        Random random = new Random();
        String firstRandomNumber = String.valueOf(random.nextInt(90000) + 10000);
        String secondRandomNumber = String.valueOf(random.nextInt(90000) + 10000);
        String email = "testemail_" + firstRandomNumber + "@testdomain" + secondRandomNumber + ".org";

        driver.findElement(By.id("signup_email_autocomplete")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("signup_password_input")).sendKeys("aaaaA!");
        driver.findElement(By.xpath("/html/body/div[1]/main/section/div/aside/div/div/div/div/div[1]" +
                "/div/form/button")).click();
    }

    // Close web driver after tests complete
    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
