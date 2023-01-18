## Parallels Desktop 上的 Ubuntu 密码忘记了，重置密码方法

打开终端，如下操作：
```shell
# 列出虚拟机
prlctl list

UUID                                    STATUS       IP_ADDR         NAME
{321c2dd8-5f50-42c9-9cc5-77b4d74cc916}  running      -               Ubuntu
```

然后，重新设置密码：
```shell
prlctl set 321c2dd8-5f50-42c9-9cc5-77b4d74cc916 --userpasswd kk:123456
```
设置成功，输出如下：
```shell
Authentication tokens updated successfully.
Success. The operation was successfully completed.

The VM has been successfully configured.
```