pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
}

rootProject.name = "AndroidPlayground"
include(":app")
include(":core")
include(":core:database")
include(":core:network")
include(":core:ui")
include(":core:utils")
include(":feature")
include(":feature:home")
include(":feature:more")
include(":feature:explore")
include(":feature:menu")
include(":feature:splash")
include(":feature:main")
