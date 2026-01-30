import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinJvm)
}

group = "com.aivanovski.challenges"
version = libs.versions.appVersion.get()

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertions)
    testImplementation(libs.mockk)
}