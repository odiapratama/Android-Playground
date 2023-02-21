dependencies {
    // Network
    api(libs.bundles.retrofit)
    api(libs.rx.kotlin)
    api(libs.rx.android)
    implementation(libs.bundles.coroutines)
    api(libs.timber)
    implementation(libs.okhttp)
    implementation(libs.androidx.core)

    // WorkManager
    api(libs.workmanager)
}