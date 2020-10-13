#!/usr/bin/env bash
num=$((1+1))
num1=$[1+1]
echo $num
echo $num1

num2=$[(1+1-0) * 2 * 2 / 2]
echo $num2

# =  -lt 小于（less than）	-le 小于等于（less equal） -eq 等于（equal）	-gt 大于（greater than） -ge 大于等于（greater equal）-ne 不等于（Not equal）
# -r 有读的权限（read）	-w 有写的权限（write）
# -x 有执行的权限（execute）
# -f 文件存在并且是一个常规的文件（file）
# -e 文件存在（existence）		-d 文件存在并是一个目录（directory）
# -s 文件存在且不为空          -L 文件存在且是一个链接(link)
if [ $1 -eq 1 ]
then
    echo "你输入的是1啊"
elif [ $1 -eq 2 ]
then
    echo "你输入的是2啊"
elif [ $1 -eq 3 ]
then
    echo "你输入的是3啊"
else
    echo "你输入的不是123啊"
fi


case $1 in
"1")
    echo "111"
;;
#break
"2")
    echo "222"
;;
*)
    echo "default"
;;
esac

# while
s=0
i=1
while [ $i -le 100 ]
do
    s=$[$s + $i]
    i=$[$i + 1]
done
echo $s

# for
s=0
for((i=0;i<=100;i++))
do
    s=$[$s+$i]
done
echo $s
































