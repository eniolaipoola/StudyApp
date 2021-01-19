plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(Apps.compileSdk)
    //buildToolsVersion("30.0.3")

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

    //if testing includes android resources
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.appcompat)
    implementation(Libs.coreKtx)
    implementation(Libs.materialDesign)
    implementation(Libs.constraintLayout)
    implementation(Libs.legacySupport)
    implementation(Libs.navigationUi)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationFragmentKtx)
    implementation(Libs.navigationUiKtx)

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
    implementation(Libs.lifecycleExtension)

    //Network Calls
    implementation(Libs.retrofit)
    implementation(Libs.okHttpLogging)
    implementation(Libs.retrofitGsonConverter)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.espressoCore)
}

repositories {
    mavenCentral()
}