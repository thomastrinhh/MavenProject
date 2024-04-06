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

    // MW_4_12 Verify that X and Y intercepts of a linear function
    // can be calculated.
    @Test(priority = 12)
    void verifyXYIntercepts() throws InterruptedException {
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

        // Click the 'Find the x and y Intercepts' option from the menu
        driver.findElement(By.xpath("//*[@data-id='2115']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@index='535']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@index='538']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_13 Verify that the inverse of a linear function
    // can be calculated.
    @Test(priority = 13)
    void verifyInverse() throws InterruptedException {
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

        // Click the 'Find the Inverse' option from the menu
        driver.findElement(By.xpath("//*[@data-id='2125']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@index='266']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_14 Verify that the derivative of a function
    // can be calculated.
    @Test(priority = 14)
    void verifyFirstDerivative() throws InterruptedException {
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

        // Click the 'Find the Derivative' option from the menu
        driver.findElement(By.xpath("//*[@data-id='14']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>2</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_15 Verify that the 'More...' button to expand the answer options
    // is functional.
    @Test(priority = 15)
    void verifyMoreOptions() throws InterruptedException {
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

        // Click the 'More...' button at the bottom of the 'How should I answer?' list
        driver.findElement(By.cssSelector(".topics-more")).click();
        Thread.sleep(3000);
    }

    // MW_4_16 Verify that the second derivative of a function
    // can be calculated.
    @Test(priority = 16)
    void verifySecondDerivative() throws InterruptedException {
        // Click the 'Find the Second Derivative' option from the menu
        driver.findElement(By.xpath("//*[@data-id='2097']")).click();
        Thread.sleep(5000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>0</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_17 Verify that the calculator menu button
    // is functional.
    @Test(priority = 17)
    void verifyCalculatorMenu() throws InterruptedException {
        // Click the three horizontal lines menu button
        driver.findElement(By.cssSelector(".mw-hamburger")).click();
        Thread.sleep(3000);
    }

    // MW_4_18 Verify 'Calculus' menu option is functional
    @Test(priority = 18)
    void verifyCalculusOption() throws InterruptedException {
        // Click the 'Calculus' menu option
        driver.findElement(By.cssSelector("a.menu-row:nth-child(6) > div:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    // MW_4_19 Verify that the integral of a function
    // can be calculated.
    @Test(priority = 19)
    void verifyIntegral() throws InterruptedException {
        // Click the Integral key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(1) > div:nth-child(10) > div:nth-child(2)")).click();
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

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@index='548']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_20 Verify 'Trigonometry' menu option is functional
    @Test(priority = 20)
    void verifyTrigonometryOption() throws InterruptedException {
        // Click the three horizontal lines menu button
        driver.findElement(By.cssSelector(".mw-hamburger")).click();
        Thread.sleep(3000);

        // Click the 'Trigonometry' menu option
        driver.findElement(By.cssSelector("a.menu-row:nth-child(6) > div:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    // MW_4_21 Verify that the sine of an angle
    // can be calculated.
    @Test(priority = 21)
    void verifySine() throws InterruptedException {
        // Click the Sin key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(1) > div:nth-child(9) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 0 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // If the popup window comes up asking how it should answer, select
        // the 'Evaluate' option from the menu. (Only happens sometimes)
        if (driver.findElement(By.cssSelector(".popup-container")).isDisplayed()) {
            // Click the 'Evaluate' option from the menu
            driver.findElement(By.xpath("//*[@data-id='395']")).click();
            Thread.sleep(5000);
        }

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>0.5</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_22 Verify that the cosine of an angle
    // can be calculated.
    @Test(priority = 22)
    void verifyCosine() throws InterruptedException {
        // Click the Cos key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(9) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 0 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // If the popup window comes up asking how it should answer, select
        // the 'Evaluate' option from the menu. (Only happens sometimes)
        if (driver.findElement(By.cssSelector(".popup-container")).isDisplayed()) {
            // Click the 'Evaluate' option from the menu
            driver.findElement(By.xpath("//*[@data-id='395']")).click();
            Thread.sleep(5000);
        }

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>0.86602540</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_23 Verify that the tangent of an angle
    // can be calculated.
    @Test(priority = 23)
    void verifyTangent() throws InterruptedException {
        // Click the Tan key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(9) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 0 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // If the popup window comes up asking how it should answer, select
        // the 'Evaluate' option from the menu. (Only happens sometimes)
        if (driver.findElement(By.cssSelector(".popup-container")).isDisplayed()) {
            // Click the 'Evaluate' option from the menu
            driver.findElement(By.xpath("//*[@data-id='395']")).click();
            Thread.sleep(5000);
        }

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>0.57735026</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_24 Verify that the angles of a triangle
    // can be calculated from the sides.
    @Test(priority = 24)
    void verifyTriangleTool() throws InterruptedException {
        // Click the Triangle key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(10) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 4 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button twice to get to the 'c' field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button twice to get to the 'a' field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // If the popup window comes up asking how it should answer, select
        // the 'Solve the Triangle' option from the menu. (Only happens sometimes)
        if (driver.findElement(By.cssSelector(".popup-container")).isDisplayed()) {
            // Click the 'Solve the Triangle' option from the menu
            driver.findElement(By.xpath("//*[@data-id='394']")).click();
            Thread.sleep(5000);
        }

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>36.86989764</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_25 Verify 'Linear Algebra' menu option is functional
    @Test(priority = 25)
    void verifyLinearAlgebraOption() throws InterruptedException {
        // Click the three horizontal lines menu button
        driver.findElement(By.cssSelector(".mw-hamburger")).click();
        Thread.sleep(3000);

        // Click the 'Linear Algebra' menu option
        driver.findElement(By.cssSelector("a.menu-row:nth-child(9) > div:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    // MW_4_26 Verify that the determinant of a matrix
    // can be calculated.
    @Test(priority = 26)
    void verifyMatrixTool() throws InterruptedException {
        // Click the Matrix key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(1) > div:nth-child(9) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Select the matrix size
        // Show that the size can be changed
        driver.findElement(By.cssSelector(".matrix-cells > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > div:nth-child(1)")).click();
        Thread.sleep(2000);

        // Changed to 3x3
        driver.findElement(By.cssSelector(".matrix-cells > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(3) > div:nth-child(1)")).click();
        Thread.sleep(2000);

        // Click the 'Insert' button
        driver.findElement(By.id("matrix-select")).click();
        Thread.sleep(4000);

        // Click the 4 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 4 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 4 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 3 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(4) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // If the popup window comes up asking how it should answer, select
        // the 'Find the Determinant' option from the menu. (Only happens sometimes)
        if (driver.findElement(By.cssSelector(".popup-container")).isDisplayed()) {
            // Click the 'Find the Determinant' option from the menu
            driver.findElement(By.xpath("//*[@data-id='251']")).click();
            Thread.sleep(5000);
        }

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>0</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_27 Verify 'Physics' menu option is functional
    @Test(priority = 27)
    void verifyPhysicsOption() throws InterruptedException {
        // Click the three horizontal lines menu button
        driver.findElement(By.cssSelector(".mw-hamburger")).click();
        Thread.sleep(3000);

        // Click the 'Physics' menu option
        driver.findElement(By.cssSelector("a.menu-row:nth-child(11) > div:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    // MW_4_28 Verify 'Greek Alphabet' calculator button is functional
    @Test(priority = 28)
    void verifyGreekAlphabetButton() throws InterruptedException {
        // Click the 'Greek Alphabet' calculator button
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(9) > div:nth-child(2)")).click();
        Thread.sleep(3000);

        // Close the menu
        driver.findElement(By.cssSelector(".popup-close > i:nth-child(1)")).click();
        Thread.sleep(3000);
    }

    // MW_4_29 Verify 'Trigonometric Functions' calculator button is functional
    @Test(priority = 29)
    void verifyTrigonometricFunctionsButton() throws InterruptedException {
        // Click the 'Trigonometric Functions' calculator button
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(10) > div:nth-child(2)")).click();
        Thread.sleep(3000);

        // Close the menu
        driver.findElement(By.cssSelector(".popup-container")).click();
        Thread.sleep(3000);
    }

    // MW_4_30 Verify 'Equations' calculator button is functional
    @Test(priority = 30)
    void verifyEquationsButton() throws InterruptedException {
        // Click the 'Equations' calculator button
        driver.findElement(By.cssSelector(".small")).click();
        Thread.sleep(3000);
    }

    // MW_4_31 Verify that a physics equation can be solved
    @Test(priority = 31)
    void verifyPhysicsEquation() throws InterruptedException {
        // Click the Force equation from the menu
        driver.findElement(By.cssSelector("div.equation-single:nth-child(1)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 0 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the right arrow button to get to the next field
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(1000);

        // Click the 5 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(3) > div:nth-child(3) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        //Click the 'Send' button (arrow icon)
        driver.findElement(By.cssSelector(".mw-paper-airplane")).click();
        Thread.sleep(3000);

        // Verify the result of the operation
        Assert.assertTrue(driver.findElement(By.xpath("//*[@data-mathml='<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mstyle displaystyle=\"true\"><mn>3</mn></mstyle></math>']"))
                .isDisplayed(), "The correct result was not produced.");
        Thread.sleep(3000);
    }

    // MW_4_32 Verify 'Graphing' menu option is functional
    @Test(priority = 32)
    void verifyGraphingOption() throws InterruptedException {
        // Click the three horizontal lines menu button
        driver.findElement(By.cssSelector(".mw-hamburger")).click();
        Thread.sleep(3000);

        // Click the 'Graphing' menu option
        driver.findElement(By.cssSelector("a.menu-row:nth-child(12) > div:nth-child(2)")).click();
        Thread.sleep(3000);
    }

    // MW_4_33 Verify that typing in different functions dynamically changes the
    // graph on the screen.
    @Test(priority = 33)
    void verifyGraphingScreenIsDynamic() throws InterruptedException {
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

        // Click to add another graph
        driver.findElement(By.cssSelector("#editor-number-20")).click();
        Thread.sleep(2000);

        // Click the f(x) key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(1) > div:nth-child(11) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the = key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(5) > div:nth-child(7) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the - key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(5) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the x key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(2) > div:nth-child(1) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the - key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(5) > div:nth-child(2)")).click();
        Thread.sleep(2000);

        // Click the 1 key
        driver.findElement(By.cssSelector("div.kbRow:nth-child(4) > div:nth-child(2) > div:nth-child(2)")).click();
        Thread.sleep(4000);
    }

    // MW_4_34 Verify you can zoom in and out on the graph.
    @Test(priority = 34)
    void verifyGraphZoom() throws InterruptedException {
        // Click the 'Zoom In' button
        driver.findElement(By.id("graph-zoom-in")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("graph-zoom-in")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("graph-zoom-in")).click();
        Thread.sleep(1000);

        // Click the 'Zoom Out' button
        driver.findElement(By.id("graph-zoom-out")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("graph-zoom-out")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("graph-zoom-out")).click();
        Thread.sleep(1000);
    }

    // Close web driver after tests complete
    @AfterTest
    void closeDriver() {
        driver.quit();
    }

}
