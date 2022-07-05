#!/bin/bash

# 字符串运算符练习

a="123"
b="13"
c="1"
d=""

if [ $a = $b ]
then
	echo "$a = $b"
else
	echo "$a != $b"
fi

if [ $a != $b ]
then
	echo "$a != $b"
else
	echo "$a = $b"
fi

if [ -z $a ]
then
	echo "$a 的长度为 0"
else
	echo "$a 的长度不为 0"
fi

echo "$b 的长度不为 0 吗？"
if [ -n $b ]
then
	echo Yes
else
	echo No
fi

echo "d 表示的字符串是空的吗?"
if [ $a ]
then
	echo Yes
else
	echo No
fi




