package com.cybertek.tests.day13_properties_driver_testbase;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
    WebDriver driver;
    @Test
    public void test(){
       String s1=Singleton.getInstance();
       String s2=Singleton.getInstance();

        System.out.println("s1 = "+ s1);
        System.out.println("s2 = " + s2);

    }
    @Test
    public void test2(){
        //this is how we create webdriver object from now on
        driver= Driver.get();

        //we are getting url from configuration.properties file
        driver.get(ConfigurationReader.get("url"));

        driver.navigate().refresh();
    }
    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("http://amazon.com");

        Driver.closeDriver();
    }
}
