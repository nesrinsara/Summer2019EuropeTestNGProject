package com.cybertek.tests.day15_extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest {
    //This class is used for starting and building reports
    ExtentReports report;
    //this class is used to create the HTML report file
    ExtentHtmlReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report=new ExtentReports();

        //create report path
        String projectPath=System.getProperty("user.dir");
        String path=projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter=new ExtentHtmlReporter((path));


        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Vytrack smoke test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));

    }
    @Test
    public void test1(){
        //give a name to the current tas
        extentLogger=report.createTest("TC342 Login as Driver Test");

        //test steps
        //info() -->write test steps
        extentLogger.info("Open Chrome");
        extentLogger.info("Go to URL");
        extentLogger.info("enter driver info");
        extentLogger.info("click submit");
        extentLogger.info("verify logged in");
        extentLogger.info("TC342 is passed");

    }
    @AfterMethod
    public void tearDown(){
        //this is when the report actually created
        report.flush();
    }

}
