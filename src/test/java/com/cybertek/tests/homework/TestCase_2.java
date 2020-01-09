package com.cybertek.tests.homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_2 extends TestBase {

    @Test
    public void TC_2() throws InterruptedException {
        extentLogger = report.createTest("Test Case 2");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a storemanager");
        loginPage.login(username, password);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Hover over Activities, go to Calender Events Page");
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        extentLogger.info("click grid settings");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        WebElement gridSettings=driver.findElement(By.xpath("//*[@class='fa-cog hide-text']"));
        gridSettings.click();
        List<WebElement> checkBoxes=driver.findElements(By.xpath("//td/label"));
        System.out.println("checkBoxes.size() = " + checkBoxes.size());
        for (WebElement checkBox:checkBoxes) {
            if(checkBox.isSelected()){
                checkBox.click();
            }
        }

        for (WebElement checkBox:checkBoxes) {
            Assert.assertFalse(checkBox.isSelected(),"verify options are not selected");
        }
        checkBoxes.get(0).click();
       BrowserUtils.waitFor(2);
        Assert.assertTrue(checkBoxes.get(0).isSelected(),"verify title is selected");


    }

}
