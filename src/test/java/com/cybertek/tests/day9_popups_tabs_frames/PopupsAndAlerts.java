package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");

    }

    @Test
    public void test1(){

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
        driver.findElement(By.xpath("//*[text()='No']")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get(("http://practice.cybertekschool.com/javascript_alerts"));
        driver.findElement(By.xpath("//Button[1]")).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.xpath("//Button[2]")).click();
        alert.dismiss();
        driver.findElement(By.xpath("//Button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("Mike Smith");
        //when we send keys, we might not see the text in the input box
        Thread.sleep(1000);
        alert.accept();

    }
    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
