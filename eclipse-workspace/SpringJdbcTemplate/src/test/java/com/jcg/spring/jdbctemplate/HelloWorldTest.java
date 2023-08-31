package com.jcg.spring.jdbctemplate;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.testng.annotations.Test;
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
    @Test
    public void test3() {
    	Assert.assertTrue(hw.getBoolean());
    }
    @Test
    public void test4() {
    	System.out.println("Test Execution");
    }
    @Test
    public void test5() {
    	Assert.assertNotNull(hw.testsb2());
    }
    public void test6() {
    	Assert.assertNull(hw.testsb());
    }
    
}