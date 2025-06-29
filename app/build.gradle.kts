plugins {
    alias(libs.plugins.sampleConventionAndroidApplication)
    alias(libs.plugins.sampleConventionAndroidCompose)
}

android {
    namespace = "io.github.mikan.sample.kstatemachine"

    defaultConfig {
        applicationId = "io.github.mikan.sample"
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.qiita)
    implementation(libs.androidxCoreKtx)
    implementation(libs.androidxLifecycleRuntimeKtx)
    implementation(libs.androidxActivityCompose)
}
