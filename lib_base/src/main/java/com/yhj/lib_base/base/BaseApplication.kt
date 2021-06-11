package com.yhj.lib_base.base

import android.app.Application
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.lib_base.utils.SpUtils

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/11
 *    @desc   :
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouterHelper.initHelper(this)

        SpUtils.initUtils(this)
    }
}