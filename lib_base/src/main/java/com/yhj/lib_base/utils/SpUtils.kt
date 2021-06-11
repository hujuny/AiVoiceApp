package com.yhj.lib_base.utils

import android.content.Context
import android.content.SharedPreferences

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/11
 *    @desc   :SharedPreferences工具类
 */
object SpUtils {

    private const val SP_NAME = "config"
    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    fun initUtils(context: Context) {
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        editor = sp.edit()
        editor.apply()
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String) = sp.getString(key, "")


    fun putInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    fun getInt(key: String, defValue: Int) = sp.getInt(key, defValue)

}