#!/bin/bash

# 单引号
str='this is a cat.'

echo $str

# 双引号
str="this is a dog."
echo $str

# 双引号中使用变量
str2="Look! $str"
echo $str2

# 输出转义字符，如：双引号
echo \"我在双引号里\"
