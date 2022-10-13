package com.playground.buildsrc

object Configs {
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
//    private const val versionQualifier = "alpha1"

    private fun generateVersionCode(): Int {
        return versionMajor * 10000 + versionMinor * 100 + versionPatch
    }

    private fun generateVersionName(): String {
        return "$versionMajor.$versionMinor.$versionPatch"
    }

    const val applicationId = "com.problemsolver.androidplayground"
    val VersionCode = generateVersionCode()
    val VersionName = generateVersionName()
    const val MinSdk = 23
    const val TargetSdk = 33
    const val CompileSdk = 33
    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
    /*val FreeCompilerArgs = listOf(
        "-Xjvm-default=all",
        "-Xopt-in=kotlin.RequiresOptIn",
        "-Xopt-in=kotlin.Experimental",
        "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.FlowPreview",
        "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
        "-Xopt-in=com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi",
        "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
    )*/

    object Release {
        const val BaseUrl = "\"https://ghapi.huchen.dev/\""
        const val DBRoomName = "\"PlaygroundDB\""
        const val DataStoreName = "\"PlaygroundDS\""
    }

    object Debug {
        const val BaseUrl = "\"https://ghapi.huchen.dev/\""
        const val DBRoomName = "\"PlaygroundDB\""
        const val DataStoreName = "\"PlaygroundDS\""
    }
}