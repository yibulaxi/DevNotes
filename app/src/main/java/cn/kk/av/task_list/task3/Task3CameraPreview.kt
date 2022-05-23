package cn.kk.av.task_list.task3

import android.graphics.*
import android.hardware.Camera
import android.util.Log
import android.view.MenuItem
import android.view.TextureView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import cn.kk.base.UIHelper
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.BitmapHelper
import cn.kk.base.utils.ThreadHelper
import cn.kk.customview.R
import okhttp3.internal.wait
import java.io.ByteArrayOutputStream

/**
 * 任务列表3：在 Android 平台使用 Camera API 进行视频的采集，分别使用 SurfaceView、TextureView 来预览 Camera 数据，取到 NV21 的数据回调
 *
 * 参考其他人对代码：
 * [这个完成了 7 个任务](https://github.com/LZacking/Audio-and-Video)
 */
class Task3CameraPreview: BaseActivity() {
    override fun getLayout(): Int {
        return R.layout.activity_task3_camera_preview
    }

    val PREVIEW_TEXTURE_VIEW_MODE = 1
    val PREVIEW_SURFACE_VIEW_MODE = 2

    // 预览模式
    private var previewMode = PREVIEW_TEXTURE_VIEW_MODE
    private lateinit var camera: Camera
    private var frameData: ByteArray? = null

    private lateinit var cameraView: TextureView
    private lateinit var imgFrame: ImageView
    private lateinit var previewModeTip: TextView

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // config toolbar
        baseToolbar?.setBackgroundColor(ContextCompat.getColor(this, R.color.primary_20))
        baseToolbar?.inflateMenu(R.menu.menu_camera_preview)
        baseToolbar?.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.menu_texture_view -> {
                    if (previewMode == PREVIEW_TEXTURE_VIEW_MODE) false

                    previewMode = PREVIEW_TEXTURE_VIEW_MODE
                }
                R.id.menu_surface_view -> {
                    if (previewMode == PREVIEW_SURFACE_VIEW_MODE) false

                    previewMode = PREVIEW_SURFACE_VIEW_MODE
                }
                else -> {}
            }
            true
        }


        previewModeTip = findViewById(R.id.tv_preview_mode)
        cameraView = findViewById(R.id.texture_view)
        imgFrame = findViewById(R.id.iv_frame)


        showPreviewModeTip()

        cameraView.surfaceTextureListener = mSurfaceTextureListener

        camera = Camera.open(1)
        camera.setDisplayOrientation(90)
    }

    fun showPreviewModeTip(){
        previewModeTip.text = if(previewMode == PREVIEW_TEXTURE_VIEW_MODE) getString(R.string.camera_preview_texture_view) else getString(R.string.camera_preview_surface_view)
    }

    private val mSurfaceTextureListener = object: TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {

            camera.setPreviewTexture(surface)
            camera.setPreviewCallback(object : Camera.PreviewCallback{
                override fun onPreviewFrame(data: ByteArray?, camera: Camera?) {
                    if (data == null || camera == null) return

                    ThreadHelper.runTask {
                        val previewSize = camera.parameters.previewSize
                        val yuvImage = YuvImage(
                            data,
                            ImageFormat.NV21,
                            previewSize.width,
                            previewSize.height,
                            null
                        )
                        val baos = ByteArrayOutputStream()

                        // yuv 转 jpg
                        yuvImage.compressToJpeg(
                            Rect(0, 0, previewSize.width, previewSize.height),
                            100,
                            baos
                        )
                        val imgBytes = baos.toByteArray()

                        // ImageByte 转  bitmap
                        val options = BitmapFactory.Options()
                            .apply { inPreferredConfig = Bitmap.Config.RGB_565 }
                        val bitmap =
                            BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.size, options)
                        // bitmap 需要旋转角度
                        val correctBitmap = BitmapHelper.rotateBitmap(bitmap, -90f)

                        ThreadHelper.runOnUIThread { imgFrame.setImageBitmap(correctBitmap) }
                    }


                }

            })
            camera.startPreview()

            // 支持分辨率
            val sizes = camera.parameters.supportedPictureSizes
            sizes.forEach {
                Log.d(TAG, "支持分辨率: ${it.width} * ${it.height}")
            }
            // 预览分辨率
            val previewSize = camera.parameters.previewSize
            Log.d(TAG, "预览分辨率: ${previewSize.width} * ${previewSize.height}")

            // 镜像设置
            val matrix = Matrix()
            matrix.setScale(-1f, 1f, 540f, 0f)
//            cameraView.setTransform(matrix)

        }

        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {
            // todo
        }

        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
            camera.release()
            return false
        }

        override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {
            // todo
        }

    }
}