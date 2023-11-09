package com.jcg.spring.jdbctemplate;
import org.testng.annotations.*;

public class optionalParameter {
   
    @Test
    @Parameters({"val1","val2"})
    public void Sum(@Optional("1") int val1, @Optional("2") int val2) {
        int finalsum = val1 + val2;
        System.out.println("The final sum of the given values is " + finalsum);
    }
}
