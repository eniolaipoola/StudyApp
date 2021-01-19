plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
}

android {
    compileSdkVersion(Apps.compileSdk)

    defaultConfig {
        applicationId = "com.eniola.studyapp"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        multiDexEnabled = true
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://jackiechanbruteforce.ulesson.com/3p/api/\"")
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        this
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.appcompat)

    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.navigation:navigation-ui:${Versions.navigation}")
    implementation("androidx.navigation:navigation-fragment:${Versions.navigation}")
    implementation("androidx.navigation:navigation-fragment-ktx:${Versions.navigation}")
    implementation("androidx.navigation:navigation-ui-ktx:${Versions.navigation}")

    //dagger dependencies
    implementation(Libs.dagger)
    implementation(Libs.daggerAndroidSupport)
    kapt(Libs.daggerCompiler)
    kapt(Libs.daggerProcessor)

    //Room
    implementation(Libs.room)
    implementation(Libs.roomKtx)
    kapt(Libs.roomKapt)

    implementation(Libs.liveData)
    implementation(Libs.viewModel)

    //Network Calls
    implementation(Libs.retrofit)
    implementation(Libs.okHttpLogging)
    implementation(Libs.retrofitGsonConverter)

    testImplementation(TestLibs.junit)
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}

repositories {
    mavenCentral()
}