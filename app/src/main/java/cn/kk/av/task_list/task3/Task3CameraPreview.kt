package cn.kk.av.task_list.task3

import android.content.Intent
import android.graphics.*
import android.hardware.Camera
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import cn.kk.base.activity.BaseActivity
import cn.kk.base.utils.BitmapHelper
import cn.kk.base.utils.ThreadHelper
import cn.kk.customview.R
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

    val PREVIEW_MODE_KEY = "preview_mode"
    val PREVIEW_TEXTURE_VIEW_MODE = 1
    val PREVIEW_SURFACE_VIEW_MODE = 2

    // 预览模式
    private var previewMode = PREVIEW_TEXTURE_VIEW_MODE
    private var mCamera: Camera? = null
    private var previewSize: Camera.Size?= null

    private lateinit var cameraTextureView: TextureView
    private lateinit var cameraSurfaceView: SurfaceView
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
                    finish()
                    startActivity(Intent(this, Task3CameraPreview::class.java).apply { putExtra(PREVIEW_MODE_KEY, PREVIEW_TEXTURE_VIEW_MODE) })
                }
                R.id.menu_surface_view -> {
                    if (previewMode == PREVIEW_SURFACE_VIEW_MODE) false
                    finish()
                    startActivity(Intent(mSelf, Task3CameraPreview::class.java).apply { putExtra(PREVIEW_MODE_KEY, PREVIEW_SURFACE_VIEW_MODE) })
                    true
                }
                else -> {}
            }
            true
        }


        previewModeTip = findViewById(R.id.tv_preview_mode)
        cameraTextureView = findViewById(R.id.texture_view)
        cameraSurfaceView = findViewById(R.id.surface_view)
        imgFrame = findViewById(R.id.iv_frame)

        previewMode = intent.getIntExtra(PREVIEW_MODE_KEY, PREVIEW_TEXTURE_VIEW_MODE)
        showPreviewModeTip()

        if (previewMode == PREVIEW_TEXTURE_VIEW_MODE) {
            cameraTextureView.surfaceTextureListener = mSurfaceTextureListener
        } else {
            cameraTextureView.visibility = View.GONE
            cameraSurfaceView.visibility = View.VISIBLE
            cameraSurfaceView.holder.addCallback(mSurfaceHolderCallback)
        }

        // open Camera
        mCamera = Camera.open(1)
        mCamera?.setDisplayOrientation(90)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCamera?.setPreviewCallback(null)
        mCamera?.stopPreview()
        mCamera?.release()
        mCamera = null
    }


   private fun showPreviewModeTip(){
        previewModeTip.text = if(previewMode == PREVIEW_TEXTURE_VIEW_MODE) getString(R.string.camera_preview_texture_view) else getString(R.string.camera_preview_surface_view)
    }

    // TextureView 用
    private val mSurfaceTextureListener = object: TextureView.SurfaceTextureListener {
        override fun onSurfaceTextureAvailable(surface: SurfaceTexture, width: Int, height: Int) {

            mCamera?.setPreviewTexture(surface)
            mCamera?.setPreviewCallback(mPreviewCallback)
            mCamera?.startPreview()

            // 支持分辨率
            val sizes = mCamera?.parameters?.supportedPictureSizes
            sizes?.forEach {
                Log.d(TAG, "支持分辨率: ${it.width} * ${it.height}")
            }
            // 预览分辨率
            val previewSize = mCamera?.parameters?.previewSize
            Log.d(TAG, "预览分辨率: ${previewSize?.width} * ${previewSize?.height}")

            // 镜像设置
            val matrix = Matrix()
            matrix.setScale(-1f, 1f, 540f, 0f)
//            cameraView.setTransform(matrix)

        }

        override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {
            // todo
        }

        override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
            mCamera?.setPreviewCallback(null)
            mCamera?.stopPreview()
            mCamera?.release()
            mCamera = null
            return false
        }

        override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {
            // todo
        }

    }

    /**
     * Camera 预览回调
     */
    private val mPreviewCallback = object : Camera.PreviewCallback {
        override fun onPreviewFrame(data: ByteArray?, camera: Camera?) {
            if (data == null || camera == null) return

            ThreadHelper.runTask {
                if (previewSize == null) {
                    previewSize = camera.parameters.previewSize
                }
                val yuvImage = YuvImage(
                    data,
                    ImageFormat.NV21,
                    previewSize!!.width,
                    previewSize!!.height,
                    null
                )
                val baos = ByteArrayOutputStream()

                // yuv 转 jpg
                yuvImage.compressToJpeg(
                    Rect(0, 0, previewSize!!.width, previewSize!!.height),
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

    }

    private val mSurfaceHolderCallback = object: SurfaceHolder.Callback {
        override fun surfaceCreated(holder: SurfaceHolder) {
            mCamera?.setPreviewDisplay(holder)
            mCamera?.setPreviewCallback(mPreviewCallback)
            mCamera?.startPreview()
        }

        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
            mCamera?.setPreviewCallback(null)
            mCamera?.stopPreview()
            mCamera?.release()
            mCamera = null
        }

    }
}