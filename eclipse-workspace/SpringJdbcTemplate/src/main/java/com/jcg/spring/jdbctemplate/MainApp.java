package com.jcg.spring.jdbctemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
  

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class MainApp {
	static JdbcTemplate jdbcTemplateObj;
    static SimpleDriverDataSource dataSourceObj;
 
    // Database Configuration Parameters
    static String DB_USERNAME = "postgres";
    static String DB_PASSWORD = "postgres";
    static String DB_URL = "jdbc:postgresql://Localhost:5432/postgres";
 
    public static SimpleDriverDataSource getDatabaseConnection()  {
    	dataSourceObj = new SimpleDriverDataSource();
        dataSourceObj.setDriverClass(org.postgresql.Driver.class); // PostgreSQL driver class

        // Set the database connection parameters
        dataSourceObj.setUrl(DB_URL);
        dataSourceObj.setUsername(DB_USERNAME);
        dataSourceObj.setPassword(DB_PASSWORD);

        return dataSourceObj;
    }
 public static void main(String[] args) throws SQLException {
    	

        
	 jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());

	    if (jdbcTemplateObj != null) {
	        String createTableQuery = "CREATE TABLE IF NOT EXISTS contact (" +
	            "name VARCHAR(100), " +
	            "email VARCHAR(100), " +
	            "address VARCHAR(100), " +
	            "telephone VARCHAR(20))";
	        jdbcTemplateObj.update(createTableQuery);

	       
	        performDatabaseOperations();

	        
	        String sqlSelectQuery = "SELECT name, email, address, telephone FROM contact";
	        List<Contact> listContacts = jdbcTemplateObj.query(sqlSelectQuery, new RowMapper<Contact>() {
	            public Contact mapRow(ResultSet result, int rowNum) throws SQLException {
	                Contact contactObj = new Contact();
	                contactObj.setName(result.getString("name"));
	                contactObj.setEmail(result.getString("email"));
	                contactObj.setAddress(result.getString("address"));
	                contactObj.setPhone(result.getString("telephone"));
	                return contactObj;
	            }
	        });
	        
	        for (Contact contactDetail : listContacts) {
	            System.out.println(contactDetail.toString());
	        }
	    } else {
	        System.out.print("Application Is Not Able To Bind With The Database! Please Check!");
	    }
	}

	private static void performDatabaseOperations() {
	    String sqlInsertQuery = "INSERT INTO contact(name, email, address, telephone) VALUES (?, ?, ?, ?)";
	    for (int j = 101; j < 10; j++) {
	    	String name = "Bhushan" + j;
	    	if (!isContactExists(name)) { 
	            jdbcTemplateObj.update(sqlInsertQuery, name, "Walunj" + j + "bhushan86@gmail.com", "India"+j+"region", "8669329169");
	        }
	    }

	    String sqlUpdateQuery = "UPDATE contact SET email=? WHERE name=?";
	    jdbcTemplateObj.update(sqlUpdateQuery, "Bhushanwalunj86@gmail.com", "Bhushan");

	    String sqlDeleteQuery = "DELETE FROM contact WHERE name = ?";
	    jdbcTemplateObj.update(sqlDeleteQuery,"Bhushan105");
	    } 
	private static boolean isContactExists(String name) {
	    String sqlSelectQuery = "SELECT COUNT(*) FROM contact WHERE name=?";
	    int count = jdbcTemplateObj.queryForObject(sqlSelectQuery, Integer.class, name);
	    return count > 0;
	}
        
}
