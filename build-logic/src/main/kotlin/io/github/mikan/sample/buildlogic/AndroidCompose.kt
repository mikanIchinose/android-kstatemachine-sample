package io.github.mikan.sample.buildlogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose() {
    apply(plugin = libs.plugin("kotlinCompose").pluginId)

    with(android) {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        implementation(platform(libs.library("androidxComposeBom")))
        implementation(libs.library("androidxUi"))
        implementation(libs.library("androidxUiGraphics"))
        implementation(libs.library("androidxUiToolingPreview"))
        implementation(libs.library("androidxMaterial3"))
        debugImplementation(libs.library("androidxUiTooling"))
        debugImplementation(libs.library("androidxUiTestManifest"))
    }
}
