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
    api(projects.core.ui)
    api(projects.core.network)
    api(projects.core.utils)

    implementation(projects.feature.splash)
    implementation(projects.feature.menu)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // Hilt testing
    androidTestImplementation(libs.hilt.test)
    kaptAndroidTest(libs.hilt.android.compiler)
    kaptAndroidTest(libs.hilt.compiler)
}