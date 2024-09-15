plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("org.jetbrains.kotlin.kapt") version "1.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.dagger:dagger:2.47") // Dagger core
    kapt("com.google.dagger:dagger-compiler:2.47") // Dagger compiler (via KAPT for Kotlin)
}
kapt {
    correctErrorTypes = true // Recommended for using Dagger with Kotlin

}
tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        jvmTarget = "17" // or "11" for JDK 11, depending on what JDK you're using
//    }
//}
//
//java {
//    toolchain {
//        languageVersion.set(JavaLanguageVersion.of(17)) // Replace 11 with your JDK version
//    }
//}
