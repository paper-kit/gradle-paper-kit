import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    id("com.google.devtools.ksp") version "1.7.10-1.0.6"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    `maven-publish`
}

buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin"))
    }
}

group = "online.viestudio"
version = "2.2.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://papermc.io/repo/repository/maven-public/")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["java"])
        }
    }
}

dependencies {
    implementation("com.squareup", "kotlinpoet", "1.12.0")
    implementation("com.squareup", "kotlinpoet-ksp", "1.12.0")
    implementation("com.google.devtools.ksp", "symbol-processing-api", "1.7.10-1.0.6")
    implementation("com.google.auto.service", "auto-service-annotations", "1.0.1")
    ksp("dev.zacsweers.autoservice", "auto-service-ksp", "1.0.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}