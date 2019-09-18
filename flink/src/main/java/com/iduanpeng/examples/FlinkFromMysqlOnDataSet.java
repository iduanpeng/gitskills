package com.iduanpeng.examples;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.typeinfo.BasicTypeInfo;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.typeutils.RowTypeInfo;
import org.apache.flink.types.Row;

public class FlinkFromMysqlOnDataSet {

    public static void main(String[] args) throws Exception {
        TypeInformation[] fieldTypes = new TypeInformation[]{
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO,
                BasicTypeInfo.STRING_TYPE_INFO
        };

        RowTypeInfo rowTypeInfo = new RowTypeInfo(fieldTypes);
        JDBCInputFormat jdbcInputFormat = JDBCInputFormat.buildJDBCInputFormat()
                .setDrivername("com.mysql.jdbc.Driver")
                .setDBUrl("jdbc:mysql://172.18.71.155:4000/mdmtest")
                .setUsername("root")
                .setPassword("")
                .setRowTypeInfo(rowTypeInfo)
                .setQuery("select * from table_b")
                .finish();

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<Row> input = env.createInput(jdbcInputFormat);
//        input.groupBy(new KeySelector<Row, String>() {
//            @Override
//            public String getKey(Row row) throws Exception {
//                return (String)row.getField(0);
//            }
//        }).reduce(new ReduceFunction<Row>() {
//            @Override
//            public Row reduce(Row row, Row t1) throws Exception {
//                return row;
//            }
//        }).print();
//        input.union();
//        input.map(new MapFunction<Row, PeopleData>() {
//            @Override
//            public PeopleData map(Row row) throws Exception {
//
//                return null;
//            }
//        }).reduce(new ReduceFunction<PeopleData>() {
//            @Override
//            public PeopleData reduce(PeopleData peopleData, PeopleData t1) throws Exception {
//                return null;
//            }
//        }).print();
        input.map(new MapFunction<Row, Object>() {
            @Override
            public Object map(Row row) throws Exception {
                return null;
            }
        });
    }
}
