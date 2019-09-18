package com.iduanpeng.examples;

import com.iduanpeng.dal.entity.People;
import com.iduanpeng.examples.flink_rich.ParallelReader;
import com.iduanpeng.examples.flink_rich.Reader;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkFromMysqlParallel {
    public static void main(String[] args) {
        //flink 自带
        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<People> peopleDataStreamSource =
                streamExecutionEnvironment.addSource(new ParallelReader()).setParallelism(3);
        peopleDataStreamSource.keyBy(new KeySelector<People, String>() {
            @Override
            public String getKey(People people) throws Exception {
                return people.getZjhm();
            }
        });
    }
}
