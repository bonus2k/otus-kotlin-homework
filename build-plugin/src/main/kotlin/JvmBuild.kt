package ru.otus.kotlin.buildplugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.the
import org.gradle.accessors.dm.LibrariesForLibs

class JvmBuild : Plugin<Project> {
    override fun apply(target: Project) = with(target) {

        val libs = project.the<LibrariesForLibs>()

        project.pluginManager.apply("org.jetbrains.kotlin.jvm")
        project.group = project.rootProject.group
        project.version = project.rootProject.version

        project.tasks.withType(JavaCompile::class.java) {
            sourceCompatibility = libs.versions.jvm.language.get()
            targetCompatibility = libs.versions.jvm.compiler.get()
        }

        project.repositories {
            mavenCentral()
        }

    }
}