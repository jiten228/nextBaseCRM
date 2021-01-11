package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class TestCase1_1 {
    public static void main(String[] args) throws InterruptedException {

        // User Story #1 As a user, I should be able to login to the app.

        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // TC #1. Open website / go to login page: http://login2.nextbasecrm.com/
        driver.get("http://login2.nextbasecrm.com/");

        Thread.sleep(2000);

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
        driver.close();
       }
    }