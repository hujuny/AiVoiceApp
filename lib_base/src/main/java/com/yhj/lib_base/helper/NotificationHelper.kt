package com.yhj.lib_base.helper

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/13
 *    @desc   : 通知栏
 */
object NotificationHelper {

    private lateinit var context: Context
    private lateinit var nm: NotificationManager


    private const val CHANNEL_ID = "ai_voice_id"
    private const val CHANNEL_NAME = "语音服务"

    fun initHelper(context: Context) {
        this.context = context
        nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        sendBindVoiceChannel()

    }

    //创建渠道
    private fun sendBindVoiceChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH)
            //呼吸灯
            channel.enableLights(false)
            //震动
            channel.enableVibration(false)
            //角标
            channel.setShowBadge(false)

            nm.createNotificationChannel(channel)

        }
    }

    //绑定语音服务
    fun bindVoiceService(content: String): Notification {
        val notificationCompat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompat.Builder(context, CHANNEL_ID)
        } else {
            NotificationCompat.Builder(context)
        }
        notificationCompat.setContentTitle(CHANNEL_NAME)
        notificationCompat.setContentText(content)
        notificationCompat.setWhen(System.currentTimeMillis())
        notificationCompat.setAutoCancel(false)
        return notificationCompat.build()
    }


}