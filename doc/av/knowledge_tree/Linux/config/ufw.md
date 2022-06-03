### 防火墙设置

使用 UFW 防火墙来确保只允许连接到某些服务.

应用程序可以在安装时向 UFW 注册其配置文件。这些配置文件允许 UFW 按名称管理这些应用程序。OpenSSH，允许我们现在连接到我们的服务器的服务，有一个在 UFW 注册的配置文件。

可以通过键入以下内容来查看：
```shell
ufw app list
```

输出结果：
```shell
Available applications:
  Bind9
  CUPS
  OpenSSH
```
需要确保防火墙允许 SSH 连接，以便下次可以重新登录。可以通过如下命令允许这些连接：
```shell
ufw allow OpenSSH
```

启用防火墙：
```shell
ufw enable
```

查看防火墙状态：
```shell
ufw status
```
如下：
```shell
Status: active

To                         Action      From
--                         ------      ----
OpenSSH                    ALLOW       Anywhere                  
OpenSSH (v6)               ALLOW       Anywhere (v6)     
```