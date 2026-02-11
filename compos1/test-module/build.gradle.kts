plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.kotlinx.cli)
    testImplementation(kotlin("test-junit5"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {}
}