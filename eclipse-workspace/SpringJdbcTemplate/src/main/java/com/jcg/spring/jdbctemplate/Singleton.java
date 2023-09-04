package com.jcg.spring.jdbctemplate;
class Encapsulated 
{
	private int psetNO;
	private String hext;
	
	public Encapsulated() {
		
	}
	public void setpset(int imv) {
		this.psetNO = imv;
	}
	public void  sethext(String smv) {
		this.hext = smv;
	}
	public int getpset() {
		return psetNO;
	}
	public String gethext() {
		return hext;
	}
}
class MapperLock
{
	private static MapperLock fin = null;

	private MapperLock() {
		
	}
	public static MapperLock getInstance() {
		if(fin==null) {
			fin = new MapperLock();
		}
		return fin;
	}
}
public class Singleton {

	public static void main(String[] args) {
		MapperLock a = MapperLock.getInstance();
		System.out.println(a.hashCode());
		MapperLock b = MapperLock.getInstance();
	    System.out.println(b.hashCode());
	    System.out.println(a.hashCode()==b.hashCode());
	     
	}

}
