package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagnameTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput=driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith");

        WebElement emailInput=driver.findElement(By.name("email"));
        emailInput.sendKeys("mike_smith@gmail.com");

        WebElement signUpButton=driver.findElement(By.tagName("button"));
        signUpButton.click();
        String signUPMessage=driver.findElement(By.tagName("h3")).getText();
        System.out.println(signUPMessage);
}
}
