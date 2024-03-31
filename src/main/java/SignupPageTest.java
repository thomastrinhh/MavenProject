import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;
import java.util.NoSuchElementException;

public class SignupPageTest {
    // Initialize web driver
    WebDriver driverChrome = new FirefoxDriver();
    // Create a JavaScriptExecutor object for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driverChrome;

    @Test (priority = 1)
    // MW_2_01 Verify that sign-up button on landing page is functional
    void verifySignupButton() throws InterruptedException {
        // Open https://www.mathway.com and display site properties
        driverChrome.get("https://www.mathway.com/");
        driverChrome.manage().window().maximize();

        // Click the Account icon on landing page
        driverChrome.findElement(By.xpath("//*[@id=\"top-menu\"]/div/div[2]/div[2]/i")).click();
        //Thread.sleep(1000);
        // Click the "Sign Up" button from dropdown
        driverChrome.findElement(By.xpath("//*[@id=\"user-menu\"]/a[2]/div[2]")).click();
    }
    @Test (priority = 2)
    // MW_2_02 Verify that email address input is functional
    void verifyEmailAddressInput() {
        // Input test email
        driverChrome.findElement(By.id("signup_email_autocomplete")).sendKeys
                ("testemail@domain.org");
    }
    @Test(priority = 3)
    // MW_2_03 Verify that password input field is functional
    void verifyPasswordInput() throws InterruptedException {
        // Input test password
        driverChrome.findElement(By.id("signup_password_input")).sendKeys("123Test");

        // Clear text from password input field
        driverChrome.findElement(By.id("signup_password_input")).clear();
    }

    @Test(priority = 4)
        // MW_2_0
    void verifyPasswordCriteriaDynamic() throws InterruptedException {
        // Reload page
        driverChrome.navigate().refresh();

        // Input test email address (this will allow us to get the final 'Looks Good!' checkmark)
        driverChrome.findElement(By.id("signup_email_autocomplete")).sendKeys
                ("testemail@domain.org");
        // Click on sign up password input field to generate dynamic password criteria
        driverChrome.findElement(By.id("signup_password_input")).click();
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
            driverChrome.findElement(By.id("signup_password_input")).sendKeys(key);
            Thread.sleep(2000);
            driverChrome.findElement(By.cssSelector(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
