package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElemet= driver.findElement(By.id("state"));

        Select stateList=new Select(dropdownElemet);
        List<WebElement> options=stateList.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }
    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElemet = driver.findElement(By.id("state"));

        Select stateList = new Select(dropdownElemet);

        String actualOption=stateList.getFirstSelectedOption().getText();
        String expectedOption="Select a State";
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,expectedOption,"verify first selection is select a state");

        Thread.sleep(3000);
        stateList.selectByVisibleText("Texas");
        actualOption=stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Texas");

        //2.using index number
        Thread.sleep(2000);
        stateList.selectByIndex(51);
        System.out.println(stateList.getFirstSelectedOption().getText());
        actualOption=stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Wyoming");

        //3.using value of attribute
        Thread.sleep(2000);
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());


    }
}
