package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");
       WebElement fullnameInput=driver.findElement(By.name("full_name"));
        Thread.sleep(1000);
       fullnameInput.sendKeys("Mike Smith");
        Thread.sleep(1000);
       WebElement emailInput=driver.findElement(By.name("email"));
        Thread.sleep(1000);
       emailInput.sendKeys("mike_smith@gmail.com");

       WebElement signUp=driver.findElement(By.name("wooden_spoon"));
        Thread.sleep(1000);
       signUp.click();

       WebElement messageElement=driver.findElement(By.name("signup_message"));
       String actualMessage=messageElement.getText();
        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");
        }
        driver.quit();



    }
}
