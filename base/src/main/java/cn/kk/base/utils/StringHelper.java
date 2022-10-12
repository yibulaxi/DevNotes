package cn.kk.base.utils;


import android.graphics.Color;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

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



    public static void main(String[] args) {


//        list2arrayDemo();

        String sentence1 = "Allergens are anything harmless (or neutral) that can be inhaled in air by nose and trigger excessive immune reaction.";
        String keyWord = "allergen";

//        System.out.println(word2Cap(keyWord));

        System.out.println(highLightWord(sentence1, keyWord));

    }
}
