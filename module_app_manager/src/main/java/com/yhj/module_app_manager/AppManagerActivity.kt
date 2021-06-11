package com.yhj.module_app_manager

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_app_manager.databinding.ActivityAppManagerBinding
import kotlin.math.log


@Route(path = ARouterHelper.PATH_APP_MANAGER)
class AppManagerActivity : BaseActivity<ActivityAppManagerBinding>() {


    override fun getLayoutId() = R.layout.activity_app_manager

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false


}
