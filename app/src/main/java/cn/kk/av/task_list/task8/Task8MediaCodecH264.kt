package cn.kk.av.task_list.task8

import android.app.Activity
import android.content.pm.PackageManager
import android.media.MediaCodec
import android.media.MediaFormat
import android.os.Environment
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import androidx.core.app.ActivityCompat
import cn.kk.base.activity.BaseActivity
import cn.kk.customview.R
import java.io.*
import java.nio.ByteBuffer

/**
 * MediaCodec H264 编解码
 */
class Task8MediaCodecH264: BaseActivity() {

    override fun getLayout(): Int {
        return R.layout.activity_task8_media_codec_h264
    }


    private val REQUEST_EXTERNAL_STORAGE = 1
    private val PERMISSIONS_STORAGE = arrayOf(
        "android.permission.READ_EXTERNAL_STORAGE",
        "android.permission.WRITE_EXTERNAL_STORAGE"
    )


    private var canDecode = true
    private var mSurfaceView: SurfaceView? = null
    private var mSurfaceHolder: SurfaceHolder? = null
    private var mDecodeThread: Thread? = null
    private var mMediaCodec: MediaCodec? = null
    private var mInputStream: DataInputStream? = null

    private val SD_PATH = Environment.getExternalStorageDirectory().path + "/av"
    private val H264_FILE = "$SD_PATH/min.h264"

    override fun doWhenOnCreate() {
        super.doWhenOnCreate()

        // 获取权限
        // 获取权限
        verifyStoragePermissions(this)
        mSurfaceView = findViewById<View>(R.id.surfaceView) as SurfaceView
        // 获取文件输入流
        // 获取文件输入流
        getFileInputStream()
        // 初始化解码器
        // 初始化解码器
        initMediaCodec()

    }

    override fun onDestroy() {
        super.onDestroy()
        canDecode = true
    }


    private fun verifyStoragePermissions(ctx: Activity) {
        try {
            // 检测是否有写的权限
            val permissionRead = ActivityCompat.checkSelfPermission(
                ctx,
                PERMISSIONS_STORAGE.get(0)
            )
            val permissionWrite = ActivityCompat.checkSelfPermission(
                ctx,
                PERMISSIONS_STORAGE.get(1)
            )
            if (permissionRead != PackageManager.PERMISSION_GRANTED || permissionWrite != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(
                    ctx,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 获取需要解码的文件流
     */
    fun getFileInputStream() {
        try {
            val file: File = File(H264_FILE)
            mInputStream = DataInputStream(FileInputStream(file))
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            try {
                mInputStream!!.close()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }
        }
    }


    /**
     * 初始化解码器
     */
    private fun initMediaCodec() {
        mSurfaceHolder = mSurfaceView!!.holder
        mSurfaceHolder?.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {
                    // 创建编码器
                    mMediaCodec = MediaCodec.createDecoderByType(MediaFormat.MIMETYPE_VIDEO_AVC)
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                // 使用MediaFormat初始化编码器，设置宽，高
                val mediaFormat = MediaFormat.createVideoFormat(
                    MediaFormat.MIMETYPE_VIDEO_AVC,
                    holder.surfaceFrame.width(),
                    holder.surfaceFrame.height()
                )
                // 设置帧率
                mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 40)
                // 配置编码器
                mMediaCodec!!.configure(mediaFormat, holder.surface, null, 0)
                startDecodingThread()
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {}
        })
    }


    /**
     * 开启解码器并开启读取文件的线程
     */
    private fun startDecodingThread() {
        mMediaCodec!!.start()
        mDecodeThread = Thread(DecodeThread())
        mDecodeThread!!.start()
    }

    private inner class DecodeThread : Runnable {
        override fun run() {
            // 开始解码
            decode()
        }

        private fun decode() {
            // 获取一组缓存区(8个)
            val inputBuffers: Array<ByteBuffer> = mMediaCodec!!.getInputBuffers()
            // 解码后的数据，包含每一个buffer的元数据信息
            val info = MediaCodec.BufferInfo()
            // 获取缓冲区的时候，需要等待的时间(单位：毫秒)
            val timeoutUs: Long = 10000
            var streamBuffer: ByteArray? = null
            try {
                // 返回可用的字节数组
                streamBuffer = getBytes(mInputStream!!)
            } catch (e: IOException) {
                e.printStackTrace()
            }
            var bytes_cnt = 0
            // 得到可用字节数组长度
            bytes_cnt = streamBuffer!!.size

            // 没有得到可用数组
            if (bytes_cnt == 0) {
                streamBuffer = null
            }
            // 每帧的开始位置
            var startIndex = 0
            // 定义记录剩余字节的变量
            val remaining = bytes_cnt
            // while(true)大括号内的内容是获取一帧，解码，然后显示；直到获取最后一帧，解码，结束
            while (canDecode) {
                try {// 当剩余的字节=0或者开始的读取的字节下标大于可用的字节数时  不在继续读取
                    if (remaining == 0 || startIndex >= remaining) {
                        break
                    }

                    // 寻找帧头部
                    var nextFrameStart: Int = findHeadFrame(streamBuffer!!, startIndex + 2, remaining)

                    // 找不到头部返回-1
                    if (nextFrameStart == -1) {
                        nextFrameStart = remaining
                    }
                    // 得到可用的缓存区
                    val inputIndex: Int = mMediaCodec!!.dequeueInputBuffer(timeoutUs)
                    // 有可用缓存区
                    startIndex = if (inputIndex >= 0) {
                        val byteBuffer = inputBuffers[inputIndex]
                        byteBuffer.clear()
                        // 将可用的字节数组(一帧)，传入缓冲区
                        byteBuffer.put(streamBuffer, startIndex, nextFrameStart - startIndex)
                        // 把数据传递给解码器
                        mMediaCodec?.queueInputBuffer(inputIndex, 0, nextFrameStart - startIndex, 0, 0)
                        // 指定下一帧的位置
                        nextFrameStart
                    } else {
                        continue
                    }
                    val outputIndex: Int = mMediaCodec!!.dequeueOutputBuffer(info, timeoutUs)
                    if (outputIndex >= 0) {
                        // 加入try catch的目的是让界面显示的慢一点，这个步骤可以省略
                        try {
                            Thread.sleep(33)
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }
                        // 将处理过的数据交给surfaceview显示
                        mMediaCodec!!.releaseOutputBuffer(outputIndex, true)
                    }
                } catch (e: Exception) {
                }
            }
        }
    }

    /**
     * 查找帧头部的位置
     * 在实际的H264数据帧中，往往帧前面带有00 00 00 01 或 00 00 01分隔符
     * @param bytes
     * @param start
     * @param totalSize
     * @return
     */
    private fun findHeadFrame(bytes: ByteArray, start: Int, totalSize: Int): Int {
        for (i in start until totalSize - 4) {
            if (bytes[i] == (0x00).toByte()
                && bytes[i + 1] == (0x00).toByte()
                && bytes[i + 2] == (0x00).toByte()
                && bytes[i + 3] == (0x01).toByte()
                || bytes[i] == (0x00).toByte()
                && bytes[i + 1] == (0x00).toByte()
                && bytes[i + 2] == (0x01).toByte()) {
                return i
            }
        }
        return -1
    }

    companion object {
        /**
         * 获得可用的字节数组
         * @param is
         * @return
         * @throws IOException
         */
        @Throws(IOException::class)
        fun getBytes(`is`: InputStream): ByteArray? {
            var len: Int
            val size = 1024
            var buf: ByteArray
            val bos = ByteArrayOutputStream()
            buf = ByteArray(size)
            while (`is`.read(buf, 0, size).also { len = it } != -1) {
                // 将读取的数据写入到字节输出流
                bos.write(buf, 0, len)
            }
            // 将这个流转换成字节数组
            buf = bos.toByteArray()
            return buf
        }

    }
}