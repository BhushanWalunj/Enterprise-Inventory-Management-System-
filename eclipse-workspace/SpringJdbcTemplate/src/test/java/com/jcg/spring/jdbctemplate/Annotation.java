package com.jcg.spring.jdbctemplate;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
 
public class Annotation {
 @Test
 public void testCase1() {
   System.out.println("Normal Test Case"); 
 }

 @BeforeMethod
 public void beforeMethod() {
   System.out.println("execute before every Method");
 }
 
 @AfterMethod
 public void afterMethod() {
   System.out.println("execute after every Method");
 }
 
 @BeforeClass
 public void beforeClass() {
   System.out.println("execute before the Class");
 }
 
 @AfterClass
 public void afterClass() {
   System.out.println("execute after the Class");
 }
 
 @BeforeTest
 public void beforeTest() {
   System.out.println("execute before the Test");
 }
 
 @AfterTest
 public void afterTest() {
   System.out.println("execute after the Test");
 }
 
 @BeforeSuite
 public void beforeSuite() {
   System.out.println("execute before the Test Suite");
 }
 
 @AfterSuite
 public void afterSuite() {
   System.out.println("execute after the Test Suite");
 }
}
