import com.playground.buildsrc.Libs

android {
    namespace = "com.playground.core.ui"
}

dependencies {
    // Support
    implementation(Libs.JetpackLib.CoreKtx)

    // View
    implementation(Libs.JetpackLib.ConstraintLayout)
    implementation(Libs.JetpackLib.AppCompat)
    implementation(Libs.UI.Material)

    // Lifecycle
    implementation(Libs.JetpackLib.Lifecycle.Extension)
    implementation(Libs.JetpackLib.Lifecycle.ViewModelKtx)
    implementation(Libs.JetpackLib.Lifecycle.LiveDataKtx)
    implementation(Libs.JetpackLib.Lifecycle.RuntimeKtx)

    // Coil
    implementation(Libs.Images.Coil)

    // SmoothBottomBar
    api(Libs.UI.SmoothBottomBar)

    // Lottie
    api(Libs.Images.Lottie)
}