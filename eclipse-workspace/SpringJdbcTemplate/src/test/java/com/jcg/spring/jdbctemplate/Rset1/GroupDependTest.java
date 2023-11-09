package com.jcg.spring.jdbctemplate.Rset1;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.ArrayList;
import com.jcg.spring.jdbctemplate.CollectionClassForAnim;
public class GroupDependTest {
          
	     
	     
	     @DataProvider(name="9123Data")
	     public Object[][] dataPmethod(){
	    	 return new Object[][] {{"dog","cat","DOMESTIC"},{"lion","tiger","wild"}};
	     }
	     @Test(groups="Wild",dependsOnGroups= {"Domestic"})
 	     public void animal1() {
	    	 System.out.println("Wild Animals grouping made base on living status");
	    	 Reporter.log("Animal Test SUcc");
	     }
	    
	     @Test(groups="Domestic")
	     public void animal2() {
	     	 System.out.println("Domestic animals-cat are serpeated by living status");
	         Reporter.log("Animal2 Test Exec Successfully");
	     } 
	     
	     @Test(groups="Domestic")
	     public void animal3() {
	    	 System.out.println("Domestic  Animal-dog ");
	    	 Reporter.log("animal3 Exec Succ");
	     }
	     
	     @Test(groups="Wild")
	     public void animal4() {
	    	 System.out.println("Wild cat reserved ");
	    	 Reporter.log("Wild animal4 test Exec Succ");
	     }	
	     @Test(groups="Amphibian",dependsOnGroups="Wild")
	     public void sapians() {
	       System.out.println("Sapians are both living aqua as well as ground");
	       Reporter.log("Sapiens Test Successfully tested");
	     }
	     @Test(dataProvider="9123Data")
	     public void testanime(String str1,String str2,String str3)
	     {   
	    	
	     }
}
