package cn.kk.base.utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateHelper {

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


    /**
     * 获取今天是周几
     * @return
     */
    public static int getWeekDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获取当前一周的所有日期（day of month）
     * @return map key: 周几 value: day of month
     */
    public static HashMap<Integer, Integer> getAllDaysOfWeek(){
        int todayInWeekDay = getWeekDay();

        LinkedHashMap<Integer, Integer> days = new LinkedHashMap<>();
        final int week_day_count = 7;
        for (int i = 1; i <= week_day_count; i++) {
            days.put(i, getDayOfMonth(i - todayInWeekDay));
        }
        return days;
    }


    public static int getDayOfMonth(int diffDay){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(new Date().getTime() + 86400 * 1000L * diffDay));
        return cal.get(Calendar.DAY_OF_MONTH);
    }


    public static void main(String[] args) {

        HashMap<Integer, Integer> dayOfWeek = getAllDaysOfWeek();
        for (Map.Entry<Integer, Integer> entry : dayOfWeek.entrySet()) {
            System.out.println("星期 " + entry.getKey() + " -> " + entry.getValue());
        }

    }
}
