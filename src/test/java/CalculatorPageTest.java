//      File: CalculatorPageTest.java
// Author(s): Brett Anderson, Thomas Trinh
//      Date: 03/31/2024
//   Purpose: This file contains the tests for the Calculator (main) Page unit of mathway.com.
//            These automated web tests are performed using Selenium with the Chrome
//            WebDriver Browser.


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


public class CalculatorPageTest {
    // Initialize web driver
    WebDriver driver = new FirefoxDriver();

    // Create a JavaScriptExecutor object for scrolling
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // MW_4_01 Verify that on-screen keyboard is functional
    @Test(priority = 1)
    void verifyCalculatorTextBox() throws InterruptedException {
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
        Thread.sleep(3000);
        driver.findElement(By.id("login_email_input")).sendKeys
                ("cyna77801@5o0x6ajj.crankymonkey.info");
        // Input correct password for test account (e.g., password = '123Test')
        driver.findElement(By.id("login_password_input")).sendKeys("Test123");
        // Click 'Sign In' button after correct email and password is entered
        driver.findElement(By.xpath("//*[@id=\"__next\"]/main/section/div/aside/div/div/div/div" +
                "/div[1]/div/form/button/span/span[1]")).click();
        Thread.sleep(10000);

        // Click the 2 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the + key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(6) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 2 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);
    }

    // MW_4_02 Verify that addition is functional
    @Test(priority = 2)
    void verifyAddition() throws InterruptedException {
        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>4</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_03 Verify that subtraction is functional
    @Test(priority = 3)
    void verifySubtraction() throws InterruptedException {
        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the - key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(5) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 1 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>4</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_04 Verify that multiplication is functional
    @Test(priority = 4)
    void verifyMultiplication() throws InterruptedException {
        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the x key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(7) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 6 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=" +
                        "\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>30</mn>" +
                        "</mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");

        Thread.sleep(3000);
    }

    // MW_4_05 Verify that division is functional
    @Test(priority = 5)
    void verifyDivision() throws InterruptedException {
        // Click the 1 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 0 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the / key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(5) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(5000);

        // Click the 'Divide' option from the menu
        driver.findElement(By.xpath("//*[@data-id='13']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>2</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_06 Verify that square root is functional
    @Test(priority = 6)
    void verifySquareRoot() throws InterruptedException {
        // Click the Square Root key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(1) > div:nth-child(6) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 9 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // Click the 'Calculate the Square Root' option from the menu
        driver.findElement(By.xpath("//*[@data-id='49']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>3</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_07 Verify that 'Tap to view steps...' option is functional
    // in the chat window
    @Test(priority = 7)
    void verifyTapToViewSteps() throws InterruptedException {
        // Click the 'Tap to view steps...' button under the answer
        driver.findElements(By.className("ch-bubble-action")).getLast().click();
        Thread.sleep(5000);

        // Close the upgrade popup
        driver.findElement(By.className("popup-close")).click();
        Thread.sleep(3000);
    }

    // MW_4_08 Verify that exponents/powers are functional
    @Test(priority = 8)
    void verifyExponents() throws InterruptedException {
        // Click the 8 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the Exponent key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(6) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 2 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>64</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // Linear Algebra tests
    // MW_4_09 Verify that Domain and Range of a linear function
    // can be calculated.
    @Test(priority = 9)
    void verifyDomainRange() throws InterruptedException {
        // Click the f(x) key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(1) > div:nth-child(11) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the = key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(7) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 2 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the x key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the + key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(6) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 1 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // Click the 'Find the Domain and Range' option from the menu
        driver.findElement(By.xpath("//*[@data-id='2065']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@index='162']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@index='419']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_10 Verify that 'Tap to show graph...' option is functional
    // in the chat window
    @Test(priority = 10)
    void verifyTapToShowGraph() throws InterruptedException {
        // Click the 'Tap to show graph...' button under the last answer
        driver.findElements(By.className("ch-bubble-action")).getLast().click();
        Thread.sleep(5000);

        // Verify the graph is shown
        Assert.assertTrue(driver.findElements(By.className("GraphWrapper"))
                .getLast().isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_11 Verify that 'Tap to hide graph...' option is functional
    // in the chat window
    @Test(priority = 11)
    void verifyTapToHideGraph() throws InterruptedException {
        // Click the 'Tap to hide graph...' button under the graph
        driver.findElements(By.className("ch-bubble-action")).getLast().click();
        Thread.sleep(5000);

        // Verify the graph is no longer shown
        Assert.assertFalse(driver.findElements(By.className("GraphWrapper"))
                .getLast().isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // Close web driver after tests complete
    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
