#!/bin/bash

echo "Shell 传递参数练习:"

echo "我这个脚本的执行文件名：$0"
echo "传递的参数：$*"
echo "传递的参数：$@"
for arg in "$@"; do
	echo $arg
done

echo "参数数量：$#"
echo "第一个参数：$1"
echo "第二个参数：$2"
echo "第三个参数：$3"

echo "脚本运行的当前进程ID: $$"
echo "后台运行的最后一个进程ID: $!"
