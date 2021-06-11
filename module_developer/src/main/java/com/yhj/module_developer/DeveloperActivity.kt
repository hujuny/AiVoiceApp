package com.yhj.module_developer

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_developer.databinding.ActivityDeveloperBinding

@Route(path = ARouterHelper.PATH_DEVELOPER)
class DeveloperActivity : BaseActivity<ActivityDeveloperBinding>() {


    override fun getLayoutId()=R.layout.activity_developer

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false
}
