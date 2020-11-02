1. Kafka 消息是采用 Pull 模式，还是 Push 模式？  
    Kafka 最初考虑的问题是，customer 应该从 brokes 拉取消息还是 brokers 将消息推送到
    consumer，也就是 pull 还 push。在这方面，Kafka 遵循了一种大部分消息系统共同的传统
    的设计：producer 将消息推送到 broker，consumer 从 broker 拉取消息
    一些消息系统比如 Scribe 和 Apache  Flume 采用了 push 模式，将消息推送到下游的
    consumer。这样做有好处也有坏处：由 broker 决定消息推送的速率，对于不同消费速率的
    consumer 就不太好处理了。消息系统都致力于让 consumer 以最大的速率最快速的消费消
    息，但不幸的是，push 模式下，当 broker 推送的速率远大于 consumer 消费的速率时，
    consumer 恐怕就要崩溃了。最终 Kafka 还是选取了传统的 pull 模式
    Pull 模式的另外一个好处是 consumer 可以自主决定是否批量的从 broker 拉取数据。Push
    模式必须在不知道下游 consumer 消费能力和消费策略的情况下决定是立即推送每条消息还
    是缓存之后批量推送。如果为了避免 consumer 崩溃而采用较低的推送速率，将可能导致一
    次只推送较少的消息而造成浪费。Pull 模式下，consumer 就可以根据自己的消费能力去决
    定这些策略
    Pull 有个缺点是，如果 broker 没有可供消费的消息，将导致 consumer 不断在循环中轮询，
    直到新消息到 t 达。为了避免这点，Kafka 有个参数可以让 consumer 阻塞知道新消息到达
    (当然也可以阻塞知道消息的数量达到某个特定的量这样就可以批量发  
2. Kafka 存储在硬盘上的消息格式是什么？  
    消息由一个固定长度的头部和可变长度的字节数组组成。头部包含了一个版本号和 CRC32
    校验码。  
    消息长度: 4 bytes (value: 1+4+n)  
    版本号: 1 byte  
    CRC 校验码: 4 bytes  
    具体的消息: n bytes  
3. Kafka 高效文件存储设计特点
    1. Kafka 把 topic 中一个 parition 大文件分成多个小文件段，通过多个小文件段，就容易定
       期清除或删除已经消费完文件，减少磁盘占用
    2. 通过索引信息可以快速定位 message 和确定 response 的最大大小
    3. 通过 index 元数据全部映射到 memory，可以避免 segment file 的 IO 磁盘操作
    4. 通过索引文件稀疏存储，可以大幅降低 index 文件元数据占用空间大小
4. Kafka 创建 Topic 时如何将分区放置到不同的 Broker 中
    1. 副本因子不能大于 Broker 的个数；
    2. 第一个分区（编号为 0）的第一个副本放置位置是随机从 brokerList 选择的；
    3. 其他分区的第一个副本放置位置相对于第 0 个分区依次往后移。也就是如果我们有 5 个
    Broker，5 个分区，假设第一个分区放在第四个 Broker 上，那么第二个分区将会放在第五
    个  Broker  上；第三个分区将会放在第一个  Broker  上；第四个分区将会放在第二个
    Broker 上，依次类推；
    4. 剩余的副本相对于第一个副本放置位置其实是由 nextReplicaShift 决定的，而这个数也是
    随机产生的
5. Kafka 新建的分区会在哪个目录下创建
    在启动 Kafka 集群之前，我们需要配置好 log.dirs 参数，其值是 Kafka 数据的存放目录，
    这个参数可以配置多个目录，目录之间使用逗号分隔，通常这些目录是分布在不同的磁盘
    上用于提高读写性能。
    当然我们也可以配置 log.dir 参数，含义一样。只需要设置其中一个即可。
    如果 log.dirs 参数只配置了一个目录，那么分配到各个 Broker 上的分区肯定只能在这个
    目录下创建文件夹用于存放数据。
    但是如果 log.dirs 参数配置了多个目录，那么 Kafka 会在哪个文件夹中创建分区目录呢？
    答案是：Kafka 会在含有分区目录最少的文件夹中创建新的分区目录，分区目录名为 Topic
    名+分区 ID。注意，是分区文件夹总数最少的目录，而不是磁盘使用量最少的目录！也就
    是说，如果你给 log.dirs 参数新增了一个新的磁盘，新的分区目录肯定是先在这个新的磁
    盘上创建直到这个新的磁盘目录拥有的分区目录不是最少为止。
6. kafka 的 ack 机制
    request.required.acks 有三个值 0 1 -1  
    0:生产者不会等待 broker 的 ack，这个延迟最低但是存储的保证最弱当 server 挂掉的时候
    就会丢数据  
    1：服务端会等待 ack 值  leader 副本确认接收到消息后发送 ack 但是如果 leader 挂掉后他
    不确保是否复制完成新 leader 也会导致数据丢失  
    -1：同样在 1 的基础上 服务端会等所有的 follower 的副本受到数据后才会受到 leader 发出
    的 ack，这样数据不会丢失  
7. 