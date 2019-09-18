package com.iduanpeng.examples;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

public class SparkDemo {

    private static String appName = "spark.sql.demo";
    private static String master = "local[*]";

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName(appName)
                .master(master)
                .getOrCreate();

        Dataset<Row> df = spark.read()
                .format("jdbc")
                .option("url", "jdbc:mysql://172.18.118.222:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
                .option("dbtable", "aaa")
                .option("user", "root")
                .option("pass" + "word", "root")
                .load();

        Dataset<Row> df1 = spark.read()
                .format("jdbc")
                .option("url", "jdbc:mysql://172.18.118.222:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai")
                .option("dbtable", "bbb")
                .option("user", "root")
                .option("pass" + "word", "root")
                .load();
        Dataset<Row> rowDataset = df.crossJoin(df1);
        Dataset<Row> select = rowDataset.select("ZJHM", "XM");
        JavaRDD<Row> rowJavaRDD = select.toJavaRDD();
//        JavaRDD<Iterable<Row>> values = rowJavaRDD.groupBy(new Function<Row, String>() {
//            @Override
//            public String call(Row row) throws Exception {
//                return row.getString(1);
//            }
//        }).values();
//        System.out.println(values);

        select.show();
    }

}
