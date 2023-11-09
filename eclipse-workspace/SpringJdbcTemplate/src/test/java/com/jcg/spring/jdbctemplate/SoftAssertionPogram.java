package com.jcg.spring.jdbctemplate;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class SoftAssertionPogram {
   @DataProvider(name="DP1")
   public Object[][] dpmethod(){
	   return new Object[][] {{"The","GoD","TheGoD"},{"My","Spring","MySpring"}};
   }
   
   @DataProvider(name="DP2")
   public Object[][] dpmethod1(){
	   return new Object[][] {{12,13,56}};
   }
   
   @Test(priority=-1,dataProvider="DP2")
   public void check(int s1,int s2,int s3) {
	   int ad = s1+s2;
	   Assert.assertTrue(ad<s3);
   }
   @Test(priority=1,dataProvider="DP1")
   public void test(String v1,String v2,String v3){
	   String str1 = v1+v2;
		   SoftAssert sc = new SoftAssert();
		   sc.assertAll();
		   sc.assertEquals(str1,v3);
	       Assert.assertEquals(str1, v3);
   }
   
   
}
