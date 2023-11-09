package com.jcg.spring.jdbctemplate;

import org.testng.Assert;
import org.testng.annotations.*;


import com.beust.jcommander.Parameter;

public class xmlParamTag {

	@Test
	 @Parameters ({"1", "4"})
	public void test( @Optional("Optional Parameter Selected")int a,int b) {
		System.out.println(a+b);
		Assert.assertTrue(a+b>0);
	}
}
