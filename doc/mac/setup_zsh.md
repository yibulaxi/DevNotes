## Mac 配置 zsh

MacOS 在 Catalina 后，默认 shell 用的是 zsh。 查看当前终端 shell 用的是什么，用：`echo $SHELL`， 因此
环境变量是从 .zshrc 中开始的。

如果没有 .zshrc 这个文件，需要手动创建一个：`touch .zshrc`(在 ～/) 下，然后 .zshrc 里面加上如下内容：

``source ~/.bash_profile``

如果 .bash_profile 文件也没有，那么也手动创建一个，然后里面添加具体的需要配置的环境变量，如：
```shell
export ADB_HOME="/Users/kk/Library/Android/sdk/platform-tools"

export PATH=$PATH:$ADB_HOME
```

最后执行：`source ~/.zshrc` 配置的环境变量就生效了。
