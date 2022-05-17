### Android Gradle 插件

#### 更新 Gradle

[官网文档](https://developer.android.com/studio/releases/gradle-plugin?hl=zh-cn)

下表列出了各个 Android Gradle 插件版本所需的 Gradle 版本。为了获得最佳性能，您应使用 Gradle 和插件这两者的最新版本。

| 插件版本      | 所需的 Gradle 版本 |
| ------------- | ------------------ |
| 1.0.0 - 1.1.3 | 2.2.1 - 2.3        |
| 1.2.0 - 1.3.1 | 2.2.1 - 2.9        |
| ...           | ...                |
| 4.2.0+        | 6.7.1+             |
| 7.0           | 7.0+               |
| 7.1           | 7.2+               |
| 7.2           | 7.3+               |

可以在 Android Studio 的 File > Project Structure > Project 菜单中指定 Gradle 版本，也可以通过在 gradle/wrapper/gradle-wrapper.properties 文件中修改 Gradle 分发引用来指定。以下示例在 gradle-wrapper.properties 文件中将 Gradle 的版本设置为 7.4.2。


