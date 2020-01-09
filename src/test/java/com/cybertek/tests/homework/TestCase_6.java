package com.cybertek.tests.homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase_6  extends TestBase {
    @Test
    public void TC_6() throws InterruptedException {
        extentLogger = report.createTest("Test Case 6");
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
        createCalendarEventsPage.startTime.clear();
        createCalendarEventsPage.startTime.sendKeys("9:00 PM");
        System.out.println(createCalendarEventsPage.startTime.getText());
        //Assert.assertEquals(createCalendarEventsPage.startTime.getText(),"9:00 PM","verify start time");
        createCalendarEventsPage.endTime.clear();
        createCalendarEventsPage.endTime.sendKeys("10:00 PM"+ Keys.ENTER);
        Assert.assertEquals(createCalendarEventsPage.endTime.getText(),"10:00 PM","Verify end time is 10:00 PM");



    }
}
