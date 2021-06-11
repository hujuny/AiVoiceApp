package com.yhj.lib_base.base

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewbinding.ViewBinding

/**
 *    @author : 杨虎军
 *    @date   : 2021/06/10
 *    @desc   :
 */
abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    lateinit var binding: T
    lateinit var context: Context


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, getLayoutId())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            supportActionBar?.let {
                it.title = getTitleText()
                it.elevation = 0f
                it.setDisplayHomeAsUpEnabled(isShowBack())
            }
        }

        context = this


        initView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return true
    }

    abstract fun getLayoutId(): Int

    abstract fun getTitleText(): String

    abstract fun initView()

    abstract fun isShowBack(): Boolean




    /**
     * 判断是否有权限
     */
    fun hasPermission(permissions: Array<String>): Boolean {
        for (permission: String in permissions) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) == PackageManager.PERMISSION_DENIED
            ) {
                return false
            }
        }
        return true
    }

}