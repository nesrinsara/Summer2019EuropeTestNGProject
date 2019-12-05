package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homework8 {
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
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id='myCountry']")).sendKeys("United States of America");
        String expectedMessage="You selected: United States of America";
        String actualMessage=driver.findElement(By.xpath("//strong")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verify we got expected message");
    }
}
