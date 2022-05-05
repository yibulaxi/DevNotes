package cn.kk.ndk.bean

import android.util.Log

val TAG = "Animal---"
class Animal(var age: Int, var name: String) {
    companion object {

        /**
         * 获取类型
         */
        @JvmStatic
        fun getType(type: String): String{
            Log.d(TAG, "getType: ${type}...")
            return type
        }
    }

    /**
     * 获取体重
     */
    fun getWeight(value: Int): Int{
        Log.d(TAG, "getWeight: ${value}...")
        return value
    }

    /**
     * 获取食物
     */
    fun getFoods(foods: Array<String>): String{
        for (s in foods) {
            Log.d(TAG, "getFoods: ${s}")
        }
        return foods[0]
    }
}