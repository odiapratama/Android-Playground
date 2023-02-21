android {
    namespace = "com.playground.core.ui"
}

dependencies {
    implementation(projects.core.utils)

    // Navigation
    api(libs.navigation.fragment)
    api(libs.navigation.ui)

    // Support
    implementation(libs.androidx.core)

    // View
    implementation(libs.constraintlayout)
    implementation(libs.appcompat)
    api(libs.material)

    // Lifecycle
    implementation(libs.lifecycle.ext)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.runtime)

    // Coil
    implementation(libs.coil)

    // SmoothBottomBar
    api(libs.smoothbottombar)

    // Lottie
    api(libs.lottie)

    // Splitties
    api(libs.splitties)
}