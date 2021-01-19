package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase9_1 {
    public static void main(String[] args) throws InterruptedException{
        // Set up web browser driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //go to https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");


        Thread.sleep(4000);
        //Enter user name
        driver.findElement(By.id("prependedInput")).sendKeys("user123");

        Thread.sleep(4000);
        //enter password
        driver.findElement(By.name("_password")).sendKeys("UserUser123");

        Thread.sleep(4000);
        // Click login button   //tagName[@attribute='value']
        driver.findElement(By.xpath("//button[@name='_submit']")).click();


        //verify login successful
        Thread.sleep(4000);

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);









    }

}
