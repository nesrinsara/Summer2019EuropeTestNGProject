package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1=driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        //link1.click();
        Thread.sleep(1000);
        //WebElement home= driver.findElement(By.linkText("Home"));
       // home.click();

        WebElement link6=driver.findElement(By.partialLinkText("6"));
        link6.click();
        driver.quit();
    }
}
