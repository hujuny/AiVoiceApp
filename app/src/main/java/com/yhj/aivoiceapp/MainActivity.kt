package com.yhj.aivoiceapp

import com.yhj.aivoiceapp.databinding.ActivityMainBinding
import com.yhj.lib_base.adapter.CommonAdapter
import com.yhj.lib_base.adapter.CommonViewHolder
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper

/**
 * @author :杨虎军
 * @date   :2021/6/10
 * @desc   :
 */
class MainActivity : BaseActivity<ActivityMainBinding>() {


    private var mList = ArrayList<String>()

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

        binding.rvContent.adapter =
            CommonAdapter<String>(mList, object : CommonAdapter.OnBindDataListener<String> {
                override fun onBindViewHolder(
                    model: String,
                    viewHolder: CommonViewHolder,
                    type: Int,
                    position: Int
                ) {
                    viewHolder.setText(R.id.tv_content, model)
                }

                override fun getLayoutId(type: Int): Int {
                    return R.layout.activity_main
                }

            })
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