package com.yhj.moudle_joke

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.moudle_joke.databinding.ActivityJokeBinding

@Route(path = ARouterHelper.PATH_JOKE)
class JokeActivity : BaseActivity<ActivityJokeBinding>() {

    override fun getLayoutId()=R.layout.activity_joke

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false
}
