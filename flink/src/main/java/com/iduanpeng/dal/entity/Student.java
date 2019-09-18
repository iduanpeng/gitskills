package com.iduanpeng.dal.entity;



public class Student {

    public String sourceTableName;

    public String gmsfhm;

    public String name;

    public String xb;

    public String address;

    public int namePriority;

    public int xbPriority;

    public Student() {
    }

    public Student(String sourceTableName, String gmsfhm, String name, String xb, String address,
                   Integer namePriority, Integer xbPriority ) {
        this.sourceTableName = sourceTableName;
        this.gmsfhm = gmsfhm;
        this.name = name;
        this.xb = xb;
        this.address = address;
        this.namePriority = namePriority;
        this.xbPriority = xbPriority;
    }

    public String getGmsfhm() {
        return gmsfhm;
    }

    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSourceTableName() {
        return sourceTableName;
    }

    public void setSourceTableName(String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }

    public int getNamePriority() {
        return namePriority;
    }

    public void setNamePriority(int namePriority) {
        this.namePriority = namePriority;
    }

    public int getXbPriority() {
        return xbPriority;
    }

    public void setXbPriority(int xbPriority) {
        this.xbPriority = xbPriority;
    }

    public void setNamePriority(Integer namePriority) {
        this.namePriority = namePriority;
    }

    public void setXbPriority(Integer xbPriority) {
        this.xbPriority = xbPriority;
    }
}
