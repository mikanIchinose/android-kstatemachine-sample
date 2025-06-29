package io.github.mikan.sample.buildlogic

import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

internal fun Project.configureKmpCompose() {
    apply(plugin = libs.plugin("kotlinCompose").pluginId)
}