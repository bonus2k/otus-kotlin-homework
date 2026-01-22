package ru.otus.kotlin.buildplugin

import org.gradle.api.Plugin
import org.gradle.api.Project


class MyPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        group = "otus"
        description = "Print hello + project info"

        println("Hello from plugin!")
        println("Project: ${project.path}")
        println("Dir: ${project.projectDir}")
        println("Gradle: ${project.gradle.gradleVersion}")

    }
}