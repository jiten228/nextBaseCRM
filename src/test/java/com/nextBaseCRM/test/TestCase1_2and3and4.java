package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestCase1_2and3and4 {
    public static void main(String[] args) throws InterruptedException {
        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


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

        // TC #2. Enter positive user name and negative user name.
        // TC #3. Enter positive user password and negative user password.

        /*
        Usernames:
    helpdesk39@cybertekschool.com
    helpdesk40@cybertekschool.com
    marketing39@cybertekschool.com
    marketing40@cybertekschool.com
    hr39@cybertekschool.com
    hr40@cybertekschool.com

    Password:
    UserUser
         */
        ArrayList<String> usernamesPositive = new ArrayList<String>(Arrays.asList("helpdesk39@cybertekschool.com",
                "helpdesk40@cybertekschool.com",
                "marketing39@cybertekschool.com",
                "marketing40@cybertekschool.com",
                "hr39@cybertekschool.com",
                "hr40@cybertekschool.com"));

        String password = "UserUser";


        for (String each : usernamesPositive) {
            // type User name
            driver.findElement(By.name("USER_LOGIN")).sendKeys(each);
            // type Password
            driver.findElement(By.name("USER_PASSWORD")).sendKeys(password);

            //====================================================================================

            // TC #4 Click login button
            driver.findElement(By.className("login-btn")).click();

            // do log out
            driver.findElement(By.className("user-name")).click();

            // click log out button
            driver.findElement(By.linkText("Log out")).click();


            // clear user id
            driver.findElement(By.name("USER_LOGIN")).clear();

        }

            // Enter negative user name and password.

            ArrayList<String> usernamesNegative = new ArrayList<>(Arrays.asList(
                    "helpdesk4555@cybertekschool.com",
                    "aaaaaabbbbcccc@gmail.com",
                    "marketing1000@cybertekschool.com"));

            String passwordNegative = "cyberttek";

            for (String each1 : usernamesNegative) {
                // type User name
                driver.findElement(By.name("USER_LOGIN")).sendKeys(each1);
                // type Password
                driver.findElement(By.name("USER_PASSWORD")).sendKeys(passwordNegative);

                //  Click login button
                driver.findElement(By.className("login-btn")).click();
                Thread.sleep(2000);

                // clear user id
                driver.findElement(By.name("USER_LOGIN")).clear();

                String expectedText = "Incorrect login or password";
                String actualText = driver.findElement(By.className("errortext")).getText();

                if (expectedText.equals(actualText)) {
                    System.out.println("Text verification PASSED!");
                } else {
                    System.err.println("Text verification FAILED!!!");
                    System.out.println("ExpectedText = " + expectedText);
                    System.out.println("ActualText = " + actualText);
                }
            }

         driver.close();

            driver.close();

        }
    }
