package com.iduanpeng.examples;

import com.google.common.collect.Lists;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.Tuple2;

import java.util.List;
import java.util.Properties;

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
//        Dataset<Row> select = rowDataset.select("ZJHM", "XM");
        JavaRDD<Row> rowJavaRDD = rowDataset.toJavaRDD();
//        JavaRDD<Iterable<Row>> values = rowJavaRDD.groupBy(new Function<Row, String>() {
//            @Override
//            public String call(Row row) throws Exception {
//                return row.getString(1);
//            }
//        }).values();
//        System.out.println(values);
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        properties.setProperty("driver","com.mysql.jdbc.Driver");
        //
        List<StructField> list = Lists.newArrayList();
        list.add(DataTypes.createStructField("ZJHM",DataTypes.StringType,true));
        list.add(DataTypes.createStructField("XM",DataTypes.StringType,true));

        StructType structType = DataTypes.createStructType(list);
        spark.createDataFrame(rowJavaRDD,structType);
        rowDataset.write().mode("append").jdbc("jdbc:mysql://172.18.118.222:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "aaa_copy",properties);


    }

}
