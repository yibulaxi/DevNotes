package cn.kk.customview.utils;

import android.content.Context;

import java.net.InetAddress;
import java.net.UnknownHostException;

import cn.kk.customview.R;

public class SystemUtil {

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

    public static void main(String[] args) {
    }
}
