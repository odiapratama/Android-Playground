import com.playground.buildsrc.Configs
import com.playground.buildsrc.Libs
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
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

    // support
    implementation(Libs.JetpackLib.CoreKtx)
    implementation(Libs.JetpackLib.LegacyV4)
    implementation(Libs.JetpackLib.MultiDex)

    // View
    implementation(Libs.JetpackLib.ConstraintLayout)
    implementation(Libs.JetpackLib.AppCompat)
    implementation(Libs.UI.Material)

    // Navigation
    implementation(Libs.JetpackLib.Navigation.Fragment)
    implementation(Libs.JetpackLib.Navigation.UI)

    // Network
    implementation(Libs.Network.Retrofit)
    implementation(Libs.Network.RxKotlin)
    implementation(Libs.Network.RxAndroid)
    implementation(Libs.Network.Coroutines)
    implementation(Libs.Logger.Timber)
    implementation(Libs.Network.GsonConverter)
    implementation(Libs.Network.OkHttpInterceptor)

    // Lifecycle
    implementation(Libs.JetpackLib.Lifecycle.Extension)
    implementation(Libs.JetpackLib.Lifecycle.ViewModelKtx)
    implementation(Libs.JetpackLib.Lifecycle.LiveDataKtx)
    implementation(Libs.JetpackLib.Lifecycle.RuntimeKtx)

    // Hilt
    implementation(Libs.Hilt.Android)
    kapt(Libs.Hilt.AndroidCompiler)

    // Hilt testing
    androidTestImplementation(Libs.TestingLib.HiltAndroidTest)
    kaptAndroidTest(Libs.Hilt.AndroidCompiler)
    kaptAndroidTest(Libs.Hilt.Compiler)

    // Coil
    implementation(Libs.Images.Coil)

    // Biometric
    implementation(Libs.JetpackLib.Biometric)

    // SmoothBottomBar
    implementation(Libs.UI.SmoothBottomBar)

    // DataStore
    implementation(Libs.JetpackLib.DataStore)

    // WorkManager
    implementation(Libs.JetpackLib.WorkManager)

    // Lottie
    implementation(Libs.Images.Lottie)

    // LeakCanary
    debugImplementation(Libs.Logger.LeakCanary)

    testImplementation(Libs.TestingLib.JUnit)
    androidTestImplementation(Libs.TestingLib.JunitExt)
    androidTestImplementation(Libs.TestingLib.Espresso)
}