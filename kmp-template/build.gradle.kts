plugins {
    alias(libs.plugins.sampleConventionKotlinMultiplatform)
}

kotlin {
    androidLibrary {
        namespace = "io.github.mikan.sample.kmptemplate"
    }
    sourceSets {
        commonMain {
            dependencies {
            }
        }

        commonTest {
            dependencies {
            }
        }

        androidMain {
            dependencies {
            }
        }

        iosMain {
            dependencies {
            }
        }
    }
}
