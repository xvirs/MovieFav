import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //Dager hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

    //parcelable para poder pasar objetos por paramentro cuando se quiera hacer navegacion con compose
    id("kotlin-parcelize")
    //Serealizacion
    kotlin("plugin.serialization") version "1.8.10"
}

android {
    namespace = "com.example.movieapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movieapp"
        minSdk = 26
        targetSdk = 34
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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    //Navegacion Compose
    implementation("androidx.navigation:navigation-compose:2.7.1")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Fragment
    implementation ("androidx.fragment:fragment-ktx:1.6.1")
    // Activity
    implementation ("androidx.activity:activity-ktx:1.7.2")
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.0")
    implementation ("androidx.lifecycle:lifecycle-runtime:2.6.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Corrutinas
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")


    //Hilt
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-android-compiler:2.47")

    //coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Carrusel
    implementation("com.google.accompanist:accompanist-pager:0.20.0")
    implementation("androidx.compose.ui:ui-util:1.5.0")

    // -- Navigation
    implementation ("androidx.navigation:navigation-compose:2.7.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation("androidx.compose.material:material:1.5.0")
    //serializacion
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

    //Fuentes Texto
    implementation ("androidx.compose.ui:ui-text-google-fonts:1.6.0-alpha04")


    implementation ("androidx.window:window:1.2.0-beta01")
    implementation ("androidx.compose.material3:material3-window-size-class")

}



