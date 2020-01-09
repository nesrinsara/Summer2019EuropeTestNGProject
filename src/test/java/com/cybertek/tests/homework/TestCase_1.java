package com.cybertek.tests.homework;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase_1 extends TestBase {
    @Test
    public void TC_1() {
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);
        WebElement threeDotsTesterMeeting=Driver.get().findElement(By.xpath("(//*[@class='dropdown-toggle'])[20]"));
        BrowserUtils.scrollToElement(threeDotsTesterMeeting);
        BrowserUtils.hover(threeDotsTesterMeeting);
        WebElement view=Driver.get().findElement(By.xpath("//*[@class='fa-eye hide-text']"));
        WebElement edit=Driver.get().findElement(By.xpath("//*[@class='fa-pencil-square-o hide-text']"));
        WebElement delete=Driver.get().findElement(By.xpath("//*[@class='fa-trash-o hide-text']"));
        Assert.assertTrue(view.isDisplayed(),"verify view is displayed");
        Assert.assertTrue(edit.isDisplayed(),"verify edit is displayed");
        Assert.assertTrue(delete.isDisplayed(),"verify delete is displayed");

    }
}
