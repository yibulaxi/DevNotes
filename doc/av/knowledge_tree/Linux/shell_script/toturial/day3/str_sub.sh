#!/bin/bash

# 截取字符串
nums='12345678'

# 从第二个（索引为1）的字符串开始，截取三个字符
nums_sub=${nums:1:3}
echo $nums_sub
