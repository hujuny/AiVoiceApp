package com.yhj.lib_base.base

import android.app.Application
import android.content.Intent
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.lib_base.helper.NotificationHelper
import com.yhj.lib_base.service.InitService
import com.yhj.lib_voice.manager.VoiceManager

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/11
 *    @desc   :
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ARouterHelper.initHelper(this)
        NotificationHelper.initHelper(this)
        VoiceManager.initManager(this)


        startService(Intent(this, InitService::class.java))
    }
}