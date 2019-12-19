package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    //normally no need to create this cons because we extends BasePage, it will use parent class's cons
    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }




}
