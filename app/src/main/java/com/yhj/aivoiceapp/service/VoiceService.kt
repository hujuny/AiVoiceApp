package com.yhj.aivoiceapp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.yhj.lib_base.helper.NotificationHelper

/**
 * @author :杨虎军
 * @date   :2021/6/13
 * @desc   :语音Service
 */
class VoiceService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        initService()
    }

    private fun initService() {
//        VoiceManager.initManager(this)
    }

    /**
     *  START_STICKY:当系统内存不足的时候，杀掉了服务，那么在系统内存不再紧张的时候，启动服务
     *  START_NOT_STICKY:当系统内存不足的时候，杀掉了服务，直到下一次startService才启动
     *  START_REDELIVER_INTENT:重新传递Intent值
     *  START_STICKY_COMPATIBILITY:START_STICKY兼容版本，但是它也不能保证系统kill掉服务一定能重启
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        bindNotification()
        return START_STICKY_COMPATIBILITY
    }

    //绑定通知栏
    private fun bindNotification() {
        startForeground(1000, NotificationHelper.bindVoiceService("正在运行"))
    }


}
