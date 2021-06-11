package com.yhj.module_voice_setting

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_voice_setting.databinding.ActivityVoiceSettingBinding

@Route(path = ARouterHelper.PATH_VOICE_SETTING)
class VoiceSettingActivity : BaseActivity<ActivityVoiceSettingBinding>() {

    override fun getLayoutId()=R.layout.activity_voice_setting

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false
}
