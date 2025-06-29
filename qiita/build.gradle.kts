import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    alias(libs.plugins.sampleConventionKotlinMultiplatform)
    alias(libs.plugins.openApiGenerator)
}

kotlin {
    androidLibrary {
        namespace = "io.github.mikan.sample.qiita"
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktorClientCore)
            implementation(libs.kotlinxSerializationJson)
        }
    }
}

val apiName = "qiita"
val buildApiDir = "${layout.buildDirectory.get()}/openApiGenerator/$apiName"
val basePackage = "io.github.mikan.sample.qiita"
fun String.packageToDir() = replace('.', '/')

tasks.register<GenerateTask>("generate") {
    doFirst {
        delete(file(buildApiDir))
    }
    generatorName.set("kotlin")
    library.set("multiplatform")
    configOptions.set(
        mapOf(
            "dateLibrary" to "kotlinx-datetime",
        )
    )
    remoteInputSpec.set("https://raw.githubusercontent.com/nanato12/qiita-openapi/refs/heads/develop/openapi.yml")
    outputDir.set(buildApiDir)
    packageName.set(basePackage)
    apiPackage.set("$basePackage.remote")
    modelPackage.set("$basePackage.model")
    generateApiTests.set(false)
    generateModelTests.set(false)
}

tasks.register<Copy>("copy") {
    val dirFrom = "$buildApiDir/src/commonMain/kotlin/${basePackage.packageToDir()}"
    val dirInto = "$projectDir/src/commonMain/kotlin/${basePackage.packageToDir()}"

    doFirst {
        delete(file(dirInto))
    }

    dependsOn("generate")
    from(dirFrom)
    into(dirInto)
}

tasks.register("buildApi") {
    dependsOn("generate", "copy")
}