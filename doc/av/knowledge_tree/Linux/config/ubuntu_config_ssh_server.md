## Ubuntu 配置 ssh 服务

- 安装 SSH 服务器：打开终端并输入 "sudo apt-get install openssh-server" 并回车。这将安装 SSH 服务器软件。

- 配置 SSH 服务器：打开配置文件 "/etc/ssh/sshd_config" 。可以使用命令 "sudo nano /etc/ssh/sshd_config" 打开。

- 修改配置文件: 修改配置文件中的默认端口号 (默认为22)，需要修改的话可以将 #Port 22 改为 Port 你需要的端口号。

- 重启 SSH 服务器: 输入 "sudo service ssh restart" 或 "sudo /etc/init.d/ssh restart" 重启 SSH 服务器。

- 检查 SSH 服务器状态: 输入 "sudo service ssh status" 检查 SSH 服务器是否正在运行。

- 设置防火墙: 若你使用了防火墙，需要在防火墙中添加 SSH 的端口号。可以使用 "sudo ufw allow ssh" 或 "sudo ufw allow 端口号" 来添加。

- 使用 SSH 客户端连接: 使用 SSH 客户端（如 PuTTY）连接到你的 Ubuntu 系统。在主机名或 IP 地址栏中输入你的 IP 地址，并在端口栏中输入你设置的端口号。然后使用你的用户名和密码登录。