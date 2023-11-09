package com.jcg.spring.jdbctemplate;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
public class HelloWorldTest {
	 HelloWorld hw = new HelloWorld();
    @Test
    		public void testmsg() {
      
        Assert.assertEquals(hw.getMessage(), "Hello,World!");
    }
    @Test
    public void test1() {
    	Assert.assertTrue(hw.b=="kelto");
    }
    @Test
    public void test2() {
    	Assert.assertTrue(hw.a>=12);
    }
    @Test(priority=2)
    public void test3() {
    	Assert.assertTrue(hw.getBoolean());
    }
    @Test
    public void test4() {
    	System.out.println("Test Execution");
    }
    @BeforeMethod
    public void test5() {
    	Assert.assertNotNull(hw.testsb2());
    }
    @Test(priority=1)

    public void testex() {
    	System.out.println("Priority exist 1");
    	Assert.assertEquals(1, 1);
    		}
    	
    public void test6() {
    	Assert.assertNull(hw.testsb());
    }

}