#!/bin/bash

# if else
if [ $(ps -ef | grep -c "ssh") -gt 1 ]; then echo "true"; fi


# if elif else
a=10
b=20

if [ $a == $b ]
then
	echo "a=b"
elif [ $a -gt $b ]
then
	echo "a>b"
elif [ $a -lt $b ]
then
	echo "a<b"
else
	echo "不知道a和b的关系了"
fi

# for
for value in 1 2 3 4 5
do
	echo "value: $value"
done

# while
index=1
while(( $index<=5 ))
do
	echo $index
	let "index++"
done


# 无限循环,

