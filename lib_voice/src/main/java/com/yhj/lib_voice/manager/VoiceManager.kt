package com.yhj.lib_voice.manager

import android.content.Context
import com.yhj.lib_voice.VoiceTTS

/**
 *    @author : yhj
 *    @date   : 2021/06/17
 *    @desc   :
 */
object VoiceManager {

    const val APP_ID = "24384570"
    const val API_KEY = "yuGsaOQD8hDCFYFGNEgI8Ky5"
    const val SECRET_KEY = "t583s2fGMd73fsjxxrkWXG4maD2q7s72"

    fun initManager(context: Context) {
        VoiceTTS.initTTS(context)
    }


    fun setPeople(people: String) {
        VoiceTTS.setPeople(people)
    }

    fun setVoiceSpeed(speed: String) {
        VoiceTTS.setVoiceSpeed(speed)
    }

    fun setVolume(volume: String) {
        VoiceTTS.setVolume(volume)
    }


    //----------------------TTS START--------------------
    fun ttsStart(text: String) {
        VoiceTTS.start(text, null)
    }

    fun ttsStart(text: String, onTTSResultListener: VoiceTTS.OnTTSResultListener?) {
        VoiceTTS.start(text, onTTSResultListener)

    }

    fun ttsPause() {
        VoiceTTS.pause()
    }

    fun ttsRestart() {
        VoiceTTS.restart()
    }

    fun ttsStop() {
        VoiceTTS.stop()
    }

    fun ttsRelease() {
        VoiceTTS.release()
    }

}