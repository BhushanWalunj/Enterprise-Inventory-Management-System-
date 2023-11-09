package com.jcg.spring.jdbctemplate;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class MultipleDependant 
{
    @Test
    public void OpenBrowser() {
        System.out.println("Opening The Browser");
        Reporter.log("OpenBrowser test Method run");
    }

    @Test(dependsOnMethods = { "SignIn", "OpenBrowser" })
    public void LogOut() {
        System.out.println("Logging Out");
        Reporter.log("log out test run succ Dependency - 2");
    }
    
    @Test
    public void SignIn() {
        System.out.println("Signing In");
        Reporter.log("Signin test run method");
    }
}


