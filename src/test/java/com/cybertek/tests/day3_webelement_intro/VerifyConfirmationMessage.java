package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {

    /**
     * open browser
     * go to http://practice.cybertekschool.com/forgot_password to an external site.
     * enter any email
     * verify that email is displayed in the input box
     * click on Retrieve password
     * verify that confirmation message says 'Your e-mail's been sent!'
     */


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement emailInputbox=driver.findElement(By.name("email"));
        String expectedEmail="test@gmail.com";
        Thread.sleep(3000);

        emailInputbox.sendKeys(expectedEmail);

        //.gettext()--> works % 99, but if doesnt work use .getattribute("value")

        String actualEmail=emailInputbox.getAttribute("value");

        if (expectedEmail.equals(actualEmail)) {

            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected email: "+expectedEmail);
            System.out.println("actual email: "+ actualEmail);
        }
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        String expectedMessage="Your e-mail's been sent!";
        WebElement messageElement=driver.findElement(By.name("confirmation_message"));
        String actualMessage=messageElement.getText();
        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected message: "+ expectedMessage);
            System.out.println("Actual Message: " + actualMessage);
        }
        driver.quit();


    }
}