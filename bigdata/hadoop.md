### hadoop 安装
* `tar -zxvf` hadoop包
* 配置环境变量
```
JAVA_HOME=/opt/module/jdk1.8.0_121
HADOOP_HOME=/opt/module/hadoop-3.1.3
PATH=$PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin
export JAVA_HOME HADOOP_HOME PATH
```
* `/etc/core-site.xml` hdfs的分布式系统使用配置（默认是本地模式） 依赖 namenode datanode的进程  
```xml
<property>
  <name>fs.defaultFS</name>
  <value>hdfs://governance1:9000</value>
</property>
```

* hadoop 的数据存放文件路径
```xml
    <property>
      <name>hadoop.tmp.dir</name>
      <!--<value>/tmp/hadoop-${user.name}</value> -->
      <value>/opt/module/hadoop-3.1.3/data/tmp</value>
    </property>
```  

* `hadoop namenode -format`格式化生成路径  
![格式化图片](./img/namenode-format.png)
* `hadoop-daemon.sh start namenode` web 访问 `ip:50070` 或者jps命令 可以验证namenode是否启动成功

* yarn配置 `yarn-site.xml`
```xml
<property>
    <name>yarn.resourcemanager.hostname</name>
    <value>0.0.0.0</value>
  </property> 
```
* 2.x版本设置mapreduce shuffle的配置 3.x版本待研究
```xml
<property>
    <description>A comma separated list of services where service name should only
      contain a-zA-Z0-9_ and can not start with numbers</description>
    <name>yarn.nodemanager.aux-services</name>
    <value></value>
    <!--<value>mapreduce_shuffle</value>-->
  </property>
```


* mapreduce 程序在yarn上运行需要配置 `mapred-site.xml`
```xml
<property>
  <name>mapreduce.framework.name</name>
  <value>yarn</value>
</property>
```
* `yarn-daemon.sh start resourcemanager` 启动RM
* `yarn-daemon.sh start nodemanager` 启动NM  

### 分布式环境安装注意点
* 规划
    1. HDFS 1个NN + N个 DN + N个2NN
    2. YARN 1个RM + N个NM
    3. 
       |hadoop1|hadoop2|hadoop3
       |---- | ----| ----|
       |DN   | DN  |  DN |
       |NM   | NM  |  NM |
       |NN   | RM  |  2NM|