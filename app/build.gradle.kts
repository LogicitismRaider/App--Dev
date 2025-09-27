plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.instagramrepilca"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.instagramrepilca"
        minSdk = 24
        targetSdk = 36
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    dependencies {
        implementation("androidx.core:core-splashscreen:1.0.1") // Check for the latest version
        // ... other dependencies
    }
    dependencies {
        // Navigation Component
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.7") // Or the latest version
        implementation("androidx.navigation:navigation-ui-ktx:2.7.7")     // Or the latest version

        // Material Components (you already have this based on your project info)
        implementation("com.google.android.material:material:1.13.0")
        // ... other dependencies
    }

}