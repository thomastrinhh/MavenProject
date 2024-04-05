//      File: SettingsPageTest.java
// Author(s): Brett Anderson, Thomas Trinh
//      Date: 03/31/2024
//   Purpose: This file contains the tests for the Settings/Profile Page unit of mathway.com.
//            These automated web tests are performed using Selenium with the Chrome
//            WebDriver Browser.


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class SettingsPageTest {
    // Initialize web driver
    WebDriver driver = new FirefoxDriver();

    // Create a JavaScriptExecutor object for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // MW_3_01 Verify that Profile/Settings button on landing page is functional
    @Test(priority = 1)
    void verifySettingsButton() throws InterruptedException {
        // Open https://www.mathway.com
        driver.get("https://www.mathway.com/");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        // Click the Account icon on landing page
        driver.findElement(By.xpath("//*[@id=\"top-menu\"]/div/div[2]/div[2]/i")).click();
        Thread.sleep(3000);
        // Click the "Sign In" button from dropdown
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a[1]/div[2]")).click();
        // Input email address for test account (email = 'cyna77801@5o0x6ajj.crankymonkey.info')
        Thread.sleep(5000);
        driver.findElement(By.id("login_email_input")).sendKeys
                ("cyna77801@5o0x6ajj.crankymonkey.info");
        // Input correct password for test account (e.g., password = '123Test')
        driver.findElement(By.id("login_password_input")).sendKeys("Test123");
        // Click 'Sign In' button after correct email and password is entered
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section/div/aside/div/div/div/div" +
                "/div[1]/div/form/button/span/span[1]")).click();
        Thread.sleep(10000);

        // Click the Settings/Profile icon on landing page
        driver.findElement(By.cssSelector("i.mw:nth-child(2)")).click();
        Thread.sleep(5000);
    }

    // MW_3_02 Verify that 'Upgrade' button is functional
    @Test(priority = 2)
    void verifyUpgradeButton() throws InterruptedException {
        // Click the 'Upgrade' button on the Settings page under the Access tab
        driver.findElement(By.id("btn-upgrade")).click();
        Thread.sleep(5000);
    }

    // MW_3_03 Verify that upgrade payment plan can be changed
    @Test(priority = 3)
    void verifyUpgradePlans() throws InterruptedException {
        // Click the radial button for the other upgrade option of $39.99/year
        driver.findElement(By.cssSelector("div.radio:nth-child(3) > label:nth-child(2)")).click();
        Thread.sleep(3000);

        // Click the radial button for the original upgrade option of $9.99/month
        driver.findElement(By.cssSelector("div.radio:nth-child(1) > label:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    // MW_3_04 Verify that clicking 'Go Premium' button brings user to
    // payment screen
    @Test(priority = 4)
    void verifyGoPremium() throws InterruptedException {
        // Click the radial button for the other upgrade option of $39.99/year
        driver.findElement(By.id("go-premium")).click();
        Thread.sleep(5000);

        // Go back
        driver.navigate().back();
        Thread.sleep(5000);
    }

    // MW_3_05 Verify that the 'Email' tab is functional
    @Test(priority = 5)
    void verifyEmailTab() throws InterruptedException {
        // Click the Settings/Profile icon on landing page
        driver.findElement(By.cssSelector("i.mw:nth-child(2)")).click();
        Thread.sleep(5000);

        // Click the 'Plus' button for the Email tab
        driver.findElement(By.cssSelector("#tab-email > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    // MW_3_06 Verify that the 'contact Chegg support.' link is functional
    @Test(priority = 6)
    void verifyContactSupport() throws InterruptedException {
        // Click the 'contact Chegg support' link in the Email tab
        driver.findElement(By.linkText("contact Chegg support.")).click();
        Thread.sleep(5000);

        // Close new tab
        // Store all window handles to iterate through later
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the newly opened tab
        String newTabHandle = windowHandles.getLast();
        driver.switchTo().window(newTabHandle);
        Thread.sleep(3000);

        // Close the newly opened tab
        driver.close();
        Thread.sleep(5000);

        // Switch back to the original tab
        String originalTabHandle = windowHandles.getFirst();
        driver.switchTo().window(originalTabHandle);
        Thread.sleep(3000);
    }

    // MW_3_07 Verify that the 'Security' tab is functional
    @Test(priority = 7)
    void verifySecurityTab() throws InterruptedException {
        // Click the 'Plus' button for the Security tab
        driver.findElement(By.cssSelector("#tab-security > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    // MW_3_08 Verify that the 'open security settings on Chegg.' link is functional
    @Test(priority = 8)
    void verifySecuritySettings() throws InterruptedException {
        // Click the 'open security settings on Chegg.' link in the Security tab
        driver.findElement(By.linkText("open security settings on Chegg.")).click();
        Thread.sleep(5000);

        // Close new tab
        // Store all window handles to iterate through later
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the newly opened tab
        String newTabHandle = windowHandles.getLast();
        driver.switchTo().window(newTabHandle);
        Thread.sleep(3000);

        // Close the newly opened tab
        driver.close();
        Thread.sleep(5000);

        // Switch back to the original tab
        String originalTabHandle = windowHandles.getFirst();
        driver.switchTo().window(originalTabHandle);
        Thread.sleep(3000);
    }

    // MW_3_09 Verify that the 'Account' tab is functional
    @Test(priority = 9)
    void verifyAccountTab() throws InterruptedException {
        // Click the 'Plus' button for the Account tab
        driver.findElement(By.cssSelector("#tab-account > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    // MW_3_10 Verify that the 'data deletion request.' link is functional
    @Test(priority = 10)
    void verifyDataDeletionRequest() throws InterruptedException {
        // Click the 'data deletion request.' link in the Account tab
        driver.findElement(By.linkText("data deletion request.")).click();
        Thread.sleep(5000);

        // Close new tab
        // Store all window handles to iterate through later
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        // Switch to the newly opened tab
        String newTabHandle = windowHandles.getLast();
        driver.switchTo().window(newTabHandle);
        Thread.sleep(3000);

        // Close the newly opened tab
        driver.close();
        Thread.sleep(5000);

        // Switch back to the original tab
        String originalTabHandle = windowHandles.getFirst();
        driver.switchTo().window(originalTabHandle);
        Thread.sleep(3000);
    }

    // MW_3_11 Verify that the 'Chat' tab is functional
    @Test(priority = 11)
    void verifyChatTab() throws InterruptedException {
        // Click the 'Plus' button for the Chat tab
        driver.findElement(By.cssSelector("#tab-chat > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    // MW_3_12 Verify that the 'Clear Chat History' button is functional
    @Test(priority = 12)
    void verifyClearChatHistory() throws InterruptedException {
        // Click the 'Clear Chat History' button in the Chat tab
        driver.findElement(By.id("btn-clear-history")).click();
        Thread.sleep(5000);
    }

    // MW_3_13 Verify that the 'No' button is functional
    @Test(priority = 13)
    void verifyNoButton() throws InterruptedException {
        // Click the 'No' button in the popup
        driver.findElement(By.cssSelector(".popup-button-no")).click();
        Thread.sleep(5000);
    }

    // MW_3_14 Verify that the 'Close' button is functional
    @Test(priority = 14)
    void verifyClosePopup() throws InterruptedException {
        // Click the 'Clear Chat History' button in the Chat tab
        driver.findElement(By.id("btn-clear-history")).click();
        Thread.sleep(5000);

        // Click the 'X' button in the popup
        driver.findElement(By.cssSelector(".popup-close")).click();
        Thread.sleep(5000);
    }

    // MW_3_15 Verify that the 'Yes' button is functional
    @Test(priority = 15)
    void verifyYesButton() throws InterruptedException {
        // Click the 'Clear Chat History' button in the Chat tab
        driver.findElement(By.id("btn-clear-history")).click();
        Thread.sleep(5000);

        // Click the 'Yes' button in the popup
        driver.findElement(By.cssSelector(".popup-button-yes")).click();
        Thread.sleep(5000);
    }

    // MW_3_16 Verify that the 'OK' button is functional
    @Test(priority = 16)
    void verifyOKButton() throws InterruptedException {
        // Click the 'Yes' button in the popup
        driver.findElement(By.cssSelector(".popup-button-ok")).click();
        Thread.sleep(5000);
    }

    // MW_3_17 Verify that all tabs can be minimized
    @Test(priority = 17)
    void verifyMinimizeAllTabs() throws InterruptedException {
        // Click the 'Minus' button on the Chat tab
        driver.findElement(By.cssSelector("#tab-chat > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    // MW_3_18 Verify that 'Enter a problem...' button is functional
    @Test(priority = 18)
    void verifyEnterAProblem() throws InterruptedException {
        // Click the 'Enter a problem...' button on the Settings screen
        driver.findElement(By.cssSelector("#return-link")).click();
        Thread.sleep(10000);
    }

    // MW_3_19 Verify that the 'Sign Out' tab is functional
    @Test(priority = 19)
    void verifySignOutTab() throws InterruptedException {
        // Click the Settings/Profile icon on landing page
        driver.findElement(By.cssSelector("i.mw:nth-child(2)")).click();
        Thread.sleep(5000);

        // Click the 'Plus' button for the Sign Out tab
        driver.findElement(By.cssSelector("#tab-signout > div:nth-child(1) > div:nth-child(1)")).click();
        Thread.sleep(5000);
    }

    // MW_3_20 Verify that the 'Sign Out' button is functional
    @Test(priority = 20)
    void verifySignOutButton() throws InterruptedException {
        // Click the 'Sign Out' button on the Sign Out tab
        driver.findElement(By.id("btn-signout")).click();
        Thread.sleep(5000);
    }

    // Close web driver after tests complete
    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
