#!/bin/bash

# 文件测试运算符

file_prefix="/home/kk/learn_shell/day4/"
file_1="$file_prefix"readme.md""
file_2="$file_prefix"args.sh""
file_3="~/learn_shell/day4"
file_4="~/learn_shell/day4/hello"

echo "$file_1 是否为普通文件："
if [ -f $file_1 ]
then
	echo Yes
else 
	echo No
fi

echo "$file_2 是否为普通文件："
if [ -f $file_2 ]
then
	echo Yes
else
	echo NO
fi


echo "$file_2 是否可读："
if [ -r $file_2 ]
then
	echo Yes
else
	echo NO
fi

echo "$file_2 是否可写："
if [ -w $file_2 ]
then
	echo Yes
else
	echo NO
fi

echo "$file_2 是否可执行："
if [ -x $file_2 ]
then
	echo Yes
else
	echo NO
fi

echo "$file_4 是否存在："
if [ -e $file_4 ]
then
	echo Yes
else
	echo NO
fi


