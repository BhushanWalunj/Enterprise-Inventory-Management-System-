package com.jcg.spring.jdbctemplate;
import java.util.*;
import org.apache.logging.log4j.Logger;
class HelloWorld {
    
	Scanner s = new Scanner(System.in);
    int a = 12;
    String b = "kelto";
    String sb = null;
    String sb2 = "lemo";
    boolean c = true;
    public String getMessage() {
    	return "Hello,World!";
    }
	public String getText() {
		
		return b;
	}
	public int getnumber() {
		return a;
	}
	public boolean getBoolean() {
		return c;
	}
	public String testsb() {
		return sb;
	}
	public String testsb2() {
		return sb2;
	}
	
}
