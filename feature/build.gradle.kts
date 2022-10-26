import com.android.build.gradle.BaseExtension
import com.playground.buildsrc.Configs

plugins {
    id("java-platform")
}

subprojects {
    apply(plugin = "com.android.library")

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
        }
    }
}