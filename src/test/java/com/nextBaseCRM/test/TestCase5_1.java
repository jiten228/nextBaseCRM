package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


        //create a Poll

        driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-vote']")).click();

        Thread.sleep(2000);

        WebElement editorFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(editorFrame);
        WebElement cursor = driver.switchTo().activeElement();
        cursor.sendKeys("There is a Poll for you.", Keys.ENTER);
        driver.switchTo().defaultContent();



        Thread.sleep(3000);
        WebElement inputQuestion = driver.findElement(By.xpath("//input[@id='question_0']"));
        inputQuestion.sendKeys("Which of them is the step of SDLC ?");

        Thread.sleep(3000);
        WebElement answer1 = driver.findElement(By.xpath("//input[@id='answer_0__0_']"));
        answer1.sendKeys("Design");

        WebElement answer2 = driver.findElement(By.xpath("//input[@id='answer_0__1_']"));
        answer2.sendKeys("Grooming Meeting");
        Thread.sleep(3000);

        WebElement answer3 = driver.findElement(By.xpath("//input[@id='answer_0__2_']"));
        answer3.sendKeys("Deploying");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@id='multi_0']")).click();
        Thread.sleep(2000);


        //    driver.findElement(By.xpath("//button[@class='ui-btn ui-btn-lg ui-btn-primary']"));


        //Answer and Vote


    }


    @AfterMethod // close driver
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);

    }

}
