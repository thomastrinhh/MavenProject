//      File: SignupPageTest.java
// Author(s): Brett Anderson, Thomas Trinh
//      Date: 03/05/2024
//   Purpose: This file contains the tests for the Sign-up page unit of mathway.com.
//            These automated web tests are performed using Selenium with the Chrome
//            WebDriver Browser.


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;


public class SignupPageTest {
    // Initialize web driver
    WebDriver driver = new FirefoxDriver();

    // Create a JavaScriptExecutor object for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // MW_2_01 Verify that sign-up button on landing page is functional
    @Test (priority = 1)
    void verifySignupButton() throws InterruptedException {
        // Open https://www.mathway.com
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
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys("test18273654@123.abc");
    }

    // MW_2_03 Verify that password input field is functional
    @Test(priority = 3)
    void verifyPasswordInput() throws InterruptedException {
        // Input test password
        driver.findElement(By.id("signup_password_input")).sendKeys("123Test");
    }

    @Test(priority = 4)
        // MW_2_0
    void verifyPasswordCriteriaDynamic() throws InterruptedException {
        // Clear text from email and password input fields
        driver.findElement(By.id("signup_email_autocomplete")).clear();
        driver.findElement(By.id("signup_password_input")).clear();

        // Input test email address (this will allow us to get the final 'Looks Good!' checkmark)
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys
                ("test18273654@123.abc");
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
    // 1. Individually locate each checkmark element by xpath
    // 2. Input the corresponding password to satisfy the given requirement
    // 3. Print whether the individual password criteria was satisfied or not along with the utilized password
    private boolean isElementPresent(String xpath, String key) {
        try {
            driver.findElement(By.id("signup_password_input")).sendKeys(key);
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // MW_2_05 Verify that invalid email prompts user to enter a valid email
    @Test(priority = 5)
    void verifyInvalidEmail() throws InterruptedException {
        // Click 'Create account' button
        driver.findElement(By.cssSelector("button.sc-1eq90u-3:nth-child(4)")).click();
        Thread.sleep(2000);

    }

    // MW_2_06 Verify that email with existing account prompts user to sign in
    @Test(priority = 6)
    void verifyExistingAccount() throws InterruptedException {
        // Clear email input field
        driver.findElement(By.id("signup_email_autocomplete")).clear();

        // Enter valid email
        driver.findElement(By.id("signup_email_autocomplete")).sendKeys("cyna77801@5o0x6ajj.crankymonkey.info");
        Thread.sleep(2000);

        // Click 'Create account' button
        driver.findElement(By.cssSelector("button.sc-1eq90u-3:nth-child(4)")).click();
        Thread.sleep(2000);

    }

    // Close web driver after login page tests complete
    @AfterTest
    void closeDriver() {
        driver.close();
    }
}
