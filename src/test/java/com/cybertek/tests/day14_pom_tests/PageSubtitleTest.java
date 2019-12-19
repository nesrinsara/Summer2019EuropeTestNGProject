package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events
    */

    @Test
    public void verifySubtitletest(){
        LoginPage loginPage=new LoginPage();
        String username= ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        loginPage.login(username,password);

        DashboardPage dashboardpage=new DashboardPage();
        String expectedPageSubtitle="Quick Launchpad";
        String actualPageSubtitle=dashboardpage.getPageSubTitle();
        Assert.assertEquals(expectedPageSubtitle,actualPageSubtitle,"verify the page subtitle is as expected");
        dashboardpage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calenderEventsPage=new CalendarEventsPage();
        Assert.assertEquals(calenderEventsPage.getPageSubTitle(),"Calendar Events","verify subtitles");


    }


}
