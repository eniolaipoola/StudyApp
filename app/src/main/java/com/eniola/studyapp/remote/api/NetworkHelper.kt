package com.eniola.studyapp.remote.api

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

suspend fun <T> safeAPICall(dispatcher: CoroutineDispatcher = Dispatchers.IO,
                            apiCall: suspend () -> T) : ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())

        } catch (throwable: Throwable){
            throwable.printStackTrace()
            when(throwable) {
                is IOException ->
                    ResultWrapper.Error(103, "Not connected to the internet")
                is UnknownHostException ->
                    ResultWrapper.Error(101, ErrorStatus.NO_CONNECTION)
                is SocketTimeoutException ->
                    ResultWrapper.Error(102, ErrorStatus.TIMEOUT)
                is HttpException -> {
                    ResultWrapper.Error(401, throwable.message())

                }
                else -> {
                    ResultWrapper.Error(null, throwable.localizedMessage)
                }
            }
        }
    }

}