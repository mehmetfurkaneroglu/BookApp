plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.eroglu.bookapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.eroglu.bookapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    //RxJava
    implementation ("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")

    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1") // Coroutine desteği için bu satırı ekleyin
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:2.6.1")
    // To use Kotlin Symbol Processing (KSP)
    //ksp("androidx.room:room-compiler:2.5.0")
    //Add the SwipeRefreshLayout Widget
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.2.0-alpha01")
    //RxJava
    implementation ("io.reactivex.rxjava3:rxjava:3.0.6")
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")
    //ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    //Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //Hilt
    implementation ("com.google.dagger:hilt-android:2.51")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.51")
    kapt ("com.google.dagger:hilt-compiler:2.51")

}

kapt {
    correctErrorTypes = true
}