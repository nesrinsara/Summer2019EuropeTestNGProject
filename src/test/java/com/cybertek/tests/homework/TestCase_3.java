package com.cybertek.tests.homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase_3 extends TestBase {
    @Test
    public void TC_3() throws InterruptedException {
        extentLogger = report.createTest("Test Case 3");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: " + username);
        extentLogger.info("password: " + password);
        extentLogger.info("Login as a storemanager");
        loginPage.login(username, password);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        extentLogger.info("Hover over Activities, go to Calender Events Page");
        calendarEventsPage.navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Click create Calendar Event Page");
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.saveAndClose.click();
        List<String> expectedOptions= Arrays.asList("Save And Close","Save And New","Save");
        List<WebElement> options=driver.findElements(By.xpath("//li/button"));
        List<String>actualOptions=new ArrayList<>();

        for (WebElement option:options) {

            actualOptions.add(option.getText());
        }
        Assert.assertEquals(expectedOptions,actualOptions,"Verify options are avilable");
    }
}
