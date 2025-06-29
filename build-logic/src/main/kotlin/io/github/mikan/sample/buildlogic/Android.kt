package io.github.mikan.sample.buildlogic

import org.gradle.api.JavaVersion
import org.gradle.api.Project

internal fun Project.configureAndroid() {
    with(android) {
        compileSdk = libs.version("compileSdk").toInt()

        defaultConfig {
            minSdk = libs.version("minSdk").toInt()
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }
}
