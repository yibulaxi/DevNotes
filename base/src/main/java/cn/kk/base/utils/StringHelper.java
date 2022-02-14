package cn.kk.base.utils;

import android.text.TextUtils;

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

    public static void main(String[] args) {

        String answer = "<div id=\"exp\" class=\".expDiv\">亲兄弟</div><div id=\"lj_recite\" class=\"sentence\"><div><div>Alicia tiene un hermano y una hermana.<br><span class=\"exp\">Alicia 有一个哥哥和一个姐姐</span></div></div></div>";
        System.out.println("answer: " + answer);
        System.out.println("filterHtml: " + filterHtml(answer));
        String[] split = filterHtml(answer).split("\n");


        System.out.println(split.length);
    }
}
