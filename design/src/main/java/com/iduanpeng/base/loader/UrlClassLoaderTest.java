package com.iduanpeng.base.loader;

import com.founder.bigdata.api.IComponent;
import com.founder.bigdata.api.IFactory;
import com.founder.bigdata.api.ObjectContext;
import com.founder.bigdata.api.datasource.IDataSource;
import com.founder.bigdata.api.datasource.IDataSourceFactory;
import com.founder.bigdata.api.datasource.source.IDataFetcher;
import com.founder.bigdata.api.datasource.source.IDataProcessor;
import com.founder.bigdata.api.datasource.storage.ItemDeclare;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class UrlClassLoaderTest {

    //http://172.18.118.228:88/imooc/M00/00/09/rBJ25GAYR1-AJP4XBJ4NxNOK7BU718.jar
    public static void main(String[] args) throws Exception {
        UrlClassLoaderTest test = new UrlClassLoaderTest();
        test.load();
    }

    private void load() throws Exception{
        String mysqlUrl = "http://172.18.118.228:88/imooc/M00/00/09/rBJ25GAYR6mAJM2iAFjTvI7ypKE671.jar";
        String mysqlClassName = "com.founder.bigdata.datasource.mysql.Mysql8Component";
        URL jarURL = new URL(mysqlUrl);
        ClassLoader clsLoader = this.getClass().getClassLoader();
        URL[] jars = new URL[] {jarURL};
        URLClassLoader cmpClsloader = new URLClassLoader(jars, clsLoader);
        IComponent component = null;

        Class<IComponent> actCls = (Class<IComponent>)cmpClsloader.loadClass(mysqlClassName);
        component = actCls.newInstance();
        component.init();

        IFactory<IDataSource> factory = ObjectContext.getContext().getFactory(IDataSource.class.getName(), "mysql8");
        IDataSourceFactory dsFactory = (IDataSourceFactory) factory;
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("host", "172.18.124.28");
        properties.put("port",3306);
        properties.put("username", "root");
        properties.put("password", "root");
        properties.put("jdbcUrl","jdbc:mysql://172.18.124.28:3306/governance?useUnicode=true&characterEncoding=utf-8" );
        properties.put("dsType", "mysql8");
        properties.put("database", "governance");

        IDataSource dataSource = dsFactory.createInstance(properties);
        dataSource.open();

        ItemDeclare itemDeclare1 = new ItemDeclare();
        itemDeclare1.setSjxywmc("conn_id");

        List<ItemDeclare> list = new ArrayList<>();
        list.add(itemDeclare1);

        IDataFetcher dataFetcher = dataSource.loadData("conn_manage", list, null);
        dataFetcher.run(new IDataProcessor() {
            @Override
            public void process(Object o) {
                System.out.println(o.toString());
            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

        Connection connection = DriverManager.getConnection("jdbc:mysql://172.18.124.28:3306/governance?useUnicode=true&characterEncoding=utf-8", "root", "root");
        System.out.println(connection);
    }


}
