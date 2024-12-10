plugins {
    id("com.android.application")
}

android {
    namespace = "com.jalsoft.android.appenv"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jalsoft.android.appenv"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "0.8.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("com.android.volley:volley:1.2.1")
    implementation ("androidx.drawerlayout:drawerlayout:1.1.1")
    implementation("com.google.android.material:material:1.2.1")


}