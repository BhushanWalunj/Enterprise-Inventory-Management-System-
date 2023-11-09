package com.jcg.spring.jdbctemplate.Rset1;
import com.jcg.spring.jdbctemplate.Rset1.SInMulDependent;
import org.testng.annotations.*;
class SuperClass extends SInMulDependent
{   
	
	
	
	
}
public class InheritedDepen extends SInMulDependent {
	SInMulDependent mv = new SInMulDependent();
	SInMulDependent iv = new SInMulDependent();
	@Test
	public void testHashCode() {
		System.out.println(mv.hashCode()==iv.hashCode());
	}
    	  
    @Test(dependsOnMethods={"objectioncreation","testHashCode"})
      public void inheritedProp() {
	     System.out.println("Objection cretION PERFECTLY INHERITED FROM OTHER CLASS");	

       }

}
