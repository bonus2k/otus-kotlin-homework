pluginManagement {
    includeBuild("../build-plugin")
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
        id("build-jvm") apply false
        id("build-kmp") apply false
    }
}



plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "compos2"
include("m1l1-first")
include("native")
