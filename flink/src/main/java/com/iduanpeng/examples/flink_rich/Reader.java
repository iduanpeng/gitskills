package com.iduanpeng.examples.flink_rich;

import com.iduanpeng.dal.entity.People;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;

public class Reader extends RichSourceFunction<People> {

    public Reader() {
        super();
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
    }

    @Override
    public void close() throws Exception {
        super.close();
    }

    @Override
    public void run(SourceContext<People> sourceContext) throws Exception {

    }

    @Override
    public void cancel() {

    }
}
