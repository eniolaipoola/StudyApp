package com.eniola.studyapp.remote

import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */
interface APIService {


}

//provide apiService instance for viewModel classes
class NetworkService @Inject constructor(private val retrofit: Retrofit){
    val apiService: APIService get() =
        retrofit.create(APIService::class.java)
}