package ru.otus.kotlin.buildplugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension


class MyPluginMultiplatform : Plugin<Project> {

    override fun apply(project: Project): Unit = with(project) {
        pluginManager.apply("org.jetbrains.kotlin.multiplatform")

        extensions.configure<KotlinMultiplatformExtension> {
            linuxX64()

            sourceSets.apply {
                val commonMain = getByName("commonMain")
                val commonTest = getByName("commonTest")

            }
        }

        tasks.register("printKmp") {
            group = "otus"
            description = "Print info about configured KMP targets"

            println("KMP configured for: ${project.path}")
            println("Project: ${project.path}")
            println("Dir: ${project.projectDir}")
            println("Gradle: ${project.gradle.gradleVersion}")
        }
    }
}