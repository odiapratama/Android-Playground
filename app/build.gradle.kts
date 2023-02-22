import com.playground.buildsrc.Configs
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kapt)
    alias(libs.plugins.hilt)
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = Configs.CompileSdk

    defaultConfig {
        applicationId = "com.problemsolver.androidplayground"
        minSdk = Configs.MinSdk
        targetSdk = Configs.TargetSdk
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = Configs.AndroidJunitRunner
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
//            enableUnitTestCoverage = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", Configs.Debug.BaseUrl)
            buildConfigField("String", "DBRoomName", Configs.Debug.DBRoomName)
            buildConfigField("String", "DataStoreName", Configs.Debug.DataStoreName)
        }
        create("benchmark") {
            initWith(getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false

            flavorDimensions += "environment"
            productFlavors {
                create("demo") {
                    dimension = "environment"
                    // ...
                }
                create("production") {
                    dimension = "environment"
                    // ...
                }
            }
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", Configs.Release.BaseUrl)
            buildConfigField("String", "DBRoomName", Configs.Release.DBRoomName)
            buildConfigField("String", "DataStoreName", Configs.Release.DataStoreName)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))

    implementation(projects.feature.main)

    // Support
    implementation(libs.legacy.support)
    implementation(libs.multidex)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Hilt testing
    androidTestImplementation(libs.hilt.test)
    kaptAndroidTest(libs.hilt.android.compiler)
    kaptAndroidTest(libs.hilt.compiler)

    // LeakCanary
    debugImplementation(libs.leak.canary)

    testImplementation(libs.junit.test)
    androidTestImplementation(libs.junit.ext.test)
    androidTestImplementation(libs.espresso.core)
}