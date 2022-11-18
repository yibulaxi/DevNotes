package cn.kk.base.utils;

import android.content.Context;
import android.os.Environment;
import android.text.format.DateUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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

}
