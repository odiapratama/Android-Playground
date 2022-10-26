import com.android.build.gradle.BaseExtension
import com.playground.buildsrc.Configs

plugins {
    id("java-platform")
}

subprojects {
    apply(plugin = "com.android.library")
    apply(plugin = "kotlin-android")
    apply(plugin = "kotlin-kapt")

    plugins.withType(BasePlugin::class.java).configureEach {
        configure<BaseExtension> {
            defaultConfig {
                minSdk = Configs.MinSdk
                compileSdkVersion(Configs.CompileSdk)
                consumerProguardFiles("consumer-rules.pro")
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
                isCoreLibraryDesugaringEnabled = true
            }

            dataBinding.isEnabled = true
        }
    }
}

dependencies {
    constraints {
        api(project(":core:database"))
        api(project(":core:ui"))
        api(project(":core:network"))
        api(project(":core:utils"))
    }
}
