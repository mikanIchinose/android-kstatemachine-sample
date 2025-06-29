package io.github.mikan.sample.convention

import io.github.mikan.sample.buildlogic.androidLibrary
import io.github.mikan.sample.buildlogic.configureAndroid
import io.github.mikan.sample.buildlogic.configureAndroidCompose
import io.github.mikan.sample.buildlogic.configureDetekt
import io.github.mikan.sample.buildlogic.configureKotlin
import io.github.mikan.sample.buildlogic.configureUnitTest
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("unused")
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")

            configureKotlin()
            configureAndroid()
            configureAndroidCompose()
            configureDetekt()
            configureUnitTest()

            with(androidLibrary) {
                defaultConfig {
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    consumerProguardFiles("consumer-rules.pro")
                }
            }
        }
    }
}