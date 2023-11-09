package com.jcg.spring.jdbctemplate;
import com.jcg.spring.jdbctemplate.*;
import com.jcg.spring.jdbctemplate.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.*;
import org.testng.annotations.*;
public class TestCode {
  

	
   JDBCSource ref = new JDBCSource();
	
   @DataProvider(name="isLaptopExistDP")
   public Object[][] dpmethod(){
	   return new Object[][] {{"MSI",""}};
   }
   
   @Test
   void isTableCreated() {
       
        int result = ref.createTable();
        
        
        Assert.assertTrue(result >= 0, "Table creation should be successful");
    }
   
   
   @Test
   public void testisTableExist() {
      
       int creation = ref.createTable();
       Assert.assertEquals(0, creation);
       boolean tableExists = ref.jdbcTemplateObj.queryForObject(
               "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'laptop'",
               Integer.class) == 1;
       Assert.assertEquals(tableExists, tableExists);   
   }
   
   
   @Test(dataProvider="isLaptopExistDP")
   
   public void isLaptopExistsTest() {
       

//       boolean exist = 
//       Assert.assertTrue(exist);
   }
   
   
   @Test
   public void testDisplayData() {
       List<laptop> laptops = ref.displayData();

     
       Assert.assertNotNull(laptops);
       Assert.assertFalse(laptops.isEmpty());

       
       for (laptop laptop : laptops) {
           Assert.assertNotNull(laptop.getname());
           Assert.assertNotEquals("", laptop.getname());
       }
   }
   
   @Test
   
   public void TestupdatedRecords() {
        
    }
    
    @Test
    public void TestDeleteRecords() {
    	 
         Assert.assertEquals(false, false);
    }
    
   
    
   
   
    
    
    
    
}
