package io.github.mikan.sample.buildlogic

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>()
        .named("libs")

internal fun VersionCatalog.version(name: String) = findVersion(name).get().requiredVersion

internal fun VersionCatalog.library(name: String) = findLibrary(name).get().get()

internal fun VersionCatalog.plugin(name: String) = findPlugin(name).get().get()

internal fun VersionCatalog.bundle(name: String) = findBundle(name).get().get()

internal fun DependencyHandlerScope.implementation(artifact: Dependency) {
    add("implementation", artifact)
}

internal fun DependencyHandlerScope.implementation(artifact: MinimalExternalModuleDependency) {
    add("implementation", artifact)
}

internal fun DependencyHandlerScope.debugImplementation(
    artifact: MinimalExternalModuleDependency,
) {
    add("debugImplementation", artifact)
}

internal fun DependencyHandlerScope.testImplementation(
    artifact: MinimalExternalModuleDependency,
) {
    add("testImplementation", artifact)
}

internal val Project.androidApplication: ApplicationExtension
    get() = extensions.getByType<ApplicationExtension>()

internal val Project.androidLibrary: LibraryExtension
    get() = extensions.getByType<LibraryExtension>()

internal val Project.android: CommonExtension<*, *, *, *, *, *>
    get() = runCatching { androidLibrary }
        .recoverCatching { androidApplication }
        .onFailure { println("Could not find Library or Application extension from this project") }
        .getOrThrow()

internal val Project.kotlinMultiplatform: KotlinMultiplatformExtension
    get() = extensions.getByType<KotlinMultiplatformExtension>()
