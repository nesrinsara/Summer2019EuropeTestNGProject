package com.cybertek.tests.day11_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

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
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        //Actions -->class that contains all the user interactions
        //passing driver as cons
        Actions actions=new Actions(driver);

        WebElement img=driver.findElement(By.tagName("img"));
        //perform()-->complete the action, mandatory
        actions.moveToElement(img).perform();

        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed(),"verify message is displayed");

    }

    @Test
    public void DragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);

        WebElement source =driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
        actions.pause(1000);
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        actions.dragAndDrop(source,target).perform();

    }
    @Test
    public void DragAndDropChaining(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        //how to create actions object/ passing driver as a constructor
        Actions actions = new Actions(driver);
        // we drag this element(source)
        WebElement source = driver.findElement(By.id("draggable"));
        //we drop here (target)
        WebElement target = driver.findElement(By.id("droptarget"));
        //pause() --> waiting just like thread.sleep, accepts milliseconds
        actions.pause(1000);
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
        //we have to provide source and target to this method, it will drag and drop
        //if you are dealing more than one method(in actions) you use build() before perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You did great!']")).isDisplayed(),"verify 'you did great' is dsplayed");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");

    }

}
