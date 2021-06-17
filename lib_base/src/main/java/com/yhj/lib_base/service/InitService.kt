package com.yhj.lib_base.service

import android.app.IntentService
import android.content.Intent
import com.yhj.lib_base.utils.SpUtils

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/13
 *    @desc   : 初始化服务
 */
class InitService : IntentService(InitService::class.simpleName) {


    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(p0: Intent?) {

        SpUtils.initUtils(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }


}

