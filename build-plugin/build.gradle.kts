plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins{
        register("build-jvm"){
            id = "build-jvm"
            implementationClass = "ru.otus.kotlin.buildplugin.MyPlugin"
        }
        register("build-kmp"){
            id = "build-kmp"
            implementationClass = "ru.otus.kotlin.buildplugin.MyPluginMultiplatform"
        }
    }
}

repositories {
    mavenCentral()
}



dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
    testImplementation(kotlin("test-junit5"))
}

