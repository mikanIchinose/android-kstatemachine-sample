package io.github.mikan.sample.buildlogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureUnitTest() {
    dependencies {
        testImplementation(libs.library("kotlinTest"))
    }
}