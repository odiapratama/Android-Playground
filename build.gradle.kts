// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.google.dagger.hilt.android") version com.playground.buildsrc.Libs.Versions.Hilt apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(com.playground.buildsrc.Deps.AndroidGradle)
        classpath(com.playground.buildsrc.Deps.KotlinGradle)
        classpath(com.playground.buildsrc.Deps.Hilt)
        classpath(com.playground.buildsrc.Deps.NavSafeArgs)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath(kotlin("gradle-plugin", com.playground.buildsrc.Deps.Versions.KotlinVersion))
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
