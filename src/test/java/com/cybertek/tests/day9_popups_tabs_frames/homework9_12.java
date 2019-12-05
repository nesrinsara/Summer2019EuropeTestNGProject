package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework9_12 {
    WebDriver driver;
    @BeforeMethod
    public void driverSetup(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.xpath("//*[@href='status_codes/200']")).click();
        String epectedMessage="This page returned a 200 status code";
        String actualMessage=driver.findElement(By.xpath("//p")).getText();
        System.out.println(actualMessage);
        if(actualMessage.contains(epectedMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
    @Test
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.xpath("//*[@href='status_codes/301']")).click();
        String epectedMessage="This page returned a 301 status code";
        String actualMessage=driver.findElement(By.xpath("//p")).getText();
        System.out.println(actualMessage);
        if(actualMessage.contains(epectedMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.xpath("//*[@href='status_codes/404']")).click();
        String epectedMessage="This page returned a 404 status code";
        String actualMessage=driver.findElement(By.xpath("//p")).getText();
        System.out.println(actualMessage);
        if(actualMessage.contains(epectedMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.xpath("//*[@href='status_codes/500']")).click();
        String epectedMessage="This page returned a 500 status code";
        String actualMessage=driver.findElement(By.xpath("//p")).getText();
        System.out.println(actualMessage);
        if(actualMessage.contains(epectedMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
}
