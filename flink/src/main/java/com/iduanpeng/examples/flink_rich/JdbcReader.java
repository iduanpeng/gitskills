package com.iduanpeng.examples.flink_rich;

import com.iduanpeng.dal.entity.People;
import org.apache.commons.compress.utils.Lists;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class JdbcReader {

    PreparedStatement ps1;

    PreparedStatement ps2;

    private Connection connection;


    public void open() throws Exception {
        connection = getConnection();
        String sql1 = "select * from aaa";
        String sql2 = "select * from bbb";
        ps1 = this.connection.prepareStatement(sql1);
        ps2 = this.connection.prepareStatement(sql2);
    }


    public List<People> run() throws Exception {
        //先获取主数据建模的信息
        //1、来源表信息
        //2、来源表与主数据字段关联信息
        //3、查询

        List<People> data = Lists.newArrayList();
        ResultSet resultSet1 = ps1.executeQuery();
        ResultSet resultSet2 = ps2.executeQuery();
        while(resultSet1.next()){
                People people = new People(
                                            "aaa",
                                            resultSet1.getString("ZJHM"),
                                            resultSet1.getString("XM")
                                            );

            data.add(people);
        }
        while(resultSet2.next()){
            People people = new People(
                    "bbb",
                    resultSet2.getString("ZJHM"),
                    resultSet2.getString("XM")

            );
            data.add(people);
        }
        return data;
    }

    public void close() throws Exception {
        if (connection != null){
            connection.close();
        }
        if (ps1 != null){
            connection.close();
        }
        if (ps2 != null){
            connection.close();
        }
    }



    public static Connection getConnection() throws Exception{
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://172.18.118.222:3306/test","root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
        return connection;
    }

    public static void main(String[] args) throws Exception{
        Connection connection = getConnection();
        System.out.println(connection);
    }
}
