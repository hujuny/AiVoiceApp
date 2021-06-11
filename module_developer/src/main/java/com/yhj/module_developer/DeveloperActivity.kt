package com.yhj.module_developer

import androidx.recyclerview.widget.DividerItemDecoration
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.adapter.CommonAdapter
import com.yhj.lib_base.adapter.CommonViewHolder
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.module_developer.data.DeveloperListData
import com.yhj.module_developer.databinding.ActivityDeveloperBinding

@Route(path = ARouterHelper.PATH_DEVELOPER)
class DeveloperActivity : BaseActivity<ActivityDeveloperBinding>() {


    private val mTypeTitle = 0
    private val mTypeContent = 1
    private val mList = ArrayList<DeveloperListData>()


    override fun getLayoutId() = R.layout.activity_developer


    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false


    override fun initView() {
        initData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvDeveloper.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvDeveloper.adapter =
            CommonAdapter(mList, object : CommonAdapter.OnMoreBindDataListener<DeveloperListData> {

                override fun onBindViewHolder(
                    model: DeveloperListData,
                    viewHolder: CommonViewHolder,
                    type: Int,
                    position: Int
                ) {
                    when (model.type) {
                        mTypeTitle -> viewHolder.setText(R.id.mTvDeveloperTitle, model.text)
                        mTypeContent -> {
                            viewHolder.setText(
                                R.id.mTvDeveloperContent,
                                "${position}.${model.text}"
                            )
                            viewHolder.itemView.setOnClickListener {
                                itemClick(position)
                            }
                        }
                    }
                }

                override fun getLayoutId(type: Int): Int {

                    return if (type == mTypeTitle)
                        R.layout.layout_developer_title
                    else R.layout.layout_developer_content
                }

                override fun getItemType(position: Int): Int {
                    return mList[position].type
                }

            })
    }

    private fun initData() {
        val dataArray = resources.getStringArray(R.array.DeveloperListArray)
        dataArray.forEach {
            //标题
            if (it.contains("["))
                addItemData(mTypeTitle, it.replace("[", "").replace("]", ""))
            else
                addItemData(mTypeContent, it)

        }
    }

    private fun addItemData(type: Int, text: String) {
        mList.add(DeveloperListData(type, text))
    }

    private fun itemClick(position: Int) {
        when (position) {
            1 -> ARouterHelper.startActivity(ARouterHelper.PATH_APP_MANAGER)
            2 -> ARouterHelper.startActivity(ARouterHelper.PATH_CONSTELLATION)
            3 -> ARouterHelper.startActivity(ARouterHelper.PATH_JOKE)
            4 -> ARouterHelper.startActivity(ARouterHelper.PATH_MAP)
            5 -> ARouterHelper.startActivity(ARouterHelper.PATH_SETTING)
            6 -> ARouterHelper.startActivity(ARouterHelper.PATH_VOICE_SETTING)
            7 -> ARouterHelper.startActivity(ARouterHelper.PATH_WEATHER)
        }
    }
}
