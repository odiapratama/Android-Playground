import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}
apply {
    plugin("kotlin-android")
    plugin("dagger.hilt.android.plugin")
    plugin("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "com.problemsolver.androidplayground"
        minSdkVersion(19)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", "\"https://ghapi.huchen.dev/\"")
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    val lifecycleVersion = "2.2.0"
    val navVersion = "2.3.1"
    val rxJavaVersion = "2.3.0"
    val rxAndroidVersion = "2.1.1"
    val hiltVersion = "2.28-alpha"
    val hiltAndroidXVersion = "1.0.0-alpha01"
    val timberVersion = "4.7.1"
    val coroutinesVersion = "1.2.1"
    val retrofitVersion = "2.6.1"
    val okhttp3Version = "4.1.0"
    val archVersion = "2.2.0-alpha01"
    val coilVersion = "0.11.0"
    val ktxVersion = "1.3.0"
    val legacyVersion = "1.0.0"
    val constraintVersion = "1.1.3"
    val appCompatVersion = "1.1.0"
    val materialVersion = "1.1.0"
    val junitVersion = "4.13"
    val junitExtVersion = "1.1.1"
    val espressoVersion = "3.2.0"
    val multidexVersion = "2.0.1"
    val biometricVersion = "1.0.1"
    val smoothBottomBarVersion = "1.7.6"
    val dataStoreVersion = "1.0.0-alpha02"

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))

    // support
    implementation("androidx.core:core-ktx:$ktxVersion")
    implementation("androidx.legacy:legacy-support-v4:$legacyVersion")
    implementation("androidx.multidex:multidex:$multidexVersion")

    //view
    implementation("androidx.constraintlayout:constraintlayout:$constraintVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:$materialVersion")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Network
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("io.reactivex.rxjava2:rxkotlin:$rxJavaVersion")
    implementation("io.reactivex.rxjava2:rxandroid:$rxAndroidVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    implementation("com.jakewharton.timber:timber:$timberVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttp3Version")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:$archVersion")
    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$archVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$archVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$archVersion")

    // Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:$hiltAndroidXVersion")
    kapt("androidx.hilt:hilt-compiler:$hiltAndroidXVersion")

    // Hilt testing
    androidTestImplementation("com.google.dagger:hilt-android-testing:$hiltVersion")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kaptAndroidTest("androidx.hilt:hilt-compiler:$hiltAndroidXVersion")

    // Coil
    implementation("io.coil-kt:coil:$coilVersion")

    // Biometric
    implementation("androidx.biometric:biometric:$biometricVersion")

    // SmoothBottomBar
    implementation("com.github.ibrahimsn98:SmoothBottomBar:$smoothBottomBarVersion")

    // DataStore
    implementation("androidx.datastore:datastore-preferences:$dataStoreVersion")
    implementation("androidx.datastore:datastore-core:$dataStoreVersion")

    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$junitExtVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
}