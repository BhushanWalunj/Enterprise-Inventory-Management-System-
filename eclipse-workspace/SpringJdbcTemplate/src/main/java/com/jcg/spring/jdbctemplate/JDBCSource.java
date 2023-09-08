package com.jcg.spring.jdbctemplate;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JDBCSource {
    JdbcTemplate jdbcTemplateObj;
    SimpleDriverDataSource dataSourceObj;
  
	

    String DB_USERNAME = "postgres";
    String DB_PASSWORD = "postgres";
    String DB_URL = "jdbc:postgresql://Localhost:5432/postgres";

    public SimpleDriverDataSource getDatabaseConnection()  {
        dataSourceObj = new SimpleDriverDataSource();
        dataSourceObj.setDriverClass(org.postgresql.Driver.class); 
        dataSourceObj.setUrl(DB_URL);
        dataSourceObj.setUsername(DB_USERNAME);
        dataSourceObj.setPassword(DB_PASSWORD);

        return dataSourceObj;
    }
    int update;
    String createTableQuery;
    String sqlUpdateQuery;
    String sqlDeleteQuery;
    String sqlSelectQuery;
    String sqlInsertQuery;
    
    
    public int  createTable() {
        jdbcTemplateObj = new JdbcTemplate(getDatabaseConnection());
        createTableQuery = "CREATE TABLE IF NOT EXISTS mobile (" +
            "name VARCHAR(100), " +
            "version VARCHAR(100), " +
            "company VARCHAR(100), " +
            "ram VARCHAR(20))";
        int creation = jdbcTemplateObj.update(createTableQuery);
        return creation;
    }

   
    	public void insertData() {
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of laptop information to add:");
        int numLaptops = scanner.nextInt();
        scanner.nextLine();
        String name;
        sqlInsertQuery = "INSERT INTO laptop(name, version ,company ,ram) VALUES (?, ?, ?, ?)";
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

                update = jdbcTemplateObj.update(sqlInsertQuery, name, version ,company ,ram);
            } else {
                System.out.println("laptop with name " + name + " already present");
            }
        }
    }

    public void updateData() {
        sqlUpdateQuery = "UPDATE laptop SET ram=? WHERE name=? and company=?";
        jdbcTemplateObj.update(sqlUpdateQuery);
    }

    public void deleteData() {
        sqlDeleteQuery = "DELETE FROM laptop WHERE name = ?";
        jdbcTemplateObj.update(sqlDeleteQuery,"Newzen");
    }

    public void displayData() {
        sqlSelectQuery = "SELECT name, version, company, ram FROM laptop";
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
    }

     boolean islaptopExists(String name) {
        String sqlSelectQuery = "SELECT COUNT(*) FROM laptop WHERE name=?";
        int count = jdbcTemplateObj.queryForObject(sqlSelectQuery, Integer.class, name);
        return count > 0;
    }

    public static void main(String[]args) throws SQLException {
    	 JDBCSource j = new JDBCSource();
    	j.createTable();
        j.insertData();
        j.updateData();
        j.deleteData();
        j.displayData();
    }
}