package cn.kk.customview.factory

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

            when(itemAction) {
                // region 《Android 开发艺术探索》
                BaseItem.action_book_1 -> {
                    val chapterModelList = mutableListOf<ItemChapterModel>().apply {
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
                    val bookModel = BookModel("Android\n开发艺术探索", itemAction, chapterModelList)

                    return bookModel
                }
                // endregion
            }

            return BookModel()
        }
    }
}