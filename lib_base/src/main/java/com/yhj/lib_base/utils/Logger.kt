package com.yhj.lib_base.utils

import android.util.Log
import com.yhj.lib_base.BuildConfig

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/11
 *    @desc   :日志工具
 */
object Logger {

    private const val TAG: String = "AiVoiceApp"

    fun i(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.i(TAG, it)
            }
        }
    }

    fun d(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.d(TAG, it)
            }
        }
    }

    fun e(text: String?) {
        if (BuildConfig.DEBUG) {
            text?.let {
                Log.e(TAG, it)
            }
        }
    }
}