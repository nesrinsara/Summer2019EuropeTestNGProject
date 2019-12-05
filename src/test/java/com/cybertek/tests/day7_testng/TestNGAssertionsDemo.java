package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assertion");
        Assert.assertEquals("title","title");
        System.out.println("After second assertion");
    }
    @Test
    public void test2(){
       String actualTitle="Cybertek";
       String expectedTitleBeginning="C";
       Assert.assertTrue(actualTitle.startsWith(expectedTitleBeginning),"verify title starts with C");
        Assert.assertTrue("nesrin$mail".contains("@"),"verify @ in email");

    }
    @Test
    public void test3(){
        Assert.assertNotEquals("one","two","one shouldn't be equal to two");
    }
    @Test
    public void test4(){
        Assert.assertFalse(1<0);//if this lie is false, it will not complain
    }
}
