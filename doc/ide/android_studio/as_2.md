## 大量的类报红，但是能正常编译运行

按照改变强度，尝试如下：

- Build -> Rebuild
- Build -> Clean Project -> Rebuild
- File -> Invalidate Caches...
- 删除项目跟目录下的 .gradle .idea
- 删除电脑用户目录下的 .gradle。 Mac 下在 `~/.gradle`
- 删除 Android Studio 的配置文件:
      - [配置文件路径，官方文档](https://developer.android.com/studio/intro/studio-config)
      - Mac 目录：`~/Library/Application Support/Google/<product><version>`
- 再次打开项目，重新构建完毕即可