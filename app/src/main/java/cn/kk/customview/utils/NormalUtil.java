package cn.kk.customview.utils;

import java.io.*;

/**
 * 常用的方法工具类
 */
public class NormalUtil {

    /**
     * 获取用户目录
     * @return
     */
    public static String getUserDir(){
        return System.getProperty("user.dir");
    }

    /**
     * 获取类的绝对路径
     * @param clazz
     * @return
     */
    public static String getClassAbsPath(Class clazz){
        String path = clazz.getPackage().getName().replaceAll("\\.","/");
        String name = clazz.getSimpleName();
        String userDir = getUserDir();
        return (userDir.equals("/") ? "" : (userDir + "/")) + path + "/" + name + ".class";
    }

    /**
     * 获取指定类的源代码
     * @param clazz
     * @return 返回类的源代码
     */
    public static String getSourceCode(Class clazz) {
        String classAbsPath = NormalUtil.getClassAbsPath(clazz);
        File sourceFile = new File(classAbsPath);
        BufferedReader br = null;
        String codeStr = null;
        try {
            br = new BufferedReader(new FileReader(sourceFile));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            codeStr = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(codeStr);
        }
        return codeStr;
    }

    public static float convert(float alpha){
        return Math.min(Math.max(0f, alpha), 1.0f) * 255;
    }

    public static void main(String[] args) {

        System.out.println(convert(0.6f));

        int[][] myS = new int[6][];

        myS[0] = new int[]{1,2};
    }
}
