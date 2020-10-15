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
* 配置`core-site.xml` 同单机版
* `hdfs-site.xml` 配置2NN
```xml
<property>
  <name>dfs.namenode.secondary.https-address</name>
  <value>0.0.0.0:9869</value>
  <description>
    The secondary namenode HTTPS server address and port.
  </description>
</property>
```
* `yarn-site.xml`配置RM
```xml
<property>
    <description>The hostname of the RM.</description>
    <name>yarn.resourcemanager.hostname</name>
    <value>0.0.0.0</value>
  </property> 
```
* 启动hadoop
    1. 先格式化namenode
    2. `hadoop-daemon.sh start namenode && datanode`
    3. `hadoop-daemon.sh start secondarynamenode`
    4. `yarn-daemon.sh start resourcemanager && yarn-daemon.sh start nodemanager`
    5. `/sbin/start-all.sh`群起脚本注意事项：是读取 `HADOOP_HOME/etc/hadoop/slaves(wokers)` 获取集群中所有节点主机名
       注意需要配置SSH 免密登录 和 当前用户家目录 `.bashrc` 配置了 `source /etc/profile`
* 配置历史服务器 `mapred-site.xml`
```xml
<property>
  <name>mapreduce.jobhistory.address</name>
  <value>0.0.0.0:10020</value>
  <description>MapReduce JobHistory Server IPC host:port</description>
</property>

<property>
  <name>mapreduce.jobhistory.webapp.address</name>
  <value>0.0.0.0:19888</value>
  <description>MapReduce JobHistory Server Web UI host:port</description>
</property>
```
`yarn-site.xml`
```xml
<property>
    <description>
    URL for log aggregation server
    </description>
    <name>yarn.log.server.url</name>
    <value>http://hadoop1:19888/jobhistory/logs</value>
  </property>
```
```xml
<property>
    <name>yarn.log-aggregation-enable</name>
    <value>true</value>
  </property>
```
```xml
<property>
    <description>How long to keep aggregation logs before deleting them.  -1 disables. 
    Be careful set this too small and you will spam the name node.</description>
    <name>yarn.log-aggregation.retain-seconds</name>
    <value>-1</value>
  </property> 
```
       
