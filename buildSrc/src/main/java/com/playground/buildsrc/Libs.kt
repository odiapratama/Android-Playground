package com.playground.buildsrc

object Libs {

    object Versions {
        const val CoreKtx = "1.8.0"
        /*const val Room = "2.4.2"*/
        const val Hilt = "2.42"
        const val Lifecycle = "2.2.0"
    }

    object JetpackLib {
        const val CoreKtx = "androidx.core:core-ktx:${Versions.CoreKtx}"
        const val AppCompat = "androidx.appcompat:appcompat:1.4.2"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        /*const val Startup = "androidx.startup:startup-runtime:1.1.1"*/
        const val Fragment = "androidx.fragment:fragment-ktx:1.5.0"
        /*const val Paging3 = "androidx.paging:paging-runtime-ktx:3.1.1"*/
        const val DataStore = "androidx.datastore:datastore-preferences:1.0.0"
        const val LegacyV4 = "androidx.legacy:legacy-support-v4:1.0.0"
        const val MultiDex = "androidx.multidex:multidex:2.0.1"
        const val Biometric = "androidx.biometric:biometric:1.0.1"
        const val WorkManager = "androidx.work:work-runtime-ktx:2.7.1"

        object Lifecycle {
            const val Extension = "androidx.lifecycle:lifecycle-extensions:${Versions.Lifecycle}"
            const val ViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle}"
            const val LiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle}"
            const val RuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle}"
        }

        object Navigation {
            const val Fragment = "androidx.navigation:navigation-fragment-ktx:2.5.0"
            const val UI = "androidx.navigation:navigation-ui-ktx:2.5.0"
        }

        /*object Room {
            const val Compiler = "androidx.room:room-compiler:${Versions.Room}"
            const val Ktx = "androidx.room:room-ktx:${Versions.Room}"
            const val Runtime = "androidx.room:room-runtime:${Versions.Room}"
        }*/
    }

    object UI {
        const val Material = "com.google.android.material:material:1.6.1"

        // EXT
        const val SmoothBottomBar = "com.github.ibrahimsn98:SmoothBottomBar:1.7.6"
    }

    object Hilt {
        const val Compiler = "androidx.hilt:hilt-compiler:${Versions.Hilt}"
        const val Android = "com.google.dagger:hilt-android:${Versions.Hilt}"
        const val AndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Hilt}"
    }

    /*object GoogleService {
        const val Ads = "com.google.android.gms:play-services-ads:21.1.0"

        object Maps {
            const val Location = "com.google.android.gms:play-services-location:20.0.0"
            const val Places = "com.google.android.libraries.places:places:2.6.0"
            const val Service = "com.google.android.gms:play-services-maps:18.1.0"
        }
    }*/

    object Network {
        private const val RetrofitVersion = "2.9.0"
        private const val OkHttpVersion = "5.0.0-alpha.2"

        const val Retrofit = "com.squareup.retrofit2:retrofit:$RetrofitVersion"
        const val GsonConverter = "com.squareup.retrofit2:converter-gson:$RetrofitVersion"
        /*const val OkHttp = "com.squareup.okhttp3:okhttp:$OkHttpVersion"*/
        const val OkHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:$OkHttpVersion"

        const val Coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.2.1"
        const val RxKotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
        const val RxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }

    object Images {
        const val Coil = "io.coil-kt:coil:0.11.0"
        const val Lottie = "com.airbnb.android:lottie:3.5.0"
    }

    object Logger {
        const val Timber = "com.jakewharton.timber:timber:4.7.1"
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:2.9.1"
    }

    object TestingLib {
        const val JUnit = "junit:junit:4.13.2"
        const val JunitExt = "androidx.test.ext:junit:1.1.3"
        const val Espresso = "androidx.test.espresso:espresso-core:3.4.0"
        const val HiltAndroidTest = "com.google.dagger:hilt-android-testing:${Versions.Hilt}"

        /*object Room {
            const val Test = "androidx.room:room-testing:${Versions.Room}"
        }*/
    }
}