package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
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
        driver.get("http://practice.cybertekschool.com/upload");
        driver.findElement(By.name("file")).sendKeys("/Users/user/Desktop/file.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();
        System.out.println(actualFileName);
        String expectedFileName="file.txt";
      Assert.assertEquals(actualFileName,expectedFileName,"verify we got name of the file");

    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");
        String projectPath=System.getProperty("user.dir");
        String relativePath= "src/test/resources/testfile.txt";

        ///Users/user/IdeaProjects/Summer2019EuropeTestNGProject/src/test/resources/testfile.txt

        String filePath=projectPath+"/"+relativePath;
        driver.findElement(By.name("file")).sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();
        System.out.println(actualFileName);
        String expectedFileName="testfile.txt";
        Assert.assertEquals(actualFileName,expectedFileName,"verify we got name of the file");

    }
}
