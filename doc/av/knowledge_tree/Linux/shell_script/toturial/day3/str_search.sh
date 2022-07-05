#!/bin/bash

# 查找字符串
str='Today is a good day!'

# 查找字符 a 的位置
echo `expr index "$str" a`
