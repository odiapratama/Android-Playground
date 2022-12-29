import com.playground.buildsrc.Libs

plugins {
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:network"))
    implementation(project(":core:utils"))

    // Hilt
    implementation(Libs.Hilt.Android)
    kapt(Libs.Hilt.AndroidCompiler)

    // Hilt testing
    androidTestImplementation(Libs.TestingLib.HiltAndroidTest)
    kaptAndroidTest(Libs.Hilt.AndroidCompiler)
    kaptAndroidTest(Libs.Hilt.Compiler)
}