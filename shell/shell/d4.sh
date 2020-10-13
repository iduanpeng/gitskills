#!/usr/bin/env bash

# wc [选项参数] filename
# -l 统计文件行数
# -w 统计文件的单词数
# -m 统计文件的字符数
# -c 统计文件的字节数

wc -w redis.conf

# cut  [选项参数]  filename 默认分隔符是制表符
# -f 列号 提取第几列
# -d d为Descriptor分隔符，按照指定分隔符分割列

echo $PATH | cut -d ":" -f 1
echo $PATH | cut -d ':' -f 2,3
echo $PATH | cut -d: -f 3-
echo $PATH | cut -d ':' -f 1-3,5

# sed [选项参数]  ‘command’  filename
# sed是一种流编辑器，它一次处理一行内容。处理时，把当前处理的行存储在临时缓冲区中，称为“模式空间”，接着用sed命令处理缓冲区中的内容，处理完成后，把缓冲区的内容送往屏幕。接着处理下一行，这样不断重复，直到文件末尾。文件内容并没有改变，除非你使用重定向存储输出
# 选项参数 -e 直接在指令列模式上进行sed的动作编辑
# 命令参数 a 新增 a 的后面可以接字符串在下一行出现  d 删除  s 查找并替换

sed '2a mei nv' sed.txt
sed '2d' sed.txt
#删除sed.txt文件最后一行
sed '$d' sed.txt
# 删除sed.txt文件第二行至最后一行
sed '2,$d' sed.txt
# 将sed.txt文件中wo替换为ni  ‘g’表示global，全部替换，不加g只会替换第一个匹配到的字符。
sed 's/wo/ni/g' sed.txt


# awk 一个强大的文本分析工具，把文件逐行的读入，以空格为默认分隔符将每行切片，切开的部分再进行分析处理
# awk [选项参数] ‘pattern1{action1}  pattern2{action2}...’ filename    pattern：表示AWK在数据中查找的内容，就是匹配模式   action：在找到匹配内容时所执行的一系列命令
# 选项参数 说明 -F 指定输入文件拆分隔符 -v 赋值一个用户定义变量

# 搜索passwd文件以root关键字开头的所有行，并输出该行的第7列
awk -F: '/^root/{print $7}' passwd
# 搜索passwd文件以root关键字开头的所有行，并输出该行的第1列和第7列，中间以“，”号分割
awk -F: '/^root/{print $1","$7}' passwd
# 只显示/etc/passwd的第一列和第七列，以逗号分割，且在所有行前面添加列名user，shell在最后一行添加"dahaige，/bin/zuishuai"
awk -F : 'BEGIN{print "user, shell"} {print $1","$7} END{print "dahaige,/bin/zuishuai"}' passwd
# 将passwd文件中的用户id增加数值1并输出
awk -v i=1 -F: '{print $3+i}' passwd

#awk 内置变量 FILENAME 文件名 NR  已读的记录数行号 NF 切割后列的个数
#统计passwd文件名，每行的行号，每行的列数
awk -F: '{print "filename:"  FILENAME ", linenumber:" NR  ",columns:" NF}' passwd
# 查询sed.txt中空行所在的行号
awk '/^$/{print NR}' sed.txt


# sort命令是在Linux里非常有用，它将文件进行排序，并将排序结果标准输出。默认情况以第一个字符串的字典顺序来排序
# sort(选项)(参数)
# -n 依照数值的大小进行排序
# -r 以相反的顺序来排序
# -t 设置排序时所用的分割字符 默认使用TAB
# -k 指定需要排序的列
# -u unique 如果出现相同的数据 只出现一行

# 按照“：”分割后的第三列倒序排序
sort -t : -nrk 3  sort.sh
# bb:40:5.4
# bd:20:4.2
# cls:10:3.5
# xz:50:2.3
# ss:30:1.6















