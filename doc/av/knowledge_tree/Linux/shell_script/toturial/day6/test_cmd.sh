#!/bin/bash

# test 命令数值测试
n1=100
n2=100

if test $n1 -eq $n2
then
	echo "相等"
else
	echo "不想等"
fi

a=1
b=10
res=$[a+b]
echo "res: $res"

# test 命令字符串测试
s1="abc"
s2="abc"
if test $s1 = $s2
then
	echo "s1=s2"
else
	echo "s1!=s2"
fi

# test 命令文件测试
if test -e /bin/bash
then
	echo "文件存在"
else
	echo "文件不存在"
fi

