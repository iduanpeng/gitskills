package com.iduanpeng.bigdata.flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPeriodicWatermarks;
import org.apache.flink.streaming.api.functions.source.SourceFunction;
import org.apache.flink.streaming.api.watermark.Watermark;

import javax.annotation.Nullable;

public class WatermarkTest {
    public static void main(String[] args) {
        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();
        environment.addSource(new SourceFunction<Object>() {
            @Override
            public void run(SourceContext<Object> sourceContext) throws Exception {

            }

            @Override
            public void cancel() {

            }
        }).assignTimestampsAndWatermarks(new AssignerWithPeriodicWatermarks<Object>() {
            @Nullable
            @Override
            public Watermark getCurrentWatermark() {
                return null;
            }

            @Override
            public long extractTimestamp(Object o, long l) {
                return 0;
            }
        });

    }
}
