package cn.kk.customview.factory

import cn.kk.base.bean.BaseMoreItem
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
            val moreInfoList = mutableListOf<BaseMoreItem>()
            when(itemAction) {

                // region 面试
                BaseItem.ACTION_BOOK_INTERVIEW -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("面试攻略", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("要点", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("准备", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("简历要点", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("提高面试通过率", chapterOrder, this.size + 1, true))
                        }, itemAction))
                        add(ItemChapterModel("面试公司记录", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("湘财证券", chapterOrder, this.size + 1, true))
                        }, itemAction))
                    }
                    return BookModel("面试", itemAction, chapterModelList)
                }
                // endregion

                // region audio video dev 音视频开发
                BaseItem.ACTION_BOOK_AV_DEV -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("知识树", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                             add(ItemSectionModel("音频知识", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("视频知识", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("C 语言", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("C++", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("FFMpeg", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("Linux", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("WebRTC", chapterOrder, this.size + 1, false))
                             add(ItemSectionModel("Android 上的音视频API", chapterOrder, this.size + 1, false))
                             add(ItemSectionModel("JNI/NDK", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("OpenGL 渲染", chapterOrder, this.size + 1, true))
                             add(ItemSectionModel("libyuv", chapterOrder, this.size + 1, false))
                             add(ItemSectionModel("Vulkan", chapterOrder, this.size + 1, false))
                             add(ItemSectionModel("开发通用技能", chapterOrder, this.size + 1, false))
                        }, itemAction))
                        add(ItemChapterModel("课程或书本", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("搞定音频技术- 极客时间", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("搞定视频技术- 极客时间", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("极课时间，简介地址", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("音视频基础+ffmpeg原理 一课完成音视频技术开发入门", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("FFmpeg音视频核心技术全面精讲+实战（进阶）", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("实时互动直播技术（进阶）", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("企业级流媒体服务器设计与开发（高级", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("《FFmpeg 从入门到精通》", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("开发商业级热门短视频App 掌握Jetpack组件库", chapterOrder, this.size + 1, false))
                        }, itemAction))
                        add(ItemChapterModel("入门到提高 —— 任务列表", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("1. 在 Android 平台绘制一张图片，使用至少 3 种不同的 API，ImageView，SurfaceView，自定义 View", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("2. 在 Android 平台使用 AudioRecord 和 AudioTrack API 完成音频 PCM 数据的采集和播放，并实现读写音频 wav 文件", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("3. 在 Android 平台使用 Camera API 进行视频的采集，分别使用 SurfaceView、TextureView 来预览 Camera 数据，取到 NV21 的数据回调", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("4. 学习 Android 平台的 MediaExtractor 和 MediaMuxer API，知道如何解析和封装 mp4 文件", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("5. 学习 Android 平台 OpenGL ES API，了解 OpenGL 开发的基本流程，使用 OpenGL 绘制一个三角形", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("6. 学习 Android 平台 OpenGL ES API，学习纹理绘制，能够使用 OpenGL 显示一张图片", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("7. 学习 MediaCodec API，完成音频 AAC 硬编、硬解", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("8. 学习 MediaCodec API，完成视频 H.264 的硬编、硬解", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("9. 串联整个音视频录制流程，完成音视频的采集、编码、封包成 mp4 输出", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("10. 串联整个音视频播放流程，完成 mp4 的解析、音视频的解码、播放和渲染", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("11. 进一步学习 OpenGL，了解如何实现视频的剪裁、旋转、水印、滤镜，并学习 OpenGL 高级特性，如：VBO，VAO，FBO 等等", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("12. 学习 Android 图形图像架构，能够使用 GLSurfaceviw 绘制 Camera 预览画面", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("13. 深入研究音视频相关的网络协议，如 rtmp，hls，以及封包格式，如：flv，mp4", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("14. 深入学习一些音视频领域的开源项目，如 webrtc，ffmpeg，ijkplayer，librtmp 等等", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("15. 将 ffmpeg 库移植到 Android 平台，结合上面积累的经验，编写一款简易的音视频播放器", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("16. 将 x264 库移植到 Android 平台，结合上面积累的经验，完成视频数据 H264 软编功能", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("17. 将 librtmp 库移植到 Android 平台，结合上面积累的经验，完成 Android RTMP 推流功能", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("18. 上面积累的经验，做一款短视频 APP，完成如：断点拍摄、添加水印、本地转码、视频剪辑、视频拼接、MV 特效等功能", chapterOrder, this.size + 1, false))
                        }, itemAction))
                        add(ItemChapterModel("开源项目", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("grafika", 4, 1, false))
                            add(ItemSectionModel("android-gpuimage", 4, 2, false))
                            add(ItemSectionModel("AudioVideoRecordingSample", 4, 2, false))
                            add(ItemSectionModel("ijkplayer", 4, 2, false))
                            add(ItemSectionModel("ExoPlayer", 4, 2, false))
                        }, itemAction))
                        add(ItemChapterModel("行业大佬", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("glums", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("李超", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("Jhuster", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("雷霄骅", chapterOrder, this.size + 1, false))
                            add(ItemSectionModel("DevYK", chapterOrder, this.size + 1, true))
                        }, itemAction))
                        add(ItemChapterModel("Android 官方文档", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("文档", 6, 1, false))
                        }, itemAction))
                        add(ItemChapterModel("其他", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("入门的技术博客", 7, 1, false))
                            add(ItemSectionModel("流媒体开发主要工作内容", 7, 2, false))
                            add(ItemSectionModel("音视频基础 148 题", 7, 2, false))
                            add(ItemSectionModel("glums 公众号(音视频开发进阶)开放的 播放器实战项目", 7, 2, false))
                        }, itemAction))
                    }
                    return BookModel("音视频开发", itemAction, chapterModelList)
                }
                // endregion
                // region Android NDK
                BaseItem.ACTION_BOOK_NDK -> {
                    chapterModelList.apply {

                        add(ItemChapterModel("入门", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                                   add(ItemSectionModel("简介", chapterOrder, this.size + 1, true))
                                   add(ItemSectionModel("JNI 基本概念", chapterOrder, this.size + 1, true))
                        }, itemAction))

                        add(ItemChapterModel("基础 Demo 之 Mooc 网学习 NDK", mutableListOf<ItemSectionModel>().apply {
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("NDK 工程结构", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("CMake 编译", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("Java 调用 C/C++ 方式一：静态注册", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("Java 调用 C/C++ 方式二：动态注册", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("Java 与 JNI 引用类型转换", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 访问 Java 类字段", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 访问 Java 类方法", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 访问 Java 类回调方法 和 子线程访问 Java 类的回调方法", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 创建 Java 类", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 引用类型", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 异常处理", chapterOrder, this.size + 1, true))
                            add(ItemSectionModel("JNI 线程操作", chapterOrder, this.size + 1, true))
                        }, itemAction))
                    }
                    return BookModel("NDK 开发", itemAction, chapterModelList)
                }
                // endregion
                // region Android 开发高手课
                BaseItem.action_book_android_dev_performance -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("高质量开发", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("崩溃优化", 1, 1, true))
                            add(ItemSectionModel("内存优化", 1, 2, true))
                            add(ItemSectionModel("卡顿优化", 1, 3, true))
                            add(ItemSectionModel("启动优化", 1, 4, true))
                            add(ItemSectionModel("IO 优化", 1, 5, true))
                            add(ItemSectionModel("存储优化", 1, 6, true))
                            add(ItemSectionModel("网络优化", 1, 7, true))
                            add(ItemSectionModel("耗电优化", 1, 8, true))
                            add(ItemSectionModel("UI 优化", 1, 9, true))
                            add(ItemSectionModel("包体积优化", 1, 10, true))
                            add(ItemSectionModel("想成为 Android 高手，你需要先搞定这三个问题", 1, 11, true))
                        }, itemAction))
                        add(ItemChapterModel("高效开发", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("如何提升组织与个人的研发效能", 2, 1, true))
                            add(ItemSectionModel("关于编译，你需要了解什么？", 2, 2, true))
                            add(ItemSectionModel("编译插桩的三种方法: AspectJ、ASM、ReDex", 2, 3, true))
                            add(ItemSectionModel("大数据与 AI，如何高效地测试？", 2, 4, true))
                            add(ItemSectionModel("从每月到每天，如何给版本发布提速？", 2, 5, true))
                            add(ItemSectionModel("数据评估", 2, 6, true))
                            add(ItemSectionModel("线上疑难问题该如何排查和跟踪？", 2, 7, true))
                            add(ItemSectionModel("做一名有高度的移动开发工程师", 2, 8, true))
                        }, itemAction))
                        add(ItemChapterModel("架构演进", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("聊聊重构：优秀的架构都是演进而来的", 3, 1, true))
                            add(ItemSectionModel("Native Hook 技术，天使还是魔鬼？", 3, 2, true))
                            add(ItemSectionModel("移动开发新大陆", 3, 3, true))
                            add(ItemSectionModel("动态化实践，如何选择适合自己的方案？", 3, 4, true))
                            add(ItemSectionModel("聊聊 Flutter，面对层出不穷的新技术该如何跟进？", 3, 5, true))
                            add(ItemSectionModel("Android 开发高手课学习心得", 3, 6, true))
                        }, itemAction))
                        add(ItemChapterModel("让 Sample 跑起来", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("AMS 插桩强化练习", 4, 1, true))
                        }, itemAction))
                        add(ItemChapterModel("特别放送", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("Android JVM TI 机制详解", 5, 1, true))
                            add(ItemSectionModel("专栏学得苦？可能是方法没找对", 5, 2, true))
                            add(ItemSectionModel("专栏学得苦？可能你还需要一套配套学习书单", 5, 3, true))
                            add(ItemSectionModel("Native 下如何获取调用栈？", 5, 4, true))
                            add(ItemSectionModel("聊聊 Framework 的学习方法", 5, 5, true))
                            add(ItemSectionModel("Android 工程师的 “面试指南”", 5, 6, true))
                            add(ItemSectionModel("程序员修炼之路，设计能力的提升途径", 5, 6, true))
                        }, itemAction))
                    }
                    return BookModel("Android 开发高手课", itemAction, chapterModelList)
                }
                // endregion
                // region 《Android 开发艺术探索》
                BaseItem.action_book_android_dev_art -> {
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
                            add(ItemSectionModel("性能优化方法", 15, 1, true))
                            add(ItemSectionModel("内存泄漏分析之 MAT 工具", 15, 2, true))
                            add(ItemSectionModel("提高程序的可维护性", 15, 3, true))
                        }, itemAction))
                    }

                    return BookModel("Android\n开发艺术探索", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_1 }
                }
                // endregion

                // region 《Linux 命令行与 shell 脚本编程大全》
                BaseItem.action_book_linux -> {
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
                        add(ItemChapterModel("第 13 章 更多的结构化命令", mutableListOf<ItemSectionModel>().apply {
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
                BaseItem.action_book_android_custom_view_elementary -> {
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
                BaseItem.action_book_android_advance -> {

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
                            val chapterOrder = chapterModelList.size + 1
                            add(ItemSectionModel("线程基础", chapterModelList.size + 1, this.size + 1, false))
                            add(ItemSectionModel("同步", chapterModelList.size + 1, this.size + 1, false))
                            add(ItemSectionModel("阻塞队列", chapterModelList.size + 1, this.size + 1, true))
                            add(ItemSectionModel("线程池", chapterModelList.size + 1, this.size + 1, true))
                            add(ItemSectionModel("AsyncTask 原理", chapterModelList.size + 1, this.size + 1, false))
                        }, itemAction))
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

                    return BookModel("Android\n进阶之光", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_4 }
                }
                // endregion

                // region 《Android编程权威指南》
                BaseItem.action_book_android_programming -> {
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
                    // more info
                    moreInfoList.apply {
                        add(BaseMoreItem("BeatBox", "").apply { item_action = BaseItem.ACTION_BOOK_ANDROID_PROGRAMMING_APP_BEATBOX})
                    }
                    return BookModel("Android\n编程权威指南", itemAction, chapterModelList).apply {
                        bookImgRes = R.drawable.bg_book_5
                        if(moreInfoList.isNotEmpty()) {
                            moreItemList = moreInfoList
                        }
                    }
                }
                // endregion

                // region Git
                BaseItem.action_book_git -> {
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
                BaseItem.action_book_android_arch -> {
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
                BaseItem.action_book__android_plugin -> {
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
                BaseItem.action_book_android_hot_fix -> {
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
                BaseItem.action_book_ffmpeg -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 FFmpeg", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("定义", 1, 1, true))
                            add(ItemSectionModel("历史", 1, 2, true))
                            add(ItemSectionModel("基本组成", 1, 3, true))
                            add(ItemSectionModel("FFmpeg 的编解码工具 ffmpeg", 1, 4, true))
                            add(ItemSectionModel("FFmpeg 的播放器 ffplay", 1, 5, true))
                            add(ItemSectionModel("FFmpeg 的多媒体分析器 ffprobe", 1, 6, true))
                            add(ItemSectionModel("FFmpeg 编译", 1, 7, true))
                            add(ItemSectionModel("编码支持与定制", 1, 8, true))
                        }, itemAction))
                        add(ItemChapterModel("第 2 章 FFmpeg 工具使用基础", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("ffmpeg 常用命令", 2, 1, true))
                            add(ItemSectionModel("ffprobe 常用命令", 2, 2, true))
                            add(ItemSectionModel("ffplay 常用命令", 2, 3, true))
                        }, itemAction))
                        add(ItemChapterModel("第 3 章 FFmpeg 转封装", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("音视频文件转 MP4 格式", 3, 1, true))
                            add(ItemSectionModel("视频文件转 FLV", 3, 2, true))
                            add(ItemSectionModel("视频文件转 M3U8", 3, 3, true))
                            add(ItemSectionModel("视频文件切片", 3, 4, true))
                            add(ItemSectionModel("音视频文件音视频流抽取", 3, 5, true))
                            add(ItemSectionModel("系统资源的使用情况", 3, 6, true))
                        }, itemAction))
                        add(ItemChapterModel("第 4 章 FFmpeg 转码", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("软编码 H.264 与 H.265", 4, 1, true))
                            add(ItemSectionModel("硬编解码", 4, 2, true))
                            add(ItemSectionModel("输入 MP3", 4, 3, true))
                            add(ItemSectionModel("输出 AAC", 4, 4, true))
                            add(ItemSectionModel("系统资源使用情况", 4, 5, true))
                        }, itemAction))
                        add(ItemChapterModel("第 5 章 FFmpeg 流媒体", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("发布与录制 RTMP 流"))
                            add(ItemSectionModel("录制 RTSP 流"))
                            add(ItemSectionModel("录制 HTTP 流"))
                            add(ItemSectionModel("复制和发布 UDP/TCP 流"))
                            add(ItemSectionModel("推多路流"))
                            add(ItemSectionModel("生成 HDS 流"))
                            add(ItemSectionModel("生成 DASH 流"))
                        }, itemAction))
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
                        }, itemAction))
                        add(ItemChapterModel("第 7 章 FFmpeg 采集设备", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("FFmpeg 中 Linux 设备操作"))
                            add(ItemSectionModel("FFmpeg 中 OS X 设备操作"))
                            add(ItemSectionModel("FFmpeg 中 Windows 设备操作"))
                        }, itemAction))
                        add(ItemChapterModel("第 8 章 FFmpeg 接口 libavformat 的使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("音视频流封装"))
                            add(ItemSectionModel("音视频文件解封装"))
                            add(ItemSectionModel("音视频文件转封装"))
                            add(ItemSectionModel("视频截取"))
                            add(ItemSectionModel("avio 内存数据操作"))
                        }, itemAction))
                        add(ItemChapterModel("第 9 章 FFmpeg 接口 libavcodec 的使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("FFmpeg 旧接口的使用"))
                            add(ItemSectionModel("FFmpeg 新接口的使用"))
                        }, itemAction))
                        add(ItemChapterModel("第 10 章 FFmpeg 接口 libavfilter 的使用", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("filtergraph 和 filter 简述"))
                            add(ItemSectionModel("FFmpeg 中预留的滤镜"))
                            add(ItemSectionModel("avfilter 流程图"))
                            add(ItemSectionModel("使用滤镜加 LOGO 操作"))
                        }, itemAction))
                    }
                    return BookModel("FFmpeg 从入门到精通", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_10 }
                }
                // endregion

                // region 数据结构
                BaseItem.action_book_data_arch -> {
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
                BaseItem.action_book_python -> {
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

                // region Http
                BaseItem.action_book_http -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 了解 Web 及网络基础", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("使用 HTTP 协议访问 Web"))
                            add(ItemSectionModel("网络基础 TCP/IP"))
                            add(ItemSectionModel("与HTTP关系密切的协议：IP、TCP 和 DNS"))
                            add(ItemSectionModel("负责域名解析的 NDS 服务"))
                            add(ItemSectionModel("各种协议与 HTTP协议的关系"))
                            add(ItemSectionModel("URI 和 URL"))
                        }))
                        add(ItemChapterModel("第 2 章 简单的 HTTP 协议", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("HTTP 协议用于客户端和服务器端之间的通信"))
                            add(ItemSectionModel("通过请求和响应的交换达成通信"))
                            add(ItemSectionModel("HTTP是不保存状态的协议"))
                            add(ItemSectionModel("请求 URI 定位资源"))
                            add(ItemSectionModel("告知服务器意图的 HTTP 方法"))
                            add(ItemSectionModel("使用方法下达命令"))
                            add(ItemSectionModel("持久连接节省通信量"))
                            add(ItemSectionModel("使用 Cookie 的状态管理"))
                        }))
                        add(ItemChapterModel("第 3 章 HTTP 报文的 HTTP 信息", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("HTTP 报文"))
                            add(ItemSectionModel("请求报文及响应报文结构"))
                            add(ItemSectionModel("编码提升传输速率"))
                            add(ItemSectionModel("发送多种数据的多部分对象集合"))
                            add(ItemSectionModel("获取部分内容的范围请求"))
                            add(ItemSectionModel("内容协商返回最合适的内容"))
                        }))
                        add(ItemChapterModel("第 4 章 返回结果的 HTTP 状态码", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("状态码告知从服务器端返回的请求结果"))
                            add(ItemSectionModel("2xx"))
                            add(ItemSectionModel("3xx 重定向"))
                            add(ItemSectionModel("4xx"))
                            add(ItemSectionModel("5xx"))
                        }))
                        add(ItemChapterModel("第 5 章 与 HTTP 协作的 Web 服务器", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("用单台虚拟主机实现多个域名"))
                            add(ItemSectionModel("通信数据转发程序：代理、网管、隧道"))
                            add(ItemSectionModel("保存资源的缓存"))
                        }))
                        add(ItemChapterModel("第 6 章 HTTP 首部", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("报文首部"))
                            add(ItemSectionModel("首部字段"))
                            add(ItemSectionModel("HTTP/1.1 通用首部字段"))
                            add(ItemSectionModel("请求首部字段"))
                            add(ItemSectionModel("响应首部字段"))
                            add(ItemSectionModel("实体首部字段"))
                            add(ItemSectionModel("为 Cookie 服务的首部字段"))
                            add(ItemSectionModel("其他首部字段"))
                        }))
                        add(ItemChapterModel("第 7 章 确保 Web 安全的 HTTPS", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("HTTP 的缺点"))
                            add(ItemSectionModel("HTTP+加密+认证+完整性保护=HTTPS"))
                        }))
                        add(ItemChapterModel("第 8 章 确认访问用户身份的认证", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("何为认证"))
                            add(ItemSectionModel("BASIC 认证"))
                            add(ItemSectionModel("DIGEST 认证"))
                            add(ItemSectionModel("SSL 客户端认证"))
                            add(ItemSectionModel("基于表单认证"))
                        }))
                        add(ItemChapterModel("第 9 章 基于 HTTP 的功能追加协议", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("基于 HTTP 的协议"))
                            add(ItemSectionModel("消除 HTTP 的瓶颈的 SPDY"))
                            add(ItemSectionModel("使用浏览器进行全双工通信的 WebSocket"))
                            add(ItemSectionModel("期盼已久的 HTTP/2.0"))
                            add(ItemSectionModel("Web 服务器管理文件的 WebDAV"))
                        }))
                        add(ItemChapterModel("第 10 章 构建 Web 内容的技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("HTML"))
                            add(ItemSectionModel("动态 HTML"))
                            add(ItemSectionModel("Web 应用"))
                            add(ItemSectionModel("数据发布的格式及语言"))
                        }))
                        add(ItemChapterModel("第 11 章 Web 的攻击技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("针对 Web 的攻击技术"))
                            add(ItemSectionModel("因输出值转译不完全引发的安全漏洞"))
                            add(ItemSectionModel("因设置或设计上的缺陷引发的安全漏洞"))
                            add(ItemSectionModel("因会话管理疏忽引发的安全漏洞"))
                            add(ItemSectionModel("其他安全漏洞"))
                        }))
                    }
                    return BookModel("图解 Http", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_13 }
                }
                // endregion

                // region 码出高效 Java 开发手册
                BaseItem.action_book_java_easy_coding -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 计算机基础", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("信息安全"))
                            add(ItemSectionModel("黑客与安全"))
                            add(ItemSectionModel("SQL 注入"))
                            add(ItemSectionModel("XSS 与 CSRF"))
                            add(ItemSectionModel("CSEF"))
                            add(ItemSectionModel("HTTPS"))
                            add(ItemSectionModel("编程语言的发展"))
                        }))
                        add(ItemChapterModel("第 2 章 面向对象", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("类"))
                            add(ItemSectionModel("类的定义"))
                            add(ItemSectionModel("接口与抽象类"))
                            add(ItemSectionModel("内部类"))
                            add(ItemSectionModel("访问权限控制"))
                            add(ItemSectionModel("this 与 super"))
                            add(ItemSectionModel("类关系"))
                            add(ItemSectionModel("序列化"))
                            add(ItemSectionModel("方法"))
                            add(ItemSectionModel("方法签名"))
                            add(ItemSectionModel("参数"))
                            add(ItemSectionModel("构造方法"))
                            add(ItemSectionModel("类内方法"))
                            add(ItemSectionModel("getter 与 setter"))
                            add(ItemSectionModel("同步与异步"))
                            add(ItemSectionModel("复写"))
                            add(ItemSectionModel("重载"))
                            add(ItemSectionModel("泛型"))
                            add(ItemSectionModel("数据类型"))
                            add(ItemSectionModel("基本数据类型"))
                            add(ItemSectionModel("包装类型"))
                            add(ItemSectionModel("字符串"))
                        }))
                        add(ItemChapterModel("第 3 章 ", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("命名规范"))
                            add(ItemSectionModel("常量"))
                            add(ItemSectionModel("变量"))
                            add(ItemSectionModel("代码展示风格"))
                            add(ItemSectionModel("缩进、空格与空行"))
                            add(ItemSectionModel("换行与高度"))
                            add(ItemSectionModel("控制语句"))
                            add(ItemSectionModel("代码注释"))
                            add(ItemSectionModel("注释三要素"))
                            add(ItemSectionModel("注释格式"))
                        }))
                        add(ItemChapterModel("第 4 章 走进 JVM", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("字节码"))
                            add(ItemSectionModel("类的加载过程"))
                            add(ItemSectionModel("内存布局"))
                            add(ItemSectionModel("对象实例化"))
                            add(ItemSectionModel("垃圾回收"))
                        }))
                        add(ItemChapterModel("第 5 章 异常与日志", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("异常分类"))
                            add(ItemSectionModel("try 代码块"))
                            add(ItemSectionModel("异常的抛与接"))
                            add(ItemSectionModel("日志"))
                            add(ItemSectionModel("日志规范"))
                            add(ItemSectionModel("日志框架"))
                        }))
                        add(ItemChapterModel("第 6 章 数据结构与集合", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("数据结构"))
                            add(ItemSectionModel("集合框架图"))
                            add(ItemSectionModel("List 结合"))
                            add(ItemSectionModel("Queue 结合"))
                            add(ItemSectionModel("Map 集合"))
                            add(ItemSectionModel("Set 集合"))
                            add(ItemSectionModel("集合初始化"))
                            add(ItemSectionModel("数组与集合"))
                            add(ItemSectionModel("集合与泛型"))
                            add(ItemSectionModel("元素的比较"))
                            add(ItemSectionModel("Comparable 和 Comparator"))
                            add(ItemSectionModel("hashCode 和 equals"))
                            add(ItemSectionModel("fail-fast 机制"))
                            add(ItemSectionModel("Map 类集合"))
                            add(ItemSectionModel("红黑树"))
                            add(ItemSectionModel("TreeMap"))
                            add(ItemSectionModel("HashMap"))
                            add(ItemSectionModel("ConcurrentHashMap"))
                        }))
                        add(ItemChapterModel("第 7 章 并发与多线程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("线程安全"))
                            add(ItemSectionModel("什么是锁"))
                            add(ItemSectionModel("线程同步"))
                            add(ItemSectionModel("同步是什么"))
                            add(ItemSectionModel("volatile"))
                            add(ItemSectionModel("信号量同步"))
                            add(ItemSectionModel("线程池"))
                            add(ItemSectionModel("线程池的好处"))
                            add(ItemSectionModel("线程池源码详解"))
                            add(ItemSectionModel("ThreadLocal"))
                            add(ItemSectionModel("引用类型"))
                            add(ItemSectionModel("ThreadLocal 价值"))
                            add(ItemSectionModel("ThreadLocal 副作用"))
                        }))
                        add(ItemChapterModel("第 8 章 单元测试", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("单元测试的基本原则"))
                            add(ItemSectionModel("单元测试覆盖率"))
                            add(ItemSectionModel("单元测试编写"))
                            add(ItemSectionModel("JUnit 单元测试"))
                            add(ItemSectionModel("命名"))
                            add(ItemSectionModel("断言与假设"))
                        }))
                        add(ItemChapterModel("第 9 章 代码规约", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("代码规约的意义"))
                            add(ItemSectionModel("如何推动落地"))
                            add(ItemSectionModel("手册纵览"))
                            add(ItemSectionModel("从规约到学习方法论"))
                        }))
                    }
                    return BookModel("码出高效 Java 开发手册", itemAction, chapterModelList).apply { bookImgRes = R.drawable.bg_book_14 }
                }
                // endregion

                // region C++
                BaseItem.action_book_c_plus -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 开始", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("一个简单的 C++ 程序", 1, 1, true))
                            add(ItemSectionModel("输入输出", 1, 2, true))
                            add(ItemSectionModel("注释简介", 1, 3, true))
                            add(ItemSectionModel("控制流", 1, 4, true))
                            add(ItemSectionModel("类简介", 1, 5, true))
                            add(ItemSectionModel("书店程序", 1, 6, true))
                        }, itemAction))
                        add(ItemChapterModel("第 2 章 变量和基本类型", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("基本内置类型", 2, 1, true))
                            add(ItemSectionModel("变量", 2, 2, true))
                            add(ItemSectionModel("复合类型", 2, 3, true))
                            add(ItemSectionModel("const 限定符", 2, 4, true))
                            add(ItemSectionModel("处理类型", 2, 5, true))
                            add(ItemSectionModel("自定义数据结构", 2, 6, true))
                        }, itemAction))
                        add(ItemChapterModel("第 3 章 字符串、向量和数组", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("命名空间的 using 声明", 3, 1, true))
                            add(ItemSectionModel("标准库类型 string", 3, 2, true))
                            add(ItemSectionModel("标准库类型 vector", 3, 3, true))
                            add(ItemSectionModel("迭代器介绍", 3, 4, true))
                            add(ItemSectionModel("数组", 3, 5, true))
                            add(ItemSectionModel("多维数组"))
                        }, itemAction))
                        add(ItemChapterModel("第 4 章 表达式", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("基础", 4, 1, true))
                            add(ItemSectionModel("算数运算符"))
                            add(ItemSectionModel("逻辑和关系运算符"))
                            add(ItemSectionModel("赋值运算符"))
                            add(ItemSectionModel("递增和递减运算符"))
                            add(ItemSectionModel("成员访问运算符", 4, 6, true))
                            add(ItemSectionModel("条件运算符"))
                            add(ItemSectionModel("位运算符", 4, 8, true))
                            add(ItemSectionModel("sizeof 运算符", 4, 9, true))
                            add(ItemSectionModel("逗号运算符"))
                            add(ItemSectionModel("运算符优先级表"))
                        }, itemAction))
                        add(ItemChapterModel("第 5 章 语句", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("简单语句"))
                            add(ItemSectionModel("语句作用域"))
                            add(ItemSectionModel("条件语句"))
                            add(ItemSectionModel("迭代语句"))
                            add(ItemSectionModel("跳转语句"))
                            add(ItemSectionModel("try 语句块和异常处理"))
                        }))
                        add(ItemChapterModel("第 6 章 函数", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("函数基础"))
                            add(ItemSectionModel("参数传递"))
                            add(ItemSectionModel("返回类型和 return 语句"))
                            add(ItemSectionModel("函数重载"))
                            add(ItemSectionModel("函数匹配"))
                            add(ItemSectionModel("函数指针"))
                        }))
                        add(ItemChapterModel("第 7 章 类", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("定义抽象数据类型"))
                            add(ItemSectionModel("访问控制与封装"))
                            add(ItemSectionModel("类的其他特性"))
                            add(ItemSectionModel("类的作用域"))
                            add(ItemSectionModel("构造函数再探"))
                            add(ItemSectionModel("类的静态成员"))
                        }))
                        add(ItemChapterModel("第 8 章 IO库", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("IO 类"))
                            add(ItemSectionModel("文件输入输出"))
                            add(ItemSectionModel("string流"))
                        }))
                        add(ItemChapterModel("第 9 章 顺序容器", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("顺序容器概述"))
                            add(ItemSectionModel("容器库概览"))
                            add(ItemSectionModel("顺序容器操作"))
                            add(ItemSectionModel("vector 对象是如何增长的"))
                            add(ItemSectionModel("额外的 string 操作"))
                            add(ItemSectionModel("容器适配器"))
                        }))
                        add(ItemChapterModel("第 10 章 泛型算法", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("概述"))
                            add(ItemSectionModel("初识泛型算法"))
                            add(ItemSectionModel("定向操作"))
                            add(ItemSectionModel("再探迭代器"))
                            add(ItemSectionModel("泛型算法结构"))
                            add(ItemSectionModel("特定容器算法"))
                        }))
                        add(ItemChapterModel("第 11 章 关联容器", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("使用关联容器"))
                            add(ItemSectionModel("关联容器概述"))
                            add(ItemSectionModel("关联容器操作"))
                            add(ItemSectionModel("无须容器"))
                        }))
                        add(ItemChapterModel("第 12 章 动态内存", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("动态内存与智能指针"))
                            add(ItemSectionModel("动态数组"))
                            add(ItemSectionModel("使用标准库：文本查询程序"))
                        }))
                        add(ItemChapterModel("第 13 章 拷贝控制", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("拷贝、赋值与销毁"))
                            add(ItemSectionModel("拷贝控制和资源管理"))
                            add(ItemSectionModel("交换操作"))
                            add(ItemSectionModel("拷贝控制示例"))
                            add(ItemSectionModel("动态内存管理类"))
                            add(ItemSectionModel("对象移动"))
                        }))
                        add(ItemChapterModel("第 14 章 重载运算与类型转换", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("基本概念"))
                            add(ItemSectionModel("输入和输出运算符"))
                            add(ItemSectionModel("算数和关系运算符"))
                            add(ItemSectionModel("赋值运算符"))
                            add(ItemSectionModel("下标运算符"))
                            add(ItemSectionModel("递增和递减运算符"))
                            add(ItemSectionModel("成员访问运算符"))
                            add(ItemSectionModel("重载、类型转换与运算符"))
                        }))
                        add(ItemChapterModel("第 15 章 面向对象程序设计", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("概述"))
                            add(ItemSectionModel("定义基类和派生类"))
                            add(ItemSectionModel("虚函数"))
                            add(ItemSectionModel("抽象基类"))
                            add(ItemSectionModel("访问控制与继承"))
                            add(ItemSectionModel("继承中的类作用域"))
                            add(ItemSectionModel("构造函数与拷贝控制"))
                            add(ItemSectionModel("容器与继承"))
                            add(ItemSectionModel("文本查询程序再探"))
                        }))
                        add(ItemChapterModel("第 16 章 模板与泛型编程", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("定义模板"))
                            add(ItemSectionModel("模板实参推断"))
                            add(ItemSectionModel("重载与模板"))
                            add(ItemSectionModel("可变参数模板"))
                            add(ItemSectionModel("模板特例化"))
                        }))
                        add(ItemChapterModel("第 17 章 标准库特殊设施", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("tuple 类型"))
                            add(ItemSectionModel("bitset 类型"))
                            add(ItemSectionModel("正则表达式"))
                            add(ItemSectionModel("随机数"))
                            add(ItemSectionModel("IO 库再探"))
                        }))
                        add(ItemChapterModel("第 18 章 用于大型程序的工具", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("异常处理"))
                            add(ItemSectionModel("命名空间"))
                            add(ItemSectionModel("多重继承与虚继承"))
                        }))
                        add(ItemChapterModel("第 19 章 特殊工具与技术", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("控制内存分配"))
                            add(ItemSectionModel("运行时类型识别"))
                            add(ItemSectionModel("枚举类型"))
                            add(ItemSectionModel("类成员指针"))
                            add(ItemSectionModel("嵌套类"))
                            add(ItemSectionModel("union：一种节省空间的类"))
                            add(ItemSectionModel("局部类"))
                            add(ItemSectionModel("固有的不可移植的特性"))
                        }))
                        add(ItemChapterModel("附录A 章 标准库", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("标注库名字和头文件"))
                            add(ItemSectionModel("算法概览"))
                            add(ItemSectionModel("随机数"))
                        }))
                    }
                    // more info
                    moreInfoList.apply {
                        add(BaseMoreItem("C++ 那些事", "https://github.com/Light-City/CPlusPlusThings.git"))
                        add(BaseMoreItem("C++ 入门", "https://juejin.cn/post/6844904039407173646"))
                    }
                    return BookModel("C++ Primer", itemAction, chapterModelList).apply {
                        bookImgRes = R.drawable.bg_book_15
                        if (moreInfoList.isNotEmpty()) {
                            moreItemList = moreInfoList
                        }
                    }
                }
                // endregion

                // region C语言
                BaseItem.action_book_c -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 导言", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("入门"))
                            add(ItemSectionModel("变量与算数表达式"))
                            add(ItemSectionModel("for 语句"))
                            add(ItemSectionModel("符号常量"))
                            add(ItemSectionModel("字符输入/输出"))
                            add(ItemSectionModel("数组"))
                            add(ItemSectionModel("函数"))
                            add(ItemSectionModel("参数——传值调用"))
                            add(ItemSectionModel("字符数组"))
                            add(ItemSectionModel("外部变量与作用域"))
                        }))
                        add(ItemChapterModel("第 2 章 类型、运算符与表达式", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("变量名"))
                            add(ItemSectionModel("数据类型及长度"))
                            add(ItemSectionModel("常量"))
                            add(ItemSectionModel("声明"))
                            add(ItemSectionModel("算数运算符"))
                            add(ItemSectionModel("关系运算符与逻辑运算符"))
                            add(ItemSectionModel("类型转换"))
                            add(ItemSectionModel("自增预算符与自减运算符"))
                            add(ItemSectionModel("按位运算符"))
                            add(ItemSectionModel("赋值运算符与表达式"))
                            add(ItemSectionModel("条件表达式"))
                            add(ItemSectionModel("运算符优先级与求值次序"))
                        }))
                        add(ItemChapterModel("第 3 章 控制流", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("语句与程序块"))
                            add(ItemSectionModel("if-else 语句"))
                            add(ItemSectionModel("else-if 语句"))
                            add(ItemSectionModel("switch 语句"))
                            add(ItemSectionModel("while 循环与 for 循环"))
                            add(ItemSectionModel("do while 循环"))
                            add(ItemSectionModel("breadk 语句与 continue 语句"))
                            add(ItemSectionModel("goto 语句与标号"))
                        }))
                        add(ItemChapterModel("第 4 章 函数与程序结构", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("函数基本知识"))
                            add(ItemSectionModel("返回非整型值的函数"))
                            add(ItemSectionModel("外部变量"))
                            add(ItemSectionModel("作用域规则"))
                            add(ItemSectionModel("头文件"))
                            add(ItemSectionModel("静态变量"))
                            add(ItemSectionModel("寄存器变量"))
                            add(ItemSectionModel("程序块结构"))
                            add(ItemSectionModel("初始化"))
                            add(ItemSectionModel("递归"))
                            add(ItemSectionModel("C预处理器"))
                        }))
                        add(ItemChapterModel("第 5 章 指针与数组", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("指针与地址"))
                            add(ItemSectionModel("指针与函数参数"))
                            add(ItemSectionModel("指针与数组"))
                            add(ItemSectionModel("地址算数运算符"))
                            add(ItemSectionModel("字符指针与函数"))
                            add(ItemSectionModel("指针数组以及指向指针的指针"))
                            add(ItemSectionModel("多维数组"))
                            add(ItemSectionModel("指针数组的初始化"))
                            add(ItemSectionModel("指针与多维数组"))
                            add(ItemSectionModel("命令行参数"))
                            add(ItemSectionModel("指向函数的指针"))
                            add(ItemSectionModel("复杂声明"))
                        }))
                        add(ItemChapterModel("第 6 章 结构", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("结构的基本知识"))
                            add(ItemSectionModel("结构与函数"))
                            add(ItemSectionModel("结构数组"))
                            add(ItemSectionModel("指向结构的指针"))
                            add(ItemSectionModel("自引用结构"))
                            add(ItemSectionModel("表查找"))
                            add(ItemSectionModel("类型定义（typedef）"))
                            add(ItemSectionModel("联合"))
                            add(ItemSectionModel("位字段"))
                        }))
                        add(ItemChapterModel("第 7 章 输入与输出", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("标准输入/输出"))
                            add(ItemSectionModel("格式化输出——printf函数"))
                            add(ItemSectionModel("变长参数表"))
                            add(ItemSectionModel("格式化输入——scanf函数"))
                            add(ItemSectionModel("文件访问"))
                            add(ItemSectionModel("错误处理——stderr和exit"))
                            add(ItemSectionModel("行输入和行输出"))
                            add(ItemSectionModel("其他函数"))
                        }))
                        add(ItemChapterModel("第 8 章 UNIX 系统接口", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("文件描述符"))
                            add(ItemSectionModel("低级 I/O——read 和 unlink"))
                            add(ItemSectionModel("open、create、close 和 unlink"))
                            add(ItemSectionModel("随机访问——lseek"))
                            add(ItemSectionModel("实例：fopen 和 getc 函数的实现"))
                            add(ItemSectionModel("实例：目录列表"))
                            add(ItemSectionModel("实例：存储分配程序"))
                        }))

                    }
                    // more info
                    moreInfoList.apply {
                        add(BaseMoreItem("C++ 入门", "https://juejin.cn/post/6844904022827073543"))
                    }
                    return BookModel("C程序设计语言", itemAction, chapterModelList).apply {
                        bookImgRes = R.drawable.bg_book_16
                        moreItemList = moreInfoList
                    }
                }
                // endregion

                // region Kotlin
                BaseItem.action_book_kotlin -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("第 1 章 课程导学与准备工作", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("课程介绍与学习指南"))
                        }))
                        add(ItemChapterModel("第 2 章 开发环境搭建", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("Kotlin 开发环境配置"))
                            add(ItemSectionModel("Kotlin 开发环境配置 - IntellJ"))
                            add(ItemSectionModel("Kotlin 开发环境配置 - Android Studio"))
                            add(ItemSectionModel("Gradle 工程简介"))
                            add(ItemSectionModel("Gradle 常见问题解决"))
                        }))
                        add(ItemChapterModel("第 3 章 内置类型", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("基本类型"))
                            add(ItemSectionModel("数组"))
                            add(ItemSectionModel("区间"))
                            add(ItemSectionModel("集合框架"))
                            add(ItemSectionModel("函数"))
                            add(ItemSectionModel("案例：四则计算器"))
                        }))
                        add(ItemChapterModel("第 4 章 类型初步", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("类和接口"))
                            add(ItemSectionModel("扩展方法"))
                            add(ItemSectionModel("空类型安全"))
                            add(ItemSectionModel("智能类型转换"))
                            add(ItemSectionModel("案列：使用 Retrofit 发送网络请求"))
                        }))
                        add(ItemChapterModel("第 5章 表达式", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("常量和变量"))
                            add(ItemSectionModel("分支表达式"))
                            add(ItemSectionModel("运算符与中缀表达式"))
                            add(ItemSectionModel("Lambda 表达式"))
                            add(ItemSectionModel("案例：为 Person 实现 equals 和 hashCode"))
                            add(ItemSectionModel("案例：为 String 实现四则运算"))
                        }))
                        add(ItemChapterModel("第 6 章 函数进阶", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("高阶函数"))
                            add(ItemSectionModel("内联函数"))
                            add(ItemSectionModel("几个有用的高阶函数"))
                            add(ItemSectionModel("集合变换与序列"))
                            add(ItemSectionModel("SAM 转换"))
                            add(ItemSectionModel("案例：统计字符个数"))
                            add(ItemSectionModel("案例：HTML DSL"))
                            add(ItemSectionModel("实践：体验 Gradle Kotlin DSL"))
                        }))
                        add(ItemChapterModel("第 7 章 类型进阶", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("类的构造器"))
                            add(ItemSectionModel("类与成员的可见行"))
                            add(ItemSectionModel("类属性的延迟初始化"))
                            add(ItemSectionModel("代理 Delegate"))
                            add(ItemSectionModel("案例：使用属性代理读写 Properties"))
                            add(ItemSectionModel("单例：object"))
                            add(ItemSectionModel("内部类"))
                            add(ItemSectionModel("数据类 data class"))
                            add(ItemSectionModel("枚举类 enum class"))
                            add(ItemSectionModel("密封类 sealed class"))
                            add(ItemSectionModel("内联类 inner class"))
                            add(ItemSectionModel("案例：数据类的 Json 序列化"))
                            add(ItemSectionModel("案例：递归整型列表的简单实现"))
                        }))
                        add(ItemChapterModel("第 8 章 泛型", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("泛型的基本概念"))
                            add(ItemSectionModel("泛型约束"))
                            add(ItemSectionModel("泛型的型变"))
                            add(ItemSectionModel("UnsaveVariance"))
                            add(ItemSectionModel("星投影 Start Projection"))
                            add(ItemSectionModel("泛型的实现类型与内联特化"))
                            add(ItemSectionModel("案例：模拟 Self Type"))
                            add(ItemSectionModel("案例：基于泛型实现 Model 实例的注入"))
                        }))
                        add(ItemChapterModel("第 9 章 反射", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("反射的基本概念"))
                            add(ItemSectionModel("实践：获取泛型实参"))
                            add(ItemSectionModel("案例：为数据实现 DeepCopy"))
                            add(ItemSectionModel("案例：Model 映射"))
                            add(ItemSectionModel("案例：可释放对象引用的不可空类型"))
                            add(ItemSectionModel("案例：插件化加载类"))
                        }))
                        add(ItemChapterModel("第 10 章 注解", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("注解的基本概念"))
                            add(ItemSectionModel("常见内置注解的使用"))
                            add(ItemSectionModel("案例：仿 Retrofit 反射读取注解请求玩过"))
                            add(ItemSectionModel("案例：注解加持反射版 Model 映射"))
                            add(ItemSectionModel("扩展：Kotlin 编译器插件介绍"))
                        }))
                        add(ItemChapterModel("第 11 章 协程初步", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("Kotlin 协程学习指引"))
                            add(ItemSectionModel("协程的基本概念"))
                            add(ItemSectionModel("协程的常见实现1"))
                            add(ItemSectionModel("协程的常见实现2"))
                            add(ItemSectionModel("Kotlin 协程的基本要素1"))
                            add(ItemSectionModel("Kotlin 协程的基本要素2"))
                            add(ItemSectionModel("案例：Generator 与标准库的序列生成器"))
                            add(ItemSectionModel("案例：仿 Lua 协程实现非对称协程 API"))
                            add(ItemSectionModel("案例：基于非对称协程 API 实现对称协程"))
                            add(ItemSectionModel("案例：仿 Go 的 Channel 实现协程通信"))
                            add(ItemSectionModel("案例：仿 Js 实现 async await"))
                            add(ItemSectionModel("延伸：揭秘 suspend fun main"))
                        }))
                        add(ItemChapterModel("第 12 章 协程进阶", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("案例：仿官方框架实现 launch 1"))
                            add(ItemSectionModel("案例：仿官方框架实现 launch 2"))
                            add(ItemSectionModel("案例：仿官方框架实现 delay"))
                            add(ItemSectionModel("案例：仿官方框架实现调度器"))
                            add(ItemSectionModel("案例：仿官方框架实现 runBlocking"))
                            add(ItemSectionModel("案例：仿官方框架实现 async"))
                            add(ItemSectionModel("案例：仿官方框架实现取消响应1"))
                            add(ItemSectionModel("案例：仿官方框架实现取消响应2"))
                            add(ItemSectionModel("案例：仿官方框架实现异常处理"))
                            add(ItemSectionModel("案例：仿官方框架实现作用域1"))
                            add(ItemSectionModel("案例：仿官方框架实现作用域2"))
                        }))
                        add(ItemChapterModel("第 13 章 协程应用", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("协程框架概述"))
                            add(ItemSectionModel("实践：回调转协程的完整写法"))
                            add(ItemSectionModel("Channel"))
                            add(ItemSectionModel("Select"))
                            add(ItemSectionModel("案例：统计代码行数"))
                            add(ItemSectionModel("Flow"))
                            add(ItemSectionModel("案例：协程在 Ktor 服务中的应用"))
                            add(ItemSectionModel("案例：协程在 Spring 服务中的应用"))
                            add(ItemSectionModel("案例：协程在 Android 服务中的应用"))
                        }))
                        add(ItemChapterModel("第 14 章 课程总结", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("总结"))
                        }))
                        add(ItemChapterModel("第 135章 赠送：弹药补充", mutableListOf<ItemSectionModel>().apply{
                            add(ItemSectionModel("Kotlin1.4 新特性介绍"))
                        }))
                    }
                    return BookModel("Kotlin 突破开发语言瓶颈", itemAction, chapterModelList)
                }
                // endregion

                // region IDE
                BaseItem.ACTION_BOOK_IDE -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("Android Studio", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("常见问题", 1, 1, true))
                            add(ItemSectionModel("Gradle 插件", 1, 2, true))
                            add(ItemSectionModel("大量的类报红，但是能正常编译运行", 1, 3, true))
                        }, itemAction))

                    }
                    return BookModel("IDE", itemAction, chapterModelList)
                }
                // endregion

                // region temp
                BaseItem.ACTION_BOOK_TEMP -> {
                    chapterModelList.apply {
                        add(ItemChapterModel("first chapter", mutableListOf<ItemSectionModel>().apply {
                            add(ItemSectionModel("1.1", 1, 1, true))
                        }, itemAction))

                    }
                    return BookModel("Temp", itemAction, chapterModelList)
                }
                // endregion
            }

            return BookModel("空", itemAction, chapterModelList)
            }
        }
    }