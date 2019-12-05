package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class homework7 {
    WebDriver driver;
    @BeforeMethod
    public void driverSetup(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void quit(){
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[text()='File Upload']")).click();
        ///Users/user/Desktop/text.text
        //Step 3. Upload any file with .txt extension from your computer.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("/Users/user/Desktop/text.text");

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();
        //Step 5. Verify that subject is: “File Uploaded!”
        String actualSubject = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();
        String expectedSubject = "File Uploaded!";
        Assert.assertEquals(actualSubject,expectedSubject,"verify subject is file uploaded");
        //Step 6. Verify that uploaded file name is displayed.
        WebElement uploaded = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(uploaded.isDisplayed(),"verify that uploaded file name is diplayed ");
    }
}
