### Linux 配置 ssh

使用场景：Mac 电脑连接远程的 Linux 服务器。

首先远程的 Linux 服务器需要开启 ssh 服务,[具体配置参考](./ubuntu_config_ssh_server.md)


#### step1 Mac 上要生成密钥（如果没有生成的话）

可先查询是否有密钥，在当前用户目录下：
```shell
.ssh
├── id_rsa
├── id_rsa.pub
└── known_hosts
```

```shell
// 生成 rsa 密钥
ssh-keygen -t rsa
```

#### step2 复制 id_rsa.pub 里的公钥

注意：要全部复制。

#### step3 把 第二步的公钥追加到 Linux 服务器的 authorized_keys 文件中

authorized_keys 路径：`~/.ssh/authorized_keys`

```shell
echo '复制的公钥' >> ~/.ssh/authorized_keys
```

配置完成，用 ssh 测试下：

``ssh username@your-server-ip``

注：username 要替换成 Linux 服务器的用户名，your-server-ip 要替换成 Linux 服务器的 IP 地址。

