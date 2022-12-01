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

import androidx.annotation.NonNull;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

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


    public static void main(String[] args) {
    }
}
