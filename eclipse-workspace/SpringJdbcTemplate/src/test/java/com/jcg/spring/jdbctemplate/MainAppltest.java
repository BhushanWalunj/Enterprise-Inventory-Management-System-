package com.jcg.spring.jdbctemplate;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

@Test
public class MainAppltest {

    MainAppl s = new MainAppl();
    
    @Test
    public void testCreateTable() {
        String expectedQuery = "CREATE TABLE IF NOT EXISTS laptop (" +
                "name VARCHAR(100), " +
                "version VARCHAR(100), " +
                "company VARCHAR(100), " +
                "ram VARCHAR(20))";

        String actualCreateQuery = s.createTableQuery.toString();
        
        Assert.assertEquals(actualCreateQuery,expectedQuery);
    }

    @Test
    public void testInsertRecords() {
        String expectedInsertQuery = "INSERT INTO laptop(name, version ,company ,ram) VALUES (?, ?, ?, ?)";
        Assert.assertEquals(s.sqlInsertQuery, expectedInsertQuery);
    }
    @Test
    public void testUserinput() {
    	Assert.assertTrue(s.a>=0 && s.a<=3);
    }

    @Test
    public void testUpdateRecords() {
        String expectedUpdateQuery = "UPDATE laptop SET ram=? WHERE name=? and company=?";
        Assert.assertEquals(s.sqlUpdateQuery, expectedUpdateQuery);
    }

    @Test
    public void testDeleteRecords() {
        String expectedDeleteQuery = "DELETE FROM laptop WHERE ram = ?";
        Assert.assertEquals(s.sqlDeleteQuery, expectedDeleteQuery);
    }
    
    @Test
    public void testIsContactExists() {
        boolean contactExists = s.islaptopExists("SampleName");

        Assert.assertTrue(contactExists);
    }
    @Test
    public void testPerformDatabaseOperations_Insert() {
        
    }
    @AfterTest
    public void afterTest() {
        System.out.println("Test execution end");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Test
//    public void testPerformDatabaseOperations_Insert() {
//      
//
//        Assert.assertEquals(laptop,null);
//
//    
//        laptop insertedLaptop = laptop.get(0);
//        Assert.assertEquals(insertedLaptop.getname(), "SampleName");
//        Assert.assertEquals(insertedLaptop.getversion(), "SampleVersion");
//        Assert.assertEquals(insertedLaptop.getcompany(), "SampleCompany");
//        Assert.assertEquals(insertedLaptop.getram(), "SampleRAM");
//    }
//
//    @Test
//    public void testPerformDatabaseOperations_Update() {
//        s.sqlUpdateQuery = "UPDATE laptop SET ram=? WHERE name=? and company=?";
//        s.performDatabaseOperations();
//
//       
//        String updatedRam = "UpdatedRAM";
//        List<laptop> laptops = s.jdbcTemplateObj.query("SELECT * FROM laptop", (resultSet, i) -> {
//            laptop laptopObj = new laptop();
//            laptopObj.setname(resultSet.getString("name"));
//            laptopObj.setversion(resultSet.getString("version"));
//            laptopObj.setcompany(resultSet.getString("company"));
//            laptopObj.setram(resultSet.getString("ram"));
//            return laptopObj;
//        });
//
//        for (laptop laptopObj : laptops) {
//            if (laptopObj.getname().equals("Acer 34") && laptopObj.getcompany().equals("Russia")) {
//                Assert.assertEquals(laptopObj.getram(), updatedRam);
//            }
//        }
//    }
//
//    @Test
//    public void testPerformDatabaseOperations_Delete() {
//        s.sqlDeleteQuery = "DELETE FROM laptop WHERE ram = ?";
//        s.performDatabaseOperations(); // Simulate delete
//
//        
//
//        for (laptop laptopObj : laptop) {
//            Assert.assertNotEquals(laptopObj.getram(), "4gb");
//        }
//    }

    //@Test
//    public void testQueryRecords() {
//       
//        List<laptop> laptops = s.jdbcTemplateObj.query("SELECT * FROM laptop", (resultSet, i) -> {
//            laptop laptopObj = new laptop();
//            laptopObj.setname(resultSet.getString("name"));
//            laptopObj.setversion(resultSet.getString("version"));
//            laptopObj.setcompany(resultSet.getString("company"));
//            laptopObj.setram(resultSet.getString("ram"));
//            return laptopObj;
//        });
//
//        Assert.assertFalse(laptops.isEmpty());
//
//        // Additional deep testing for specific data
//        laptop queriedLaptop = laptops.get(0);
//        Assert.assertEquals(queriedLaptop.getname(), "SampleName");
//        Assert.assertEquals(queriedLaptop.getversion(), "SampleVersion");
//        Assert.assertEquals(queriedLaptop.getcompany(), "SampleCompany");
//        Assert.assertEquals(queriedLaptop.getram(), "SampleRAM");
//    }

    
}








































































//package com.jcg.spring.jdbctemplate;
//
//
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;  
//import org.testng.annotations.Test;  
//public class MainAppltest
//{  
//	MainAppl s = new MainAppl();     
//@AfterTest  
//public void after_test()  
//{  
//    System.out.println("After test execution..");  
//}
//@Test
//public void testfirstinput() {
//     
//   
//}
//@Test
//public void testCreateTable() {
//	String expectedQuery = "CREATE TABLE IF NOT EXISTS laptop (" +
//            "name VARCHAR(100), " +
//            "version VARCHAR(100), " +
//            "company VARCHAR(100), " +
//            "ram VARCHAR(20))";
//	
//    String actualcreateQuery = s.createTableQuery;
//
//    Assert.assertEquals(expectedQuery,actualcreateQuery);
//}
//@Test
//public void testInsertRecords() {
//   String actualinsertquery = "INSERT INTO laptop(name, version ,company ,ram) VALUES (?, ?, ?, ?)";
//   Assert.assertEquals(0,0);
//}
//
//@Test
//public void testUpdateRecords() {
//    String expectedupdate = "UPDATE laptop SET ram=? WHERE name=? and company=?";
//    String actualupdate = s.sqlUpdateQuery;
//    Assert.assertEquals(expectedupdate,actualupdate);
//}
//
//@Test
//public void testDeleteRecords() {
//    
//}
//
//@Test
//public void testQueryRecords() {
//    
//}
//
//@Test
//public void testIsContactExists() {
//   
//}
//} 















