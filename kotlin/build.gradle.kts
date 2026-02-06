import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinPowerAssert)
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

@OptIn(ExperimentalKotlinGradlePluginApi::class)
powerAssert {
    functions = listOf("io.kotest.matchers.shouldBe")
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.kotest.runner)
    testImplementation(libs.kotest.assertions)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinTest)
}