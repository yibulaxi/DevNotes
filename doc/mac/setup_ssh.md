### Mac 配置 ssh

- 打开终端
- 执行命令：`ssh-keygen -t rsa`
如下：
```text
kk@192 ~ % ssh-keygen -t rsa
Generating public/private rsa key pair.
Enter file in which to save the key (/Users/kk/.ssh/id_rsa): 
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /Users/kk/.ssh/id_rsa
Your public key has been saved in /Users/kk/.ssh/id_rsa.pub
The key fingerprint is:
SHA256:2sn3h3RFZIf2kgAfs571sG8U/MYUSKjFsgbKUbDa/Nc kk@192.168.1.17
The key's randomart image is:
+---[RSA 3072]----+
|     .o.  o.=..++|
|     ... . =.=+.+|
|    ..o . = ooo*.|
|    +o   + . oo*=|
|   . o  S   o .o*|
|      .+ .. . .+ |
|      ..+..E o  o|
|        .. .. .. |
|            ..   |
+----[SHA256]-----+
```
- 然后生成公钥在 /Users/kk/.ssh/id_rsa.pub 中