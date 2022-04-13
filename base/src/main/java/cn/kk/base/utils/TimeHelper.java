package cn.kk.base.utils;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TimeHelper {


    /**
     * 将 ms 格式化成 时:分
     * @param duration 时长，单位 ms
     * @return
     */
    public static String getDurationFormat(long duration) {
        return String.format(Locale.getDefault(), "%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}
