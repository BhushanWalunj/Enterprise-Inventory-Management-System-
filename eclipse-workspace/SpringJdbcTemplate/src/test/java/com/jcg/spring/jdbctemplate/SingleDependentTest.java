package com.jcg.spring.jdbctemplate;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SingleDependentTest {

  @Test (dependsOnMethods = { "OpenBrowser" })
  public void SignIn() {
	  System.out.println("This will execute second (SignIn)");
	  Reporter.log("MethodDepen");
  }

  @Test
  public void OpenBrowser() {
	  System.out.println("This will execute first (Open Browser)");
  }
}