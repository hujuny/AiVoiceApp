/**
 *    @author : 杨虎军
 *    @date   : 2021/06/10
 *    @desc   :
 */
object AiVoiceConstants {

    const val kotlin_version = "1.4.21"
    const val gradle_version = "4.0.2"
}

object AppConfig {

    const val compileSdkVersion = 30
    const val applicationId = "com.yhj.aivoiceapp"
    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0"
}

object DependenciesConfig {

    //kotlin基础库
    const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${AiVoiceConstants.kotlin_version}"

    //kotlin核心库
    const val CORE_KTX = "androidx.core:core-ktx:1.3.2"

    //Android标准库
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.2.0"

    //constraintlayout
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout:2.0.4"

    //EventBus
    const val EVENT_BUS = "org.greenrobot:eventbus:3.2.0"

    //ARouter
    const val AROUTER = "com.alibaba:arouter-api:1.5.0"
    const val AROUTER_COMPILER = "com.alibaba:arouter-compiler:1.2.2"

    //RecyclerView
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:1.2.0-alpha01"
}

//Module配置
object ModuleConfig {

    //是否App
    var isApp = true

    const val MODULE_APP_MANAGER = "com.yhj.module_app_manager"
    const val MODULE_CONSTELLATION = "com.yhj.module_constellation"
    const val MODULE_DEVELOPER = "com.yhj.module_developer"
    const val MODULE_JOKE = "com.yhj.module_joke"
    const val MODULE_MAP = "com.yhj.module_map"
    const val MODULE_SETTING = "com.yhj.module_setting"
    const val MODULE_VOICE_SETTING = "com.yhj.module_voice_setting"
    const val MODULE_WEATHER = "com.yhj.module_weather"

}
