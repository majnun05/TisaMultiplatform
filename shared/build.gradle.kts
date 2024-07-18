plugins {
    kotlin("multiplatform")
    id("com.android.library")

    //Kotlinx Serialization
    kotlin("plugin.serialization") version "1.9.10"
//    id("io.ktor.plugin") version "2.3.9"
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    //Dependencies versions
    val coroutinesVersion = "1.6.4"
    val ktorVersion = "2.3.2"
    val koinVersion = "3.3.2"
    val serialization_version = "1.6.3"

    sourceSets {
        //commonMain sourceSet
        val commonMain by getting {
            //Common dependencies
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
//
//                // Untuk platform JVM
//                implementation("io.ktor:ktor-client-core-jvm:1.6.8")
//                implementation("io.ktor:ktor-client-gson-jvm:1.6.8")
//
//                // Tambahkan dependensi Gson
//                implementation("com.google.code.gson:gson:2.8.8")
//
//                implementation("io.ktor:ktor-serialization-gson:2.3.9")
//                implementation("io.ktor:ktor-client-json:1.6.8")
//                implementation("io.ktor:ktor-client-gson:1.6.8")

                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                //Use api so that the android app can use it as well
                api("io.insert-koin:koin-core:$koinVersion")

                // log
                implementation("io.github.aakira:napier:1.5.0")
                implementation("io.github.aakira:napier:2.7.1")
            }
        }


        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        //AndroidMain sourceSet
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")

                api("io.insert-koin:koin-android:$koinVersion")
            }
        }

        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting

        //iOSMain sourceSet
        val iosMain by creating {
            dependencies{
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }

            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
    task("testClasses")
}

android {
    namespace = "com.badista.tisakmp"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
        targetSdk = 33
    }
}
