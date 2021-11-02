val versionCompose: String by rootProject.extra
val versionCameraX: String by rootProject.extra

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "dev.gressier.camera"
        minSdk = 26
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = sourceCompatibility
    }
    kotlinOptions {
        jvmTarget = "${compileOptions.sourceCompatibility}"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionCompose
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.6.0")

    // Jetpack Compose
    implementation("androidx.compose.ui:ui:$versionCompose")
    implementation("androidx.compose.material3:material3:1.0.0-alpha01")
    implementation("androidx.compose.ui:ui-tooling-preview:$versionCompose")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$versionCompose")

    // Debugging
    debugImplementation("androidx.compose.ui:ui-tooling:$versionCompose")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$versionCompose")
}