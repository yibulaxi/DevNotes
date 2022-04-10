package cn.kk.customview.config

class UIConfig {

    companion object {
        val PART_SYSTEM_STUDY = 0
        val PART_SYSTEM_UI = 1
        val PART_COOL_300 = 2
        val PART_THIRD = 3
        val PART_HENCODER = 4
        val PART_WORK = 5
    }

   open class SubConfig {
       companion object {
           // 常用控件
           val COMMON_VIEW = 10
           // 通知栏
           val NOTIFICATION_VIEW = 11
           // 菜单
           val MENU_VIEW = 12
           // 图形和图像
           val GRAPHIC_AND_IMAGE_VIEW = 13
           // 动画
           val ANIM_VIEW = 14
           // 文件和数据
           val FILE_AND_DATA = 15
           // 系统和设备
           val SYS_AND_DEVICE = 16
           // 意图
           val INTENT_SECTION = 17
           // 第三方 sdk
           val SDK_3RD_SECTION = 18
       }

    }

    open class SubConfigSystem {

        open class Anim {
            companion object {
                // 视图动画
                val ANIM_VIEW = 100
                // 属性动画
                val ANIM_PROPERTY = 101
                // 动画进阶
                val ANIM_ADVANCE = 102
            }
        }

        open class  Draw {
            companion object {
                // Paint 基本使用
                val PAINT_TYPE = 200
                // 绘图进阶
                val ADVANCE_TYPE = 201
                // 混合模式
                val XFERMODE_TYPE = 202
                // Canvas 与涂层
                val CANVAS_TYPE = 203
                // Android 画布
                val ANDROID_CANVAS_TYPE = 204
                // Matrix 与坐标变换
                val MATRIX_TYPE = 205
            }

        }

        open class View {
            companion object {
                val BOX_VIEW = 300
                val VIEW_ADVANCE_PROPERTY = 300
            }
        }
    }

}