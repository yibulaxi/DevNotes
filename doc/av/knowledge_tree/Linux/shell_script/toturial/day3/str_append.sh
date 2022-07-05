#!/bin/bash

# 拼接字符串
country1=China
country2=America

# 使用双引号拼接
str="two power: ${country1} and ${country2}"
echo $str

# 使用单引号拼接
str='two power: '$country1' and '$country2''
echo $str

