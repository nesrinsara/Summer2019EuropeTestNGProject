package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {


    WebDriver driver;
    @BeforeMethod
    public void driverSetup(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void click() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        WebElement link=driver.findElement(By.linkText("Dropdown"));
        //if you cannot click because of any issue
        //create your javascript object
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",link);

    }

    @Test
    public void type() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputBox=driver.findElement(By.cssSelector("input[type='text]"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;
        String str="hello disable inputbox";
        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputBox);


    }

    @Test
    public void scrollDown() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse=(JavascriptExecutor)driver;

        for(int i=0;i<10;i++){
            Thread.sleep(500);
            //scroll down
            jse.executeScript("window.scrollBy(0,250)");
        }
        for(int i=0;i<5;i++){
            Thread.sleep(500);
            //scroll up
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i <4 ; i++) {
            //creating dynamic xpath using i
            String imageXpath = "(//img)["+i+"]";
            System.out.println("after combining string"+imageXpath);
            //passing xpath to weblement
            WebElement img = driver.findElement(By.xpath(imageXpath));

            //creating actions object
            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            //hovering over on the image
            actions.moveToElement(img).perform();

            //creating dynamic xpath for the text
            String textXpath = "//h5[.='name: user"+i+"']";
            System.out.println("textXpath = " + textXpath);

            //passing xpath to webelement
            WebElement text = driver.findElement(By.xpath(textXpath));
            //verifying text is displayed
            Assert.assertTrue(text.isDisplayed());

        }



    }
}
