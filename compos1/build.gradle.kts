plugins {
    kotlin("jvm") apply false
}

group = "ru.otus.kotlin.compos1"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    group = rootProject.group
    version = rootProject.version
    repositories {
        mavenCentral()
    }
}
