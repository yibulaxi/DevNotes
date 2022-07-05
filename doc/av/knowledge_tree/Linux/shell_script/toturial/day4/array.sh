#!/bin/bash

foods=(milk egg apple)
echo ${foods[0]}
echo ${foods[1]}
echo ${foods[2]}

foods[0]=noodle
echo ${foods[0]}

# 查看所有元素
echo "食物概览: ${foods[*]}"
echo "食物概览: ${foods[@]}"

# 获取数组的长度
echo "食物数量：${#foods[*]}"
