
package com.jcg.spring.jdbctemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
  

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class MainAppl {
	static JdbcTemplate jdbcTemplateObj;
    static SimpleDriverDataSource dataSourceObj;
    static int update; 
    
    static String DB_USERNAME = "postgres";
    static String DB_PASSWORD = "postgres";
    static String DB_URL = "jdbc:postgresql://Localhost:5432/postgres";
 
    public static SimpleDriverDataSource getDatabaseConnection()  {
    	dataSourceObj = new SimpleDriverDataSource();
        dataSourceObj.setDriverClass(org.postgresql.Driver.class); 

  
        dataSourceObj.setUrl(DB_URL);
        dataSourceObj.setUsername(DB_USERNAME);
        dataSourceObj.setPassword(DB_PASSWORD);

        return dataSourceObj;
    }
    static String createTableQuery;
    static String sqlInsertQuery;
    static String sqlUpdateQuery;
    static String sqlDeleteQuery;
    static int a;
    
 public static void test() throws SQLException {
	 
     jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());
	    
     if (jdbcTemplateObj != null) {	       
	        createTableQuery = "CREATE TABLE IF NOT EXISTS laptop (" +
	            "name VARCHAR(100), " +
	            "version VARCHAR(100), " +
	            "company VARCHAR(100), " +
	            "ram VARCHAR(20))";
	        
	        jdbcTemplateObj.update(createTableQuery);
	       
	        
	        performDatabaseOperations();
	        String sqlSelectQuery = "SELECT name, version, company, ram FROM laptop";
	        List<laptop> listlaptops = jdbcTemplateObj.query(sqlSelectQuery, new RowMapper<laptop>() {
	            public laptop mapRow(ResultSet result, int rowNum) throws SQLException {
	            	laptop laptopObj = new laptop();
	            	laptopObj.setname(result.getString("name"));
	            	laptopObj.setversion(result.getString("version"));
	            	laptopObj.setcompany(result.getString("company"));
	            	laptopObj.setram(result.getString("ram"));
	                return laptopObj;
	            } 
	        });
	        for (laptop laptopDetail : listlaptops) {
	            System.out.println(laptopDetail.toString());
	        }
	    } else {
	        System.out.print("Application Is Not Able To Bind With The Database! Please Check!");
	    }
	}

	public static void performDatabaseOperations() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of laptop information to add:");
        int numLaptops = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Operations based on input 1 - insert data into tables  2 - update data  3 - delete data in Query ? 4 - display data");
        a  = scanner.nextInt();
        scanner.nextLine();
        if(a==1) {
        String name;
        String sqlInsertQuery = "INSERT INTO laptop(name, version ,company ,ram) VALUES (?, ?, ?, ?)";
        for (int j = 0; j < numLaptops; j++) {
            System.out.println("Enter details for laptop " + (j + 1));
            System.out.print("Name: ");
            name = scanner.nextLine();
            if (!islaptopExists(name)) {
                System.out.print("version: ");
                String version = scanner.nextLine();
                System.out.print("company: ");
                String company = scanner.nextLine();
                System.out.print("ram: ");
                String ram = scanner.nextLine();

                jdbcTemplateObj.update(sqlInsertQuery, name, version ,company ,ram);
            } else {
                System.out.println("laptop with name " + name + " already present");
            }
        }
        }
        else if(a==2){
        sqlUpdateQuery = "UPDATE laptop SET ram=? WHERE name=? and company=?";
	    jdbcTemplateObj.update(sqlUpdateQuery, "32gb", "Acer 34","Russia");
        }
        else if(a==3) {
	    sqlDeleteQuery = "DELETE FROM laptop WHERE ram = ?";
	    jdbcTemplateObj.update(sqlDeleteQuery,"4gb");
        }
    }
	
	static boolean islaptopExists(String name) {
	    String sqlSelectQuery = "SELECT COUNT(*) FROM laptop WHERE name=?";
	    int count = jdbcTemplateObj.queryForObject(sqlSelectQuery, Integer.class, name);
	    return count > 0;
	}
	

	
	
}










































//package com.jcg.spring.jdbctemplate;
//import 
//import com.jcg.spring.jdbctemplate.laptop;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.*;


//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//
//public class MainAppl {
//static JdbcTemplate jdbcTemplateObj;
//  static SimpleDriverDataSource dataSourceObj;
//
// 
//  static String DB_USERNAME = "postgres";
//  static String DB_PASSWORD = "postgres";
//  static String DB_URL = "jdbc:postgresql://Localhost:5432/postgres";
//
//  public static SimpleDriverDataSource getDatabaseConnection()  {
//  dataSourceObj = new SimpleDriverDataSource();
//      dataSourceObj.setDriverClass(org.postgresql.Driver.class);
//
//
//      dataSourceObj.setUrl(DB_URL);
//      dataSourceObj.setUsername(DB_USERNAME);
//      dataSourceObj.setPassword(DB_PASSWORD);
//
//      return dataSourceObj;
//  }
// 
// 
// 
//public static void main(String[] args) throws SQLException {
// 
//jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());
// if (jdbcTemplateObj != null) {      
//     String createTableQuery = "CREATE TABLE IF NOT EXISTS laptop (" +
//         "name VARCHAR(100), " +
//         "version VARCHAR(100), " +
//         "company VARCHAR(100), " +
//         "ram VARCHAR(20))";
//     jdbcTemplateObj.update(createTableQuery);
//     performDatabaseOperations();
//     String sqlSelectQuery = "SELECT name, version, company, ram FROM laptop";
//     List<laptop> listlaptops = jdbcTemplateObj.query(sqlSelectQuery, new RowMapper<laptop>() {
//         public laptop mapRow(ResultSet result, int rowNum) throws SQLException {
//          laptop laptopObj = new laptop();
//          laptopObj.setname(result.getString("name"));
//          laptopObj.setversion(result.getString("version"));
//          laptopObj.setcompany(result.getString("company"));
//          laptopObj.setram(result.getString("ram"));
//             return laptopObj;
//         }
//     });
//     for (laptop laptopDetail : listlaptops) {
//         System.out.println(laptopDetail.toString());
//     }
// } else {
//     System.out.print("Application Is Not Able To Bind With The Database! Please Check!");
// }
//}
//
//
//
//private static void performDatabaseOperations() {
//Scanner scanner = new Scanner(System.in);
//      System.out.println("Enter the number of laptop information to add:");
//      int numContacts = scanner.nextInt();
//      scanner.nextLine();
//      System.out.println("You want to insert data into tables or update?");
//      int a  = scanner.nextInt();
//      scanner.nextLine();
//      if(a==1) {
//      String sqlInsertQuery = "INSERT INTO laptop(name, version ,company ,ram) VALUES (?, ?, ?, ?)";
//      for (int j = 0; j < numContacts; j++) {
//          System.out.println("Enter details for laptop " + (j + 1));
//          System.out.print("Name: ");
//          String name = scanner.nextLine();
//          if (!islaptopExists(name)) {
//              System.out.print("version: ");
//              String version = scanner.nextLine();
//              System.out.print("company: ");
//              String company = scanner.nextLine();
//              System.out.print("ram: ");
//              String ram = scanner.nextLine();
//
//              jdbcTemplateObj.update(sqlInsertQuery, name, version ,company ,ram);
//          } else {
//              System.out.println("laptop with name " + name + " already present");
//          }
//      }
//      }
//      else if(a==2){
//      String sqlUpdateQuery = "UPDATE laptop SET version=? WHERE name=?";
// jdbcTemplateObj.update(sqlUpdateQuery, "45.66", "Hp");
//      }
//      else if(a==3) {
// String sqlDeleteQuery = "DELETE FROM laptop WHERE ram = ?";
// jdbcTemplateObj.update(sqlDeleteQuery,"3400");
//      }
//  }
//
//private static boolean islaptopExists(String name) {
// String sqlSelectQuery = "SELECT COUNT(*) FROM laptop WHERE name=?";
// int count = jdbcTemplateObj.queryForObject(sqlSelectQuery, Integer.class, name);
// return count > 0;
//}
//
//}




import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class YourTestClassTest {

    private YourTestClass yourTestClass;
    private JdbcTemplate jdbcTemplate;

    @BeforeMethod
    public void setUp() {
        yourTestClass = new YourTestClass(); // Replace with the actual class name

        // Create a simple stub for JdbcTemplate (you would typically use a real one)
        jdbcTemplate = new JdbcTemplate();
        yourTestClass.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    public void testIslaptopExists() {
        // Simulate a simple query result
        jdbcTemplate.update("INSERT INTO laptop (name) VALUES ('your_laptop_name')");
        
        // Test the islaptopExists method
        boolean result = yourTestClass.islaptopExists("your_laptop_name");
        assertEquals(true, result);
    }

    @Test
    public void testMapRow() throws SQLException {
        // Create a simple mock ResultSet
        ResultSet resultSet = new SimpleResultSet();
        resultSet.addColumn("name");
        resultSet.addColumn("version");
        resultSet.addColumn("company");
        resultSet.addColumn("ram");
        resultSet.addRow("laptop1", "v1", "Company A", "8GB");

        // Test the mapRow method
        RowMapper<laptop> rowMapper = yourTestClass.getRowMapper();
        laptop laptopObj = rowMapper.mapRow(resultSet, 0);

        assertEquals("laptop1", laptopObj.getName());
        assertEquals("v1", laptopObj.getVersion());
        assertEquals("Company A", laptopObj.getCompany());
        assertEquals("8GB", laptopObj.getRam());
    }
}
