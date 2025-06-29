package io.github.mikan.sample.buildlogic

import com.android.build.api.dsl.androidLibrary
import org.gradle.api.Project

internal fun Project.configureKotlinMultiplatform() {
    with(pluginManager) {
        apply("org.jetbrains.kotlin.multiplatform")
        apply("com.android.kotlin.multiplatform.library")
    }

    with(kotlinMultiplatform) {
        androidLibrary {
            compileSdk = libs.version("compileSdk").toInt()
            minSdk = libs.version("minSdk").toInt()

            withHostTestBuilder {
            }

            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }.configure {
                instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }

        iosX64()
        iosArm64()
        iosSimulatorArm64()

        with(sourceSets) {
            commonMain.dependencies {
                implementation(libs.library("kotlinStdlib"))
            }
            commonTest.dependencies {
                implementation(libs.library("kotlinTest"))
            }
            androidMain.dependencies {
            }
            getByName("androidDeviceTest").dependencies {
                implementation(libs.library("runner"))
                implementation(libs.library("core"))
                implementation(libs.library("junit"))
            }
            iosMain.dependencies {
            }
        }
    }
}
