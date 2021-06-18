package com.yhj.lib_voice

import android.content.Context
import android.util.Log
import com.baidu.tts.client.SpeechError
import com.baidu.tts.client.SpeechSynthesizer
import com.baidu.tts.client.SpeechSynthesizerListener
import com.baidu.tts.client.TtsMode
import com.yhj.lib_voice.manager.VoiceManager


/**
 *    @author : yhj
 *    @date   : 2021/06/17
 *    @desc   :TTS封装
 */
object VoiceTTS : SpeechSynthesizerListener {
    private lateinit var mSpeechSynthesizer: SpeechSynthesizer


    private const val TAG = "yhj"
    private var onTTSResultListener: OnTTSResultListener? = null


    fun initTTS(context: Context) {

        mSpeechSynthesizer = SpeechSynthesizer.getInstance()

        mSpeechSynthesizer.setContext(context)

        mSpeechSynthesizer.setAppId(VoiceManager.APP_ID)
        mSpeechSynthesizer.setApiKey(VoiceManager.API_KEY, VoiceManager.SECRET_KEY)

        mSpeechSynthesizer.setSpeechSynthesizerListener(this)

        mSpeechSynthesizer.initTts(TtsMode.ONLINE)

        setPeople(0.toString())
        setVoiceSpeed(5.toString())
        setVolume(5.toString())

    }

    fun setPeople(people: String) {
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEAKER, people)
    }

    fun setVoiceSpeed(speed: String) {
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_SPEED, speed)
    }

    fun setVolume(volume: String) {
        mSpeechSynthesizer.setParam(SpeechSynthesizer.PARAM_VOLUME, volume)
    }

    override fun onSynthesizeStart(p0: String?) {
        Log.e(TAG, "onSynthesizeStart: $p0")
    }

    override fun onSynthesizeDataArrived(p0: String?, p1: ByteArray?, p2: Int, p3: Int) {
        Log.e(TAG, "onSynthesizeStart: $p0")

    }

    override fun onSynthesizeFinish(p0: String?) {
        Log.e(TAG, "onSynthesizeStart: $p0")
        onTTSResultListener?.ttsEnd()
    }

    override fun onSpeechStart(p0: String?) {
        Log.e(TAG, "onSynthesizeStart: $p0")

    }

    override fun onSpeechProgressChanged(p0: String?, p1: Int) {


    }

    override fun onSpeechFinish(p0: String?) {
    }

    override fun onError(p0: String?, p1: SpeechError?) {
        if (p1 != null) {
            Log.e(TAG, "${p1.code}")
            Log.e(TAG, p1.description)
            Log.e(TAG, p0.toString())
        }
    }


    fun start(text: String) {
        mSpeechSynthesizer.speak(text)
    }

    fun start(text: String, onTTSResultListener: OnTTSResultListener?) {
        this.onTTSResultListener = onTTSResultListener
        mSpeechSynthesizer.speak(text)
    }

    fun pause() {
        mSpeechSynthesizer.pause()
    }

    fun restart() {
        mSpeechSynthesizer.resume()
    }

    fun stop() {
        mSpeechSynthesizer.stop()
    }

    fun release() {
        mSpeechSynthesizer.release()
    }

    interface OnTTSResultListener {

        fun ttsEnd()
    }

}