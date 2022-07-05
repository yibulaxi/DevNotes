#!/bin/bash

# 删除变量，删除后不能再使用了。unset
my_name="kk"
unset my_name
echo $my_name
