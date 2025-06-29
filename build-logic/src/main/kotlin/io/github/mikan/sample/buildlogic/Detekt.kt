package io.github.mikan.sample.buildlogic

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

internal fun Project.configureDetekt() {
    with(pluginManager) {
        apply("io.gitlab.arturbosch.detekt")
    }

    dependencies {
        "detektPlugins"(libs.library("detektFormatting"))
    }

    configure<DetektExtension> {
        parallel = true
        config.setFrom("$rootDir/config/detekt/detekt.yml")
        buildUponDefaultConfig = true
        autoCorrect = false
        source.setFrom(project.files("./").asFileTree)
    }

    tasks.withType<Detekt> {
        include("**/*.kt")
        include("**/*.kts")
        exclude("**/resources/**")
        exclude("**/build/**")
    }
}