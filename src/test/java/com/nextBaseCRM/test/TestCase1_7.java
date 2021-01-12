package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestCase1_7 {
    public static void main(String[] args) {
        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

<<<<<<< HEAD
=======
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

>>>>>>> origin/main
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


        // TC #7 Access to "FORGOT YOUR PASSWORD?" link page.
        driver.findElement(By.xpath("//a[@class = 'login-link-forgot-pass']")).click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //  Verify title equals:
        // Expected: Get Password

        String expectedTitle1 = "Get Password";
        String actualTitle1 = driver.getTitle();

        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println("Page \"Get Password\" title verification PASSED!");
        } else {
            System.err.println("Page \"Get Password\" title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle1);
            System.out.println("Actual title = " + actualTitle1);
        }
        driver.close();

    }

}

