package com.iduanpeng.examples;

import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class PeopleData {

    private Integer tableId;

    private String idCard;

    private String name;

    private Integer age;

    private String birth;

    public PeopleData(Integer tableId,String idCard, String name, Integer age, String birth) {
        this.tableId = tableId;
        this.idCard = idCard;
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

    public PeopleData() {
    }

    public static List<PeopleData> getMockPeopleList(){
        List<PeopleData> data = Lists.newArrayList();
        //name 选取table2  age 选取 table1 birth 选取 table2
        PeopleData p1 = new PeopleData(1,"111","小明",25,"1995");
        PeopleData p2 = new PeopleData(2,"111","小鹏",18,"1990");

        PeopleData p3 = new PeopleData(1,"222","小丽",25,"1995");
        PeopleData p4 = new PeopleData(2,"222","小莉",23,"1995");
        data.add(p1);
        data.add(p1);
        data.add(p1);
        data.add(p1);
        return data;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "PeopleData{" +
                "tableId=" + tableId +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth='" + birth + '\'' +
                '}';
    }
}
