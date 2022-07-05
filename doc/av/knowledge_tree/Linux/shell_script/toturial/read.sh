#!/bin/bash

shared_type_1=armeabi-v7a
shared_type_2=arm64-v8a
cpu_type_1=armv7-a
cpu_type_2=armv8-a

cur_shared_type=${shared_type_1}
cur_cpu_type=${cpu_type_1}
read -p $'请输入生成的动态库类型: 1(armeabi-v7a), 2(arm64-v8a): \n' select_shared_type
if [ $select_shared_type==2 ]
then
	cur_shared_type=${shared_type_2}
else
	echo "你选择的 armeabi-v7a"
fi

echo "你选择的动态库类型: ${cur_shared_type}"
