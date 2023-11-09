package com.jcg.spring.jdbctemplate.Rset1;
import org.testng.Reporter;
import org.testng.annotations.*;


public class SInMulDependent {

	@Test(dependsOnMethods="objectioncreation")
	public void checkInstance() {
		System.out.println("Instance created");
		Reporter.log("Instance Test Cleared");
	}
	@Test(dependsOnMethods="checkInstance")
    public void isSingleton()
    {
		System.out.println("True Singlton class");
		Reporter.log("Singlton Exist");
    }
	@Test
	public void objectioncreation() {
		System.out.println("Object Creation Started");
		Reporter.log("Creation method ran");
	}
	
}
