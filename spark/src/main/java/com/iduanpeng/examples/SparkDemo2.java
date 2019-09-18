//package com.iduanpeng.examples;
//
//import com.iduanpeng.dal.entity.People;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.api.java.function.Function;
//import org.apache.spark.api.java.function.Function2;
//import org.apache.spark.api.java.function.PairFunction;
//import org.apache.spark.api.java.function.VoidFunction;
//import org.apache.spark.sql.SparkSession;
//import scala.Tuple2;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class SparkDemo2 {
//    public static void main(String[] args) {
//        SparkSession sparkSession = SparkSession.builder().appName("JavaWordCount").master("local").getOrCreate();
//        //spark对普通List的reduce操作
//        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
//        List<PeopleData> data = PeopleData.getMockPeopleList();
//        JavaRDD<PeopleData> originRDD = javaSparkContext.parallelize(data);
//        JavaRDD<PeopleData> values = originRDD.mapToPair(new PairFunction<PeopleData, String, PeopleData>() {
//            @Override
//            public Tuple2<String, PeopleData> call(PeopleData peopleData) throws Exception {
//                return new Tuple2<>(peopleData.getIdCard(), peopleData);
//            }
//        }).reduceByKey(new Function2<PeopleData, PeopleData, PeopleData>() {
//            @Override
//            public PeopleData call(PeopleData peopleData, PeopleData peopleData2) throws Exception {
//                PeopleData p = new PeopleData();
//                p.setName(peopleData.getName());
//                p.setAge(peopleData.getAge());
//                if (peopleData2.getTableId().equals(2)) {
//                    p.setAge(peopleData2.getAge());
//                }
//                return p;
//            }
//        }).values();
//
//        values.foreach(new VoidFunction<PeopleData>() {
//            @Override
//            public void call(PeopleData peopleData) throws Exception {
//                System.out.println(peopleData);
//            }
//        });
//    }
//}
