package cn.kk.base.utils;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    public static String filterHtml(String str) {
        if (str == null) return "";
        str = str.replace("&nbsp;", " ");
        str = str.replace("&lt;", " ");
        str = str.replace("&gt;", " ");
        str = str.replace("<BR>", "\r\n");
        str = str.replace("<BR />", "\r\n");
        str = str.replace("<br>", "\r\n");
        str = str.replace("<br />", "\r\n");
        str = str.replace("</td>", "\t ");
        str = str.replace("</tr>", "\r\n");
        str = str.replace("<span", "\r\n<span");
        str = str.replace("<div", "\r\n<div");
        str = str.replace("</div>", "\r\n");
        str = str.replace("<li>", "\r\n- ");
        str = str.replace("</p>", "\r\n");
        str = str.replace("<p>", "\r\n");
        str = str.replaceAll("\\r+", "\n").replaceAll("\\n+", "\n");
        String regex = "<.*?>";
        return str.replaceAll(regex, "");
    }

    public static void list2arrayDemo(){
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        String[] numArray = list.toArray(new String[0]);
        for (String s : numArray) {
            System.out.println(s);
        }
    }

    public static String highLightWord(String sentence, String key){
        // Allergens are anything harmless (or neutral) that can be inhaled in air by nose and trigger excessive immune reaction.
        // allergen
        String hexColor = Integer.toHexString(Color.RED);
        if (sentence.contains("<span")) {
            return sentence.replace("<span", String.format("<span style='color:%s' ", hexColor));
        } else if (sentence.contains(key.concat(key))) {
            return sentence.replace(key, String.format("<span style='color:%s'>%s</span>", hexColor, key));
        } else if (sentence.contains(word2Cap(key))) {
            return sentence.replace(word2Cap(key), String.format("<span style='color:%s'>%s</span>", hexColor, word2Cap(key)));
        }
        return sentence;
    }


    /**
     * 转化成大些字母
     * @param character
     * @return
     */
    private Character letter2Capital(Character character) {
        char c = character;
        // 小写字母范围
        if (c >= 97 && c <= 122) {
            c = (char) (c - 32);
        }
        return c;
    }

    public static String word2Cap(String word){
//        if (TextUtils.isEmpty(word)) return word;

        char startC = word.charAt(0);
        char targetC = startC;
        if (startC >= 97 && startC <= 122) {
            // 小写字母开头
            targetC = (char) (startC - 32);
            return word.toLowerCase().replace(startC, targetC);
        }
        return word;
    }

    private static String filterHtmlImgTag(String source){
        if (source != null && !source.isEmpty()) {
            Pattern pattern = Pattern.compile("<img.*?src\\s*=\\s*\"(.*?)\".*?>"); // ios
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

    // get all activity info
    public static String getAllActivityInfo(Context context) {
        StringBuilder sb = new StringBuilder();
        PackageManager pm = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            ActivityInfo[] list = info.activities;
            sb.append("start:\n");
            for (ActivityInfo activityInfo : list) {
                sb.append(activityInfo.name
                        + "\n");
            }
            sb.append("------------------");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }
    public static void main(String[] args) {


    }
}
