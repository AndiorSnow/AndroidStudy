plugins {
    // Declare whether it is an Android application or a library module
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // Configure various properties of project construction
    namespace = "com.example.yancourse2"  // project name
    compileSdk = 34                       // Compilation SDK version of the project
    // buildToolsVersion =                // Version of project building tool

//    // Turn off png legality check for Android Studio
//    aaptOptions.cruncherEnabled = false
//    aaptOptions.useNewCruncher = false

    defaultConfig {// default config
        applicationId = "com.example.yancourse2"   // Application Package Name
        minSdk = 24                       // Minimum SDK version
        targetSdk = 33                    // target SDK version
        versionCode = 1                   // version code
        versionName = "1.0"               // version name
        // Instrumentation unit testing
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    // signingConfigs {}                  // Signature information configuration
    // sourceSets {}                      // Source file path configuration
    // listOptions {}                     // Init configuration
    buildTypes {// Specify the configuration for generating installation files to avoid code obfuscation
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {// Java version configuration
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {// Specify all dependencies of the current project, including local dependencies, library dependencies, and remote dependencies

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.compose.ui:ui:1.5.4")
    implementation("androidx.compose.ui:ui-tooling:1.5.4")
    implementation("androidx.compose.foundation:foundation:1.5.4")
    implementation("androidx.compose.material:material:1.5.4")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
    implementation("androidx.compose.runtime:runtime-rxjava2:1.5.4")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4")
}

// repositories {}   // repository configuration