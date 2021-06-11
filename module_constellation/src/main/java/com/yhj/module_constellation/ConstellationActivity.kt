package com.yhj.module_constellation

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_constellation.databinding.ActivityConstellationBinding

@Route(path = ARouterHelper.PATH_CONSTELLATION)
class ConstellationActivity : BaseActivity<ActivityConstellationBinding>() {


    override fun getLayoutId()=R.layout.activity_constellation

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false
}
