package com.jcg.spring.jdbctemplate;

import org.testng.annotations.Test;

public class GroupDependency
 {
     @Test(dependsOnGroups = { "SignIn" })
     public void ViewAcc() {
         System.out.println("SignIn Successful");
     }
  
     @Test(groups = { "SignIn" })
     public void LogIn() {
         System.out.println("Logging In Success");
     }
 }