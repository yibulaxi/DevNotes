### 修改用户名

默认用户名是：`lighthouse`

```shell
// step1 切换到 root 用户
sudu su 

// step2 打开 /etc/passwd 文件 找到 lighthouse 替换成新名字
// step3 打开 /etc/shadow 文件 找到 lighthouse 替换成新名字
// step4 打开 /etc/group 文件 找到 lighthouse 替换成新名字

// step5 修改用户目录名

// 切到用户目录: kk 是新的用户名
sudo su kk
```

实际操作如下：

```shell
lighthouse@VM-12-12-ubuntu:~$ sudo su
root@VM-12-12-ubuntu:/home/lighthouse# vim /etc/passwd
root@VM-12-12-ubuntu:/home/lighthouse# vim /etc/shadow
root@VM-12-12-ubuntu:/home/lighthouse# vim /etc/group
root@VM-12-12-ubuntu:/home/lighthouse# mv /home/lighthouse /home/kk
root@VM-12-12-ubuntu:/home/lighthouse# sudo su kk
kk@VM-12-12-ubuntu:~$ 
```

---

修改后，如果想重置 root 密码会失败。原因是只是改了用户名，但是没有改变 uid