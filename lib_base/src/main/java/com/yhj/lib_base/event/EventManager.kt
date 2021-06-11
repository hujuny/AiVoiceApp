package com.yhj.lib_base.event

import org.greenrobot.eventbus.EventBus
import java.util.*

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/10
 *    @desc   :EventBus管理
 */
class EventManager {


    //注册
    fun register(subscriber: Any) {
        EventBus.getDefault().register(subscriber)
    }

    //解绑
    fun unregister(subscriber: Any) {
        EventBus.getDefault().unregister(subscriber)
    }

    //发送
    private fun post(event: MessageEvent) {
        EventBus.getDefault().post(event)
    }

    //发送类型
    fun post(type: Int) {
        post(MessageEvent((type)))
    }

    //发送类型 string
    fun post(type: Int, string: String) {
        val messageEvent = MessageEvent(type)
        messageEvent.stringValue = string
        post(messageEvent)
    }

    //发送类型 int
    fun post(type: Int, int: Int) {
        val messageEvent = MessageEvent(type)
        messageEvent.intValue = int
        post(messageEvent)
    }

    //发送类型 boolean
    fun post(type: Int, boolean: Boolean) {
        val messageEvent = MessageEvent(type)
        messageEvent.booleanValue = boolean
        post(messageEvent)
    }


}