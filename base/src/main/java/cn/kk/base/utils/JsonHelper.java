package cn.kk.base.utils;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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

    /**
     * 这个方法写的不对. [参考](https://howtodoinjava.com/gson/gson-parse-json-array/)
     * @param jsonArray
     * @param clazz
     * @param <T>
     * @return
     */
    public  static  <T> List<T> parseJsonArray(String jsonArray, Class<T> clazz) {
        List<T> resList = new Gson().fromJson(jsonArray, new TypeToken<List<T>>(){}.getType());
       return resList;
    }

    public static void main(String[] args) {


    }
}
