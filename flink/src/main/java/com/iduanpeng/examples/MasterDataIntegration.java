package com.iduanpeng.examples;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.UnsortedGrouping;

import java.util.List;

/**
 * flink 批处理示例程序
 */
public class MasterDataIntegration {

    public static void main(String[] args) throws Exception{
        //jdbc 并行 读取源数据 此处先mock数据

        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<PeopleData> peopleDataDataSource = env.fromElements(
                new PeopleData(1, "111", "小明", 25, "1995"),
                new PeopleData(2, "111", "小鹏", 18, "1990"),
                new PeopleData(1, "222", "小丽", 25, "1995"),
                new PeopleData(2, "222", "小莉", 23, "1995"),
                new PeopleData(3, "111", "小莉", 23, "1996"),
                new PeopleData(3, "222", "小莉", 23, "1996")


        );
        //id 分组
        peopleDataDataSource.groupBy(new KeySelector<PeopleData, String>() {
            @Override
            public String getKey(PeopleData peopleData) throws Exception {
                return peopleData.getIdCard();
            }
        }).reduce(new ReduceFunction<PeopleData>() {
            @Override
            public PeopleData reduce(PeopleData peopleData, PeopleData t1) throws Exception {
                //根据字段的权重 选取
                PeopleData peopleData1 = new PeopleData();
                if (peopleData.getTableId().equals(1)){
                    peopleData1.setAge(peopleData.getAge());
                } else if (t1.getTableId().equals(1)){
                    peopleData1.setAge(t1.getAge());
                }
                peopleData1.setName(peopleData.getName());
                if (peopleData.getTableId().equals(2)){
                    peopleData1.setName(peopleData.getName());
                } else if (t1.getTableId().equals(2)){
                    peopleData1.setName(t1.getName());
                }

                if (peopleData.getTableId().equals(3)){
                    peopleData1.setBirth(peopleData.getBirth());
                } else if (t1.getTableId().equals(3)){
                    peopleData1.setBirth(t1.getBirth());
                }
                peopleData1.setTableId(1);
                peopleData1.setIdCard(peopleData.getIdCard());
                return peopleData1;
            }
        }).print();
    }

}
