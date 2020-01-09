package com.cybertek.tests.homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_5 extends TestBase {
    @Test
    public void TC_5() throws InterruptedException {
        extentLogger = report.createTest("Test Case 5");
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
        extentLogger.info("Get the values of start time and end time values");
        String startTime=createCalendarEventsPage.startTime.getAttribute("value");
        String endTime=createCalendarEventsPage.endTime.getAttribute("value");
        extentLogger.pass("PASS: Get the values End Time And Start Time Values");
        String[]startTime1=startTime.split(":");
        String[]endTime1=endTime.split(":");
        int actualDifference= Integer.valueOf(endTime1[0])-Integer.valueOf(startTime1[0]);
        extentLogger.info("Verify that difference between end time and start time is exactly 1 hour");
        Assert.assertEquals(actualDifference, 1);
        extentLogger.pass("PASS: Verify that difference between end time and start time is exactly 1 hour");
    }
}
