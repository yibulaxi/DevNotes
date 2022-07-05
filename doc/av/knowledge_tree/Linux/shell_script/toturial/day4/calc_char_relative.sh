#!/bin/bash

# 关系运算符
a=1
b=2

# 判断 a == b
if [ $a -eq $b ]
then
	echo "$a == $b"
else
	echo "$a != $b"
fi

# 判断 a < b
if [ $a -lt $b ]
then
	echo "$a < $b"
else
	echo "$a is not lower than $b"
fi




