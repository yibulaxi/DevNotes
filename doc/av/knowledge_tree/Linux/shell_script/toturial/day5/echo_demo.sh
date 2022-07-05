#!/bin/bash

# 1.显示普通字符串
echo "Hello"

# 2.显示转义字符串
echo "\"Hello\""

# 3.显示变量
echo "请输入一个名字："
read name
echo "Hello $name!"

# 4.显示换行
echo -e "Ok! \n" # -e 开启转义

# 5.显示不换行
echo -e "Ok! \c" # -e 开启转义 \c 不换行

# 6.显示结果定向至文件
echo "来自 shell 脚本 `pwd` 的测试输入" > hello.txt

# 7.原样输出字符串，不转义不取变量，用单引号
echo '$name\"'

# 8.显示命令执行结果
echo `date`
