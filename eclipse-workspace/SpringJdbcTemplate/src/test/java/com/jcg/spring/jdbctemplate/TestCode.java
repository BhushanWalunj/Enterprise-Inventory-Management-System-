package com.jcg.spring.jdbctemplate;
import com.jcg.spring.jdbctemplate.*;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class TestCode {
	
	
   JDBCSource ref = new JDBCSource();
	
   @Test
   public void TestcreateTable() {
       
        int result = ref.createTable();
        System.out.println(result);
        
        Assert.assertTrue(result >= 0, "Table creation should be successful");
    }
    @Test
    public void TestUpdateData() {
        
    	boolean isWhere = ref.sqlUpdateQuery.contains("WHERE");
        boolean isUpdate = ref.sqlUpdateQuery.contains("UPDATE"); 
        Assert.assertTrue(isUpdate);
        Assert.assertTrue(isWhere);
    
    }
    
    @Test
    public void TestRecords() {
        String expectedUpdateQuery = "UPDATE laptop SET ram=? WHERE name=? and company=?";
        Assert.assertEquals(ref.sqlUpdateQuery, expectedUpdateQuery);
    }
    
    
    
    @Test
    public void testDeleteRecords() {
        String expectedDeleteQuery = "DELETE FROM laptop WHERE ram = ?";
        Assert.assertEquals(ref.sqlDeleteQuery, expectedDeleteQuery);
    }
    
    
    @Test
    public void testIsExists() {
        boolean contactExists = ref.islaptopExists("MSI");

        Assert.assertTrue(contactExists);
    }
    
    
    
}
