package com.iduanpeng.examples;

import com.iduanpeng.dal.entity.People;
import com.iduanpeng.examples.flink_rich.JdbcReader;
import com.iduanpeng.examples.flink_rich.Reader;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.io.jdbc.JDBCInputFormat;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.List;

public class FlinkFromMysqlOnJDBC {
    public static void main(String[] args) throws Exception{
        JdbcReader jdbcReader = new JdbcReader();
        jdbcReader.open();
        List<People> run = jdbcReader.run();

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<People> peopleDataSource = env.fromCollection(run);
        peopleDataSource.groupBy(new KeySelector<People, String>() {
            @Override
            public String getKey(People people) throws Exception {
                return people.getZjhm();
            }
        }).reduce(new ReduceFunction<People>() {
            @Override
            public People reduce(People people, People t1) throws Exception {
                People result = new People(people.getTableName(),
                        people.getZjhm(),
                        people.getXm()
                        );
                //年龄取table_c 的数据
                //可以加上权重，每次遇到权重大的 直接覆盖
                if (t1.getTableName().equals("bbb")){
                    people.setXm(t1.getXm());
                }
                return people;
            }
        }).print();
        //sink 数据落地到哪里

        //flink 自带
//        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
//        DataStreamSource<People> peopleDataStreamSource =
//                streamExecutionEnvironment.addSource(new Reader()).setParallelism(3);
//        peopleDataSource.groupBy(new KeySelector<People, String>() {
//            @Override
//            public String getKey(People people) throws Exception {
//                return people.getZjhm();
//            }
//        }).reduce(new ReduceFunction<People>() {
//            @Override
//            public People reduce(People people, People t1) throws Exception {
//                return null;
//            }
//        });

    }
}
