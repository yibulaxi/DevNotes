package cn.kk.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataHelper {

    /**
     * 根据地区和语言，获取本地化的日期。
     * @param language
     * @param date
     * @return
     */
    public static String localizeMonthDay(String language, Date date) {
        SimpleDateFormat format;
        if ("es".equals(language)) {//d m
            format = new SimpleDateFormat("d MMM", new Locale("Es", "es"));
        } else if ("fr".equals(language)) {//d m.
            format = new SimpleDateFormat("d MMM", Locale.FRENCH);
        } else if ("de".equals(language)) {//d. m
            format = new SimpleDateFormat("d. MMM", Locale.GERMAN);
        } else {//d m
            format = new SimpleDateFormat("d MMM", Locale.ENGLISH);
        }
        return format.format(date);
    }




    public static void main(String[] args) {
        System.out.println(localizeMonthDay("es", new Date()));

    }
}
