plugins {
    id("com.google.dagger.hilt.android")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.core.network)
    implementation(projects.core.utils)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Hilt testing
    androidTestImplementation(libs.hilt.test)
    kaptAndroidTest(libs.hilt.android.compiler)
    kaptAndroidTest(libs.hilt.compiler)
}