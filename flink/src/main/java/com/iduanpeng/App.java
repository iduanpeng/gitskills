package com.iduanpeng;

import com.iduanpeng.dal.entity.Student;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.io.jdbc.JDBCOutputFormat;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.typeutils.RowTypeInfo;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.types.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * flink 测试程序入口类
 */
public class App {
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception{
        //字段权重顺序
        // priority     3       2      1
        // name      table3 table2 table1
        // priority     3     2     1
        //xb        table2 table1 table3


        //address 多值 暂时，分割存入

        //数据库字段类型
        TypeInformation[] fieldTypes = new TypeInformation[]{
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO
        };

        RowTypeInfo rowTypeInfo = new RowTypeInfo(fieldTypes);
        //source
        JDBCInputFormat table1 = JDBCInputFormat.buildJDBCInputFormat()
                .setDrivername("com.mysql.jdbc.Driver")
                .setDBUrl("jdbc:mysql://172.18.71.155:4000/founder")
                .setUsername("root")
                .setPassword("")
                .setRowTypeInfo(rowTypeInfo)
                .setQuery("select * from G_CZRKXX_1")
                .finish();

        JDBCInputFormat table2 = JDBCInputFormat.buildJDBCInputFormat()
                .setDrivername("com.mysql.jdbc.Driver")
                .setDBUrl("jdbc:mysql://172.18.71.155:4000/founder")
                .setUsername("root")
                .setPassword("")
                .setRowTypeInfo(rowTypeInfo)
                .setQuery("select * from G_RKXX_2")
                .finish();

        JDBCInputFormat table3 = JDBCInputFormat.buildJDBCInputFormat()
                .setDrivername("com.mysql.jdbc.Driver")
                .setDBUrl("jdbc:mysql://172.18.71.155:4000/founder")
                .setUsername("root")
                .setPassword("")
                .setRowTypeInfo(rowTypeInfo)
                .setQuery("select * from G_RYJBXX_3")
                .finish();
        //sink source
        JDBCOutputFormat outputFormat = JDBCOutputFormat.buildJDBCOutputFormat()
                .setDrivername("com.mysql.jdbc.Driver")
                .setDBUrl("jdbc:mysql://172.18.71.155:4000/founder")
                .setUsername("root")
                .setPassword("")
                .setQuery("insert into flink_result (gmsfhm,name,xb,address) values(?,?,?,?)")
                .finish();

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<Row> input1 = env.createInput(table1).setParallelism(3);
        DataSource<Row> input2 = env.createInput(table2).setParallelism(3);
        DataSource<Row> input3 = env.createInput(table3).setParallelism(3);
        //map reduce
        MapOperator<Row, Student> map1 = input1.map((row) -> {
            return new Student("table1",
                    (String) row.getField(0),
                    (String) row.getField(1),
                    (String) row.getField(2),
                    (String) row.getField(3),
                    1,
                    2);
        });

        MapOperator<Row, Student> map2 = input2.map((row) -> {
            return new Student("table2",
                    (String) row.getField(0),
                    (String) row.getField(1),
                    (String) row.getField(2),
                    (String) row.getField(3),
                    2,
                    3);
        });

        MapOperator<Row, Student> map3 = input3.map((row) -> {
            return new Student("table3",
                    (String) row.getField(0),
                    (String) row.getField(1),
                    (String) row.getField(2),
                    (String) row.getField(3),
                    3,
                    3);
        });

        map1.union(map2).union(map3)
                .groupBy((student) -> {
                    return student.getGmsfhm();
                }).reduce((s1, s2) -> {
            if (s2.getNamePriority() > s1.getNamePriority()
                    && s2.getName() != null) {
                s1.setNamePriority(s2.getNamePriority());
                s1.setName(s2.getName());
            }
            if (s2.getXbPriority() > s1.getXbPriority()
                    && s2.getXb() != null) {
                s1.setXbPriority(s2.getXbPriority());
                s1.setXb(s2.getXb());
            }
            if (s1.getAddress() != null
                    && !(s1.getAddress().equals(s2.getAddress()))) {
                s1.setAddress(s1.getAddress() + "-" + s2.getAddress());
            } else {
                if (s2.getAddress() != null) {
                    s1.setAddress(s2.getAddress());
                }
            }
            return s1;
        })
                .map((student) -> {
            Row row = new Row(4);
            row.setField(0, student.getGmsfhm());
            row.setField(1, student.getName());
            row.setField(2, student.getXb());
            row.setField(3, student.getAddress());
            return row;
        })
//                .print();
        .output(outputFormat);
    }
}
