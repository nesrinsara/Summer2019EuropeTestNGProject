package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class homework1_5 {
    WebDriver driver;

    @BeforeMethod
    public void driverChrome() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void quit() {
        driver.quit();

    }

    @Test
    public void test1() {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {

            if (!currentWindowHandle.equals(handle)) {

                driver.switchTo().window(handle);
            }
        }
        WebElement datebox = driver.findElement(By.xpath("(//*[@class='form-control'])[7]"));
        datebox.click();
        datebox.sendKeys("wrong_dob");
        WebElement invalidMessage = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]"));
        Assert.assertTrue(invalidMessage.isDisplayed(), "verify <The date of birth is not valid> message is displayed");

    }

    @Test
    public void test2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();

        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        for (String handle : windowHandles) {

            if (!currentWindowHandle.equals(handle)) {

                driver.switchTo().window(handle);
            }
            Assert.assertTrue(driver.findElement(By.xpath("//*[.='C++']")).isDisplayed(), "verify C++ is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//*[.='Java']")).isDisplayed(), "verify Java is displayed");
            Assert.assertTrue(driver.findElement(By.xpath("//*[.='JavaScript']")).isDisplayed(), "verify JavaScript is displayed");
        }
    }

    @Test
    public void test3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        String currentWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {

            if (!currentWindowHandle.equals(handle)) {

                driver.switchTo().window(handle);
            }
        }
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("a");
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='help-block'])[2]")).isDisplayed(),"verify firstname invalid message is displayed");
    }
    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        String currentWindowHandle=driver.getWindowHandle();
        Set<String> windowHandles=driver.getWindowHandles();
        for (String handle : windowHandles) {
            if(!currentWindowHandle.equals(handle)){
                driver.switchTo().window(handle);
            }

        }
        WebElement lastnameBox=driver.findElement(By.xpath("//*[@name='lastname']"));
        lastnameBox.click();
        lastnameBox.sendKeys("a");
        String expectedMessage="The last name must be more than 2 and less than 64 characters long";
        String actualMessage=driver.findElement(By.xpath("(//*[@class='help-block'])[6]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"verify actual message equals expected message");

    }
    @Test
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Registration Form")).click();
        String currentWindowHandle=driver.getWindowHandle();
        Set<String> windowHandles=driver.getWindowHandles();
        for (String handle : windowHandles) {
            if(!currentWindowHandle.equals(handle)){
                driver.switchTo().window(handle);
            }

        }
        driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("Nesrin");
        driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("Karadag");
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("nesrinsara");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("nesrin@hotmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("571-000-0000");
        driver.findElement(By.xpath("(//*[@name='gender'])[2]")).click();
        Assert.assertTrue( driver.findElement(By.xpath("(//*[@name='gender'])[2]")).isSelected(),"verify gender is selected");
        driver.findElement(By.xpath("//*[@name='birthday']")).sendKeys("01/01/1990");
        WebElement department=driver.findElement(By.xpath("//*[@name='department']"));
        Select departmentList=new Select(department);
        departmentList.selectByIndex(1);
        WebElement jobTitle=driver.findElement(By.xpath("//*[@name='job_title']"));
        Select jobTitles=new Select(jobTitle);
        jobTitles.selectByVisibleText("SDET");
        driver.findElement(By.xpath("//*[@id='inlineCheckbox2']")).click();
        Assert.assertTrue( driver.findElement(By.xpath("//*[@id='inlineCheckbox2']")).isSelected());
        driver.findElement(By.id("wooden_spoon")).click();
        String expectedMessage="You've successfully completed registration!";
        String actualMessage=driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"verify we got expected message");
    }
}