package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestCase5_1 {
    WebDriver driver;

    @BeforeMethod
    public void netBaseLoginPage() throws InterruptedException {
        //  Open Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://login2.nextbasecrm.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

// Verification title

        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Landing page title verification PASSED!");
        } else {
            System.err.println("Landing page title verification FAILED!");
            System.out.println("Expected title = " + expectedTitle);
            System.out.println("Actual title = " + actualTitle);
            Thread.sleep(3000);
        }
    }

    /*
    Usernames: helpdesk49@cybertekschool.com
           helpdesk50@cybertekschool.com
           marketing49@cybertekschool.com
           marketing50@cybertekschool.com
           hr49@cybertekschool.com
           hr50@cybertekschool.com
Password:  UserUser
     */


    @Test
    public void TC_5_1() throws InterruptedException {
        String userName = "helpdesk50@cybertekschool.com";
        String passWord = "UserUser";
//login
        driver.findElement(By.name("USER_LOGIN")).sendKeys(userName);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(passWord);

        driver.findElement(By.className("login-btn")).click();
        Thread.sleep(3000);


        //create a Vote

        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']")).click();

        WebElement inputMessage= driver.findElement(By.xpath("//input[@id='question_0']"));

        inputMessage.sendKeys("aaaa");





        //Answer and Vote
     /*
        WebElement answer=driver.findElement(By.xpath("//div/button[@class='bx-vote-block-inp-substitute']"));

        WebElement VoteElement=driver.findElement(By.xpath("//div/button[@class='ui-btn ui-btn-lg ui-btn-primary']"));
        VoteElement.getText();
        Thread.sleep(3000);
        VoteElement.click();
*/
    }


    @AfterMethod // close driver
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);

    }

}
