package com.yhj.module_setting

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_setting.databinding.ActivitySettingBinding

@Route(path = ARouterHelper.PATH_SETTING)
class SettingActivity : BaseActivity<ActivitySettingBinding>() {

    override fun getLayoutId()=R.layout.activity_setting

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false
}
