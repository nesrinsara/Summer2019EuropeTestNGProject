package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement gridSettings;

    //@FindBy(xpath = "(//*[@class='dropdown-toggle'])[20]")
    //public WebElement threeDotsTestersMeeting;


}
