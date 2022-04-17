package cn.kk.customview.io

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.lang.Exception

object FileHelper {

    fun writeFile(file: File, inputStream: InputStream): Boolean{
        val fileOutputStream = FileOutputStream(file)
        var len = 0
        val buffer = ByteArray(1024)
        try {
            while((inputStream.read(buffer).also { len = it }) != -1){
                fileOutputStream.write(buffer, 0, len)
            }
            fileOutputStream.flush()
            return true
        }catch (e: Exception){
            e.printStackTrace()
            return false
        }

    }
}