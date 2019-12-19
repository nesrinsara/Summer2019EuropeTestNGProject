package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage loginpage=new LoginPage();
        String username= ConfigurationReader.get("driver_username");
        String password=ConfigurationReader.get("driver_password");
        loginpage.login(username,password);

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");
    }

    @Test
    public void loginAsStoreManager(){
        LoginPage loginpage=new LoginPage();
        String username=ConfigurationReader.get("storemanager_username");
        String password=ConfigurationReader.get("storemanager_password");
        loginpage.login(username,password);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa3.vytrack.com/");
    }


}
