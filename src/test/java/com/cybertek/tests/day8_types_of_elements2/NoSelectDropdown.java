package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElemet=driver.findElement(By.id("dropdownMenuLink"));

        dropdownElemet.click();
       List<WebElement> listofLinks= driver.findElements(By.className("dropdown-item"));
        System.out.println("Number of links "+listofLinks.size());

        for(WebElement link: listofLinks){
            System.out.println("list of links "+link.getText());
        }
        //driver.findElement(By.linkText("Yahoo")).click();
        listofLinks.get(3).click();



    }
}
