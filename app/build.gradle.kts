plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Apps.compileSdk)

    defaultConfig {
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
        jvmTarget = "1.8"
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
    implementation(Libs.lifecycleExtension)

    //dagger dependencies
    implementation(Libs.dagger)
    implementation(Libs.daggerAndroid)
    implementation(Libs.daggerAndroidSupport)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(Libs.daggerCompiler)
    kapt(Libs.daggerProcessor)

    //Room
    implementation(Libs.room)
    implementation(Libs.roomKtx)
    kapt(Libs.roomKapt)

    implementation(Libs.liveData)
    implementation(Libs.viewModel)

    //picasso
    implementation(Libs.picasso)

    //######################## ExoPlayer ###########################
    implementation(Libs.exoPlayerCore)
    implementation(Libs.exoPlayerDash)
    implementation(Libs.exoPlayerUi)


    //Network Calls
    implementation(Libs.retrofit)
    implementation(Libs.okHttpLogging)
    implementation(Libs.retrofitGsonConverter)

    //Glide
    implementation("com.github.bumptech.glide:glide:4.8.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.8.0")

    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.mockito)
    //testImplementation(TestLibs.mockitoInline)
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}

repositories {
    mavenCentral()
}