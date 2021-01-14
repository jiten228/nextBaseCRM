package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestCase1_5 {
    public static void main(String[] args) {
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

        //  Enter positive user name and negative user name.
       // Enter positive user password and negative user password.

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
            // Click login button
            driver.findElement(By.className("login-btn")).click();


        // TC #5 User should be on home page
        // Check if expectedURL equals actualURL

        String expectedURL = "https://login2.nextbasecrm.com/stream/";
        String expectedURL1 = "https://login2.nextbasecrm.com/stream/?login=yes";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectedURL) || actualURL.equals(expectedURL1)) {
            System.out.println("Landing page URL verification PASSED!");
        } else {
            System.err.println("Landing page URL verification FAILED!");
            System.out.println("Expected URL = " + expectedURL);
            System.out.println("Actual URL = " + actualURL);
        }
        // do log out
        driver.findElement(By.className("user-name")).click();

        // click log out button
        driver.findElement(By.linkText("Log out")).click();


        // clear user id
        driver.findElement(By.name("USER_LOGIN")).clear();

     }
    driver.close();
    }
}
