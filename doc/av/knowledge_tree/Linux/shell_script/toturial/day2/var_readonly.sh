#!/bin/bash

# 只读变量
url="www.baidu.com"
readonly url

# 这个赋值操作会失败
url="www.google.com"
