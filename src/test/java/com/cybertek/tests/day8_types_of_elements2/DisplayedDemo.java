package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput=driver.findElement(By.id("username"));
        //if the element exist in html code,but not displayed in the page,it will give false
        System.out.println(usernameInput.isDisplayed());
        Assert.assertFalse(usernameInput.isDisplayed(),"verify username inputbox is not displayed");

        WebElement start=driver.findElement(By.cssSelector("#start>button"));
        start.click();
        Thread.sleep(5000);
        System.out.println(usernameInput.isDisplayed());
        Assert.assertTrue(usernameInput.isDisplayed(),"verify username iputbox is displayed");

    }
}
