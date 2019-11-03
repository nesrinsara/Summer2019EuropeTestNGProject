package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    /**
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password to an external site.
     * enter any email
     * click on Retrieve password
     * verify that url changed to http://practice.cybertekschool.com/email_sent
     */


    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInput=driver.findElement(By.name("email"));

        emailInput.sendKeys("email@gmail.com");

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";
        String actualUrl=driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Actual Url: "+actualUrl);
            System.out.println("Expected Url: "+ expectedUrl);
        }

        driver.quit();



    }
}