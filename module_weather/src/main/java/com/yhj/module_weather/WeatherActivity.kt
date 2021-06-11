package com.yhj.module_weather

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_weather.databinding.ActivityWeatherBinding

@Route(path = ARouterHelper.PATH_WEATHER)
class WeatherActivity : BaseActivity<ActivityWeatherBinding>() {


    override fun getLayoutId() = R.layout.activity_weather

    override fun initView() {}

    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false

}
