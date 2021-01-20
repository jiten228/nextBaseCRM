package com.nextBaseCRM.test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class TestCase4 {

    WebDriver driver;
    Faker faker = new Faker();

    @BeforeMethod
    public void setupClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/stream/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }
    // User Story: As a user, I should be able to create a poll.
    @Test
    public void testG20_61() throws InterruptedException {
        //Verify users can write a poll message

        String[] userNames = {"helpdesk39@cybertekschool.com",
              "helpdesk40@cybertekschool.com",
              "marketing39@cybertekschool.com",
              "marketing40@cybertekschool.com",
              "hr39@cybertekschool.com",
              "hr40@cybertekschool.com"
        };

        for (String each : userNames) {
            Thread.sleep(1000);
            driver.findElement(By.name("USER_LOGIN")).sendKeys(each);
            Thread.sleep(1000);
            driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
            driver.findElement(By.className("login-btn")).click();

            WebElement buttonPoll = driver.findElement(By.xpath("//span[.='Poll']"));
            buttonPoll.click();

            WebElement editorFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
            driver.switchTo().frame(editorFrame);
            WebElement title = driver.findElement(By.xpath("//body[@style='min-height: 119px;']"));
            String titleName = faker.funnyName().name();
            title.sendKeys(titleName);
            driver.switchTo().defaultContent();

            driver.findElement(By.xpath("//input[@id='question_0']")).sendKeys("Which character do you like Harry Pother?");
            String answer1 = faker.harryPotter().character();
            String answer2 = faker.harryPotter().character();

            driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys(answer1);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys(answer2);
            Thread.sleep(1000);
            WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
            sendButton.click();
            Thread.sleep(2000);
/*
            WebElement afterSaveTitle = driver.findElement(By.xpath("//div[starts-with(@id,'blog_post_body_')]"));
            Assert.assertTrue(afterSaveTitle.isDisplayed(), "Title save is failed");
            WebElement afterSavePoolQuestion=driver.findElement(By.xpath("//div[@class='bx-vote-question-title']"));
            Assert.assertTrue(afterSavePoolQuestion.isDisplayed(), "Pool question save is failed");
            WebElement afterSaveAnswer1 = driver.findElement(By.xpath("//label[starts-with(@for,'vote_radio')]"));
            Assert.assertTrue(afterSaveAnswer1.isDisplayed(),"Pool answer save is failed");
            WebElement afterSaveAnswer2 = driver.findElement(By.xpath("//label[@for='vote_radio_355_862']"));
            Assert.assertTrue(afterSaveAnswer2.isDisplayed(),"Pool answer save is failed");

*/
            driver.findElement(By.xpath("//span[@id='user-name']")).click();
            driver.findElement(By.xpath("//span[.='Log out']")).click();

            WebElement userLogin = driver.findElement(By.name("USER_LOGIN"));
            userLogin.clear();



        }

    }

    @Test
    public void testG20_99() throws InterruptedException {
    //Verify users can write a poll message without with title(question & answer)-Negative Test
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk40@cybertekschool.com");
        Thread.sleep(500);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        WebElement buttonPoll = driver.findElement(By.xpath("//span[.='Poll']"));
        buttonPoll.click();


        String answer1 = faker.harryPotter().book();
        String answer2 = faker.harryPotter().book();

        driver.findElement(By.xpath("//input[@id='question_0']")).sendKeys("Which book did you read?");
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys(answer1);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys(answer2);
        WebElement sendButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
        sendButton.click();
        WebElement titleMessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));

        String expectedTitleMessage = "The message title is not specified";

        Assert.assertEquals(titleMessage.getText(), expectedTitleMessage, "The message is not equal");
        Thread.sleep(2000);

    }

    @Test
    public void testG20_62() throws InterruptedException {
    //Verify users can check "allow multiple Choice"
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk40@cybertekschool.com");
        Thread.sleep(500);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        WebElement buttonPoll = driver.findElement(By.xpath("//span[.='Poll']"));
        buttonPoll.click();

        WebElement editorFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(editorFrame);
        WebElement title = driver.findElement(By.xpath("//body[@style='min-height: 119px;']"));
        String titleName = faker.ancient().hero();
        title.sendKeys(titleName);
        driver.switchTo().defaultContent();

        String answer1 = faker.animal().name();
        String answer2 = faker.animal().name();

        driver.findElement(By.xpath("//input[@id='question_0']")).sendKeys("What is your favorite animal?");
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys(answer1);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys(answer2);
        WebElement allowMultipleChoiceButton = driver.findElement(By.className("vote-checkbox"));
        Thread.sleep(1000);
        allowMultipleChoiceButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(allowMultipleChoiceButton.isSelected(), "Allow multiple choice is not selected");
    }

    @Test
    public void testG20_63() throws InterruptedException {
      //Verify users can add questions
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk40@cybertekschool.com");
        Thread.sleep(500);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        WebElement buttonPoll = driver.findElement(By.xpath("//span[.='Poll']"));
        buttonPoll.click();

        WebElement editorFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(editorFrame);
        WebElement title = driver.findElement(By.xpath("//body[@style='min-height: 119px;']"));
        String titleName = faker.country().name();
        title.sendKeys(titleName);
        driver.switchTo().defaultContent();

        String answer1 = faker.artist().name();
        String answer2 = faker.artist().name();

        driver.findElement(By.xpath("//input[@id='question_0']")).sendKeys("What is your favorite artist?");
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys(answer1);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys(answer2);

        WebElement addQuestion = driver.findElement(By.linkText("Add question"));
        addQuestion.click();
        Assert.assertTrue(addQuestion.isEnabled(), "Add question is not clickable");

        String answer3 = faker.color().name();
        String answer4 = faker.color().name();

        driver.findElement(By.xpath("//input[@id='question_1']")).sendKeys("What is your favorite color");
        driver.findElement(By.xpath("//input[@id='answer_1__0_']")).sendKeys(answer3);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='answer_1__1_']")).sendKeys(answer4);

    }

    @Test
    public void testG20_64() throws InterruptedException {
       //Verify users can cancel poll
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk40@cybertekschool.com");
        Thread.sleep(500);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        driver.findElement(By.className("login-btn")).click();

        WebElement buttonPoll = driver.findElement(By.xpath("//span[.='Poll']"));
        buttonPoll.click();

        WebElement editorFrame = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(editorFrame);
        WebElement title = driver.findElement(By.xpath("//body[@style='min-height: 119px;']"));
        String titleName = faker.company().name();
        title.sendKeys(titleName);
        driver.switchTo().defaultContent();

        String answer1 = faker.programmingLanguage().name();
        String answer2 = faker.programmingLanguage().name();


        driver.findElement(By.xpath("//input[@id='question_0']")).sendKeys("What is your programming language?");
        driver.findElement(By.xpath("//input[@id='answer_0__0_']")).sendKeys(answer1);
        driver.findElement(By.xpath("//input[@id='answer_0__1_']")).sendKeys(answer2);
        Thread.sleep(1000);

        WebElement cancelButton = driver.findElement(By.xpath("//button[@id='blog-submit-button-cancel']"));
        cancelButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(cancelButton.isEnabled(), "Cancel button is not clickable");


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(1000);

        driver.close();

    }

}


