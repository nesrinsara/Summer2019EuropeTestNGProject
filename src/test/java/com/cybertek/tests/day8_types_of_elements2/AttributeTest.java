package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton=driver.findElement(By.id("blue"));
        //.getAttribute();-->you put the attribute and it gives you value
        System.out.println(radioButton.getAttribute("name"));
        System.out.println(radioButton.getAttribute("id"));
        System.out.println(radioButton.getAttribute("type"));
        //if that attribute doesnt exist, it will return null
        System.out.println(radioButton.getAttribute("href"));
        //checked attr value is boolean, if it is checked it will give true
        System.out.println(radioButton.getAttribute("name"));
        //"outerHTML" will give full full html of element
        System.out.println(radioButton.getAttribute("outerHTML"));
        //3rd way of getting text "innerHTML"(certain cases)
        System.out.println(radioButton.getAttribute("innerHTML"));


    }
}
