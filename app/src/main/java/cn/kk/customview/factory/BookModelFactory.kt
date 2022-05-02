package cn.kk.customview.factory

import cn.kk.customview.R
import cn.kk.customview.bean.BaseItem
import cn.kk.customview.bean.BookModel
import cn.kk.customview.bean.ItemChapterModel
import cn.kk.customview.bean.ItemSectionModel

/**
 * 课本工厂
 */
class BookModelFactory {

    companion object {

        open fun createBook(itemAction: Int): BookModel {
            val chapterModelList = mutableListOf<ItemChapterModel>()
            when(itemAction) {
                // region 《Android 开发艺术探索》
                BaseItem.action_book_1 -> {
                     chapterModelList.apply {
                        // chapter 1
                        add(ItemChapterModel("第一章 Activity 的生命周期和启动模式", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Activity 生命周期全面分析"))
                            add(ItemSectionModel("Activity 启动模式"))
                            add(ItemSectionModel("IntentFilter 的匹配规则"))
                        }))

                        // chapter 2
                        add(ItemChapterModel("第二章 IPC 机制", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android IPC 机制简介"))
                            add(ItemSectionModel("Android 中的多进程模式"))
                            add(ItemSectionModel("IPC 基础概念介绍"))
                            add(ItemSectionModel("Android 的 IPC 方式"))
                            add(ItemSectionModel("Binder 连接池"))
                            add(ItemSectionModel("选择合适的 IPC 方式"))
                        }))

                        // chapter 3
                        add(ItemChapterModel("第三章 View 的事件体系", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("View 基础知识"))
                            add(ItemSectionModel("View 的滑动"))
                            add(ItemSectionModel("弹性滑动"))
                            add(ItemSectionModel("View 事件的分发机制"))
                            add(ItemSectionModel("View 的滑动冲突"))
                        }))

                        // chapter 4
                        add(ItemChapterModel("第四章 View 的工作原理", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("初识 ViewRoot 和 DecorView"))
                            add(ItemSectionModel("理解 MeasureSpec"))
                            add(ItemSectionModel("View 的工作流程"))
                            add(ItemSectionModel("自定义 View"))
                        }))
                        // chapter 5
                        add(ItemChapterModel("第五章 理解 RemoteViews", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("RemoteViews 的应用"))
                            add(ItemSectionModel("RemoteViews 内部机制"))
                            add(ItemSectionModel("RemoteViews 的意义"))
                        }))

                        // chapter 6
                        add(ItemChapterModel("第六章 Android 的 Drawable", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Drawable 简介"))
                            add(ItemSectionModel("Drawable 分类"))
                            add(ItemSectionModel("自定义 Drawable"))
                        }))

                        // chapter 7
                        add(ItemChapterModel("第七章 动画", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("View 动画"))
                            add(ItemSectionModel("View 动画的特殊使用场景"))
                            add(ItemSectionModel("属性动画"))
                            add(ItemSectionModel("使用动画的注意事项"))
                        }))

                        // chapter 8
                        add(ItemChapterModel("第八章 理解 Window 和 WindowManager", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Window 和 WindowManager"))
                            add(ItemSectionModel("Window 的内部机制"))
                            add(ItemSectionModel("Window 的创建过程"))
                        }))
                        // chapter 9
                        add(ItemChapterModel("第九章 四大组件工作过程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("四大组件运行状态"))
                            add(ItemSectionModel("Activity 的工作过程"))
                            add(ItemSectionModel("Service 的工作过程"))
                            add(ItemSectionModel("BroadcastReceiver 的工作过程"))
                            add(ItemSectionModel("ContentProvider 的工作过程"))
                        }))
                        // chapter 10
                        add(ItemChapterModel("第十章 Android 的消息机制", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android 的消息机制概述"))
                            add(ItemSectionModel("Android 的消息机制分析"))
                            add(ItemSectionModel("主线程的消息循环"))
                        }))

                        // chapter 11
                        add(ItemChapterModel("第十一章 Android 的线程和线程池", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("主线程和子线程"))
                            add(ItemSectionModel("Android 中的线程状态"))
                            add(ItemSectionModel("Android 中的线程池"))
                        }))

                        // chapter 12
                        add(ItemChapterModel("第十二章 Bitmap 的加载和 Cache", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Bitmap 的高效加载"))
                            add(ItemSectionModel("Android 中的缓存策略"))
                            add(ItemSectionModel("ImageLoader 的使用"))
                        }))

                        // chapter 13
                        add(ItemChapterModel("第十三章 综合技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("使用 CrashHandler 来获取应用的 crash 信息"))
                            add(ItemSectionModel("使用 multidex 来解决方法数越界"))
                            add(ItemSectionModel("Android 的动态加载技术"))
                            add(ItemSectionModel("反编译初步"))
                        }))

                        // chapter 14
                        add(ItemChapterModel("第十四章 JNI 和 NDK 编程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("JNI 开发流程"))
                            add(ItemSectionModel("NDK 开发流程"))
                            add(ItemSectionModel("JNI 数据类型和类型签名"))
                            add(ItemSectionModel("JNI 调用 Java 方法的流程"))
                        }))

                        // chapter 15
                        add(ItemChapterModel("第十五章 Android 性能优化", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("性能优化方法"))
                            add(ItemSectionModel("内存泄漏分析之 MAT 工具"))
                            add(ItemSectionModel("提高程序的可维护性"))
                        }))
                    }

                    return BookModel("Android\n开发艺术探索", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_1 }
                }
                // endregion

                // region 《Linux 命令行与 shell 脚本编程大全》
                BaseItem.action_book_2 -> {
                        chapterModelList.apply {
                        // chapter 1
                        add(ItemChapterModel("第 1 章 初识 Linux shell", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("什么是 Linux"))
                            add(ItemSectionModel("Linux 发行版"))
                        }))

                        // chapter 2
                        add(ItemChapterModel("第 2 章 走进 shell", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("进入命令行"))
                            add(ItemSectionModel("通过 linux 控制台终端访问 CLI"))
                            add(ItemSectionModel("通过图形化终端访问 CLI"))
                        }))

                        // chapter 3
                        add(ItemChapterModel("第 3 章 基本的 bash shell 命令", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("启动 shell"))
                            add(ItemSectionModel("shell 提示符"))
                            add(ItemSectionModel("bash 手册"))
                            add(ItemSectionModel("浏览文件系统"))
                            add(ItemSectionModel("文件和目录列表"))
                            add(ItemSectionModel("处理文件"))
                            add(ItemSectionModel("处理目录"))
                            add(ItemSectionModel("查看文件内容"))
                        }))

                        // chapter 4
                        add(ItemChapterModel("第 4 章 更多的 bash shell 命令", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("检测程序"))
                            add(ItemSectionModel("检测磁盘空间"))
                            add(ItemSectionModel("处理数据文件"))
                        }))

                        // chapter 5
                        add(ItemChapterModel("第 5 章 理解 shell", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("shell 类型"))
                            add(ItemSectionModel("shell 父子关系"))
                            add(ItemSectionModel("shell 的内建命令"))
                        }))

                        // chapter 6
                        add(ItemChapterModel("第 6 章 使用 linux 环境变量", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("什么是环境变量"))
                        }))

                        // chapter 7
                        add(ItemChapterModel("第 7 章 理解 Linux 文件权限", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Linux 的安全性"))
                        }))

                        // chapter 8
                        add(ItemChapterModel("第 8 章 管理文件系统", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("探索 Linux 文件系统"))
                        }))

                        // chapter 9
                        add(ItemChapterModel("第 9 章 安装软件程序", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("包管理基础"))
                            add(ItemSectionModel("基于 Debian 的系统"))
                            add(ItemSectionModel("基于 Red Hat 的系统"))
                            add(ItemSectionModel("从源码安装"))
                        }))

                        // chapter 10
                        add(ItemChapterModel("第 10 章 使用编辑器", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("vim"))
                            add(ItemSectionModel("nano"))
                            add(ItemSectionModel("emacs"))
                            add(ItemSectionModel("KDE 系编辑器"))
                            add(ItemSectionModel("GNOME 编辑器"))
                        }))

                        // chapter 11
                        add(ItemChapterModel("第 11 章 构建基本脚本", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("使用多个命令"))
                            add(ItemSectionModel("创建 shell 脚本文件"))
                            add(ItemSectionModel("显示消息"))
                            add(ItemSectionModel("使用变量"))
                            add(ItemSectionModel("重定向输入和输出"))
                            add(ItemSectionModel("管道"))
                            add(ItemSectionModel("执行数学运算"))
                            add(ItemSectionModel("退出脚本"))
                        }))

                        // chapter 12
                        add(ItemChapterModel("第 12 章 使用结构化命令", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("if-then 语句"))
                            add(ItemSectionModel("if-then-else 语句"))
                            add(ItemSectionModel("嵌套 if"))
                            add(ItemSectionModel("test 命令"))
                            add(ItemSectionModel("复合条件测试"))
                            add(ItemSectionModel("if-then 的高级特性"))
                            add(ItemSectionModel("case 命令"))
                        }))

                        // chapter 13
                        add(ItemChapterModel("第 14 章 更多的结构化命令", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("for 命令"))
                            add(ItemSectionModel("C 语音风格的 for 命令"))
                            add(ItemSectionModel("while 命令"))
                            add(ItemSectionModel("until 命令"))
                            add(ItemSectionModel("嵌套循环"))
                            add(ItemSectionModel("循环处理文件数据"))
                            add(ItemSectionModel("控制循环"))
                            add(ItemSectionModel("处理循环的输出"))
                            add(ItemSectionModel("实例"))
                        }))

                        // chapter 14
                        add(ItemChapterModel("第 14 章 处理用户输入", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("命令行参数"))
                            add(ItemSectionModel("特殊参数变量"))
                            add(ItemSectionModel("移动变量"))
                            add(ItemSectionModel("处理选项"))
                            add(ItemSectionModel("将选项标准化"))
                            add(ItemSectionModel("获得用户输入"))
                        }))

                        // chapter 15
                        add(ItemChapterModel("第 15 章 呈现数据", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("理解输入和输出"))
                            add(ItemSectionModel("在脚本中重定向输出"))
                            add(ItemSectionModel("在脚本中重定向输入"))
                            add(ItemSectionModel("创建自己的重定向"))
                            add(ItemSectionModel("列出打开的文件描述符"))
                            add(ItemSectionModel("阻止命令输出"))
                            add(ItemSectionModel("创建临时文件"))
                            add(ItemSectionModel("记录消息"))
                            add(ItemSectionModel("实例"))
                        }))

                        // chapter 16
                        add(ItemChapterModel("第 16 章 控制脚本", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("处理信号"))
                            add(ItemSectionModel("以后台模式运行脚本"))
                            add(ItemSectionModel("在非控制台下运行脚本"))
                            add(ItemSectionModel("作业控制"))
                            add(ItemSectionModel("调整谦让度"))
                            add(ItemSectionModel("定时运行作业"))
                        }))

                        // chapter 17
                        add(ItemChapterModel("第 17 章 创建函数", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("基本的脚本函数"))
                            add(ItemSectionModel("返回值"))
                            add(ItemSectionModel("在函数中使用变量"))
                            add(ItemSectionModel("数组变量和函数"))
                            add(ItemSectionModel("函数递归"))
                            add(ItemSectionModel("创建库"))
                            add(ItemSectionModel("在命令行上使用函数"))
                            add(ItemSectionModel("实例"))
                        }))

                        // chapter 18
                        add(ItemChapterModel("第 18 章 图形化桌面环境中的脚本编程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("创建文本菜单"))
                            add(ItemSectionModel("制作窗口"))
                            add(ItemSectionModel("使用图形"))
                        }))

                        // chapter 19
                        add(ItemChapterModel("第 19 章 初识 sed 和 gawk", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("文本处理"))
                            add(ItemSectionModel("sed 编辑器基础"))
                        }))

                        // chapter 20
                        add(ItemChapterModel("第 20 章 正则表达式", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("什么是正则表达式"))
                            add(ItemSectionModel("定义 BRE 模式"))
                            add(ItemSectionModel("扩展正则表达式"))
                            add(ItemSectionModel("实战"))
                        }))

                        // chapter 21
                        add(ItemChapterModel("第 21 章 sed 进阶", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("多行命令"))
                            add(ItemSectionModel("保持空间"))
                            add(ItemSectionModel("排除命令"))
                            add(ItemSectionModel("改变流"))
                            add(ItemSectionModel("模式替代"))
                            add(ItemSectionModel("在脚本中使用 sed"))
                            add(ItemSectionModel("创建 sed 实用工具"))
                        }))

                        // chapter 22
                        add(ItemChapterModel("第 22 章 gawk 进阶", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("使用变量"))
                            add(ItemSectionModel("处理数组"))
                            add(ItemSectionModel("使用模式"))
                            add(ItemSectionModel("结构化命令"))
                            add(ItemSectionModel("格式化命令"))
                            add(ItemSectionModel("格式化打印"))
                            add(ItemSectionModel("内建函数"))
                            add(ItemSectionModel("自定义函数"))
                            add(ItemSectionModel("实例"))
                        }))

                        // chapter 23
                        add(ItemChapterModel("第 23 章 使用其他 shell", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("dash shell"))
                            add(ItemSectionModel("dash shell 的特性"))
                            add(ItemSectionModel("dash 脚本编程"))
                            add(ItemSectionModel("zsh shell"))
                            add(ItemSectionModel("zsh shell 的组成"))
                            add(ItemSectionModel("zsh 脚本编程"))
                        }))

                        // chapter 24
                        add(ItemChapterModel("第 24 章 编写简单的脚本实用工具", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("归档"))
                            add(ItemSectionModel("管理用户账户"))
                            add(ItemSectionModel("检测磁盘空间"))
                        }))

                        // chapter 25
                        add(ItemChapterModel("第 25 章 创建与数据库、Web 及电子邮件相关的脚本", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("MySQL 数据库"))
                            add(ItemSectionModel("使用 Web"))
                            add(ItemSectionModel("使用 电子邮件"))
                        }))

                        // chapter 26
                        add(ItemChapterModel("第 26 章 一些小有意思的脚本", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("发送消息"))
                            add(ItemSectionModel("获取格言"))
                            add(ItemSectionModel("编造借口"))
                        }))
                    }

                    return BookModel("Linux 命令行与\nshell 脚本编程大全", itemAction, chapterModelList).apply { bookImgRes =  R.drawable.bg_book_2 }
                }
                // endregion

                // region《Android\n自定义控件开发入门与实践》, 图书网址：(http://www.broadview.com.cn/book/93)
                BaseItem.action_book_3 -> {
                    // chapter 1
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 绘图基础", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("基本图形绘制"))
                            add(ItemSectionModel("路径"))
                            add(ItemSectionModel("Region"))
                            add(ItemSectionModel("Canvas"))
                        }))
                    }

                    // chapter 2
                    chapterModelList.apply {
                        add(ItemChapterModel("第 2 章 视图动画", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("视图动画标签"))
                            add(ItemSectionModel("视图动画第代码实现"))
                            add(ItemSectionModel("插值器初探"))
                            add(ItemSectionModel("动画示例"))
                            add(ItemSectionModel("逐帧动画"))
                        }))
                    }

                    // chapter 3
                    chapterModelList.apply {
                        add(ItemChapterModel("第 3 章 属性动画", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("ValueAnimator 的基本使用"))
                            add(ItemSectionModel("自定义差值器与 Evaluator"))
                            add(ItemSectionModel("ValueAnimator 进阶——ofObject"))
                            add(ItemSectionModel("ObjectAnimator"))
                            add(ItemSectionModel("组合动画"))
                            add(ItemSectionModel("Animator 动画的 XML 实现"))
                        }))
                    }

                    // chapter 4
                    chapterModelList.apply {
                        add(ItemChapterModel("第 4 章 属性动画进阶", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Property ValuesHolder 与 Keyframe"))
                            add(ItemSectionModel("ViewPropertyAnimator"))
                            add(ItemSectionModel("为 ViewGroup 内的组件添加动画"))
                            add(ItemSectionModel("开源动画库 NineOldAndroids"))
                        }))
                    }

                    // chapter 5
                    chapterModelList.apply {
                        add(ItemChapterModel("第 5 章 动画进阶", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("利用 PathMeasure 实现路径动画"))
                            add(ItemSectionModel("SVG 动画"))
                        }))
                    }
                    // chapter 6
                    chapterModelList.apply {
                        add(ItemChapterModel("第 6 章 Paint 的基本使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("硬件加速"))
                            add(ItemSectionModel("文字"))
                            add(ItemSectionModel("Paint 常用函数"))
                        }))
                    }
                    // chapter 7
                    chapterModelList.apply {
                        add(ItemChapterModel("第 7 章 绘图进阶", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("贝塞尔曲线"))
                            add(ItemSectionModel("setShadowLayer 与阴影效果"))
                            add(ItemSectionModel("BlurMaskFilter 发光效果与图片阴影"))
                            add(ItemSectionModel("Shader 与 BitmapShader"))
                            add(ItemSectionModel("Shader 之 LinearGradient"))
                            add(ItemSectionModel("Shader 之 RadialGradient"))
                        }))
                    }

                    // chapter 8
                    chapterModelList.apply {
                        add(ItemChapterModel("第 8 章 混合模式", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("AvoidXfermode"))
                            add(ItemSectionModel("PorterDuffXfermode"))
                            add(ItemSectionModel("PorterDuffXfermode 之源图像模式"))
                            add(ItemSectionModel("目标图像模式与其他模式"))
                        }))
                    }

                    // chapter 9
                    chapterModelList.apply {
                        add(ItemChapterModel("第 9 章 Canvas 与图层", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("获取 Canvas 对象的方法"))
                            add(ItemSectionModel("涂层与画布"))
                            add(ItemSectionModel("Flag 的具体含义"))
                            add(ItemSectionModel("恢复画布"))
                        }))
                    }

                    // chapter 10
                    chapterModelList.apply {
                        add(ItemChapterModel("第 10 章 Android 画布", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("ShapeDrawable"))
                            add(ItemSectionModel("Bitmap"))
                            add(ItemSectionModel("SurfaceView"))
                        }))
                    }

                    // chapter 11
                    chapterModelList.apply {
                        add(ItemChapterModel("第 11 章 Matrix 与坐标变换", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("放网上了（电脑本地文件：34556-放网上第1章和第11章.pdf）"))
                        }))
                    }

                    // chapter 12
                    chapterModelList.apply {
                        add(ItemChapterModel("第 12 章 封装控件", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("自定义属性与自定义 style"))
                            add(ItemSectionModel("测量与布局"))
                            add(ItemSectionModel("实现 FlowLayout 容器"))
                        }))
                    }

                    // chapter 13
                    chapterModelList.apply {
                        add(ItemChapterModel("第 13 章 控件高级属性", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("GestureDector 手势检测"))
                            add(ItemSectionModel("Window 与 WindowManager"))
                        }))
                    }


                    return BookModel("Android\n自定义控件开发入门与实践", itemAction, chapterModelList).apply { bookImgRes =  R.drawable.bg_book_3 }
                }
                // endregion

                // region 《Android 进阶之光》
                BaseItem.action_book_4 -> {

                    // chapter 1
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 Android 新特性", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android 5.0 新特性"))
                            add(ItemSectionModel("Android 6.0 新特性"))
                            add(ItemSectionModel("Android 7.0 新特性"))
                        }))
                    }
                    // chapter 2
                    chapterModelList.apply {
                        add(ItemChapterModel("第 2 章 Material Design", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Material Design 概述"))
                            add(ItemSectionModel("Design Support Library 常用控件详解"))
                        }))
                    }
                    // chapter 3
                    chapterModelList.apply {
                        add(ItemChapterModel("第 3 章 View 体系与自定义 View", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("View 和 ViewGroup"))
                            add(ItemSectionModel("坐标系"))
                            add(ItemSectionModel("View 的滑动"))
                            add(ItemSectionModel("属性动画"))
                            add(ItemSectionModel("解析 Scroller"))
                            add(ItemSectionModel("View 的事件分发机制"))
                            add(ItemSectionModel("View 的工作流程"))
                            add(ItemSectionModel("自定义 View"))
                            add(ItemSectionModel("自定义 ViewGroup"))
                        }))
                    }
                    // chapter 4
                    chapterModelList.apply {
                        add(ItemChapterModel("第 4 章 多线程编程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("线程基础"))
                            add(ItemSectionModel("同步"))
                            add(ItemSectionModel("阻塞队列"))
                            add(ItemSectionModel("线程池"))
                            add(ItemSectionModel("AsyncTask 原理"))
                        }))
                    }
                    // chapter 5
                    chapterModelList.apply {
                        add(ItemChapterModel("第 5 章 网络编程与网络框架", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("网络分层"))
                            add(ItemSectionModel("TCP 三次握手与四次挥手"))
                            add(ItemSectionModel("HTTP 协议原理"))
                            add(ItemSectionModel("HttpClient 与 HttpURLConnection"))
                            add(ItemSectionModel("解析 Volley"))
                            add(ItemSectionModel("解析 OkHttp"))
                            add(ItemSectionModel("解析 Retrofit"))
                        }))
                    }
                    // chapter 6
                    chapterModelList.apply {
                        add(ItemChapterModel("第 6 章 设计模式", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("六大原则"))
                            add(ItemSectionModel("分类"))
                            add(ItemSectionModel("创建型"))
                            add(ItemSectionModel("结构型"))
                            add(ItemSectionModel("行为型"))
                        }))
                    }
                    // chapter 7
                    chapterModelList.apply {
                        add(ItemChapterModel("第 7 章 事件总线", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("EventBus"))
                            add(ItemSectionModel("otto"))
                        }))
                    }
                    // chapter 8
                    chapterModelList.apply {
                        add(ItemChapterModel("第 8 章 函数响应式编程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("RxJava 基本用法"))
                            add(ItemSectionModel("RxJava 的 Subject"))
                            add(ItemSectionModel("RxJava 操作符入门"))
                            add(ItemSectionModel("RxJava 线程控制"))
                            add(ItemSectionModel("RxJava 使用场景"))
                            add(ItemSectionModel("RxJava 源码解析"))
                        }))
                    }  // chapter 9
                    chapterModelList.apply {
                        add(ItemChapterModel("第 9 章 注解与依赖注入框架", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("注解"))
                            add(ItemSectionModel("依赖注入的原理"))
                            add(ItemSectionModel("依赖注入框架"))
                        }))
                    }
                    // chapter 10
                    chapterModelList.apply {
                        add(ItemChapterModel("第 10 章 应用架构设计", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("MVC"))
                            add(ItemSectionModel("MVP"))
                            add(ItemSectionModel("MVVM"))
                        }))
                    }
                    // chapter 11
                    chapterModelList.apply {
                        add(ItemChapterModel("第 11 章 系统架构与 MediaPlayer 框架", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android 系统架构"))
                            add(ItemSectionModel("Android 系统源码目录"))
                            add(ItemSectionModel("Source Insight 使用"))
                            add(ItemSectionModel("MediaPlayer 框架"))
                        }))
                    }

                    return BookModel("Android\n开发艺术探索", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_4 }
                }
                // endregion

                // region 《Android编程权威指南》
                BaseItem.action_book_5 -> {
                    chapterModelList.apply {
                        // chapter 1
                        add(ItemChapterModel("第 1 章 Android 开发初体验", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android 开发基础"))
                            add(ItemSectionModel("创建 Android 项目"))
                            add(ItemSectionModel("Android Studio 使用导航"))
                            add(ItemSectionModel("用户界面设计"))
                            add(ItemSectionModel("从布局 XML 到视图对象"))
                            add(ItemSectionModel("部件的实际应用"))
                            add(ItemSectionModel("创建提示消息"))
                            add(ItemSectionModel("使用模拟器运行应用"))
                            add(ItemSectionModel("深入学习：Android 编译过程"))
                        }))
                        // chapter 2
                        add(ItemChapterModel("第 2 章 Android 与 MVC 设计模式", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 3
                        add(ItemChapterModel("第 3 章 Activity 生命周期", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("旋转 GeoQuiz 应用"))
                        }))
                        // chapter 4
                        add(ItemChapterModel("第 4 章 UI 状态的保存与恢复", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("引入 ViewModel 依赖"))
                            add(ItemSectionModel("添加 ViewModel"))
                            add(ItemSectionModel("进程销毁时保存数据"))
                            add(ItemSectionModel("ViewModel 与保存实例状态"))
                            add(ItemSectionModel("深入学习：Jetpack、AndroidX 与 架构组件"))
                        }))
                        // chapter 5
                        add(ItemChapterModel("第 5 章 Android 应用的调试", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("异常与栈跟踪"))
                            add(ItemSectionModel("Android 特有的调试工具"))
                            add(ItemSectionModel("挑战练习：探索布局检查器"))
                            add(ItemSectionModel("挑战练习：探索 Android 性能分析器"))
                        }))
                        // chapter 6
                        add(ItemChapterModel("第 6 章 第二个 Activity", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 7
                        add(ItemChapterModel("第 7 章 Android SDK 版本与兼容", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android SDK 版本"))
                            add(ItemSectionModel("Android 编程与兼容性问题"))
                            add(ItemSectionModel("使用 Android 开发者文档"))
                            add(ItemSectionModel("挑战练习： 报告编译版本"))
                        }))
                        // chapter 8
                        add(ItemChapterModel("第 8 章 UI fragment 与 Fragment 管理器", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("UI 设计的灵活性需求"))
                            add(ItemSectionModel("引入 fragment"))
                        }))
                        // chapter 9
                        add(ItemChapterModel("第 9 章 使用 RecyclerView 显示列表", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(""))
                        }))
                        // chapter 10
                        add(ItemChapterModel("第 10 章 使用约束布局", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 11
                        add(ItemChapterModel("第 11 章 数据库与 Room 库", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Room 架构组件库"))
                            add(ItemSectionModel("创建数据库"))
                        }))
                        // chapter 12
                        add(ItemChapterModel("第 12 章 Fragment Navigation", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("单 Activity 多 Fragment"))
                            add(ItemSectionModel("Fragment argument"))
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 13
                        add(ItemChapterModel("第 13 章 对话框", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("创建 DialogFragment"))
                            add(ItemSectionModel("fragment 间的数据传递"))
                            add(ItemSectionModel("挑战练习：事件选择对话框"))
                        }))
                        // chapter 14
                        add(ItemChapterModel("第 14 章 应用栏", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("AppCompat 默认应用栏"))
                            add(ItemSectionModel("应用栏菜单"))
                            add(ItemSectionModel("使用 Android Assets Studio"))
                            add(ItemSectionModel("深入学习：应用栏、状态栏、工具栏"))
                            add(ItemSectionModel("深入学习：AppCompat 版应用栏"))
                            add(ItemSectionModel("挑战练习：RecyclerView 空视图"))
                        }))
                        // chapter 15
                        add(ItemChapterModel("第 15 章 隐式 intent", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 16
                        add(ItemChapterModel("第 16 章 使用 intent 拍照", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("布置照片"))
                            add(ItemSectionModel("文件存储"))
                            add(ItemSectionModel("使用相机 intent"))
                            add(ItemSectionModel("缩放和显示位图"))
                            add(ItemSectionModel("功能声明"))
                            add(ItemSectionModel("挑战练习：优化照片显示"))
                            add(ItemSectionModel("挑战练习：优化缩略图加载"))
                        }))
                        // chapter 17
                        add(ItemChapterModel("第 17 章 应用本地化", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("资源本地化"))
                            add(ItemSectionModel("配置修饰符"))
                            add(ItemSectionModel("测试备选资源"))
                            add(ItemSectionModel("深入学习：确定设备屏幕尺寸"))
                            add(ItemSectionModel("挑战练习：日期显示本地化"))
                        }))
                        // chapter 18
                        add(ItemChapterModel("第 18 章 Android 辅助功能", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("TalkBack"))
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 19
                        add(ItemChapterModel("第 19 章 数据绑定与 MVVM", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("为何要用 MVVM 架构"))
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 20
                        add(ItemChapterModel("第 20 章 音频播放与单元测试", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("创建 SoundPool"))
                            add(ItemSectionModel("访问 Assets"))
                            add(ItemSectionModel("..."))
                            add(ItemSectionModel("深入学习：整合测试"))
                            add(ItemSectionModel("深入学习：模拟对象与测试"))
                        }))
                        // chapter 21
                        add(ItemChapterModel("第 21 章 样式与主题", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("颜色资源"))
                            add(ItemSectionModel("样式"))
                            add(ItemSectionModel("主题"))
                            add(ItemSectionModel("添加主题颜色"))
                            add(ItemSectionModel("覆盖主题属性"))
                            add(ItemSectionModel("修改按钮属性"))
                            add(ItemSectionModel("深入学习：样式继承拾遗"))
                            add(ItemSectionModel("深入学习：引用主题属性"))
                        }))
                        // chapter 22
                        add(ItemChapterModel("第 22 章 XML drawable", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("统一样式修改"))
                            add(ItemSectionModel("shape drawable"))
                            add(ItemSectionModel("..."))
                            add(ItemSectionModel("深入学习：为什么要使用 XML drawable"))
                            add(ItemSectionModel("深入学习：使用 mipmap 图像"))
                            add(ItemSectionModel("深入学习：使用 9-patch 图像"))
                            add(ItemSectionModel("挑战练习：按钮主题"))
                        }))
                        // chapter 23
                        add(ItemChapterModel("第 23 章 深入学习 intent 和任务", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("隐式 intent"))
                            add(ItemSectionModel("任务与回退栈"))
                            add(ItemSectionModel("深入学习：进程与任务"))
                            add(ItemSectionModel("深入学习：并发文档"))
                            add(ItemSectionModel("挑战练习：应用图标"))
                        }))
                        // chapter 24
                        add(ItemChapterModel("第 24 章 HTTP 与后台任务", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Retrofit 网络连接基本"))
                            add(ItemSectionModel("从 Flickr 获取 JSON 数据"))
                            add(ItemSectionModel("应用设备配置改变"))
                            add(ItemSectionModel("..."))
                            add(ItemSectionModel("深入学习：其他 JSON 数据解析器和数据格式"))
                            add(ItemSectionModel("深入学习：撤销网络请求"))
                            add(ItemSectionModel("深入学习：管理依赖"))
                            add(ItemSectionModel("挑战练习：自定义 Gson 反序列化器"))
                            add(ItemSectionModel("挑战练习：分页"))
                            add(ItemSectionModel("挑战练习：动态调整网格列"))
                        }))// chapter 25
                        add(ItemChapterModel("第 25 章 Looper、Handler 和 HandlerThread", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))// chapter 26
                        add(ItemChapterModel("第 26 章 搜索", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("搜索 Flickr 网站"))
                            add(ItemSectionModel("使用 SearchView"))
                            add(ItemSectionModel("sharedpreferences"))
                            add(ItemSectionModel("用 Android KTX 编辑 SharedPreferences"))
                        }))
                        // chapter 27
                        add(ItemChapterModel("第 27 章 WorkManger", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 28
                        add(ItemChapterModel("第 28 章 broadcast intent", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("普通 intent 与 broadcast intent"))
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 29
                        add(ItemChapterModel("第 29 章 网页浏览", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("最后一段 Flickr 数据"))
                            add(ItemSectionModel("简单方式：使用隐式 intent"))
                            add(ItemSectionModel("较难的方式：使用 WebView"))
                            add(ItemSectionModel("处理 WebView 的设备旋转问题"))
                            add(ItemSectionModel("WebView 与定制 UI"))
                            add(ItemSectionModel("深入学习：注入 JavaScript 对象"))
                            add(ItemSectionModel("深入学习：WebView 升级"))
                            add(ItemSectionModel("深入学习：Chrome Custom Tabs"))
                            add(ItemSectionModel("挑战练习：使用回退键浏览历史网页"))
                        }))
                        // chapter 30
                        add(ItemChapterModel("第 30 章 定制视图与触摸事件", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                        // chapter 31
                        add(ItemChapterModel("第 31 章 属性动画", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("..."))
                        }))
                    }
                    return BookModel("Android\n编程权威指南", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_5 }
                }
                // endregion

                // region Git
                BaseItem.action_book_6 -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("介绍", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("背景"))
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("安装 Git", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("起步", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("基本的 Git 概念", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("文件管理和索引", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("提交", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("分支", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("diff", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("合并", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("更改提交", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("储藏和引用日志", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("远程版本库", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("版本库管理", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("补丁", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("钩子", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("合并项目", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("子模块最佳实战", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("结合 SVN 版本库使用 Git", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("高级操作", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("提示、技巧和技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                        add(ItemChapterModel("Git 和 GitHub", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel(".."))
                        }))
                    }
                    return BookModel("Git", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_6 }
                }
                // endregion

                // region 最强Android书架构大剖析
                BaseItem.action_book_7 -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 Android 体系结构的变革之路", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android 系统版本的历史变迁"))
                            add(ItemSectionModel("Android 与 Linux"))
                            add(ItemSectionModel("Android 的衍生产品"))
                            add(ItemSectionModel("对前方道路的思考"))
                        }))
                        add(ItemChapterModel("第 2 章 Android 的分区和文件系统", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("分区架构"))
                            add(ItemSectionModel("Android 文件系统中存储的内容"))
                            add(ItemSectionModel("受保护的文件系统"))
                            add(ItemSectionModel("Linux 伪文件系统"))
                        }))
                        add(ItemChapterModel("第 3 章 Android 的启动、备份和重置", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Android 系统镜像"))
                            add(ItemSectionModel("启动过程"))
                            add(ItemSectionModel("关机和重启"))
                            add(ItemSectionModel("应用的备份和恢复"))
                            add(ItemSectionModel("系统重置（recovery）和升级"))
                        }))
                        add(ItemChapterModel("第 4 章 init", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("init 的角色和任务"))
                            add(ItemSectionModel("init 和 USB"))
                            add(ItemSectionModel("init 的其他角色"))
                        }))
                        add(ItemChapterModel("第 5 章 Android 的守护进程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("core 类中的服务"))
                            add(ItemSectionModel("网络相关服务"))
                            add(ItemSectionModel("图形及多媒体服务"))
                            add(ItemSectionModel("其他服务"))
                        }))
                        add(ItemChapterModel("第 6 章 框架服务的架构", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("再探 servicemanager"))
                            add(ItemSectionModel("服务调用的模式"))
                            add(ItemSectionModel("binder"))
                            add(ItemSectionModel("system_server"))
                        }))
                        add(ItemChapterModel("第 7 章 从 Linux 角度看 Android", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("重温 /proc"))
                            add(ItemSectionModel("用户模式内存管理"))
                            add(ItemSectionModel("跟踪系统调用"))
                        }))
                        add(ItemChapterModel("第 8 章 Android 安全性", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("移动安全威胁建模"))
                            add(ItemSectionModel("Linux 层上的安全措施"))
                            add(ItemSectionModel("Dalvik 层上的安全措施"))
                            add(ItemSectionModel("用户层上的安全措施"))
                            add(ItemSectionModel("存储安全"))
                            add(ItemSectionModel("Root Android 设备"))
                        }))
                    }
                    return BookModel("最强Android书架构大剖析", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_7 }
                }
                // endregion

                // region Android 插件化开发指南
                BaseItem.action_book_8 -> {
                     chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 插件化技术的昨天、今天和明天", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("插件化技术是什么"))
                            add(ItemSectionModel("为什么需要插件化"))
                            add(ItemSectionModel("插件化技术的历史"))
                            add(ItemSectionModel("插件化技术的用途到底是什么"))
                            add(ItemSectionModel("更好的替代产品：React Native"))
                            add(ItemSectionModel("只有中国这么玩吗"))
                            add(ItemSectionModel("四大组件都需要插件化技术吗"))
                            add(ItemSectionModel("双开和虚拟机"))
                            add(ItemSectionModel("从原生页面到 HTML 5 的过度"))
                        }))
                         add(ItemChapterModel("第 2 章 Android 底层知识", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("概述"))
                             add(ItemSectionModel("Binder 原理"))
                             add(ItemSectionModel("AIDL 原理"))
                             add(ItemSectionModel("AMS"))
                             add(ItemSectionModel("Activity 工作原理"))
                             add(ItemSectionModel("App 内部的页面跳转"))
                             add(ItemSectionModel("Context 家族史"))
                             add(ItemSectionModel("Service 工作原理"))
                             add(ItemSectionModel("BroadcastReceiver 工作原理"))
                             add(ItemSectionModel("ContentProvider 工作原理"))
                             add(ItemSectionModel("PMS 及 App 安装过程"))
                             add(ItemSectionModel("ClassLoader 家族史"))
                             add(ItemSectionModel("双亲委托"))
                             add(ItemSectionModel("MultiDex"))
                             add(ItemSectionModel("实现一个音乐播放器 App"))
                         }))
                         add(ItemChapterModel("第 3 章 反射", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("基本反射技术"))
                             add(ItemSectionModel("jOOR"))
                             add(ItemSectionModel("对基本反射语法的封装"))
                             add(ItemSectionModel("对反射的进一步封装"))
                         }))
                         add(ItemChapterModel("第 4 章 代理模式", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("概述"))
                             add(ItemSectionModel("静态代理和动态代理"))
                             add(ItemSectionModel("对 AMN 的 Hook"))
                             add(ItemSectionModel("对 PMS 的 Hook"))
                         }))
                         add(ItemChapterModel("第 5 章 对 startActivity 方法进行 Hook", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("startActivity 方法的两种形式"))
                             add(ItemSectionModel("对 Activity 的 startActivity 方法进行 Hook"))
                             add(ItemSectionModel("对 Context 的 startActivity 方法进行 Hook"))
                             add(ItemSectionModel("启动没有在 AndroidManifest 中声明的 Activity"))
                             add(ItemSectionModel("欺骗AMS 的策略分析"))
                             add(ItemSectionModel("Hook 的上半场"))
                             add(ItemSectionModel("Hook 的下半场：对 H 类的 mCallback 字段进行 Hook"))
                             add(ItemSectionModel("Hook 的下半场：对 ActvityThread 的 mInstrumentation 字段进行 Hook"))
                             add(ItemSectionModel("欺骗AMS 的弊端"))
                         }))
                         add(ItemChapterModel("第 6 章 插件化技术基础知识", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("加载外部的 dex"))
                             add(ItemSectionModel("面向接口编程"))
                             add(ItemSectionModel("插件的瘦身"))
                             add(ItemSectionModel("对插件进行代码调试"))
                             add(ItemSectionModel("Application 的插件化解决方案"))
                         }))
                         add(ItemChapterModel("第 7 章 资源初探", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("资源加载机制"))
                             add(ItemSectionModel("资源的插件化解决方案"))
                             add(ItemSectionModel("换肤"))
                             add(ItemSectionModel("殊途同归：另一种换肤方式"))
                         }))
                         add(ItemChapterModel("第 8 章 最简单的插件化解决方案", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("在 AndroidManifest 中声明插件中的组件"))
                             add(ItemSectionModel("宿主 App 加载插件中的类"))
                             add(ItemSectionModel("启动插件 Service"))
                             add(ItemSectionModel("加载插件中的资源"))
                         }))
                         add(ItemChapterModel("第 9 章 Activity 的插件化解决方案", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("..."))
                         }))
                         add(ItemChapterModel("第 10 章 Service 的插件化解决方案", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("..."))
                         }))
                         add(ItemChapterModel("第 11 章 BroadcastReceiver 的插件化解决方案", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("Receiver 概述"))
                             add(ItemSectionModel("动态广播的插件化解决方案"))
                             add(ItemSectionModel("静态广播的插件化解决方案"))
                             add(ItemSectionModel("静态广播的插件化终极解决方案"))
                         }))
                         add(ItemChapterModel("第 12 章 ContentProvider 的插件化解决方案", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("ContentProvider 基本概念"))
                             add(ItemSectionModel("一个简单的 ContentProvider"))
                             add(ItemSectionModel("ContentProvider 插件化"))
                             add(ItemSectionModel("执行这段 Hook 代码的时机"))
                             add(ItemSectionModel("ContentProvider 的转发机制"))
                         }))
                         add(ItemChapterModel("第 13 章 基于静态代理的插件化解决方案：that 框架", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("静态代理的思想"))
                             add(ItemSectionModel("一个最简单的静态代理的例子"))
                             add(ItemSectionModel("插件内部的页面跳转"))
                             add(ItemSectionModel("从 肉体 上消灭 that 关键字"))
                             add(ItemSectionModel("插件向歪跳转"))
                             add(ItemSectionModel("面向接口编程在静态代理中的应用"))
                             add(ItemSectionModel("对 LaunchMode 的支持"))
                         }))
                         add(ItemChapterModel("第 14 章 that 框架对 Service 和 BroadcastReceiver 的支持", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("静态代理的思想在 Service 的应用"))
                             add(ItemSectionModel("对 BindService 的支持"))
                             add(ItemSectionModel("..."))
                         }))
                         add(ItemChapterModel("第 15 章 再谈资源", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("Android App 打包流程"))
                             add(ItemSectionModel("修改 AAPT"))
                             add(ItemSectionModel("public.xml 固定资源 id 值"))
                             add(ItemSectionModel("插件使用宿主的资源"))
                         }))
                         add(ItemChapterModel("第 16 章 基于 Fragment 的插件化框架", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel(""))
                             add(ItemSectionModel(""))
                             add(ItemSectionModel(""))
                         }))
                         add(ItemChapterModel("第 17 章 降级", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("从 Activity 到 HTML5"))
                             add(ItemSectionModel("从 HTML5 到 Activity"))
                             add(ItemSectionModel("对返回键的支持"))
                         }))
                         add(ItemChapterModel("第 18 章 插件的混淆", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("插件的基本混淆"))
                             add(ItemSectionModel("方案1：不混淆公共库"))
                             add(ItemSectionModel("方案2：混淆公共库"))
                         }))
                         add(ItemChapterModel("第 19 章 增量更新", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("如何使用增量更新"))
                             add(ItemSectionModel("制作插件的增量包"))
                             add(ItemSectionModel("App 下载增量包并解压到本地"))
                             add(ItemSectionModel("App 合并增量包"))
                         }))
                         add(ItemChapterModel("第 20 章 so 的插件化解决方案", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("编写一个最简单的 so"))
                             add(ItemSectionModel("使用 so"))
                             add(ItemSectionModel("so 的加载原理"))
                             add(ItemSectionModel("基于 System.load 的插件化解决方案"))
                             add(ItemSectionModel("基于 System.loadLibrary 的插件化解决方案"))
                         }))
                         add(ItemChapterModel("第 21 章 对 App 的打包流程进行 Hook", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("自定义 Gradle 插件"))
                             add(ItemSectionModel("修改 resources.arsc"))
                             add(ItemSectionModel(""))
                         }))
                         add(ItemChapterModel("第 22 章 插件化技术总结", mutableListOf<ItemSectionModel>().apply {
                             add(ItemSectionModel("插件的工程化"))
                             add(ItemSectionModel("插件中类的加载"))
                             add(ItemSectionModel("哪些地方可以 Hook"))
                             add(ItemSectionModel("Activity 插件化的解决方案"))
                             add(ItemSectionModel("资源的解决方案"))
                             add(ItemSectionModel("Fragment 是哪门哪派"))
                             add(ItemSectionModel("Service、ContentProvider、BroadcastReceiver 插件化的通用解决方案"))
                             add(ItemSectionModel("特定于 Service 的插件化解决方案"))
                             add(ItemSectionModel("特定于 BroadcastReceiver 的插件化解决方案"))
                             add(ItemSectionModel("特定于 ContentProvider 的插件化解决方案"))
                         }))
                    }
                    return BookModel("Android插件化开发指南", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_8 }
                }
                // endregion

                // region Android 热修复技术原理
                BaseItem.action_book_9 -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 热修复技术介绍", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("什么是热修复"))
                            add(ItemSectionModel("基本概念"))
                            add(ItemSectionModel("技术积淀"))
                            add(ItemSectionModel("技术概览"))
                        }))
                        add(ItemChapterModel("第 2 章 热替换代码修复", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("底层热替换原理"))
                            add(ItemSectionModel("突破底层差异的方法"))
                            add(ItemSectionModel("编译期与语言特性的影响"))
                        }))
                        add(ItemChapterModel("第 3 章 冷启动代码修复", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("冷启动类加载原理"))
                            add(ItemSectionModel("多态对冷启动类加载的影响"))
                            add(ItemSectionModel("Dalvik 下完整 dex 方案的新探索"))
                            add(ItemSectionModel("入口类与初始化时机的选择"))
                        }))
                        add(ItemChapterModel("第 4 章 资源热修复技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("普遍的实现方式"))
                            add(ItemSectionModel("资源文件的格式"))
                            add(ItemSectionModel("运行时资源的解析"))
                            add(ItemSectionModel("另辟蹊径的资源修复方案"))
                            add(ItemSectionModel("更优雅地替换 AssetManager"))
                            add(ItemSectionModel("一个意料之外的资源问题"))
                        }))
                        add(ItemChapterModel("第 5 章 so 库热修复技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("so 库加载原理"))
                            add(ItemSectionModel("so 库热部署实时生效的可行性分析"))
                            add(ItemSectionModel("so 库冷部署重启生效实现方案"))
                            add(ItemSectionModel("如何正确复制补丁 so 库"))
                        }))
                        add(ItemChapterModel("第 6 章 其他优秀的热修复方案", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Dexposed 浅析"))
                            add(ItemSectionModel("AndFix 探索历程"))
                            add(ItemSectionModel("Amigo 核心解读"))
                            add(ItemSectionModel("腾讯系热修复方案简介"))
                        }))
                        add(ItemChapterModel("第 7 章 热修复技术的未来展望", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("热修复的专业性"))
                            add(ItemSectionModel("对 Android 生态的影响"))
                            add(ItemSectionModel("Android 与 ios 热修复的不同"))
                            add(ItemSectionModel("未来，无限可能"))
                        }))
                    }
                    return BookModel("Android热修复技术原理", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_9 }
                }
                // endregion

                // region FFmpeg
                BaseItem.action_book_10 -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 FFmpeg", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("定义"))
                            add(ItemSectionModel("历史"))
                            add(ItemSectionModel("基本组成"))
                            add(ItemSectionModel("FFmpeg 的编解码工具 ffmpeg"))
                            add(ItemSectionModel("FFmpeg 的播放器 ffplay"))
                            add(ItemSectionModel("FFmpeg 的多媒体分析器 ffprobe"))
                            add(ItemSectionModel("FFmpeg 编译"))
                            add(ItemSectionModel("编码支持与定制"))
                        }))
                        add(ItemChapterModel("第 2 章 FFmpeg 工具使用基础", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("ffmpeg 常用命令"))
                            add(ItemSectionModel("ffprobe 常用命令"))
                            add(ItemSectionModel("ffplay 常用命令"))
                        }))
                        add(ItemChapterModel("第 3 章 FFmpeg 转封装", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("音视频文件转 MP4 格式"))
                            add(ItemSectionModel("视频文件转 FLV"))
                            add(ItemSectionModel("视频文件转 M3U8"))
                            add(ItemSectionModel("视频文件切片"))
                            add(ItemSectionModel("音视频文件音视频流抽取"))
                            add(ItemSectionModel("系统资源的使用情况"))
                        }))
                        add(ItemChapterModel("第 4 章 FFmpeg 转码", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("软编码 H.264 与 H.265"))
                            add(ItemSectionModel("硬编解码"))
                            add(ItemSectionModel("输入 MP3"))
                            add(ItemSectionModel("输出 AAC"))
                            add(ItemSectionModel("系统资源使用情况"))
                        }))
                        add(ItemChapterModel("第 5 章 FFmpeg 流媒体", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("发布与录制 RTMP 流"))
                            add(ItemSectionModel("录制 RTSP 流"))
                            add(ItemSectionModel("录制 HTTP 流"))
                            add(ItemSectionModel("复制和发布 UDP/TCP 流"))
                            add(ItemSectionModel("推多路流"))
                            add(ItemSectionModel("生成 HDS 流"))
                            add(ItemSectionModel("生成 DASH 流"))
                        }))
                        add(ItemChapterModel("第 6 章 FFmpeg 滤镜使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Filter 描述格式"))
                            add(ItemSectionModel("为视频添加水印"))
                            add(ItemSectionModel("生成画中画"))
                            add(ItemSectionModel("视频多宫格处理"))
                            add(ItemSectionModel("音频流滤镜操作"))
                            add(ItemSectionModel("音频音量探测"))
                            add(ItemSectionModel("为视频加字幕"))
                            add(ItemSectionModel("视频抠图合并"))
                            add(ItemSectionModel("3D 视频处理"))
                            add(ItemSectionModel("定时视频截图"))
                            add(ItemSectionModel("生成测试元数据"))
                            add(ItemSectionModel("对音视频倍速处理"))
                        }))
                        add(ItemChapterModel("第 7 章 FFmpeg 采集设备", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("FFmpeg 中 Linux 设备操作"))
                            add(ItemSectionModel("FFmpeg 中 OS X 设备操作"))
                            add(ItemSectionModel("FFmpeg 中 Windows 设备操作"))
                        }))
                        add(ItemChapterModel("第 8 章 FFmpeg 接口 libavformat 的使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("音视频流封装"))
                            add(ItemSectionModel("音视频文件解封装"))
                            add(ItemSectionModel("音视频文件转封装"))
                            add(ItemSectionModel("视频截取"))
                            add(ItemSectionModel("avio 内存数据操作"))
                        }))
                        add(ItemChapterModel("第 9 章 FFmpeg 接口 libavcodec 的使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("FFmpeg 旧接口的使用"))
                            add(ItemSectionModel("FFmpeg 新接口的使用"))
                        }))
                        add(ItemChapterModel("第 10 章 FFmpeg 接口 libavfilter 的使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("filtergraph 和 filter 简述"))
                            add(ItemSectionModel("FFmpeg 中预留的滤镜"))
                            add(ItemSectionModel("avfilter 流程图"))
                            add(ItemSectionModel("使用滤镜加 LOGO 操作"))
                        }))
                    }
                    return BookModel("FFmpeg 从入门到精通", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_10 }
                }
                // endregion

                // region 数据结构
                BaseItem.action_book_11 -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 数据结绪论", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("开场白"))
                            add(ItemSectionModel("你数据结构怎么学的"))
                            add(ItemSectionModel("数据结构起源"))
                            add(ItemSectionModel("基本概念和术语"))
                            add(ItemSectionModel("逻辑结构与物理结构"))
                            add(ItemSectionModel("数据类型"))
                        }))
                        add(ItemChapterModel("第 2 章 算法", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("开场白"))
                            add(ItemSectionModel("数据结构与算法关系"))
                            add(ItemSectionModel("两种算法比较"))
                            add(ItemSectionModel("算法定义"))
                            add(ItemSectionModel("算法的特性"))
                            add(ItemSectionModel("算法设计的要求"))
                            add(ItemSectionModel("算法效率的度量方法"))
                            add(ItemSectionModel("函数的渐进增长"))
                            add(ItemSectionModel("算法时间复杂度"))
                            add(ItemSectionModel("常见的时间复杂度"))
                            add(ItemSectionModel("最坏情况与平均情况"))
                            add(ItemSectionModel("算法空间复杂度"))
                        }))
                        add(ItemChapterModel("第 3 章 线性表", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("定义"))
                            add(ItemSectionModel("线性表的抽象数据离诶行"))
                            add(ItemSectionModel("线性表的顺序存储结构"))
                            add(ItemSectionModel("顺序存储结构的插入与删除"))
                            add(ItemSectionModel("线性表的链式存储结构"))
                            add(ItemSectionModel("单链表的读取"))
                            add(ItemSectionModel("单链表的插入与删除"))
                            add(ItemSectionModel("单链表的整表创建"))
                            add(ItemSectionModel("单链表的整表删除"))
                            add(ItemSectionModel("单链表结构和顺序存储结构优缺点"))
                            add(ItemSectionModel("静态链表"))
                            add(ItemSectionModel("循环链表"))
                            add(ItemSectionModel("双向链表"))
                        }))
                        add(ItemChapterModel("第 4 章 栈与队列", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("栈的定义"))
                            add(ItemSectionModel("栈的抽象数据类型"))
                            add(ItemSectionModel("栈的顺序存储结构及实现"))
                            add(ItemSectionModel("两栈的共享空间"))
                            add(ItemSectionModel("栈的链式存储结构及实现"))
                            add(ItemSectionModel("栈的作用"))
                            add(ItemSectionModel("栈的应用：递归"))
                            add(ItemSectionModel("栈的应用：四则运算表达式求值"))
                            add(ItemSectionModel("队列的定义"))
                            add(ItemSectionModel("队列的抽象数据类型"))
                            add(ItemSectionModel("循环队列"))
                            add(ItemSectionModel("队列的链式存储结构及实现"))
                        }))
                        add(ItemChapterModel("第 5 章 串", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("串的定义"))
                            add(ItemSectionModel("串的比较"))
                            add(ItemSectionModel("串的抽象数据类型"))
                            add(ItemSectionModel("串的存储结构"))
                            add(ItemSectionModel("朴素的模式匹配算法"))
                            add(ItemSectionModel("KMP模式匹配算法"))
                        }))
                        add(ItemChapterModel("第 6 章 树", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("树的定义"))
                            add(ItemSectionModel("树的抽象数据类型"))
                            add(ItemSectionModel("树的存储结构"))
                            add(ItemSectionModel("二叉树的定义"))
                            add(ItemSectionModel("二叉树的特性"))
                            add(ItemSectionModel("二叉树的存储结构"))
                            add(ItemSectionModel("遍历二叉树"))
                            add(ItemSectionModel("二叉树的建立"))
                            add(ItemSectionModel("线索二叉树"))
                            add(ItemSectionModel("树、森林与二叉树的转换"))
                            add(ItemSectionModel("哈夫曼树及应用"))
                        }))
                        add(ItemChapterModel("第 7 章 图", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("图的定义"))
                            add(ItemSectionModel("图的抽象数据类型"))
                            add(ItemSectionModel("图的存储结构"))
                            add(ItemSectionModel("图的遍历"))
                            add(ItemSectionModel("最小生成树"))
                            add(ItemSectionModel("最短路径"))
                            add(ItemSectionModel("拓扑排序"))
                            add(ItemSectionModel("关键路径"))
                        }))
                        add(ItemChapterModel("第 8 章 查找", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("查找概论"))
                            add(ItemSectionModel("顺序表查找"))
                            add(ItemSectionModel("有序表查找"))
                            add(ItemSectionModel("线性索引查找"))
                            add(ItemSectionModel("二叉树拍讯"))
                            add(ItemSectionModel("平衡二叉树"))
                            add(ItemSectionModel("多路查找树"))
                            add(ItemSectionModel("散列表查找（哈希表）概述"))
                            add(ItemSectionModel("散列函数的构造方法"))
                            add(ItemSectionModel("处理散列冲突方法"))
                            add(ItemSectionModel("散列表查找的实现"))
                        }))
                        add(ItemChapterModel("第 9 章 排序", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("排序的基本概念和分类"))
                            add(ItemSectionModel("冒泡排序"))
                            add(ItemSectionModel("简单选择排序"))
                            add(ItemSectionModel("直接插入排序"))
                            add(ItemSectionModel("希尔排序"))
                            add(ItemSectionModel("堆排序"))
                            add(ItemSectionModel("归并排序"))
                            add(ItemSectionModel("快速排序"))
                            add(ItemSectionModel("总结"))
                        }))
                    }
                    return BookModel("大话数据结构", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_11 }
                }
                // endregion

                // region Python 编程
                BaseItem.action_book_12 -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 起步", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("搭建编程环境"))
                            add(ItemSectionModel("在不同操作系统中搭建 Python 编程环境"))
                            add(ItemSectionModel("解决安装问题"))
                            add(ItemSectionModel("从终端运行 Python 程序"))
                        }))
                        add(ItemChapterModel("第 2 章 变量和简单数据类型", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("运行 hello_world.py 时发生的情况"))
                            add(ItemSectionModel("变量"))
                            add(ItemSectionModel("字符串"))
                            add(ItemSectionModel("数字"))
                            add(ItemSectionModel("注释"))
                            add(ItemSectionModel("Python 之禅"))
                        }))
                        add(ItemChapterModel("第 3 章 列表简介", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("列表是什么"))
                            add(ItemSectionModel("修改、添加和删除元素"))
                            add(ItemSectionModel("组织列表"))
                            add(ItemSectionModel("使用列表时避免索引错误"))
                        }))
                        add(ItemChapterModel("第 4 章 操作列表", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("遍历整个列表"))
                            add(ItemSectionModel("避免缩进错误"))
                            add(ItemSectionModel("创建数值列表"))
                            add(ItemSectionModel("使用列表的一部分"))
                            add(ItemSectionModel("元组"))
                            add(ItemSectionModel("设置代码格式"))
                        }))
                        add(ItemChapterModel("第 5 章 if 语句", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("一个简单示例"))
                            add(ItemSectionModel("条件测试"))
                            add(ItemSectionModel("if 语句"))
                            add(ItemSectionModel("使用 if 语句处理列表"))
                            add(ItemSectionModel("设置 if 语句的格式"))
                        }))
                        add(ItemChapterModel("第 6 章 字典", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("一个简单的字典"))
                            add(ItemSectionModel("使用字典"))
                            add(ItemSectionModel("遍历字典"))
                            add(ItemSectionModel("嵌套"))
                        }))
                        add(ItemChapterModel("第 7 章 用户输入和 while 循环", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("函数 input() 的工作原理"))
                            add(ItemSectionModel("while 循环简介"))
                            add(ItemSectionModel("使用 while 循环来处理列表和字典"))
                        }))
                        add(ItemChapterModel("第 8 章 函数", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("定义函数"))
                            add(ItemSectionModel("传递实参"))
                            add(ItemSectionModel("返回值"))
                            add(ItemSectionModel("传递列表"))
                            add(ItemSectionModel("传递任意数量的实参"))
                            add(ItemSectionModel("将函数存储在模块中"))
                            add(ItemSectionModel("函数编写指南"))
                        }))
                        add(ItemChapterModel("第 9 章 类", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("创建和使用类"))
                            add(ItemSectionModel("使用类和实例"))
                            add(ItemSectionModel("继承"))
                            add(ItemSectionModel("导入类"))
                            add(ItemSectionModel("Python 标准库"))
                            add(ItemSectionModel("类编码风格"))
                        }))
                        add(ItemChapterModel("第 10 章 文件和异常", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("从文件中读取数据"))
                            add(ItemSectionModel("写入文件"))
                            add(ItemSectionModel("异常"))
                            add(ItemSectionModel("存储数据"))
                        }))
                        add(ItemChapterModel("第 11 章 测试代码", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("测试函数"))
                            add(ItemSectionModel("测试类"))
                        }))
                        add(ItemChapterModel("项目1：外星人入侵", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("武装飞船"))
                            add(ItemSectionModel("外星人"))
                            add(ItemSectionModel("记分"))
                        }))
                        add(ItemChapterModel("项目2：数据可视化", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("生成数据"))
                            add(ItemSectionModel("下载数据"))
                            add(ItemSectionModel("使用 API"))
                        }))
                        add(ItemChapterModel("项目3：Web 应用程序", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("Django 入门"))
                            add(ItemSectionModel("用户账户"))
                            add(ItemSectionModel("设置应用程序的样式并对其进行部署"))
                        }))

                    }
                    return BookModel("Python 编程从入门到实践", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_12 }
                }
                // endregion
            }

            return BookModel("空", itemAction, chapterModelList)
        }
    }
}