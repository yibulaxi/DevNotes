#!/bin/bash

# 编写脚本测试 192.168.0.0/24 整个网段中哪些主机处于开机状态,哪些主机处于关机
# 状态(for 版本)
for i in {1..254}
do
  # 每隔 3 秒 ping一次，一共 ping 2次，并以 1500毫秒为单位设置 ping的超时时间
     ping ‐c 2 ‐i 3 ‐W 1500 192.168.0.$i  &>/dev/null
    if  [ $? -eq 0 ];then
         echo "192.168.0.$i is up"
     else
         echo  "192.168.0.$i is down"
     fi
done