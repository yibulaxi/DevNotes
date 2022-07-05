#!/bin/bash

# 布尔运算符
a=1
b=2
c=3

# !
if [ $a != $b ]
then
	echo "$a 不等于 $b"
else 
	echo "$a 等于 $b"
fi

# -o
if [ $a != $b -o $a != $c -o $b != $c ]
then
	echo "$a and $b and $c 不全相等"
else
	echo "$a and $b and $c 至少有两个数是相等的"
fi

# -a
if [ $a != $b -a $a != $c -a $b != $c ]
then
	echo "$a and $b and $c 都不想等"
else
	echo "$a and $b and $c 至少有两个数是相等的"
fi

