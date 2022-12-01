package cn.kk.customview.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import androidx.annotation.NonNull;

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

    public static void main(String[] args) {
    }
}
