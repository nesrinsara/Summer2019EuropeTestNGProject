package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class homework6 {
    WebDriver driver;
    @BeforeMethod
    public void driverSetup(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void quit(){

    }
    @Test
    public void test1(){
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.xpath("//*[@id='email']")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//*[@href='/sign_up']")).click();

        driver.findElement(By.name("full_name")).sendKeys("John Taylor");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage=driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"verify we got expected message");
        driver.navigate().to("https://www.tempmailaddress.com/");
        
        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        String receivedMailAddress = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).getText();
        String expectedMailAddress = " do-not-reply@practice.cybertekschool.com";
        System.out.println(receivedMailAddress);
        System.out.println(expectedMailAddress);
        Assert.assertTrue(expectedMailAddress.equals(receivedMailAddress), "Verify that you have recieved an email from Cybertek");String emailTitle="Thanks for subscribing to practice.cybertekschool.com!";
        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]")).click();
         //Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
         String actualAddress = driver.findElement(By.id("odesilatel")).getText();
         String expectedAddress = "do-not-reply@practice.cybertekschool.com";
          Assert.assertEquals(actualAddress,expectedAddress,"Verify that email is from: 'do-not-reply@practice.cybertekschool.com'");
          //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
                  String actualsubject = driver.findElement(By.id("predmet")).getText();
                  String expectedsubject = "Thanks for subscribing to practice.cybertekschool.com!";
         Assert.assertEquals(actualsubject,expectedsubject,"verify we got expected subject");
         


    }
}
