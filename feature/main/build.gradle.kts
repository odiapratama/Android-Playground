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
    api(project(":core:ui"))
    api(project(":core:network"))
    api(project(":core:utils"))

    implementation(project(":feature:splash"))
    implementation(project(":feature:menu"))

    // Hilt
    implementation(Libs.Hilt.Android)
    kapt(Libs.Hilt.AndroidCompiler)

    // Hilt testing
    androidTestImplementation(Libs.TestingLib.HiltAndroidTest)
    kaptAndroidTest(Libs.Hilt.AndroidCompiler)
    kaptAndroidTest(Libs.Hilt.Compiler)
}