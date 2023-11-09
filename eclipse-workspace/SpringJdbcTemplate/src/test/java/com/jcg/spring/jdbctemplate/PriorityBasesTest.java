package com.jcg.spring.jdbctemplate;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class PriorityBasesTest {
	@Test (priority = 1)
	public void b_method() {
		System.out.println("This is B method");
	}
		
	@Test (priority = 1)
	public void a_method() {
		System.out.println("This is A method");
	}
		
	@Test
	public void d_method() {
		System.out.println("This is D Method");
		
	}
		
    @Test(priority=-2)
    public void e_method() {
    	System.out.println("This is e method");
    }
	@Test
	public void c_method() {
		System.out.println("This is C Method");
		Reporter.log("Priority Based Successfully run ");
	}
	
}