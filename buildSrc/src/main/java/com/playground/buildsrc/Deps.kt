package com.playground.buildsrc

object Deps {

    object Versions {
        const val KotlinVersion = "1.6.21"
    }

    const val Hilt = "com.google.dagger:hilt-android-gradle-plugin:${Libs.Versions.Hilt}"
    const val AndroidGradle = "com.android.tools.build:gradle:7.0.0"
    const val KotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KotlinVersion}"
    const val NavSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0"
}