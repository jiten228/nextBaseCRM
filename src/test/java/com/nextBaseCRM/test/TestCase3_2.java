package com.nextBaseCRM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestCase3_2 {
    public static void main(String[] args) throws InterruptedException{

        // Setup webdriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //*******************************************************************************
        // Home page Verification
        //*******************************************************************************

        String expectedTitle = "Authorization";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification has PASSED. STEP 1 COMPLETE!");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        } else {
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }

        //*******************************************************************************
        // Login with UserName = "helpdesk52@cybertekschool.com"  & Password = "UserUser"
        //*******************************************************************************
        String userName = "marketing5@cybertekschool.com";
        String passWord = "UserUser";
        driver.findElement(By.name("USER_LOGIN")).sendKeys(userName); //username
        driver.findElement(By.name("USER_PASSWORD")).sendKeys(passWord);  //password

        driver.findElement(By.className("login-btn")).click();//click login button
        Thread.sleep(2000);
        String expectedURL = "https://login2.nextbasecrm.com/stream/?login=yes";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL)) {
            System.out.println("URL HAS PASSED! For username: " + userName);
        } else {
            System.out.println("FAILED! For username: " + userName);
            System.out.println("actualURL = " + actualURL);
            System.out.println("expectedURL = " + expectedURL);
            throw new RuntimeException();
        }

        //*******************************************************************************
        // Search (find people, documents) box & assign value "cybertek"+Enter Key
        //*******************************************************************************
        ArrayList<String> negativeData = new ArrayList<String>(Arrays.asList("Cricket",
                "Donald Trump", "Chicago"));

        for (String each : negativeData) {

            WebElement searchBox = driver.findElement(By.xpath("//input[@id = 'search-textbox-input']"));
            searchBox.sendKeys(each);
            Thread.sleep(3000);
            searchBox.sendKeys(Keys.ENTER);
            System.out.println("===========================================================");
                try {
                    WebElement getElement = driver.findElement(By.id("feed-empty-wrap"));
                    if (getElement.getText().equals("Nothing found")) {
                        System.out.println("Key Word FAILED! For: " + each);
                    }
                }catch (NoSuchElementException e){
                    e.getMessage();
                }

                }
        driver.close();
    }
}