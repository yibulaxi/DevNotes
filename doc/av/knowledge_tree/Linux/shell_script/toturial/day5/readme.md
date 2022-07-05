### Shell 

#### echo 命令

- 显示普通字符串
- 显示转义字符串
- 显示变量
- 显示换行
- 显示不换行
- 显示结果定向到文件
- 原样输出字符串，不进行转移或者取变量
- 显示命令执行结果

#### printf 命令

1. 简单的用法，和 echo 类似: `printf "hello shell\n"`
2. 复杂的用法，语法: `printf format-string [arguments...]`
	- 如下：
	```
	 printf "%-10s %-8s %5s\n" 姓名 性别 体重kg
	```
3. [转义字符，详细见](https://www.runoob.com/linux/linux-shell-printf.html)
