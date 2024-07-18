plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
    //Kotlinx Serialization
    kotlin("plugin.serialization") version "1.9.22"
}

android {
    namespace = "com.badista.tisakmp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.badista.tisakmp.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/INDEX.LIST"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    applicationVariants.all {
        addJavaSourceFoldersToModel(
            File(buildDir, "generated/ksp/$name/kotlin")
        )
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    // navigation compose
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")

    // serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    val koinComposeVersion = "3.4.1"
    val coilVersion = "2.2.2"
    val accompanistVersion = "0.28.0"
    val navVersion = "2.5.3"

    implementation("io.insert-koin:koin-androidx-compose:$koinComposeVersion")
    implementation("io.coil-kt:coil-compose:$coilVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
    implementation("androidx.navigation:navigation-compose:$navVersion")

    implementation("io.github.raamcosta.compose-destinations:core:1.8.38-beta")
//    ksp("io.github.raamcosta.compose-destinations:ksp:1.8.38-beta")

    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    implementation("io.insert-koin:koin-androidx-compose:3.4.1")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")

    implementation("io.coil-kt:coil-compose:2.4.0")

    // log
    implementation("io.github.aakira:napier:1.5.0")
}