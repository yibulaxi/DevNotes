package cn.kk.base.utils;


import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonHelper {


    // 生成 json array str
    public static String getJsonArrayStr() {
        String str = null;

        JSONObject job = new JSONObject();
        JSONArray jay = new JSONArray();
        jay.put("12345");
        jay.put("0987654321");

        try {
            job.put("uuids", jay);
//            System.out.println(job.toString());
            str = job.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return str;
    }

    /*public static <T> List<T> parseJsonArray(String jsonArray) {
        new Gson().fromJson<List<T>>();
    }*/

    public static void main(String[] args) {


    }
}
