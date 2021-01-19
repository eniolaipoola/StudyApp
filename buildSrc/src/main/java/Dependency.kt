object Apps {
    const val compileSdk = 29
    const val minSdk = 16
    const val targetSdk = 29
    const val versionCode = 5
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "4.0.0"
    const val kotlin = "1.3.61"
    const val appcompat = "1.1.0"
    const val room = "2.2.5"
    const val lifecycle = "2.2.0"
    const val navigation = "2.2.1"
    const val dagger = "2.26"
    const val retrofit = "2.8.1"
    const val okHttp = "3.12.10"
    const val coreKtx = "1.3.2"
    const val materialDesign = "1.2.1"
    const val constraintLayout = "2.0.4"
    const val legacySupport = "1.0.0"

    /* test variable */
    const val junit = "4.12"
    const val androidTestRunner = "1.2.0"
    const val espressoCore = "3.2.0"

}

object Libs {
    //Android
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Dagger
    const val dagger = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    //Room
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    //ViewModel and LiveData
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
}

object TestLibs {
    const val junit = "androidx.test.ext:junit:${Versions.junit}"
    const val androidTestRunner = "androidx.test.runner:${Versions.androidTestRunner}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"


}