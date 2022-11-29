package cn.kk.base.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class IOUtils {

    public static String readFromFile(String filename, Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput(filename);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public static String readFromFile(String filePath) {
        String ret = "";
        File file = new File(filePath);
        if (!file.exists()) return ret;
        try {
            FileInputStream fis = new FileInputStream(file);
            ret = convertStreamToString(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 读取文件结尾的几行内容
     * @param filePath
     * @param limitLine
     * @return
     */
    public static String tailFile(String filePath, int limitLine) {
        StringBuilder line = new StringBuilder();
        BufferedReader input = null;
        String tempLine;
        try {
            Process p = Runtime.getRuntime().exec("tail -" + limitLine + " " + filePath);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            while ( (tempLine = input.readLine()) != null) {
                line.append(tempLine);
            }
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line.toString();
    }

    public static boolean saveData2File(String data, String filePath){
        File logFile = new File(filePath);
        File logDir = logFile.getParentFile();
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream(logFile, true);
            OutputStreamWriter ow = new OutputStreamWriter(fos);
            ow.append( data);
            ow.append("\n\n");
            ow.close();
            fos.flush();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void write2SDCard(String data) {
        String dirPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/kk/";
        File logDir = new File(dirPath);
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
        File file =  new File(dirPath, "hello.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            OutputStreamWriter ow = new OutputStreamWriter(fos);
            ow.append( data);
            ow.append("\n\n");
            ow.close();
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public static String saveBitmap2File(Bitmap bm){
        String path = null;
        String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        File myDir = new File(root + "/req_images");
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            path = file.getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String saveBitmap2Pictures(Activity act, Bitmap bitmap) {
        // MediaStore.Images.Media.EXTERNAL_CONTENT_URI; 相册目录，在 /storage/emulated/0/Pictures/
        String path = null;
        Uri uri = act.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        if (uri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = act.getContentResolver().openOutputStream(uri);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                path = uri.toString() + ".jpg";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                path = e.toString();
            }
        }
        return path;
    }

}
