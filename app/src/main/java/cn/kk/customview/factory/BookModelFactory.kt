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
            }

            return BookModel("空", itemAction, chapterModelList)
        }
    }
}