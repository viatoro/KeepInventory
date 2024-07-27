/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.6/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    id ("idea")
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.jvm)

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.1.2"
}
group = "com.viatoro.mc"
version = "1.0.1"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation(libs.bundles.kotlinLogging)
    compileOnly("org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT")
//    compileOnly("org.spigotmc:spigot:1.21-R0.1-SNAPSHOT")
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation(libs.junit.jupiter.engine)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

//    // This dependency is exported to consumers, that is to say found on their compile classpath.
//    api(libs.commons.math3)
//
//    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
//    implementation(libs.guava)
}


//idea {
//    module {
//        downloadJavadoc = true
//        downloadSources = true
//    }
//}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

