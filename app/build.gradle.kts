plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.uilover.project2262"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.uilover.project2262"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // AndroidX & Compose Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.compose.runtime:runtime-livedata:1.7.8")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    // Firebase
    implementation("com.google.firebase:firebase-auth-ktx:22.1.1")
    implementation(libs.firebase.database)

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Image loading
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("com.github.bumptech.glide:glide:4.13.0")

    // JSON parser
    implementation("com.google.code.gson:gson:2.10.1")

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.28.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.28.0")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")

    // Constraint layout for Compose
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0")

    // Foundation (if needed for low-level UI building blocks)
    implementation("androidx.compose.foundation:foundation:1.7.6")

    // AppCompat (for backward compatibility if needed)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Kotlin Stdlib (latest stable)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")
}
