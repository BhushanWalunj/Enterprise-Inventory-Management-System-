package com.jcg.spring.jdbctemplate;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class SkipTest {
    @DataProvider(name="DP1")
    public Object[][] dpmethod1(){
    	return new Object[][] {{23,34,-11},{11,24,-13}};
    }
    @DataProvider(name="DP2")
    public Object[][] dpmethod2(){
    	return new Object[][] {{12,12,144},{44,1,44},{12,13,156}};
    }
    @DataProvider(name="DP3")
    public Object[][] dpmethod3(){
    	return new Object[][] {{1,1,1},{9,3,3},{20,5,4}};
    }
    @DataProvider(name="DP4")
    public Object[][] dpmethod4(){
    	return new Object[][] {{'a','b',195},{'b','b',196}};
    }
    @DataProvider(name="DP5")
    public Object[][] dpMethod5(){
    	return new Object[][] {{"direct","gamer"},{"weather","Lend"}};
    }
	@Test(priority=1,dataProvider="DP1")
	public void sub(int a,int b,int c) {
		int sub = a-b;
		Assert.assertEquals(c, sub);
		Reporter.log("dataProvider used by sub method is DP1");
	}
	@Test(priority=2,dataProvider="DP2")
	public void mul(int a,int b,int c) {
		int mul = a*b;
		Assert.assertEquals(c, mul);
		Reporter.log("dataProvider used by mul method is DP2");
	}
	@Test(priority=-1,enabled=true,dataProvider="DP3")
	public void divi(int a,int b,int c) {
		int div  = a/b;
		Assert.assertEquals(c,div);
		Reporter.log("dataProvider used by  method is DP3");
	}
	@Test(priority=0,dataProvider="DP4")
	public void check(char s1,char s2,int add) {
		int uniadd = (int)s1+(int)s2;
		Assert.assertEquals(add, uniadd,"check method invalid");
	}
	
	@Test(dataProvider="DP5")
	public void Arrange(String str1,String str2) {
		int l = str1.length();
		int m = str2.length();
		Assert.assertTrue(l+m>2);
	}
	@DataProvider(name="DP6")
	public Object[][] dpmethod6(){
		return new Object[][] {{true,false,true},{false,false,false},{false,true,true}};
	}
	
	@Test(priority=-1,enabled=true,dataProvider="DP6")
	public void checkcondition(boolean a,boolean b,boolean c) {
	   boolean isit = a&&b?!c:c;
	   Assert.assertEquals(isit,c);
	}
	}
