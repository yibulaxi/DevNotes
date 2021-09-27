package cn.kk.customview.utils;

import android.content.Context;
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
}
