package com.jcg.spring.jdbctemplate;
import org.testng.annotations.*;
import org.testng.*;
import org.testng.Assert;
public class DataProvide {
		@DataProvider (name = "data-provider")
		public Object[][] dpMethod(){
			return new Object[][] {{2, 3 , 5}, {5, 7, 12},{3,4,7}};
		}
		@DataProvider(name="DP2")
		public Object[][] dp2method(){
			return new Object[][] {{3,3,9},{4,5,20},{5,9,45}};
		}
		@DataProvider(name="Dp3")
		public Object[][] dpmethod(){
			return new Object[][] {{"bluettttt","redt",true},{"green444444","blue",true}};
		}
		@DataProvider(name="self")
		public Object[][] datapromethod(){
			return new Object[][] {{"Drost","Lempon","DrostLempon"}};
		}
		@Test(priority=-4,dataProvider="self")
		public void concat(String str1,String str2,String str3)
		{
			String str4 = str1+str2;
			Assert.assertEquals(str4,str3);
			Reporter.log("Concat Test Passed");
		}
		 @Test(priority=-3,dataProvider="Dp3")
		 public void testdp3(String a,String b,boolean k) {
			 boolean flip = a.length()<b.length()?true:false;
			 Assert.assertEquals(k, flip);
			 Reporter.log("TestDP3 tested successfully");
		 }
	      @Test (priority=1,dataProvider = "data-provider")
	      public void myTest (int a, int b, int result) {
		     int sum = a + b;
		     Assert.assertEquals(result, sum);
		     Reporter.log("TestmyTest tested successfully");
	      }
	      
	      @Test(priority=0,dataProvider="DP2")
	      public void multiply(int val1,int val2,int result) {
	    	  int mul = val1*val2;
	    	  Assert.assertEquals(result, mul);
	    	  Reporter.log("Multiply tested successfully");
	      }
	      @Test(priority=-4,dataProvider="DP2")
	      public void evenodd(int a,int b,int c) {
	    	  int evn = a+b;
	    	  Assert.assertFalse(evn%2==0 && c%2==0 );
	    	  Reporter.log("EvenOdd tested successfully");
	      }
	      
}

