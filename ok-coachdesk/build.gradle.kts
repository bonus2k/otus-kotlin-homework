plugins {
    id("build-jvm")
}

group = "ru.otus.kotlin.coachdesk"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version
}

