package com.yhj.module_voice_setting

import android.widget.SeekBar
import androidx.recyclerview.widget.DividerItemDecoration
import com.alibaba.android.arouter.facade.annotation.Route
import com.yhj.lib_base.adapter.CommonAdapter
import com.yhj.lib_base.adapter.CommonViewHolder
import com.yhj.lib_base.base.BaseActivity
import com.yhj.lib_base.helper.ARouterHelper
import com.yhj.lib_voice.manager.VoiceManager
import com.yhj.module_voice_setting.databinding.ActivityVoiceSettingBinding

@Route(path = ARouterHelper.PATH_VOICE_SETTING)
class VoiceSettingActivity : BaseActivity<ActivityVoiceSettingBinding>() {


    private var mList: ArrayList<String> = ArrayList()

    private var mTtsPeopleIndex: Array<String>? = null


    override fun getLayoutId() = R.layout.activity_voice_setting


    override fun getTitleText() = getString(R.string.app_name)

    override fun isShowBack() = false

    override fun initView() {

        binding.barVoiceSpeed.progress = 5
        binding.barVoiceVolume.progress = 5


    }

    override fun initData() {
        super.initData()

        val mTtsPeople = resources.getStringArray(R.array.TTSPeople)
        mTtsPeopleIndex = resources.getStringArray(R.array.TTSPeopleIndex)
        mTtsPeople.forEach {
            mList.add(it)
        }


        binding.rvVoicePeople.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvVoicePeople.adapter =
            CommonAdapter(mList, object : CommonAdapter.OnBindDataListener<String> {
                override fun onBindViewHolder(
                    model: String,
                    viewHolder: CommonViewHolder,
                    type: Int,
                    position: Int
                ) {
                    viewHolder.setText(R.id.mTvPeopleContent, model)
                    viewHolder.itemView.setOnClickListener {
                        mTtsPeopleIndex?.let {
                            VoiceManager.setPeople(it[position])
                        }
                    }
                }

                override fun getLayoutId(type: Int) = R.layout.layout_tts_people_list
            })
    }

    override fun initListener() {
        super.initListener()

        binding.barVoiceSpeed.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                binding.barVoiceSpeed.progress = progress
                VoiceManager.setVoiceSpeed(progress.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        binding.barVoiceVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                binding.barVoiceVolume.progress = progress
                VoiceManager.setVolume(progress.toString())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })
        binding.btnTest.setOnClickListener {
            VoiceManager.ttsStart("大家好，我是小爱同学")
        }
    }
}
