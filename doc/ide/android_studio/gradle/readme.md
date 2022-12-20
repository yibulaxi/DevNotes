## Gradle 

- [依赖](#依赖)


### 依赖

如下，依赖 ``org.jetbrains.kotlin:kotlin-gradle-plugin`` Gradle 同步后，会下载到本地
```shell
# Mac 下的路径
~/.gradle/caches/modules-2/files-2.1/org.jetbrains.kotlin/kotlin-gradle-plugin
```

会根据版本有多个目录：
```text
.
├── 1.3.72
│   ├── bbb8daa76a0c56eef3ec6395a06fd9c38ca80154
│   │   └── kotlin-gradle-plugin-1.3.72.jar
│   └── c00592b3e68bff6f14aa1740a2b8455d0fa3abe6
│       └── kotlin-gradle-plugin-1.3.72-sources.jar
├── 1.6.0
│   ├── 16b904295b92f797e37cbeb968dc100a9bad345d
│   │   └── kotlin-gradle-plugin-1.6.0.jar
│   └── 4cab4bb161fa95160a5e4005e7c60347da78ab67
│       └── kotlin-gradle-plugin-1.6.0-sources.jar
└── 1.6.10
    ├── 17584588cf4c6a08df474a905a02bfc5f43584ec
    │   └── kotlin-gradle-plugin-1.6.10-sources.jar
    └── c3217cee5b5185f784cd1bf5b6d6f56093047b3
        └── kotlin-gradle-plugin-1.6.10.jar
```