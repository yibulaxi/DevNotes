#!/bin/bash

# printf 简单使用
printf "Hello shell!\n"

# 复杂的使用
printf "%s %s %s\n" 姓名 性别 体重kg
printf "%s %s %f\n" 郭靖 男 66.33 

# 限制字符宽度，并且左对齐, -10s
printf "%-10s %-8s %-6s\n" name gender weight
printf "%-10s %-8s %-4.1f\n" kk male 68.89

# 转义序列
echo '\a'
printf "\a"

echo '\n'
printf '\n'

echo '\t'
printf '\t'
