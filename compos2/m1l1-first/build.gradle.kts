plugins {
    kotlin("jvm")
    id("build-jvm")
}

dependencies {
    testImplementation(kotlin("test-junit5"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {}
}