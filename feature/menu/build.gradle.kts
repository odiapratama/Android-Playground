import com.playground.buildsrc.Libs

plugins {
    id("com.google.dagger.hilt.android")
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

    implementation(project(":feature:home"))
    implementation(project(":feature:explore"))
    implementation(project(":feature:more"))

    // Hilt
    implementation(Libs.Hilt.Android)
    kapt(Libs.Hilt.AndroidCompiler)

    // Hilt testing
    androidTestImplementation(Libs.TestingLib.HiltAndroidTest)
    kaptAndroidTest(Libs.Hilt.AndroidCompiler)
    kaptAndroidTest(Libs.Hilt.Compiler)
}