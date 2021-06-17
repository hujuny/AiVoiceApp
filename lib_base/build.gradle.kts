plugins {
    id("com.android.library")
    kotlin("android")
}


android {
    useLibrary("org.apache.http.legacy")
    compileSdkVersion(AppConfig.compileSdkVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdkVersion)
        targetSdkVersion(AppConfig.targetSdkVersion)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName


        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(DependenciesConfig.STD_LIB)
    api(DependenciesConfig.CORE_KTX)
    api(DependenciesConfig.APP_COMPAT)
    api(DependenciesConfig.CONSTRAINTLAYOUT)
    api(DependenciesConfig.EVENT_BUS)
    api(DependenciesConfig.AROUTER)
    api(DependenciesConfig.RECYCLERVIEW)

    api(project(":lib_network"))
    api(project(":lib_voice"))
}