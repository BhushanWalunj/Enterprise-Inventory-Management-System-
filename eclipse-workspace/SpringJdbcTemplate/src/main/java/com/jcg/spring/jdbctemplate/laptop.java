package com.jcg.spring.jdbctemplate;

public class laptop {
	private String name ;
    private String version;
    private String company;
    private String ram;
 
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getram() {
        return ram;
    }
    public void setram(String ram) {
        this.ram = ram;
    }
    public String getcompany() {
        return company;
    }
    public void setcompany(String company) {
        this.company = company;
    }
    public String getversion() {
        return version;
    }
    public void setversion(String version) {
        this.version = version;
    }
    public String toString() {
        return String.format("[%s - %s - %s - %s]", name, version, company, ram);
    }
}
