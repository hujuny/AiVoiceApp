package com.yhj.aivoiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yhj.aivoiceapp.databinding.ActivityMainBinding
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.event.EventManager
import com.yhj.lib_base.event.MessageEvent
import com.yhj.lib_base.helper.ARouterHelper
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @author :杨虎军
 * @date   :2021/6/10
 * @desc   :
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onDestroy() {
        super.onDestroy()
//        EventManager().unregister(this)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun getTitleText() = getString(R.string.app_name)

    override fun initView() {
//        EventManager().register(this)

//        EventManager().post(111)
//        EventManager().post(222, "哈哈哈")

        binding.tvContent.setOnClickListener { ARouterHelper.startActivity(ARouterHelper.PATH_APP_MANAGER) }
    }

    override fun isShowBack() = true

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    fun onMessageEvent(event: MessageEvent) {
//        when (event.type) {
//            111 -> Log.e("yhj", "onMessageEvent: ")
//            222 -> Log.e("yhj", "onMessageEvent: " + event.stringValue)
//        }
//    }
}