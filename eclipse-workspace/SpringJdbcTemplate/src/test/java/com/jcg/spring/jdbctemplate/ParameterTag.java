package com.jcg.spring.jdbctemplate;

import org.testng.annotations.Parameters;
import org.testng.annotations.*;

public class ParameterTag 
	{
	    @Test
	    @Parameters ({"val1", "val2"})
	    public void Sum(int val1, int val2) {
	    	int finalsum = val1 + val2;
	        System.out.println("The final sum of the given values is " + finalsum);
	    }
}

