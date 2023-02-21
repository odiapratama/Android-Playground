// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.hilt).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kapt).apply(false)
    alias(libs.plugins.versionCatalogUpdate)
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.android.gradle)
        classpath(libs.kotlin.gradle)
        classpath(libs.hilt.gradle)
        classpath(libs.navigation.args)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
//        classpath(kotlin("gradle-plugin", com.playground.buildsrc.Deps.Versions.KotlinVersion))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
