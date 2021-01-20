package com.eniola.studyapp.remote

import com.eniola.studyapp.remote.api.StudyAppApiResponse
import com.eniola.studyapp.ui.subjects.SubjectResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */
interface APIService {

    @GET("content/grade")
    suspend fun getAllSubjects(): StudyAppApiResponse<SubjectResponse>

}

//provide apiService instance for viewModel classes
class NetworkService @Inject constructor(private val retrofit: Retrofit){
    val apiService: APIService get() =
        retrofit.create(APIService::class.java)
}