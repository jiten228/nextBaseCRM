package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_Clock_In {
    public static void main(String[] args) throws InterruptedException {
        //setup the browser driver
        WebDriverManager.chromedriver().setup();

        //this is the line that is opening the browser we select
        WebDriver driver= new ChromeDriver();

        //Go to https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");
        driver.manage().window().maximize();

        //log in, enter username and password
        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr39@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");

        driver.findElement(By.className("login-btn")).click();

        Thread.sleep(5000);

        driver.findElement(By.id("timeman-container")).click();









    }
}
