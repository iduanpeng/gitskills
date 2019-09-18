package com.iduanpeng.examples;

import com.iduanpeng.App;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class FlinkFromMysqlOnJDBC {
    public static final Logger LOGGER = LoggerFactory.getLogger(FlinkFromMysqlOnJDBC.class);
    public static void main(String[] args) throws Exception {
        JdbcReader jdbcReader = new JdbcReader();
        jdbcReader.open();
        List<People> run = jdbcReader.run();

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //获取统一的数据
        //根据主数据建模中的 字段 关联源数据表的查询 获取到
        DataSource<People> peopleDataSource = env.fromCollection(run).setParallelism(5);
        //根据唯一键 分组
        peopleDataSource.groupBy(new KeySelector<People, String>() {
            @Override
            public String getKey(People people) throws Exception {
                LOGGER.info("group by ZJHM {} and time is {}",people.getZjhm(),new Date());
                return people.getZjhm();
            }
        })
                //聚合操作
                //1 单值 根据权重覆盖
                //2 多值 累积
                .reduce(new ReduceFunction<People>() {
                    @Override
                    public People reduce(People people, People t1) throws Exception {
                        People result = new People(people.getTableName(),
                                people.getZjhm(),
                                people.getXm()
                        );
                        //姓名取table_b 的数据
                        //可以加上权重，每次遇到权重大的 直接覆盖
                        if (t1.getTableName().equals("table_b")) {
                            result.setXm(t1.getXm());
                        }
                        LOGGER.info("reduce by ZJHM {} and time is {}",people.getZjhm(),new Date());
                        return result;
                    }
                }).print();
        //sink 数据落地

    }
}
