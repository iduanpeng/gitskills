package com.iduanpeng.dal.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class People {

    private String tableName;

    private String zjhm;

    private String xm;

    private String xb;

    private String nl;

    private String mzdm;

    public People(String tableName,String zjhm, String xm) {
        this.tableName = tableName;
        this.zjhm = zjhm;
        this.xm = xm;
    }
}
