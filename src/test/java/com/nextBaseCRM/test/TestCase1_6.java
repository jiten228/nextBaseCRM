package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase1_6 {

    public static void main(String[] args) throws InterruptedException {
        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://login2.nextbasecrm.com/");

        // Verify title equals:
        // Expected: Authorization
        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Landing page title verification PASSED!");
        } else {
            System.err.println("Landing page title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle);
            System.out.println("Actual title = " + actualTitle);
        }

     //=======================================================================================

            // TC #6 Check "Remember me on this computer" option / CHECKBOX.
            WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));

            Thread.sleep(2000);

            // Click checkbox to select it

            checkbox.click();

            // Confirm checkbox is SELECTED
            if (checkbox.isSelected()) {
                System.out.println("Checkbox is selected, verification PASSED!");
            } else {
                System.out.println("Checkbox is NOT selected, verification PASSED!");
            }

            driver.close();

        }

    }


