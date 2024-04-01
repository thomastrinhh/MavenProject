//      File: LoginPageTest.java
// Author(s): Brett Anderson, Thomas Trinh
//      Date: 02/28/2024
//   Purpose: This file contains the tests for the Login Page unit of mathway.com.
//            These automated web tests are performed using Selenium with the Chrome
//            WebDriver Browser.


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;


public class LoginPageTest {
    // Initialize web driver
    WebDriver driver = new FirefoxDriver();

    // Create a JavaScriptExecutor object for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // MW_1_01 Verify that landing page is functional
    @Test (priority = 1)
    void verifyLandingPageOpens() throws InterruptedException {
        // Open https://www.mathway.com and display site properties
        driver.get("https://www.mathway.com/");
        driver.manage().window().maximize();

        // Get the web page's title
        String siteTitle = driver.getTitle();
        System.out.println("Web page title: " + siteTitle);

        // Get the web page's current url
        String siteUrl = driver.getCurrentUrl();
        System.out.println("Web page URL: " + siteUrl);
        //Thread.sleep(1000);
    }

    // MW_1_02 Verify that sign-in button is functional
    @Test(priority = 2)
    void verifyLoginButton() throws InterruptedException {
        // Click the Account icon on landing page
        driver.findElement(By.xpath("//*[@id=\"top-menu\"]/div/div[2]/div[2]/i")).click();
        //Thread.sleep(1000);
        // Click the "Sign In" button from dropdown
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a[1]/div[2]")).click();
    }

    // MW_1_03 Verify that email address input field is functional
    @Test(priority = 3)
    void verifyEmailAddressInput() throws InterruptedException {
        // Input email address for test account (email = 'cyna77801@5o0x6ajj.crankymonkey.info')
        driver.findElement(By.id("login_email_input")).sendKeys
                ("cyna77801@5o0x6ajj.crankymonkey.info");
    }

    // MW_1_04 Verify that password input field is functional
    @Test(priority = 4)
    void verifyPasswordInput() throws InterruptedException {
        // Input fake password to verify password input is functional
        driver.findElement(By.id("login_password_input")).sendKeys("123Test");
    }

    // MW_1_05 Verify that unauthorized log-in credentials does not allow the user to log in
    @Test(priority = 5)
    void verifyUnauthorizedLogin() throws InterruptedException {
        // Click 'Sign In' button after incorrect password is entered
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section/div/aside/div/div/div/div" +
                "/div[1]/div/form/button/span/span[1]")).click();
        Thread.sleep(1500);
    }

    // MW_1_06 Verify that authorized log-in credentials allows the user to log in after clicking 'Sign In' button
    @Test(priority = 6)
    void verifyAuthorizedLogin() throws InterruptedException {
        // Clear all text from password input box to enter the new correct password
        driver.findElement(By.id("login_password_input")).clear();
        // Input correct password for test account (e.g., password = '123Test')
        driver.findElement(By.id("login_password_input")).sendKeys("Test123");
        // Click 'Sign In' button after correct email and password is entered
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section/div/aside/div/div/div/div" +
                "/div[1]/div/form/button/span/span[1]")).click();
    }

    // Close web driver after login page tests complete
    @AfterTest
    void closeDriver() {
        driver.close();
    }

}
