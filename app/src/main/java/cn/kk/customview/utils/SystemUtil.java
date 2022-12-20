package cn.kk.customview.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.annotation.NonNull;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.kk.customview.R;

public class SystemUtil {

    private static final String GEEK_TIME_PKG_NAME = "org.geekbang.geekTime";

    /**
     * 获取 app 名称
     * @param context
     * @return
     */
    public static String getAppName(Context context){
        return String.valueOf(context.getString(R.string.app_name));
    }

    public static String getIPAddressFromDomain(String domain){
        try {
            return InetAddress.getAllByName(domain)[0].getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 打开极客时间 app
     * @param context
     */
    public static void startAppGeekTime(Context context){
        startAppByPkgName(context, GEEK_TIME_PKG_NAME);
    }

    public static void startAppByPkgName(@NonNull Context ctx,@NonNull String pkgName){
        if (TextUtils.isEmpty(pkgName)) return;
        if (!hasInstallSpecialApp(ctx, pkgName)) return;
        Intent intent = ctx.getPackageManager().getLaunchIntentForPackage(pkgName);
        if (intent == null) return;
        ctx.startActivity(intent);
    }

    public static boolean hasInstallSpecialApp(Context ctx, String pkgName) {
        if (TextUtils.isEmpty(pkgName)) return false;
        final PackageManager packageManager = ctx.getPackageManager();
        List<PackageInfo> pInfo = packageManager.getInstalledPackages(0);
        if (pInfo != null) {
            for (int i = 0; i < pInfo.size(); i++) {
                String pn = pInfo.get(i).packageName;
                if (pn.equals(pkgName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMiuiWidgetSupported(Context context) {
        Uri uri = Uri.parse("content://com.miui.personalassistant.widget.external");
        boolean isMiuiWidgetSupported = false;
        try {
            Bundle bundle = context.getContentResolver().call(uri,
                    "isMiuiWidgetSupported", null, null);
            if (bundle != null) {
                isMiuiWidgetSupported = bundle.getBoolean("isMiuiWidgetSupported");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isMiuiWidgetSupported;
    }

    public static boolean checkTablet(Context context) {
        String systemProperty = getSystemProperty("ro.build.characteristics", "");
        if (systemProperty.contains("tablet")){
            return true;
        }

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float yInches= metrics.heightPixels/metrics.ydpi;
        float xInches= metrics.widthPixels/metrics.xdpi;
        double diagonalInches = Math.sqrt(xInches*xInches + yInches*yInches);
        if (diagonalInches >= 8) {
            // 存在平板误判（如1440*810）
            boolean adjustTable = metrics.widthPixels > 0 && metrics.heightPixels * 1f / metrics.widthPixels < 1.7f;
            return  ((context.getResources().getConfiguration().screenLayout
                    & Configuration.SCREENLAYOUT_SIZE_MASK)
                    >= Configuration.SCREENLAYOUT_SIZE_LARGE) && adjustTable;
        }
        return false;
    }

    public static String getSystemProperty(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class, String.class);
            value = (String)(get.invoke(c, key, "unknown" ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    private static String filterHtmlImgTag(String source){
        if (source != null && !source.isEmpty()) {
            Pattern pattern = Pattern.compile("<img.*?src\\s*=\\s*\"(.*?)\".*?>"); // ios
//            Pattern pattern = Pattern.compile("<img\\s+(?:[^>]*?\\s+)?src=\"([^\"]*)\"");
            Matcher matcher = pattern.matcher(source);
            if (matcher.find()) {
                System.out.println("匹配了");
                return matcher.group();
            }
                System.out.println("没有匹配");
            return source;
        }
        return "";
    }

    /**
     * 获取HTML文件里面的IMG标签的SRC地址
     * @param htmlText 带html格式的文本
     */
    public static List<String> getHtmlImageSrcList(String htmlText) {
        List<String> imgSrc = new ArrayList<String>();
        Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(htmlText);
        while (m.find()) {
            imgSrc.add(m.group(1));
        }
        return imgSrc;
    }

    public static String getLinkFormat(String link){
        StringBuilder sb = new StringBuilder();
        sb.append("<a href=\"");
        sb.append(link);
        sb.append("\">");
        sb.append("[图片]");
        sb.append("</a>");
        return sb.toString();
    }

    /**
     * 去掉所有的HTML,获取其中的文本信息
     * @param htmlText
     * @return
     */
    public static String GetHtmlText(String htmlText)
    {
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlText);
        htmlText = m_html.replaceAll(""); // 过滤HTML标签
        return htmlText;
    }


    public static void main(String[] args) {

        String receive = "您好，\n" +
                "如果您在安卓平板中遇到了下图所示的情况（图一/图二）：\n" +
                "对于华为平板，在系统设置中搜索“平行视界”，关闭欧路词典的这个选项（图三），就会恢复正常;\n" +
                "对于小米平板, 相关设置的名称是“横屏模式”， 同样在系统设置中检索关闭即可；\n" +
                "其他品牌的平板操作逻辑一致，但设置项名称可能会有不同。\n" +
                "<img src=\"https://files.kf5.com/attachments/download/10434/12969600/001621735daa3f4714c787b5a612034/\" title=\"\" alt=\"图片.png\"><img src=\"https://files.kf5.com/attachments/download/10434/13530681/00162b436e2512ae59d837216ac6592/\" title=\"\" alt=\"Screenshot_2022-06-23-17-46-47-142_com.eusoft.eud.jpg\">\n" +
                "<img src=\"https://files.kf5.com/attachments/download/10434/12969614/001621736542760352f522f8b6f1627/\" title=\"\" alt=\"图片.png\">";

        String testImg = "<img src=\"https://files.kf5.com/attachments/download/10434/13714718/00162eb887797f4b7729a632e41f7bb/\" alt=\"ScreenShot-2022-08-04-at-08.50.16.png\">";

        // 替换成：<a href="https://files.kf5.com/attachments/download/10434/13714718/00162eb887797f4b7729a632e41f7bb/">[图片]</a>

        System.out.println("提取 img 标签：" + filterHtmlImgTag(testImg));


        System.out.println("提取 img 标签 src: " + getHtmlImageSrcList(testImg).get(0));
        System.out.println("格式化 img 标签: " + getLinkFormat(getHtmlImageSrcList(testImg).get(0)));
    }
}
