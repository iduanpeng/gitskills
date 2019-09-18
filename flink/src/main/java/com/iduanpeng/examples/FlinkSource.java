package com.iduanpeng.examples;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.io.jdbc.JDBCOutputFormat;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple3;

public class FlinkSource {
    public static void main(String[] args) {


        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<Tuple3<String, String, String>> tuple3DataSource = env.fromElements(new Tuple3<String, String, String>("1", "1", "1"));


// write Tuple DataSet to a relational database
//        tuple3DataSource.output(
//                // build and configure OutputFormat
//                JDBCOutputFormat.buildJDBCOutputFormat()
//                        .setDrivername("org.apache.derby.jdbc.EmbeddedDriver")
//                        .setDBUrl("jdbc:derby:memory:persons")
//                        .setQuery("insert into persons (name, age, height) values (?,?,?)")
//                        .finish()
//        );
    }

}
