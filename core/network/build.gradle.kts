import com.playground.buildsrc.Libs

dependencies {
    // Network
    api(Libs.Network.Retrofit)
    api(Libs.Network.RxKotlin)
    api(Libs.Network.RxAndroid)
    implementation(Libs.Network.Coroutines)
    api(Libs.Logger.Timber)
    api(Libs.Network.GsonConverter)
    implementation(Libs.Network.OkHttpInterceptor)

    // WorkManager
    api(Libs.JetpackLib.WorkManager)
}