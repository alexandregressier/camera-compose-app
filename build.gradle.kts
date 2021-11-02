val versionGradle by extra("7.3-rc-3")
val versionCompose by extra("1.1.0-beta01")
val versionCameraX by extra("1.0.2")

plugins {
    id("com.android.application") version "7.2.0-alpha03" apply false
    id("com.android.library") version "7.2.0-alpha03" apply false
    kotlin("android") version "1.5.31" apply false
}

tasks.wrapper {
    gradleVersion = versionGradle
}

val clean by tasks.registering(Delete::class) {
    doLast {
        delete(rootProject.buildDir)
    }
}