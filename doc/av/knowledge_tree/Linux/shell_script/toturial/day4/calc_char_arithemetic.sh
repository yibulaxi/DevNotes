#!/bin/bash

# 算数运算符. 原生 bash 不支持简单的数学运算，需要通过其他命令来实现，如 expr、awk
num=`expr 1 + 9`
echo "两数之和为: $num"

a=1
b=2

value=`expr $a + $b`
echo "a + b = $value"

value=`expr $a - $b`
echo "a - b = $value"

value=`expr $a \* $b`
echo "a * b = $value"


value=`expr $a / $b`
echo "a / b = $value"

value=`expr $a % $b`
echo "a % b = $value"

if [ $a == $b ]
then
	echo "a 等于 b"
fi

if [ $a != $b ]
then
	echo "a 不等于 b"
fi

